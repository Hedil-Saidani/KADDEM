package tn.esprit.firstproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailEquipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy="Detail_Equipe")
    private Equipe equipe;


}
