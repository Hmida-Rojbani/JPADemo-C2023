package de.tekup.jpademoc.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
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

}
