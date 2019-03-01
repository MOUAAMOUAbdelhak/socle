package app.dao;

import app.entities.Enseignant;

import java.util.List;

public interface EnseignantDAO {

    public List<Enseignant> findAll();

    public  Enseignant findById(int theId);
    public Enseignant findByName(String name);
    public void add(Enseignant enseignant);
    public Enseignant findByEmail(String emailUbo);
    public void deleteById(int theId);
}
