package com.Cotizacion.CotizacionProject.controller;


import com.Cotizacion.CotizacionProject.dependency.JpaCotizacion;
import com.Cotizacion.CotizacionProject.entity.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ControllerCotizacion {

    @Autowired
    JpaCotizacion cotiJpa;


    @GetMapping("/")
    public List showAll(){
        return cotiJpa.showAll();
    }
    @PostMapping("/")
    public void create(@RequestBody Cotizacion c){
        cotiJpa.create(c);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cotiJpa.delete(id);
    }
    @PutMapping("/{id}")
    public void Modify(@RequestBody Cotizacion c,@PathVariable Long id){
        c.setId(id);
        cotiJpa.Modify(c);
    }

    @GetMapping("/date")
    public List orderByDate(){
        return cotiJpa.orderByDate();
    }
    @GetMapping("/price")
    public List orderByPrice(){
        return cotiJpa.orderByPrice();
    }
    @GetMapping("/type")
    public List orderByType(){
        return cotiJpa.orderByType();
    }

    @GetMapping("/range/{startDate}")
    public List returnRange(@PathVariable Date startDate){
        return cotiJpa.orderByRangeDate(startDate);
    }

}
