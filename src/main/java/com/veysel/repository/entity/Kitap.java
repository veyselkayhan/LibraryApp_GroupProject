package com.veysel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_kitap")
public class Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    private String ad;


    @Column(nullable = false)
    private Long yazarId;

    @Column(nullable = false)
    private String yazarAdiSoyadi;

    private String tur;
    @Column(nullable = false)
    private int sayfaSayisi;


    private String yayinEvi;

    private LocalDate yayinTarihi;

    @Column(nullable = false,unique = true)
    private Long isbn;

//    eger deger yoksa 0 olacak
    private int adet;

//    eger deger yoksa 0 olacak

    private double fiyat;

    private boolean satistaMi;




}
