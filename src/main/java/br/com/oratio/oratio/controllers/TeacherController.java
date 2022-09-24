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

import br.com.oratio.oratio.database.entities.Teacher;
import br.com.oratio.oratio.domain.repository.TeacherRepository;

@CrossOrigin
@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository repository;

    @GetMapping("/teacher/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @RequestMapping("/teacher/all")
    public List<Teacher> getTeachers() {
         return repository.findAll();
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/teacher/create", method = RequestMethod.POST)
    public void addTeacher(@RequestBody Teacher teacher) {
        repository.save(teacher);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/teacher/edit", method = RequestMethod.PUT)
    public void editTeacher(@RequestBody Teacher teacher) {
        repository.save(teacher);
    }


    @ResponseBody
    @Transactional
    @RequestMapping(path = "/teacher/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/teacher/{id}", method = RequestMethod.GET)
    public Teacher getTeacherById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

}
