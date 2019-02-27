package app.restcontroller;


import app.dao.CandidatDAO;
import app.entities.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@Configuration
@ComponentScan(value = "app.dao")
public class CandidatRestController  {


    @Autowired
    private CandidatDAO candidatDAO;

    @RequestMapping("/candidat")
    public List<Candidat> findAll(){
        return candidatDAO.findAll();
    }
}
