package br.com.oratio.oratio.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.oratio.oratio.database.entities.Project;
import br.com.oratio.oratio.domain.repository.ProjectRepository;
import br.com.oratio.oratio.domain.repository.StudentRepository;
import br.com.oratio.oratio.domain.repository.TeacherRepository;

@RestController
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/project/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/project/create", method = RequestMethod.POST)
    public void createProject(@RequestBody Project project) {
        final boolean studentExists = studentRepository.existsById(project.getStudentId());

        if(studentExists) {
            projectRepository.save(project);
        }else{
            throw new RuntimeException("Student not found");
        }
    }

    @ResponseBody
    @RequestMapping("/project/all")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/project/edit")
    public void editProject(@RequestBody Project project) {
       
        if(project.getTeacherId()  != null) {
            final boolean teacherExists = teacherRepository.existsById(project.getTeacherId());
            if(!teacherExists) {
              throw new RuntimeException("Teacher not found");
            }
        }
        
        projectRepository.save(project);
    
    }

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/project/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

    


}
