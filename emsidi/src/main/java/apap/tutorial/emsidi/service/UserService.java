package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> getUserList();
    UserModel getUserByUsername(String nama);
    void deleteUser(UserModel user);
    void changePassword(UserModel user, String newPassword);
}
