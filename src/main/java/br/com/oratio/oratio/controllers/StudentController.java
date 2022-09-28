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

import br.com.oratio.oratio.database.entities.Student;
import br.com.oratio.oratio.domain.repository.StudentRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class StudentController {
    
    @Autowired
    private StudentRepository repository;

    @GetMapping("/student/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @RequestMapping("/student/all")
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/student/create", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student) {
        repository.save(student);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/student/edit", method = RequestMethod.PUT)
    public void editStudent(@RequestBody Student student) {
        repository.save(student);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/student/delete/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable  Long id) {
        repository.deleteById(id);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/student/semester/{semester}", method = RequestMethod.GET)
    public List<Student> getStudentsBySemester(@PathVariable String semester) {
        return repository.findBySemesterOrderByName(semester);
    }

}
