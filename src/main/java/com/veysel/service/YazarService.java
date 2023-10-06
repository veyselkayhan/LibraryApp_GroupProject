package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.YazarRepository;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;

import java.util.List;

public class YazarService extends MyFactoryService<Yazar,ID>{

    public YazarService() {
        super(new Yazar());
    }
}
