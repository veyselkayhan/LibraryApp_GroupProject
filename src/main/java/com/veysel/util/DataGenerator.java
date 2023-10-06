package com.veysel.util;

import com.veysel.controller.KitapController;
import com.veysel.controller.UserController;
import com.veysel.controller.YazarController;
import com.veysel.repository.UserRepository;
import com.veysel.repository.entity.Kitap;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;
import com.veysel.service.KitapService;
import com.veysel.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DataGenerator {
static Scanner sc= new Scanner(System.in);
KitapController kitapController;
UserController userController;
YazarController yazarController;

KitapService kitapService;


    public DataGenerator() {
        this.kitapController=new KitapController();
        this.kitapService=new KitapService();
        this.userController=new UserController();
        this.yazarController=new YazarController();
    }

    public List<User> userOlustur(){
        User user= User.builder()
                .ad("Veysel")
                .soyad("Kayhan")
                .tcKimlik("11111111111")
                .telefonNo("5378470633")
                .paraMiktari(5000.0)
                .build();


        User user1= User.builder()
                .ad("Burak")
                .soyad("Bilek")
                .tcKimlik("22222222222")
                .paraMiktari(6000.0)
                .telefonNo("5384560499")
                .build();

        User user2 = User.builder()
                .ad("Ali")
                .soyad("Cabbar")
                .telefonNo("5389657422")
                .tcKimlik("33333333333")
                .paraMiktari(100.0)
                .build();

        User user3= User.builder()
                .ad("Basri")
                .soyad("Kayhan")
                .telefonNo("5321475896")
                .paraMiktari(10000.0)
                .tcKimlik("15478563217")
                .build();
        return userController.saveAll(List.of(user,user1,user2,user3));

    }



    public List<Kitap> kitapOlustur(List<Yazar>yazarList){
        Kitap kitap=Kitap.builder()
                .ad("Harry Potter")
                .isbn(5456465L)
                .tur("Bilim Kurgu")
                .adet(45)
                .fiyat(50)
                .sayfaSayisi(500)
                .yazarId(yazarList.get(0).getId())
                .yazarAdi(yazarList.get(0).getAd()+" " +yazarList.get(0).getSoyad())
                .yayinEvi("İş bankası")
                .satistaMi(true)
                .build();

        Kitap kitap1=Kitap.builder()
                .ad("Yüzüklerin Efendisi")
                .fiyat(50)
                .tur("Bilim Kurgu")
                .yazarAdi(yazarList.get(1).getAd()+" "+yazarList.get(1).getSoyad())
                .yazarId(yazarList.get(1).getId())
                .adet(45)
                .isbn(45646L)
                .sayfaSayisi(400)
                .satistaMi(true)
                .build();


        Kitap kitap2=Kitap.builder()
                .ad("Da Vincinin Şifresi")
                .fiyat(65)
                .tur("Gizem")
                .yazarAdi(yazarList.get(2).getAd()+" "+yazarList.get(2).getSoyad())
                .yazarId(yazarList.get(2).getId())
                .adet(45)
                .isbn(456786L)
                .sayfaSayisi(250)
                .satistaMi(true)
                .build();

        Kitap kitap3 = Kitap.builder()
                .satistaMi(true)
                .tur("Gizem")
                .yazarAdi(yazarList.get(1).getAd())
                .adet(20)
                .isbn(465231L)
                .fiyat(2000)
                .yayinEvi("İş bankası")
                .sayfaSayisi(27)
                .yazarId(yazarList.get(1).getId())
                .ad("Muhammet Hocanın Yolu")
                .build();
        Kitap kitap4 = Kitap.builder()
                .satistaMi(true)
                .tur("Gizem")
                .yazarAdi(yazarList.get(2).getAd())
                .adet(70)
                .isbn(78895L)
                .fiyat(70)
                .yayinEvi("İş bankası")
                .sayfaSayisi(700)
                .yazarId(yazarList.get(2).getId())
                .ad("Kitapsızın Kitabı")
                .build();
        Kitap kitap5 = Kitap.builder()
                .satistaMi(true)
                .tur("Gizem")
                .yazarAdi(yazarList.get(4).getAd())
                .adet(30)
                .isbn(645789L)
                .fiyat(38)
                .yayinEvi("İş bankası")
                .sayfaSayisi(500)
                .yazarId(yazarList.get(4).getId())
                .ad("Ali Tatilde")
                .build();
        Kitap kitap6 = Kitap.builder()
                .satistaMi(true)
                .tur("Gizem")
                .yazarAdi(yazarList.get(3).getAd())
                .adet(15)
                .isbn(54875L)
                .fiyat(47)
                .yayinEvi("İş bankası")
                .sayfaSayisi(87)
                .yazarId(yazarList.get(3).getId())
                .ad("Zeynep'in kitabı")
                .build();

        Kitap kitap7 = Kitap.builder()
                .ad("Melekler ve Şeytanlar")
                .fiyat(75)
                .tur("Gizem")
                .yazarAdi(yazarList.get(2).getAd()+" "+yazarList.get(2).getSoyad())
                        .yazarId(yazarList.get(2).getId())
                        .adet(50)
                        .isbn(412678L)
                        .sayfaSayisi(250)
                        .satistaMi(true)
                        .build();
        Kitap kitap8=Kitap.builder()
                .ad("Digital Kale")
                .fiyat(65)
                .tur("Gizem")
                .yazarAdi(yazarList.get(2).getAd()+" "+yazarList.get(2).getSoyad())
                .yazarId(yazarList.get(2).getId())
                .adet(45)
                .isbn(4567896L)
                .sayfaSayisi(250)
                .satistaMi(true)
                .build();

        Kitap kitap9=Kitap.builder()
                .ad("Cehennem")
                .fiyat(65)
                .tur("Gizem")
                .yazarAdi(yazarList.get(2).getAd()+" "+yazarList.get(2).getSoyad())
                .yazarId(yazarList.get(2).getId())
                .adet(45)
                .isbn(45678916L)
                .sayfaSayisi(250)
                .satistaMi(true)
                .build();


        return kitapController.saveAll(List.of(kitap,kitap1,kitap2,kitap3,kitap4,kitap5,kitap6,kitap7,kitap8,kitap9));



    }

    public List<Yazar>yazarOlustur(){
        Yazar yazar= Yazar.builder()
                .ad("J.R.R")
                .soyad("Tolkien")
                .ulke("Ingiliz")
                .dogumTarihi(LocalDate.of(1850,5,14))
                .olumTarihi(LocalDate.of(1950,7,4))
                .biyografi("Orta Dünya")
                .build();

        Yazar yazar1= Yazar.builder()
                .ad("J.K")
                .soyad("Rowling")
                .ulke("Ingiliz")
                .dogumTarihi(LocalDate.of(1965,4,12))
                .biyografi("Magic Word")
                .build();

        Yazar yazar2 = Yazar.builder()
                .ad("Dan")
                .soyad("Brown")
                .ulke("Ingiliz")
                .dogumTarihi(LocalDate.of(1970,4,23))
                .build();

        Yazar yazar3=Yazar.builder()
                .ad("Orhan")
                .soyad("Pamuk")
                .ulke("Turk")
                .dogumTarihi(LocalDate.of(1940,5,23))
                .biyografi("Nobel Odullu Turk Yazar")
                .build();

        Yazar yazar4= Yazar.builder()
                .ad("Suzanne")
                .soyad("Collins")
                .ulke("Amerika")
                .dogumTarihi(LocalDate.of(1980,4,8))
                .biyografi("New Word")
                .build();

        return yazarController.saveAll(List.of(yazar,yazar2,yazar3,yazar4,yazar1));
    }


    public void guncelle(List<Kitap>kitapList,List<Yazar>yazarList){
        Yazar yazar=yazarList.get(0);
        Yazar yazar1=yazarList.get(1);
        Yazar yazar2=yazarList.get(2);
        Yazar yazar3=yazarList.get(3);
        Yazar yazar4=yazarList.get(4);

       yazar.setKitaplari(List.of(kitapList.get(0).getAd(),kitapList.get(1).getAd()));
       yazar1.setKitaplari(List.of(kitapList.get(2).getAd(),kitapList.get(3).getAd()));
       yazar2.setKitaplari(List.of(kitapList.get(4).getAd(),kitapList.get(5).getAd()));
       yazar3.setKitaplari(List.of(kitapList.get(6).getAd(),kitapList.get(7).getAd()));
       yazar4.setKitaplari(List.of(kitapList.get(8).getAd(),kitapList.get(9).getAd()));

       yazarController.saveAll(List.of(yazar,yazar1,yazar2,yazar3,yazar4));
    }

    public void verileriOlustur() {
        List<Yazar> yazarList = yazarOlustur();
        List<User> userList = userOlustur();
        List<Kitap> kitapList = kitapOlustur(yazarList);
        guncelle(kitapList, yazarList);
    }




}
