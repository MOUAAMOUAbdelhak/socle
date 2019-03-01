package app.dao;

import app.entities.Enseignant;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EnseignantDAOHibernateImpl implements EnseignantDAO {


    private EntityManager entityManager;
    @Autowired
    public EnseignantDAOHibernateImpl(EntityManager theentityManager){

        entityManager=theentityManager;
    }


    @Override
    @Transactional
    public List<Enseignant> findAll() {
        Session currentsession=entityManager.unwrap(Session.class);



        Query<Enseignant> query=
                currentsession.createQuery("from Enseignant",Enseignant.class);


        List<Enseignant> engeignantEntities=query.getResultList();

        return engeignantEntities;
    }

    @Override
    @Transactional
    public Enseignant findById(int theId) {

            Session currentsession=entityManager.unwrap(Session.class);
            Enseignant enseignant=currentsession.get(Enseignant.class,theId);
            return enseignant;



    }

    @Override
    public Enseignant findByName(String name) {
         /*   Session currentsession=entityManager.unwrap(Session.class);
        Candidat candidat=currentsession.get(Candidat.class,name);
        return candidat;*/
        Session currentsession=entityManager.unwrap(Session.class);
        Query<Enseignant> query=
                currentsession.createQuery("from Enseignant",Enseignant.class);

        List<Enseignant> enseignantEntities=query.getResultList();

        for (Enseignant c:enseignantEntities){
            if(c.getNom().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    @Override
    @Transactional
    public void add(Enseignant enseignant) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.save(enseignant);

    }

    @Override
    public Enseignant findByEmail(String emailUbo) {
        Session currentsession=entityManager.unwrap(Session.class);
        Query<Enseignant> query=
                currentsession.createQuery("from Enseignant",Enseignant.class);
        List<Enseignant> enseignantEntities=query.getResultList();

        for (Enseignant c:enseignantEntities){
            if(c.getEmailUbo().equalsIgnoreCase(emailUbo)) return c;
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Enseignant where noEnseignant=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();
    }
}
