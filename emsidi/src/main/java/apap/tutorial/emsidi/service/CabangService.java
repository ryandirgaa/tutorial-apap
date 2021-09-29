package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);

    //Method untuk menghapus cabang (menjawab latihan nomor 4)
    void deleteCabang(CabangModel cabang);

    List<CabangModel> getCabangList();
    CabangModel getCabangByNoCabang(Long noCabang);

    //Method untuk menghandle apakah bisa update dan delete pada current time
    boolean canUpdateDelete(CabangModel cabang);
}
