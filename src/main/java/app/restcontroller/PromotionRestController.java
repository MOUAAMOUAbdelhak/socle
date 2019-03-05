package app.restcontroller;

import app.dao.PromDAO;
import app.dao.PromotionDAO;
import app.entities.Promotion;
import app.entities.PromotionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Configuration
@ComponentScan("app.dao")
@EnableJpaRepositories("app.dao")
public class PromotionRestController {


    @Autowired
    private PromDAO promDAO;
    @Autowired
    private PromotionDAO promotionDAO;



    @GetMapping("/promotion")
    public List<Promotion> findAll(){
        return promotionDAO.findAll();
    }
    @GetMapping("/promotion/lieux/{lieu}")
    public Promotion getPromotionLieu(@PathVariable("lieu")String lieu){
        Promotion promotion=promotionDAO.findByLieux(lieu);
        if(promotion==null){
            throw new RuntimeException("Candidat n'existe pas :"+lieu);

        }
        return promotion;
    }
    @GetMapping("/promotion/sigles/{sigle}")
    public Promotion getPromotionSigle(@PathVariable("sigle")String sigle){
        Promotion promotion=promotionDAO.findBySigle(sigle);
        if(promotion==null){
            throw new RuntimeException("Candidat n'existe pas :"+sigle);

        }
        return promotion;
    }

    @GetMapping("/promotion/identi/{codeFromation}/{anneeUniv}")
    public Promotion getIdPromotion(@PathVariable("codeFromation")String codeFromation,@PathVariable("anneeUniv")String anneeUniv){

        PromotionPK pk = new PromotionPK(anneeUniv,codeFromation);
        System.out.println(pk.toString());
        return promDAO.findById(pk).orElse(null);
    }


    @PostMapping("/addpromotion")
    public Promotion addFormation(@RequestBody Promotion promotion) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        promotionDAO.add(promotion);

        return promotion;
    }

    @DeleteMapping("/promotion/delete/{codeFromation}/{anneeUniv}")
    public String deletepromotion(@PathVariable("codeFromation")String codeFromation,@PathVariable("anneeUniv")String anneeUniv) {

        PromotionPK pk = new PromotionPK(anneeUniv,codeFromation);

         promDAO.deleteById(pk);
         return codeFromation+"est supprimé";

    }
}
