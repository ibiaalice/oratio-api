package br.com.oratio.oratio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
    List<Teacher> OrderByName();

}

    

