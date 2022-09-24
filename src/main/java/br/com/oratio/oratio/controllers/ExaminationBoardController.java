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

import br.com.oratio.oratio.database.entities.ExaminationBoard;
import br.com.oratio.oratio.domain.repository.ExaminationBoardRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class ExaminationBoardController {
    
    @Autowired
    private ExaminationBoardRepository repository;

    @GetMapping("/examination_board/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @ResponseBody
    @RequestMapping(value = "/examination_board/all", method = RequestMethod.GET)
    public List<ExaminationBoard> getAll() {
        return repository.findAll();
    }

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/examination_board/create", method = RequestMethod.POST)
    public void addExaminationBoard(@RequestBody ExaminationBoard examinationBoard) {
        repository.save(examinationBoard);
    }

    @ResponseBody
    @RequestMapping(path = "/examination_board/edit", method = RequestMethod.PUT)
    public void editExaminationBoard(@RequestBody ExaminationBoard examinationBoard) {
        repository.save(examinationBoard);
    }

    @ResponseBody
    @RequestMapping(path = "/examination_board/delete/{id}", method = RequestMethod.DELETE)
    public void deleteExaminationBoard(@PathVariable Long id) {
        repository.deleteById(id);
    }

    
  
    
}
