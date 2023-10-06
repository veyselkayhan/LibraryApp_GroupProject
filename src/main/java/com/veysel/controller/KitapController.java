package com.veysel.controller;

import com.veysel.repository.entity.Kitap;
import com.veysel.service.KitapService;

import java.util.List;
import java.util.Optional;

public class KitapController {
    KitapService kitapService;

    public KitapController() {
        this.kitapService=new KitapService();
    }

    public Kitap save(Kitap kitap){
        return kitapService.save(kitap);
    }

    public List<Kitap> saveAll(List<Kitap>kitapList){
        return (List<Kitap>) kitapService.saveAll(kitapList);
    }

    public List<Kitap>findAll(){
        return kitapService.findAll();
    }

    public Optional<Kitap> findByID(Long id){
        return kitapService.findByID(id);
    }
}
