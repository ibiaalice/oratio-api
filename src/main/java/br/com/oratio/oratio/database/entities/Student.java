package br.com.oratio.oratio.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "student")
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String password;
    private String registrationCourseNumber;
    private Long semester;
    private long supervisorId;
    private long projectId;
    private boolean isFinished;


    
}
