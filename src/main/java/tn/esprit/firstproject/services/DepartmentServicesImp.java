package tn.esprit.firstproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.DepartementRepository;
import tn.esprit.firstproject.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServicesImp  implements  IDepartmentServices {

    @Autowired
    private  final DepartementRepository departementRepository;
    private  final UniversiteRepository  universiteRepository;

    @Override
    public Departement addOrUpdateDepartment(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public void removeDepartment(Integer idDepartment) {
        departementRepository.deleteById(idDepartment);
    }

    @Override
    public Departement retrieveDepartment(Integer idDepartment) {
        return departementRepository.findById(idDepartment).orElse(null);
    }

    @Override
    public List<Departement> retrieveAllDepartments() {
        return (List<Departement>) departementRepository.findAll();
    }


    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        if (u != null) {
            return new ArrayList<>(u.getDepartements());
        }
        return null;
    }


}
