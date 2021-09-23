package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabangServiceImpl implements CabangService {

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    @Override
    public void updateCabang(CabangModel cabang){
        cabangDb.save(cabang);
    }

    //Method untuk menghapus cabang (menjawab latihan nomor 4)
    @Override
    public void deleteCabang(CabangModel cabang){ cabangDb.delete(cabang); }

    @Override
    public List<CabangModel> getCabangList(){
        return cabangDb.findAll();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang){
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if(cabang.isPresent())
            return cabang.get();
        return null;
    }

    //Method untuk menghandle apakah bisa update dan delete pada current time
    @Override
    public boolean canUpdateDelete(CabangModel cabang){
        LocalTime currentTime = LocalTime.now(), waktuBuka = cabang.getWaktuBuka(), waktuTutup = cabang.getWaktuTutup();
        boolean canUpdate = false;

        if(waktuBuka.compareTo(waktuTutup) == -1){
            if(currentTime.compareTo(waktuTutup) >= 0 || currentTime.compareTo(waktuBuka) < 0) canUpdate = true;
            else canUpdate = false;

        }
        else if(waktuBuka.compareTo(waktuTutup) == 1){
            if(currentTime.compareTo(waktuTutup) >= 0 && currentTime.compareTo(waktuBuka) < 0) canUpdate = true;
            else canUpdate = false;
        }

        return canUpdate;
    }
}
