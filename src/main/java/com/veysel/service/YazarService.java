package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.YazarRepository;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;

import java.util.List;

public class YazarService   {

    YazarRepository yazarRepository;

    public YazarService() {
        this.yazarRepository=new YazarRepository();
    }

    public Yazar save(Yazar yazar){
        return yazarRepository.save(yazar);
    }

    public List<Yazar> saveAll(List<Yazar> yazarList){
        return (List<Yazar>) yazarRepository.saveAll(yazarList);
    }

}
