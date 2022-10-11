package br.com.oratio.oratio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findBySemester(Long semester);

    List<Student> findBySemesterOrderByName(Long semester);

}


