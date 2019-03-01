package app.dao;


import app.entities.Promotion;
import app.entities.PromotionPK;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PromotionDAOHibernateImpl implements PromotionDAO {



    private EntityManager entityManager;
    @Autowired
    public PromotionDAOHibernateImpl(EntityManager theentityManager){

        entityManager=theentityManager;
    }

    @Override
    @Transactional
    public List<Promotion> findAll() {
        Session currentsession=entityManager.unwrap(Session.class);



        Query<Promotion> query=
                currentsession.createQuery("from Promotion",Promotion.class);


        List<Promotion> promotions=query.getResultList();

        return promotions;
    }

    @Override
    @Transactional
    public Promotion findByLieux(String lieux) {
        Session currentsession=entityManager.unwrap(Session.class);
        Query<Promotion> query=
                currentsession.createQuery("from Promotion",Promotion.class);

        List<Promotion> promotions=query.getResultList();

        for (Promotion promotion:promotions){
            if(promotion.getLieuRentree().equalsIgnoreCase(lieux)) return promotion;
        }
        return null;
    }

    @Override
    @Transactional
    public Promotion findBySigle(String sigle) {
        Session currentsession=entityManager.unwrap(Session.class);
        Query<Promotion> query=
                currentsession.createQuery("from Promotion",Promotion.class);

        List<Promotion> promotions=query.getResultList();

        for (Promotion promotion:promotions){
            if(promotion.getSiglePromotion().equalsIgnoreCase(sigle)) return promotion;
        }
        return null;
    }
    @Override
    @Transactional
    public void add(Promotion promotion) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.save(promotion);

    }






}
