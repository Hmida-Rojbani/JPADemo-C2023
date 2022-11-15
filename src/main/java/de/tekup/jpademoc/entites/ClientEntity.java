package de.tekup.jpademoc.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Pattern(regexp = "^[0-9]{8}$",message = "CIN must contain exactly 8 digits.")
    private String cin;
    @Column(length = 50,nullable = false)
    @Size(min=3, max = 50)
    @NotBlank
    private String nom;
    @Column(length = 50)
    @Size(min=3, max = 50)
    @NotBlank
    private String prenom;
    @Lob
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;

}
