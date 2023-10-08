package com.veysel.controller;

import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;
import com.veysel.service.YazarService;

import java.util.List;

public class YazarController {

    YazarService yazarService;

    public YazarController() {
        this.yazarService=new YazarService();
    }

    public Yazar save(Yazar yazar){
        return yazarService.save(yazar);
    }

    public List<Yazar> saveAll(List<Yazar>yazarList){
        return (List<Yazar>) yazarService.saveAll(yazarList);
    }

    public List<Yazar>findAll(){
      return yazarService.findAll();
    }

    public void update(Yazar yazar){
        yazarService.update(yazar);
    }

    public Yazar yazarEkle(){
        return yazarService.yazarEkle();
    }
}
