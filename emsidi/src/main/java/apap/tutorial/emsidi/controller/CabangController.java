package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    private MenuService menuService;

    private int count = 0;

    @GetMapping("cabang/add")
    public String addCabangForm(Model model){
        CabangModel cabang = new CabangModel();
        List<MenuModel> listMenu = menuService.getListMenu();
        List<MenuModel> listMenuNew = new ArrayList<MenuModel>();

        cabang.setListMenu(listMenuNew);
        cabang.getListMenu().add(new MenuModel());

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuExisting", listMenu);
        return "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"save"})
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        if(cabang.getListMenu() == null){
            cabang.setListMenu(new ArrayList<>());
        }
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"addRow"})
    public String addRowCabangMultiple(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        if(cabang.getListMenu() == null || cabang.getListMenu().size() == 0){
            cabang.setListMenu(new ArrayList<>());
        }
        cabang.getListMenu().add(new MenuModel());
        List<MenuModel> listMenu = menuService.getListMenu();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuExisting", listMenu);
        return "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"deleteRow"})
    public String deleteRowCabangMultiple(
            @ModelAttribute CabangModel cabang,
            @RequestParam("deleteRow") Integer row,
            Model model
    ) {
        final Integer rowId = Integer.valueOf(row);
        cabang.getListMenu().remove(rowId.intValue());

        List<MenuModel> listMenu = menuService.getListMenu();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenuExisting", listMenu);
        return "form-add-cabang";
    }


    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        model.addAttribute("listCabang", listCabang);

        return "viewall-cabang";
    }

    /* Method tambahan untuk menjawab latihan nomor 1
    Digunakan untuk menampilkan list cabang dengan nama cabang yang berurutan */
    @GetMapping("/cabang/sortedViewAll")
    public String sortedListCabang(Model model){
        List<CabangModel> listCabang =  cabangService.getCabangList();
        listCabang.sort((o1, o2) -> o1.getNamaCabang().compareTo(o2.getNamaCabang()));
        model.addAttribute("listCabang", listCabang);

        return "viewall-cabang";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabang(@RequestParam(value = "noCabang") Long noCabang, Model model){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        List<MenuModel> listMenu = cabang.getListMenu();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", listMenu);

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(@PathVariable Long noCabang, Model model){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);

        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(@ModelAttribute CabangModel cabang, Model model){
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());

        return "update-cabang";
    }

    /* Method tambahan untuk menjawab latihan nomor 4
    Jika tidak memenuhi condition, halaman error ditampilkan (latihan nomor 5)*/
    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabangForm(@PathVariable Long noCabang, Model model){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();
        boolean canUpdate = cabangService.canUpdateDelete(cabang);

        if(canUpdate == true){
            if(listPegawai.isEmpty()){
                cabangService.deleteCabang(cabang);
                model.addAttribute("noCabang", cabang.getNoCabang());
                return "delete-cabang";
            }
            else{
                return "error";
            }
        }
        else{
            return "error";
        }
    }
}
