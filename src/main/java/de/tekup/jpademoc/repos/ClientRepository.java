package de.tekup.jpademoc.repos;

import de.tekup.jpademoc.entites.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity,Integer> {

}
