package com.veysel;

import com.veysel.controller.KitapController;
import com.veysel.controller.UserController;
import com.veysel.controller.YazarController;
import com.veysel.repository.entity.Kitap;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;
import com.veysel.util.DataGenerator;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    Scanner sc= new Scanner(System.in);
    KitapController kitapController;
    UserController userController;

    YazarController yazarController;

    public Main() {
        this.kitapController=new KitapController();
        this.yazarController=new YazarController();
        this.userController=new UserController();
        this.sc=new Scanner(System.in);
    }

    public static void main(String[] args) {

        Main main=new Main();
//        DataGenerator dataGenerator= new DataGenerator();
//        dataGenerator.verileriOlustur();
//        UserController userController=new UserController();
//
       main.libraryApp();


    }

    public Optional<User> login() {

        System.out.print("TcKimlikNo Gİriniz : ");
        String tc=sc.nextLine();
        Optional<User>user = userController.findByTcKimlik(tc);
        if(user.isPresent()){
            System.out.println("Hoşgeldiniz : "+user.get().getAd());
        }else {
            System.out.println("Hatali Giriş");
            login();
        }
        return user;
    }

    public void userMenu(Optional<User>user){
        int secim=0;
        do{
            System.out.println("1- Kitap Satin Al");
            System.out.println("2- Bakiye Yukle");
            System.out.println("0- Cikis Yap");
            System.out.print("Secim yapiniz : ");
            secim = Integer.parseInt(sc.nextLine());
            switch (secim){

                case 1:kitapSatinAl(user);break;
                case 2:bakiyeYukle(user);break;
                case 0:break;
            }
        }while (secim!=0);

    }

    private void bakiyeYukle(Optional<User> user) {
        System.out.println(user.get().getParaMiktari()+" tl bulunmaltadır");
        System.out.print("Yüklemek İstediğiniz Tutar :");
        Double tutar=Double.parseDouble(sc.nextLine());
        user.get().setParaMiktari(tutar+user.get().getParaMiktari());
        System.out.println(user.get().getParaMiktari()+" tl bulunmaltadır");
        userController.update(user.get());
    }

    private void kitapSatinAl(Optional<User> user) {
        List<Kitap>kitapList=kitapController.findAll().stream().filter(kitap ->
                kitap.isSatistaMi()==true).collect(Collectors.toList());

        kitapList.forEach(System.out::println);
        System.out.println("Hangi Kitabı Almak İstiyorsunuz");
        Long secim=Long.parseLong(sc.nextLine());
        Optional<Kitap> kitap =kitapController.findByID(secim);
        if (kitap.isPresent()){

        }else {
            System.out.println("Yanlış Kitap Idsi");
        }

    }

    public void libraryApp(){
        int secim=0;
        do{
            secim=mainMenu();
            switch (secim){
                case 1:{Optional<User> user = login();
                if(user.isPresent()){
                    userMenu(user);
                }
                break;}
                case 2:{
                    kitapController.findAll().forEach(System.out::println);
                    break;
                }
                case 3:{
                    kitapController.BooksInStock().forEach(System.out::println);
                   break;
                }
                case 4:{
                    yazarController.findAll().forEach(System.out::println);
                    break;
                }
                case 5:{
                    kitapController.kitapSave();
                    break;
                }
                case 6:{
                    yazarController.yazarEkle();
                    break;
                }
                case 7:{
                    userController.userSave();
                    break;
                }
                case 8:{
                kitapController.tureGoreKitapBul().forEach(System.out::println);
                }

            }
        }while (secim!=0);


    }

    private int mainMenu() {
        System.out.println("### Kutuphaneye Hosgeldiniz! ####");
        System.out.println("1- Giris Yap");//tc kimlik alıcak
        System.out.println("2- Tum Kitaplari Goster");
        System.out.println("3- Stoktaki Kitaplar");//query ile getir
        System.out.println("4- Yazarlari Goster");
        System.out.println("5- Kitap Ekle");
        System.out.println("6- Yazar Ekle");
        System.out.println("7- Kullanici Ekle");
        System.out.println("8- Turune Gore Kitap Ara");
        System.out.println("0 - Cikis");
        System.out.print("Secim yapiniz : ");
        Integer secim = Integer.parseInt(sc.nextLine());
        return secim;
        //TODO 8-2-3-4
    }


    //giriş kontrol isimle metot içeride tc kimlik alıcak NativeQueryden yakala
    //burdan gelen tc kimlik kullanıcıcontroller.tckimlikno ya göre userbul isimli bir metotda metoda parametre olarak vericem
    /*
    tc kimlik no girildi
    queryden tckimlik kontrol yapıcam optional kullanıcı dönücek(db de yoksa null pointer olur)

    kullanıcı menüsü(optional Kullanıcı)
    kitap satın al felan hepsi burda olucak


     */

//    public Integer menu(){
//        Scanner scanner=new Scanner(System.in);

//    }
//

}