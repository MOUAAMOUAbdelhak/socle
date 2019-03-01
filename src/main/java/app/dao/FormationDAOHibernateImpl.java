package app.dao;

import app.entities.Formation;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class FormationDAOHibernateImpl implements FormationDao {



    private EntityManager entityManager;
    @Autowired
    public FormationDAOHibernateImpl(EntityManager theentityManager){

        entityManager=theentityManager;
    }


    @Override
    @Transactional
    public List<Formation> findAll() {
        Session currentsession=entityManager.unwrap(Session.class);



        Query<Formation> query=
                currentsession.createQuery("from Formation",Formation.class);


        List<Formation> formations=query.getResultList();

        return formations;
    }

    @Override
    @Transactional
    public Formation findById(String theId) {

        Session currentsession=entityManager.unwrap(Session.class);
        Formation formation=currentsession.get(Formation.class,theId);
        return formation;
    }

    @Override
    public Formation findByName(String name) {

        Session currentsession=entityManager.unwrap(Session.class);
        Query<Formation> query=
                currentsession.createQuery("from Formation",Formation.class);

        List<Formation> formations=query.getResultList();

        for (Formation f:formations){
            if(f.getNomFormation().equalsIgnoreCase(name)) return f;
        }
        return null;
    }

    @Override
    @Transactional
    public void add(Formation formation) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.save(formation);

    }

    @Override
    @Transactional
    public void deleteById(String codeFormation) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Formation where codeFormation=:id");
        theQuery.setParameter("id", codeFormation);

        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void updateformation(Formation formation) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.save(formation);

    }
}
