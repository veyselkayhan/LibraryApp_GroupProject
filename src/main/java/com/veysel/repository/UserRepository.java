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
import java.util.Scanner;

public class UserRepository extends MyFactoryRepository<User, ID> {
    EntityManager entityManager;
    public UserRepository() {
        super(new User());
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();

    }

    public Optional<User> findByTcKimlik(String tc) {
        User user=null;
        String sql = "SELECT * FROM tbl_user WHERE tckimlik = :tcKimlik";
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createNativeQuery(sql, User.class);
        query.setParameter("tcKimlik", tc);
        try{
            user = (User) query.getSingleResult();

        }catch (Exception e){

        }
        return Optional.ofNullable(user);
    }

    public User userSave() {
        System.out.print("Kullanıcı Adınız :");
        String userName= new Scanner(System.in).nextLine();
        System.out.println(" Adınız :");
        String name= new Scanner(System.in).nextLine();
        System.out.println(" Soyadınız :");
        String surname= new Scanner(System.in).nextLine();
        System.out.print("Tc Kimlik Numarası :");
        String tcKimlikNo=new Scanner(System.in).nextLine();
        System.out.print("Telefon Numaranız : ");
        String tel=new Scanner(System.in).nextLine();
        System.out.println("İlk Eklenecek Tutar");
        Double paraMiktari=new Scanner(System.in).nextDouble();

        User user=User.builder()
                .ad(name)
                .soyad(surname)
                .tcKimlik(tcKimlikNo)
                .telefonNo(tel)
                .paraMiktari(paraMiktari)
                .build();
        return save(user);
    }
}
