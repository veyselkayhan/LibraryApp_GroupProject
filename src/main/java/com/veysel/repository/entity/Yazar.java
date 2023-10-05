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
@Table(name = "tbl_yazar")
public class Yazar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    private String ad;

    @Column(nullable = false)
    private String soyad;

    private LocalDate dogumTarihi;

    private LocalDate olumTarihi;

    private String ulke;

    private String biyografi;

    private List <Kitap> kitaplari;

}
