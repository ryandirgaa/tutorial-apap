package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;

import java.util.List;

public interface KebunSafariService {
    //Method untuk menambah KebunSafari baru
    void addKebunSafari(KebunSafariModel kebunSafari);

    //Method untuk menadpatkan semua daftar KebunSafari
    List<KebunSafariModel> getKebunSafariList();

    //Method untuk mendapatkan sebuah KebunSafari berdasarkan ID yang dimiliki
    KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari);

    //Method untuk menghapus sebuah KebunSafari berdasarkan ID yang dimiliki
    void deleteKebunSafariByIdKebunSafari(String idKebunSafari);
}
