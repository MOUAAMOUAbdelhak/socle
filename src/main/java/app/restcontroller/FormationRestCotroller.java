package app.restcontroller;

import app.dao.FormationDao;
import app.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Configuration
@ComponentScan(value = "app.dao")
public class FormationRestCotroller {
    @Autowired
    private FormationDao formationDao;

    @GetMapping("/formation")
    public List<Formation> findAll(){
        return formationDao.findAll();
    }

    @GetMapping("/formation/{forId}")
    public Formation getFormation(@PathVariable("forId") String forId){
        Formation formation=formationDao.findById(forId);

        if(formation==null){
            throw new RuntimeException("Candidat n'existe pas :"+forId);

        }
        return formation;
    }

    @GetMapping("/formation/names/{name}")
    public Formation getCandidatName(@PathVariable("name")String name){
        Formation formation=formationDao.findByName(name);
        if(formation==null){
            throw new RuntimeException("Candidat n'existe pas :"+name);

        }
        return formation;
    }

    @PostMapping("/addformation")
    public Formation addFormation(@RequestBody Formation formation) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        formationDao.add(formation);

        return formation;
    }

    @DeleteMapping("/deleteFormation/{codeFormation}")
    public String deleteenseignant(@PathVariable("codeFormation") String codeFormation) {

        Formation tempenseignant= formationDao.findById(codeFormation);

        // throw exception if null

        if (tempenseignant == null) {
            return"Fomation id not found - " + tempenseignant;
        }

        else{

            formationDao.deleteById(codeFormation);
            return "Froamtion suuprimer";
        }

    }

    // Update a Formation
    @PutMapping("/formation/update/{codeFormation}")
    public Formation updateNote(@PathVariable(value = "codeFormation")String Codeformation,@RequestBody Formation formation) {

        //formation.setCodeFormation(Codeformation);

        formationDao.updateformation(formation);
        return formation;
    }
}
