package br.com.oratio.oratio.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationBoard {

    @Id
    @GeneratedValue
    private Long id;
    private String link;
    private Long projectId;
    private Long studentId;
    private Long teacherAdvisorId;
    private Long teacherEvaluatorId;
    private String limitDate;
    private boolean isAvailable;
    
}
