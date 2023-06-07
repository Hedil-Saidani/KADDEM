package tn.esprit.firstproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idUniv;
    private  String nomUniv;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Departement> departements;
}
