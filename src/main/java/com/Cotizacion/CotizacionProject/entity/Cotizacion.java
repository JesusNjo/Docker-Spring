package com.Cotizacion.CotizacionProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date date_start = new Date();

    @Column(name = "date_new")
    @Temporal(TemporalType.DATE)
    private Date date_new = new Date();


    @Column(name = "price")
    private int price;

    @Column(name = "exchange")
    private String exchange;


}
