package de.tekup.jpademoc.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Data
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateDebut;
    private LocalDate dateRetour;
    private double prixJour;
    @Transient
    private double prix;
  
    @ManyToOne
    private ClientEntity client;

    @ManyToOne
    private VoitureEntity voiture;

    @PostLoad
    private void calculatePrix(){
        long nbJour = ChronoUnit.DAYS.between(dateDebut,dateRetour.plusDays(1));
        prix = nbJour*prixJour;
    }

}
