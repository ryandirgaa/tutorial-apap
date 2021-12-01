package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.model.PasswordModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.service.UserService;
import apap.tutorial.emsidi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public boolean validatePassword(String password) {
        if (password.length()>=8
                && Pattern.compile("[0-9]").matcher(password).find()
                && Pattern.compile("\\p{Upper}").matcher(password).find()
                && Pattern.compile("\\p{Lower}").matcher(password).find()
                && Pattern.compile("\\p{Punct}").matcher(password).find()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateEmail(String email){
        boolean isUnique = true;
        List<UserModel> listUser = userService.getUserList();
        for(int i=0; i<listUser.size(); i++){
            if(email.equals(listUser.get(i).getEmail())){
                isUnique = false;
                break;
            }
            else{
                continue;
            }
        }
        return isUnique;
    }

    @GetMapping(value = "/view")
    private String viewUserList(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);

        return "viewall-user";
    }

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();

        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);

        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        String returnStr = "";

        if (validatePassword(user.getPassword())) {
            if(validateEmail(user.getEmail())){
                userService.addUser(user);
                returnStr = "redirect:/";
            }
            else{
                returnStr = "failed";
            }
        }
        else {
            returnStr = "failed";
        }

        model.addAttribute("user", user);

        return returnStr;
    }

    @GetMapping("/delete/{username}")
    private String deleteUser(@PathVariable String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);

        model.addAttribute("nama", user.getNama());

        return "redirect:/";
    }

    @RequestMapping("/update-password")
    private String updatePassword() {
        return "form-update-password";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    private String updatePasswordSubmit(@ModelAttribute PasswordModel pass, Model model) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        String message = "";
        if (pass.getConfirmedPassword().equals(pass.getNewPassword())) {
            if (passwordEncoder.matches(pass.getOldPassword(), user.getPassword())) {
                if (this.validatePassword(pass.getNewPassword())) {
                    userService.changePassword(user, pass.getNewPassword());
                    message = "Success";
                }
                else{
                    message = "NotValid";
                }
            }
            else {
                message = "NotMatch";
            }
        }
        else {
            message = "Failed";
        }
        model.addAttribute("message" , message);

        return "form-update-password";
    }
}
