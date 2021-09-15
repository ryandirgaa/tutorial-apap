package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam(value = "id", required = true) String idKebunSafari,
            @RequestParam(value = "nama", required = true) String namaKebunSafari,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {
        //Membuat objek KebunSafari baru
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        //Memanggil service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        //Menambahkan variabel KebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn template html yang dipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model) {
        //Mendapatkan list seluruh objek KebunSafari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        //Menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        //Mereturn template html yang dipakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value = "id", required = true) String idKebunSafari, Model model) {
        //Mendapatkan objek KebunSafari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //Menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //Mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/view/{id}")
    public String viewKebunSafariById(@PathVariable(value = "id", required = true) String idKebunSafari, Model model) {
        //Mendapatkan objek KebunSafari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        if(kebunSafari != null){
            model.addAttribute("kebunSafari", kebunSafari);
            return "detail-kebun-safari";
        }
        else{
            return "error";
        }
    }

    @RequestMapping("/kebun-safari/update/{id}")
    public String updateKebunSafari(
            @PathVariable(value = "id", required = true) String idKebunSafari,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        if(kebunSafari != null){
            kebunSafari.setNoTelepon(noTelepon);
            model.addAttribute("kebunSafari", kebunSafari);
            return "update-kebun-safari";
        }
        else{
            return "error";
        }
    }

    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteteKebunSafari(@PathVariable(value = "id", required = true) String idKebunSafari, Model model) {
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        if(kebunSafari != null){
            kebunSafariService.deleteKebunSafariByIdKebunSafari(idKebunSafari);
            model.addAttribute("kebunSafari", kebunSafari);
            return "delete-kebun-safari";
        }
        else{
            return "error";
        }

    }
}
