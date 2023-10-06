package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;
import com.veysel.util.HibernateUtility;
import com.veysel.util.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UserRepository extends MyFactoryRepository<User, ID> {
    EntityManager entityManager;
    public UserRepository() {
        super(new User());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();

    }

    public Optional<User> findByTcKimlik(String tc) {
        TypedQuery<User> userNative=entityManager.createNamedQuery("SELECT * FROM tbl_user WHERE tbl_user.tckimlik ='tc'",User.class);

        //TODO doldurulacak
        return  null;
    }
}
