package br.com.oratio.oratio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.Accompaniments;

@Repository
public interface AccompanimentsRepository extends JpaRepository<Accompaniments, Long> {
   
    List<Accompaniments> findByStudentId(Long studentId);

}
