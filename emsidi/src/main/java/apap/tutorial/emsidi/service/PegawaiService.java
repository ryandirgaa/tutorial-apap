package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);

    //Method untuk update pegawai (menjawab latihan no 2)
    void updatePegawai(PegawaiModel pegawai);

    //Method untuk delete pegawai (menjawab latihan no 3)
    void deletePegawai(PegawaiModel pegawai);

    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
}
