package tn.esprit.firstproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IDepartmentServices;
import java.util.List;

@Tag(name = "Gestion des départements")
@RestController
@RequestMapping("/department")
public class DepartmentRestController {

     IDepartmentServices iDepartmentServices;

    public DepartmentRestController(IDepartmentServices iDepartmentServices) {
        this.iDepartmentServices = iDepartmentServices;
    }

    @Operation(description ="Ajout d'un département")
    @PostMapping("/add")
    Departement addDepartment(@RequestBody Departement departement) {

        return iDepartmentServices.addOrUpdateDepartment(departement);
    }

    @Operation(description ="Suppression d'un département")
    @DeleteMapping("/delete/{id}")
    void deleteDepartment( @PathVariable("id") Integer idDepartment){

        iDepartmentServices.removeDepartment(idDepartment);
    }

    @Operation(description ="Modification d'un département")
    @PutMapping("/update")
    Departement UpdateDepartment(@RequestBody Departement departement){

        return iDepartmentServices.addOrUpdateDepartment(departement);
    }

    @Operation(description ="Affichage d'un département selon l'ID")
    @GetMapping("/get/{id}")
    Departement getDepartmentByID(@PathVariable("id") Integer idDepartment) {
        return iDepartmentServices.retrieveDepartment(idDepartment);
    }

    @Operation(description ="Affichage de la liste des départements")
    @GetMapping("/all")
    List<Departement> getDepartments(){
        return  iDepartmentServices.retrieveAllDepartments();
    }

    @Operation(description ="Affichage de la liste des départements d'une université")
    @GetMapping ("/retrieveDepartementsByUniversite/{idUniversite}")
    List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite){
        return iDepartmentServices.retrieveDepartementsByUniversite(idUniversite);
    }


}
