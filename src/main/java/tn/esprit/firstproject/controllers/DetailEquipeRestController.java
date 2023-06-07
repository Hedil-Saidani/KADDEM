package tn.esprit.firstproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.services.IDetailEquipeServices;

import java.util.List;

@Tag(name = "Détail Equipes")
@RestController
@RequestMapping("/detailequipe")
@AllArgsConstructor
public class DetailEquipeRestController {

    private IDetailEquipeServices iDetailEquipeServices;

    @Operation(description ="Ajout d'un détail équipe")
    @PostMapping("/add")
    DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return iDetailEquipeServices.addOrUpdateDetailEquipe(detailEquipe);
    }

    @Operation(description ="Suppression d'un détail équipe")
    @DeleteMapping("/delete/{id}")
    void deleteDetailEquipe( @PathVariable("id") Integer idDetailEquipe){

       iDetailEquipeServices.removeDetailEquipe(idDetailEquipe);
    }

    @Operation(description ="Modification d'un détail équipe")
    @PutMapping("/update")
    DetailEquipe UpdateDetailEquipe(@RequestBody DetailEquipe detailEquipe){

        return iDetailEquipeServices.addOrUpdateDetailEquipe(detailEquipe);
    }

    @Operation(description ="Affichage d'un détail équipe selon l'ID")
    @GetMapping("/get/{id}")
    DetailEquipe getDetailEquipeByID(@PathVariable("id") Integer idDetailEquipe) {
        return iDetailEquipeServices.retrieveDetailEquipe(idDetailEquipe);
    }

    @Operation(description ="Affichage de la liste des détails équipes")
    @GetMapping("/all")
    List<DetailEquipe> getDetailEquipes(){
        return  iDetailEquipeServices.retrieveAllDetailEquipes();
    }

}
