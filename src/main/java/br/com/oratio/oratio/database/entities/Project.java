package br.com.oratio.oratio.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String link;
    private String status;
    private Long semester;
    private Long studentId;
    private Long teacherId;
    private Long evaluatorId;
    private Long evaluatorId2;
    private boolean isFinalized;
    private boolean isAvailable;
}
