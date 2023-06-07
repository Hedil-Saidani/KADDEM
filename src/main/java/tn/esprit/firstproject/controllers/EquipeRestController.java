package tn.esprit.firstproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.services.IEquipeServices;

import java.util.List;

@Tag(name = "Gestion des équipes")
@RestController
@RequestMapping("/equipe")
public class EquipeRestController {

    private  IEquipeServices iEquipeServices;

    public EquipeRestController(IEquipeServices iEquipeServices) {

        this.iEquipeServices = iEquipeServices;
    }

    @Operation(description ="Ajout d'une équipe")
    @PostMapping("/add")
    Equipe addEquipe (@RequestBody Equipe equipe) {
        return iEquipeServices.addOrUpdateEquipe(equipe);
    }


    @Operation(description ="Suppression d'une équipe")
    @DeleteMapping("/delete/{id}")
    void deleteEquipe( @PathVariable("id") Integer idEquipe){

        iEquipeServices.removeEquipe(idEquipe);
    }

    @Operation(description ="Modification d'une équipe")
    @PutMapping("/update")
    Equipe UpdateEquipe(@RequestBody Equipe equipe){

        return iEquipeServices.addOrUpdateEquipe(equipe);
    }

    @Operation(description ="Affichage d'une équipe selon l'ID")
    @GetMapping("/get/{id}")
    Equipe getEquipeByID(@PathVariable("id") Integer idEquipe) {

        return iEquipeServices.retrieveEquipe(idEquipe);
    }


    @Operation(description ="Affichage de la liste d'équipes")
    @GetMapping("/all")
    List<Equipe> getEquipes(){
        return  iEquipeServices.retrieveAllEquipes();
    }

}
