package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Contrat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IContratServices {

    Contrat addOrUpdateContrat(Contrat contrat);
    void removeContrat (Integer idContrat);
    Contrat retrieveContrat(Integer idContrat) ;
    List<Contrat> retrieveAllContrats();

    void retrieveAndUpdateStatusContrat();

    Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate, Date endDate);


}
