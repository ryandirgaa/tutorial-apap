package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    //Constructor
    public KebunSafariInMemoryService() {
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){
        KebunSafariModel listKebunById = null;
        for (int i = 0; i < listKebunSafari.size(); i++) {
            if(listKebunSafari.get(i).getIdKebunSafari().equals(idKebunSafari)){
                listKebunById = listKebunSafari.get(i);
            }
        }
        return listKebunById;
    }

    @Override
    public void deleteKebunSafariByIdKebunSafari(String idKebunSafari){
        for (int i = 0; i < listKebunSafari.size(); i++) {
            if(listKebunSafari.get(i).getIdKebunSafari().equals(idKebunSafari)){
                listKebunSafari.remove(i);
            }
        }
    }

}
