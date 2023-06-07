package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteServices {

    Universite addOrUpdateUniversite(Universite universite);
    void removeUniversite (Integer idUniversite);
    Universite retrieveUniversite(Integer idUniversite) ;
    List<Universite> retrieveAllUniversites();

    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
