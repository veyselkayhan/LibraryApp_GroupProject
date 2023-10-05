package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.Yazar;
import com.veysel.util.MyFactoryRepository;

public class YazarRepository extends MyFactoryRepository<Yazar, ID> {

    public YazarRepository() {
        super(new Yazar());
    }
}
