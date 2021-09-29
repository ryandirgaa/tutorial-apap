package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    //Method untuk update pegawai (menjawab latihan no 2)
    @Override
    public void updatePegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    //Method untuk delete pegawai (menjawab latihan no 3)
    @Override
    public void deletePegawai(PegawaiModel pegawai){ pegawaiDb.delete(pegawai); }

    @Override
    public List<PegawaiModel> getPegawaiList(){
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai){
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if(pegawai.isPresent())
            return pegawai.get();
        return null;
    }

}
