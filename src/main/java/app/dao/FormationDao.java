package app.dao;

import app.entities.Formation;

import java.util.List;

public interface FormationDao {
    public List<Formation> findAll();

    public  Formation findById(String theId);
    public Formation findByName(String name);
    public void add(Formation formation);

    public void deleteById(String codeformation);
    public void updateformation(Formation Formation);
}
