package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.Kitap;
import com.veysel.util.MyFactoryRepository;

public class KitapRepository extends MyFactoryRepository<Kitap, ID> {

    public KitapRepository() {
        super(new Kitap());
    }
}
