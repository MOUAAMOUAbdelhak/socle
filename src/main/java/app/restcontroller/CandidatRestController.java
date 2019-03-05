package app.restcontroller;


import app.dao.CandidatDAO;
import app.entities.Candidat;
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
public class CandidatRestController  {


    @Autowired
    private CandidatDAO candidatDAO;

    // expose candidat and return list of candidat
    @GetMapping("/candidat")
    public List<Candidat> findAll(){
        return candidatDAO.findAll();
    }


    // add mapping for GET /Candidatid
    @GetMapping("/{candid}")
    public Candidat getCandidat(@PathVariable("candid") String candid){
        Candidat candidat=candidatDAO.findById(candid);

        if(candidat==null){
            throw new RuntimeException("Candidat n'existe pas :"+candidat);

        }
        return candidat;
    }

    // add mapping for GET /candidats/names/{name}
    @GetMapping("/candidats/names/{name}")
    public Candidat getCandidatName(@PathVariable("name")String name){
        Candidat candidat=candidatDAO.findByName(name);
        if(candidat==null){
            throw new RuntimeException("Candidat n'existe pas :"+candidat);

        }
        return candidat;
    }
    // add mapping for POST /candidat - add new candidat

    @PostMapping("/addcandidats")
    public Candidat addCandidat(@RequestBody Candidat thecandidate) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update



        candidatDAO.add(thecandidate);

        return thecandidate;
    }


    // add mapping for DELETE /deleteCandidat/{candidatid}- delete candidat
    @DeleteMapping("/deleteCandidat/{candidatid}")
    public String deleteEmployee(@PathVariable("candidatid") String candidatid) {

        Candidat tempcandidat = candidatDAO.findById(candidatid);

        // throw exception if null

        if (tempcandidat == null) {
            throw new RuntimeException("Employee id not found - " + candidatid);
        }

        candidatDAO.deleteById(candidatid);

        return "Deleted employee id - " + candidatid;
    }
}
