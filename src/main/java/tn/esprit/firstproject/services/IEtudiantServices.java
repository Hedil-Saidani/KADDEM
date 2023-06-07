package tn.esprit.firstproject.services;


import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;


import java.util.List;
import java.util.Optional;


public interface IEtudiantServices {

    List<Etudiant> retrieveByOption(Option option);



    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    void removeEtudiant (Integer idEtudiant);
    Etudiant  retrieveEtudiant(Integer idEtudiant) ;
    List<Etudiant> retrieveAllEtudiants();

    Etudiant assignEtToDep(Integer idE,Integer idDep);
    Etudiant assignEtToEquipe(Integer idE,Integer idEquipe);

    public void addAndAssignEtudToDep(Etudiant etudiant);


    List<Etudiant> getEtudiantsByDepartement(Integer idDepartement);






}
