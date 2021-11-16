package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
//import apap.tutorial.emsidi.rest.PegawaiDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PegawaiRestService {
    PegawaiModel createPegawai(PegawaiModel pegawai);
    List<PegawaiModel> retrieveListPegawai();
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    List<PegawaiModel> getPegawaiByJenisKelamin(int jenisKelamin);
//    PegawaiModel getPegawaiByJenisKelamin(int jenisKelamin);
    PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawai);
    void deletePegawai(Long noPegawai);
    PegawaiModel updateUmur(Long noPegawai, PegawaiModel pegawaiUpdate);
}
