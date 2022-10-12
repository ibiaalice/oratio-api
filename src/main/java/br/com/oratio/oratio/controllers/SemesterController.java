package br.com.oratio.oratio.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.oratio.oratio.database.entities.Semester;
import br.com.oratio.oratio.domain.repository.SemesterRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class SemesterController {

    @Autowired
    private SemesterRepository semesterRepository;

    @GetMapping("/semester/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/semester/all")
    public List<Semester> getAll() {
        return semesterRepository.OrderByYear();
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/semester/create", method = RequestMethod.POST)
    public void addSemester(@RequestBody Semester semester) {
        semesterRepository.save(semester);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/semester/{year}", method = RequestMethod.GET)
    public List<Semester> getSemesterByYear(@PathVariable String year) {
        return semesterRepository.findByYear(year);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/semester/{id}", method = RequestMethod.DELETE)
    public void deleteSemester(@PathVariable Long id) {
        semesterRepository.deleteById(id);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/semester/{id}", method = RequestMethod.PUT)
    public void updateSemester(@PathVariable Long id, @RequestBody Semester semester) {
        semesterRepository.save(semester);
    }
    
    @Transactional
    @RequestMapping(path = "/semester/all", method = RequestMethod.DELETE)
    void deleteAll() {
        semesterRepository.deleteAll();
    }
}
