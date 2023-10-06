package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.User;
import com.veysel.util.HibernateUtility;
import com.veysel.util.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepository extends MyFactoryRepository<User, ID> {
    EntityManager entityManager;
    public UserRepository() {
        super(new User());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();

    }

    public Optional<User> findByTcKimlik(String tc) {
        User user=null;
        String sql = "SELECT * FROM tbl_user WHERE tckimlik = :tcKimlik";
        Query query = entityManager.createNativeQuery(sql, User.class);
        query.setParameter("tcKimlik", tc);
        try{
            user = (User) query.getSingleResult();

        }catch (Exception e){

        }
        return Optional.ofNullable(user);
    }
}
