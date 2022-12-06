package de.tekup.jpademoc.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;
    @PastOrPresent
    private LocalDate dateDeMiseEnMarche;
    private String model;

    private String vendor;
    @Positive
    private double prixDeJour;
    private String imagePath;


    public String getDateHtml() {
        return dateDeMiseEnMarche==null?"":dateDeMiseEnMarche.toString();
    }

    public void setDateHtml(String dateHtml) {
        this.dateDeMiseEnMarche = LocalDate.parse(dateHtml);
    }

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

}
