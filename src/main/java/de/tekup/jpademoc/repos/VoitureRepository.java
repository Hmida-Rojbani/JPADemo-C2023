package de.tekup.jpademoc.repos;

import de.tekup.jpademoc.entites.VoitureEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VoitureRepository extends CrudRepository<VoitureEntity,Integer> {
    List<VoitureEntity> findByModel(String model);

    /*@Query(nativeQuery = true,
    value = "select * from voiture_entity" +
            "where date_de_mise_en_marche >= :dateDebut " +
            "and date_de_mise_en_marche <= :dateFin")*/
    @Query("select v from VoitureEntity v " +
            "where v.dateDeMiseEnMarche >= :dateDebut  " +
            "and v.dateDeMiseEnMarche <= :dateFin")
    List<VoitureEntity> locateByInterval(@Param("dateDebut") LocalDate dateDebut,
                                         @Param("dateFin") LocalDate dateFin);
}
