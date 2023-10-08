package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.KitapRepository;
import com.veysel.repository.UserRepository;
import com.veysel.repository.YazarRepository;
import com.veysel.repository.entity.Kitap;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;
import com.veysel.util.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class KitapService  extends  MyFactoryService<Kitap,Long>{

    KitapRepository kitapRepository;
    EntityManager entityManager;

    CriteriaBuilder criteriaBuilder;
    public KitapService() {
        super(new Kitap());
        this.kitapRepository=new KitapRepository();
        this.entityManager= HibernateUtility.getSessionFactory().createEntityManager();
        this.criteriaBuilder=entityManager.getCriteriaBuilder();

    }


    public List<Kitap> BooksInStock() {
        return kitapRepository.BooksInStock();
    }

    public Kitap kitapSave() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kitap Adini Giriniz : ");
        String kitapAdi = scanner.nextLine();
        System.out.print("Kitap Turunu Giriniz : ");
        String kitapTuru = scanner.nextLine();
        System.out.print("Kitap Adedini Giriniz : ");
        Integer kitapAdedi = Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinevini Giriniz : ");
        String yayinEvi = scanner.nextLine();
        System.out.print("Kitap Yayinlanma Yilini Giriniz : ");
        Integer yayinlanmaYili = Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinlanma Ayini Giriniz : ");
        Integer yayinlanmaAyi = Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Yayinlanma Gununu Giriniz : ");
        Integer yayinlanmaGunu = Integer.parseInt(scanner.nextLine());
        System.out.print("Kitap Fiyatini Giriniz : ");
        Double fiyat = Double.parseDouble(scanner.nextLine());
        System.out.print("Kitap ISBN Giriniz : ");
        Long isbn = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Kitap Yazar Adini Soyadini Giriniz : ");
        String adSoyad = scanner.nextLine();
        System.out.print("Kitap Sayfa Sayisini Giriniz : ");
        Integer sayfaSayisi = Integer.parseInt(scanner.nextLine());


        Long yazarid = null;

        List<Yazar> yazarList = new YazarRepository().findByColumnNameAndValue("adSoyad", adSoyad);
        if (!yazarList.isEmpty()) {
            yazarid = yazarList.get(0).getId();
        } else {
            System.out.println("Yazar Bulunamadi Önce Yazar Eklemesi Yapınız");
            return null;
        }

        Kitap kitap = Kitap.builder()
                .ad(kitapAdi)
                .tur(kitapTuru)
                .adet(kitapAdedi)
                .yayinEvi(yayinEvi)
                .yayinTarihi(LocalDate.of(yayinlanmaYili, yayinlanmaAyi, yayinlanmaGunu))
                .fiyat(fiyat)
                .isbn(isbn)
                .yazarAdiSoyadi(adSoyad) // Set the author's name here
                .yazarId(yazarid)
                .sayfaSayisi(sayfaSayisi)
                .build();

        kitapRepository.save(kitap);
        System.out.println("Ekleme Başarılı");
        return kitap;

    }


    public List<Kitap> tureGoreKitapBul() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Turu Giriniz");
        String tur=scanner.nextLine();
        String sql = "SELECT * FROM tbl_kitap WHERE tur = ?";
        TypedQuery<Kitap> kitapTypedQuery = (TypedQuery<Kitap>) entityManager.createNativeQuery(sql, Kitap.class);
        kitapTypedQuery.setParameter(1, tur);
        List<Kitap> turList = kitapTypedQuery.getResultList();
        if(turList.isEmpty()){
            System.out.println("Böyle Bir tür Bulunamadi");
            return tureGoreKitapBul();
        }else {
            return turList;
        }

    }


    public void findKıtapId(User user) {
        kitapRepository.findKıtapId(user);
    }
}
