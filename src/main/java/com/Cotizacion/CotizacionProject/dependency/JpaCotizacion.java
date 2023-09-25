package com.Cotizacion.CotizacionProject.dependency;

import com.Cotizacion.CotizacionProject.entity.Cotizacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
@Transactional
public class JpaCotizacion implements DAO{

    @PersistenceContext
    EntityManager em;


    @Override
    public List showAll() {
        String query = "FROM Cotizacion";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void create(Cotizacion c) {
        em.merge(c);
    }

    @Override
    public void delete(Long id) {
    Cotizacion c = em.find(Cotizacion.class,id);
    em.remove(c);
    }

    @Override
    public void Modify(Cotizacion c) {
        Cotizacion c2 = em.find(Cotizacion.class,c.getId());

        c2.setDate_new(new Date());
        c2.setPrice(c.getPrice());
        c2.setExchange(c.getExchange());
        em.persist(c2);
    }

    @Override
    public List orderByDate() {
        return em.createQuery("FROM Cotizacion order by date_start asc").getResultList();
    }

    @Override
    public List orderByPrice() {
        return em.createQuery("FROM Cotizacion order by price asc").getResultList();
    }

    @Override
    public List orderByType() {
        return em.createQuery("FROM Cotizacion order by exchange asc").getResultList();
    }

    @Override
    public List orderByRangeDate(Date startDate) {
      String query = "FROM Cotizacion WHERE date_start >= :date_start";
      return em.createQuery(query).setParameter("date_start",startDate).getResultList();

    }
}
