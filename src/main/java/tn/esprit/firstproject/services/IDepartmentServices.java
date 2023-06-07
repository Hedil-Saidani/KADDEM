package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface IDepartmentServices {

    Departement addOrUpdateDepartment(Departement departement);
    void removeDepartment (Integer idDepartment);
    Departement retrieveDepartment(Integer idDepartment) ;
    List<Departement> retrieveAllDepartments();

     List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}


