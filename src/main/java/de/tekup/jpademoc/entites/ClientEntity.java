package de.tekup.jpademoc.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@Data
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CIN_CLIENT",unique = true)
    private Integer cin;
    @Column(length = 50,nullable = false)
    private String nom;
    private String prenom;
    @Lob
    private String adresse;
    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;

}
