package tn.esprit.firstproject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {
    //Set<Etudiant> findByNom(String nom);
    List<Etudiant> findByOption(Option option);

    @Query("select e from  Etudiant e where e.option= :opt and e.nom= :nom ")
    List<Etudiant> retrieveByOption(@Param("opt") Option option, @Param("nom") String nomE);


    @Query("select e from  Etudiant e where e.option= ?1 and e.nom= ?2 ")
    List<Etudiant> retrieveByOptionAndNom(Option option,String nomE);


    @Query("select e from  Etudiant e where e.departement.nomDepart= :nom")
    List<Etudiant> retrieveEtudiantsByDep(@Param("nom") String nomDep);

    List<Etudiant> findEtudiantByDepartement_NomDepart(String nomDepartment);


    @Query("select e from  Etudiant e join e.contrats contrat where  contrat.archive=false ")
    List<Etudiant> retrieveEtuiantsByContratNonarchive();


    List<Etudiant> getEtudiantsByDepartement_IdDepart(int idDepartment);











}
