package app.dao;

import app.entities.Candidat;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;

import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class CandidatDAOHibarnateImpl implements CandidatDAO {

    private EntityManager entityManager;


    @Autowired
    public CandidatDAOHibarnateImpl(EntityManager theentityManager){

        entityManager=theentityManager;
    }

    @Override
    public List<Candidat> findAll() {

        Session currentsession=entityManager.unwrap(Session.class);



        Query<Candidat> query=
                currentsession.createQuery("from Candidat",Candidat.class);

        List<Candidat> candidatEntities=query.getResultList();

        return candidatEntities;
    }
}
