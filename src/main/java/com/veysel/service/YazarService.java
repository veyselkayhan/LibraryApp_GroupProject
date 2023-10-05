package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.Yazar;

public class YazarService extends MyFactoryService<Yazar, ID> {
    public YazarService() {
        super(new Yazar());
    }
}
