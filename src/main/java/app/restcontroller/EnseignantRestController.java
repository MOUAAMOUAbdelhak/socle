package app.restcontroller;


import app.dao.EnseignantDAO;
import app.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Configuration
@ComponentScan(value = "app.dao")
public class EnseignantRestController {
    @Autowired
    private EnseignantDAO enseignantDAO;

    @GetMapping("/enseignant")
    public List<Enseignant> findAll(){
        return enseignantDAO.findAll();
    }
    @GetMapping("/enseignant/{ensId}")
    public Enseignant getCandidat(@PathVariable("ensId") int ensId){
        Enseignant enseignant=enseignantDAO.findById(ensId);

        if(enseignant==null){
            throw new RuntimeException("Candidat n'existe pas :"+ensId);

        }
        return enseignant;
    }
    @GetMapping("/enseignants/emailUbo/{emailUbo}")
    public Enseignant getenseignat(@PathVariable("emailUbo") String emailUbo){
        Enseignant enseignant= (Enseignant) enseignantDAO.findByEmail(emailUbo);
        if(enseignant==null){
            throw new RuntimeException("Candidat n'existe pas :"+emailUbo);

        }
        return enseignant;
    }
    @GetMapping("/enseignant/names/{name}")
    public Enseignant getCandidatName(@PathVariable("name")String name){
        Enseignant enseignant=enseignantDAO.findByName(name);
        if(enseignant==null){
            throw new RuntimeException("Candidat n'existe pas :"+name);

        }
        return enseignant;
    }
    @PostMapping("/addenseignant")
    public Enseignant addCandidat(@RequestBody Enseignant theenseignat) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        enseignantDAO.add(theenseignat);

        return theenseignat;
    }

    @DeleteMapping("/deleteenseignant/{enseignantid}")
    public String deleteenseignant(@PathVariable("enseignantid") int enseignantid) {

        Enseignant tempenseignant= enseignantDAO.findById(enseignantid);

        // throw exception if null

        if (tempenseignant == null) {
            return"Enseignant id not found - " + tempenseignant;
        }

       else{

            enseignantDAO.deleteById(enseignantid);
            return "Enseignant suuprimer";
        }

    }
}
