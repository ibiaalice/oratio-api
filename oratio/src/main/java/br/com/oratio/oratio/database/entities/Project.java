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
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String link;
    private String status;
    private Long studentId;
    private Long teacherId;
    private boolean isFinalized;
    private boolean isAvailable;
}
