package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.Kitap;

public class KitapService extends MyFactoryService<Kitap, ID> {
    public KitapService() {
        super(new Kitap());
    }
}
