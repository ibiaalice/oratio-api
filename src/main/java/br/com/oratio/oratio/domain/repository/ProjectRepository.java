package br.com.oratio.oratio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findBySemesterOrderByTitle(Long semester);
    
}
