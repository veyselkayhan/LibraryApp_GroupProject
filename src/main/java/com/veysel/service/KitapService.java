package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.KitapRepository;
import com.veysel.repository.entity.Kitap;
import com.veysel.repository.entity.User;

import java.util.List;

public class KitapService  extends  MyFactoryService<Kitap,ID>{

    public KitapService() {
        super(new Kitap());
    }


}
