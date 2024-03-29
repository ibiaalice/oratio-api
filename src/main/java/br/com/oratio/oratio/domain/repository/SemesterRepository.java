package br.com.oratio.oratio.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {

    List<Semester> findByYear(String year);

    List<Semester> OrderByYear();

    @Query("select s from Semester s where s.status = 'ACTIVE'")
    Semester getByActiveStatus();

}