package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

import java.time.LocalTime;


@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @GetMapping("pegawai/add/{noCabang}")
    public String addPegawaiForm(@PathVariable Long noCabang, Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);

        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);

        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, String namaPegawai, CabangModel cabang, Model model){
        List<PegawaiModel> listPegawai = pegawaiService.getPegawaiList();

        boolean can = true;

        for (int i = 0; i < listPegawai.size(); i++) {
            if(listPegawai.get(i).getNamaPegawai().equals(pegawai.getNamaPegawai())){
                can = false;
                break;
            }
            else{
                continue;
            }
        }
        if(can == true){
            pegawaiService.addPegawai(pegawai);
            model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
            model.addAttribute("namaPegawai", pegawai.getNamaPegawai());

            return "add-pegawai";
        }
        else{
            return "error";
        }

    }

    /* Method tambahan untuk menjawab latihan nomor 2
    Jika tidak memenuhi condition, halaman error ditampilkan (latihan nomor 5)*/
    @GetMapping("/pegawai/update/{noCabang}/{noPegawai}")
    public String updatePegawaiForm(@PathVariable Long noCabang, @PathVariable Long noPegawai, Model model){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        boolean canUpdate = cabangService.canUpdateDelete(cabang);

        if(canUpdate == true) {
            pegawai.setCabang(cabang);
            model.addAttribute("noCabang", noCabang);
            model.addAttribute("pegawai", pegawai);

            return "form-update-pegawai";
        }
        else {
            return "error";
        }
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model){
        pegawaiService.updatePegawai(pegawai);
        model.addAttribute("noPegawai", pegawai.getNoPegawai());

        return "update-pegawai";
    }

    /* Method tambahan untuk menjawab latihan nomor 3
    Jika tidak memenuhi condition, halaman error ditampilkan (latihan nomor 5)*/
    @GetMapping("/pegawai/delete/{noCabang}/{noPegawai}")
    public String deletePegawai(@PathVariable Long noCabang, @PathVariable Long noPegawai, Model model){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        boolean canUpdate = cabangService.canUpdateDelete(cabang);

        if(canUpdate == true) {
            pegawaiService.deletePegawai(pegawai);
            model.addAttribute("noPegawai", pegawai.getNoPegawai());

            return "delete-pegawai";
        }
        else {
            return "error";
        }
    }

}
