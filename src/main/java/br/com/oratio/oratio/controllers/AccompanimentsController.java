package br.com.oratio.oratio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.oratio.oratio.database.entities.Accompaniments;
import br.com.oratio.oratio.domain.repository.AccompanimentsRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class AccompanimentsController {

    @Autowired
    private AccompanimentsRepository accompanimentsRepository;

    @GetMapping("/accompaniments/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/accompaniments/create", method = RequestMethod.POST)
    public void addAccompaniments(@RequestBody Accompaniments accompaniments) {
        accompanimentsRepository.save(accompaniments);
    }

    @ResponseBody
    @RequestMapping("/accompaniments/all")
    public List<Accompaniments> getAccompaniments() {
        return accompanimentsRepository.findAll();
    }

    @ResponseBody
    @RequestMapping( path = "/accompaniments/{id}", method = RequestMethod.GET)
    public List<Accompaniments> getAccompanimentsById(@PathVariable Long id) {
        return accompanimentsRepository.findByStudentId(id);
    }

    @ResponseBody
    @RequestMapping( path = "/accompaniments/{id}", method = RequestMethod.DELETE)
    public void deleteAccompaniments(@PathVariable Long id) {
        accompanimentsRepository.deleteById(id);
    }

    @ResponseBody
    @RequestMapping( path = "/accompaniments/edit", method = RequestMethod.PUT)
    public void updateAccompaniments( @RequestBody Accompaniments accompaniments) {
        accompanimentsRepository.save(accompaniments);
    }

  


    
    
}
