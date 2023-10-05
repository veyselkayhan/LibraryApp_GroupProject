package com.veysel.util;

import com.veysel.controller.KitapController;
import com.veysel.controller.UserController;
import com.veysel.controller.YazarController;
import com.veysel.repository.UserRepository;
import com.veysel.repository.entity.User;
import com.veysel.service.UserService;

import java.util.List;
import java.util.Scanner;

public class DataGenerator {
static Scanner sc= new Scanner(System.in);
KitapController kitapController;
UserController userController;
YazarController yazarController;

    public DataGenerator() {
        this.kitapController=new KitapController();
        this.userController=new UserController();
        this.yazarController=new YazarController();
    }

    public static void userOlustur(){
        System.out.print("Ad :");
        String ad=sc.nextLine();
        System.out.print("Soyad :");
        String soyad=sc.nextLine();
        System.out.print("TcKimlik");
        String tc= sc.nextLine();
        System.out.print("Tel");
        String tel=sc.nextLine();
        System.out.println("Para Miktari");
        double para=sc.nextDouble();
        User user= User.builder()
                .ad(ad)
                .soyad(soyad)
                .tcKimlik(tc)
                .telefonNo(tel)
                .paraMiktari(para)
                .build();

        new UserService().save(user);

    }


}
