package app.dao;

import app.entities.Candidat;

import java.util.List;

public interface CandidatDAO {
    public List<Candidat> findAll();
    public void add(Candidat candidat);
    public  Candidat findById(String theId);
    public Candidat findByName(String name);
    public void deleteById(String theId);

}
