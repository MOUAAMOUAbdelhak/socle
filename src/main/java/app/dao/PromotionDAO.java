package app.dao;

import app.entities.Promotion;
import app.entities.PromotionPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionDAO {

    public List<Promotion> findAll();

    public  Promotion findByLieux(String lieux);
    public Promotion findBySigle(String sigle);
    public void add(Promotion promotion);



    //public void deleteById(String codeformation);
    //public void updateformation(Formation Formation);
}
