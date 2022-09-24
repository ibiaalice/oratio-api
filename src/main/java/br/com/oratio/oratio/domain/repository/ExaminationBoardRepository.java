package br.com.oratio.oratio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oratio.oratio.database.entities.ExaminationBoard;

@Repository
public interface ExaminationBoardRepository extends JpaRepository<ExaminationBoard, Long> {

    
}
