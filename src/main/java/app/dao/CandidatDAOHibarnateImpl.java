package app.dao;

import app.entities.Candidat;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class CandidatDAOHibarnateImpl implements CandidatDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public CandidatDAOHibarnateImpl(EntityManager theentityManager){

        entityManager=theentityManager;
    }

    @Override
    @Transactional
    public List<Candidat> findAll() {
// get the current hibernate session
        Session currentsession=entityManager.unwrap(Session.class);

// create a query

        Query<Candidat> query=
                currentsession.createQuery("from Candidat",Candidat.class);

// execute query and get result list
        List<Candidat> candidatEntities=query.getResultList();
// return the results
        return candidatEntities;
    }



    @Override
    @Transactional
    public Candidat findById(String theId) {
        Session currentsession=entityManager.unwrap(Session.class);
        Candidat candidat=currentsession.get(Candidat.class,theId);
        return candidat;

        /*
        Query<Candidat> query=
                currentsession.createQuery("from Candidat",Candidat.class);

        List<Candidat> candidatEntities=query.getResultList();

        for (Candidat c:candidatEntities){
            if(c.getNoCandidat().equalsIgnoreCase(theId)) return c;
        }
        return null;
         */
    }
    @Override
    @Transactional
    public void add(Candidat candidat) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.save(candidat);
    }
    @Override
    @Transactional
    public Candidat findByName(String name) {
       /*   Session currentsession=entityManager.unwrap(Session.class);
        Candidat candidat=currentsession.get(Candidat.class,name);
        return candidat;*/
      Session currentsession=entityManager.unwrap(Session.class);
        Query<Candidat> query=
                currentsession.createQuery("from Candidat",Candidat.class);

        List<Candidat> candidatEntities=query.getResultList();

        for (Candidat c:candidatEntities){
            if(c.getNom().equalsIgnoreCase(name)) return c;
        }
        return null;
    }


    @Override
    @Transactional
    public void deleteById(String theId) {
// get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Candidat where noCandidat=:theId");
        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();
    }
}
