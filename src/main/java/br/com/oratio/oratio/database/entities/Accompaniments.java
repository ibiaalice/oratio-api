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
@Table(name = "accompaniments")
@AllArgsConstructor
@NoArgsConstructor
public class Accompaniments {

    @Id
    @GeneratedValue
    private Long id;
    private Long studentId;
    private String description;
    private String link;
    private String createdDate;
    
}
