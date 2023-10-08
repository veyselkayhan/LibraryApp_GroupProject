package com.veysel.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.entity.Kitap;
import com.veysel.util.HibernateUtility;
import com.veysel.util.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class KitapRepository extends MyFactoryRepository<Kitap, ID> {

    EntityManager entityManager;

    public KitapRepository() {

        super(new Kitap());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();
    }

    public List<Kitap> BooksInStock() {
        String sql = "SELECT * FROM tbl_kitap WHERE satistami = true";
        TypedQuery<Kitap> kitapQuery = (TypedQuery<Kitap>) entityManager.createNativeQuery(sql, Kitap.class);

        try {
            return kitapQuery.getResultList();
        } catch (Exception e) {
            // Handle the exception or log it properly
            e.printStackTrace();
        }

        return null;
    }



}
