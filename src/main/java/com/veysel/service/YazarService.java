package com.veysel.service;

import com.sun.xml.bind.v2.model.core.ID;
import com.veysel.repository.YazarRepository;
import com.veysel.repository.entity.User;
import com.veysel.repository.entity.Yazar;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class YazarService extends MyFactoryService<Yazar,ID>{

    YazarRepository yazarRepository;
    public YazarService() {
        super(new Yazar());
        this.yazarRepository=new YazarRepository();
    }

    public Yazar yazarEkle() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Yazar Adini Soyadini Giriniz : ");
        String adSoyad = scanner.nextLine();
        System.out.print("Yazar Biyografisini Giriniz : ");
        String biyografi =scanner.nextLine();
        System.out.print("Yazar Ulkesini Giriniz : ");
        String ulke = scanner.nextLine();
        System.out.print("Yazarin Dogdugu Yili Giriniz : ");
        Integer yil= Integer.parseInt(scanner.nextLine());
        System.out.print("Yazarin Dogdugu Ayi Giriniz : ");
        Integer ay= Integer.parseInt(scanner.nextLine());
        System.out.print("Yazarin Dogdugu Gunu Giriniz : ");
        Integer gun = Integer.parseInt(scanner.nextLine());
        System.out.print("Yazar hala hayatta mi? (E/H) : ");
        if(scanner.nextLine().equalsIgnoreCase("H")){
            System.out.print("Yazarin Oldugu Yili Giriniz : ");
            Integer olumYil= Integer.parseInt(scanner.nextLine());
            System.out.print("Yazarin Oldugu Ayi Giriniz : ");
            Integer olumAy= Integer.parseInt(scanner.nextLine());
            System.out.print("Yazarin Oldugu Gunu Giriniz : ");
            Integer olumGun = Integer.parseInt(scanner.nextLine());

            Yazar yazar = Yazar.builder()
                    .adSoyad(adSoyad)
                    .biyografi(biyografi)
                    .ulke(ulke)
                    .dogumTarihi(LocalDate.of(yil,gun,ay))
                    .olumTarihi(LocalDate.of(olumYil,olumAy,olumGun))
                    .build();
            yazarRepository.save(yazar);
            System.out.println("Yazar basariyla eklendi...");
            return yazar;
        } else {
            Yazar yazar = Yazar.builder()
                    .adSoyad(adSoyad)
                    .biyografi(biyografi)
                    .ulke(ulke)
                    .dogumTarihi(LocalDate.of(yil,gun,ay))
                    .build();
            yazarRepository.save(yazar);
            System.out.println("Yazar basariyla eklendi...");
            return yazar;
        }
    }
}
