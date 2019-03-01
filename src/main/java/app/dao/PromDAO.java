package app.dao;

import app.entities.Promotion;
import app.entities.PromotionPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromDAO extends CrudRepository<Promotion, PromotionPK> {
}
