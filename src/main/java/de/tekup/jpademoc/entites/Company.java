package de.tekup.jpademoc.entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class Company {
    @Id
    private int id;
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    private List<ClientEntity> clients;
}
