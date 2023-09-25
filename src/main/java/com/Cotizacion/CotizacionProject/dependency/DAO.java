package com.Cotizacion.CotizacionProject.dependency;

import com.Cotizacion.CotizacionProject.entity.Cotizacion;

import java.util.Date;
import java.util.List;

public interface DAO {

    public List showAll();

    public void create(Cotizacion c);

    public void delete(Long id);

    public void Modify(Cotizacion c);

    public List orderByDate();

    public List orderByPrice();

    public List orderByType();

    public List<Cotizacion> orderByRangeDate(Date fecha);


}
