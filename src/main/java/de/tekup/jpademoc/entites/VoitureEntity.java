package de.tekup.jpademoc.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;
    private LocalDate dateDeMiseEnMarche;
    private String model;

    private String vendor;
    private double prixDeJour;
    private String imagePath;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

}
