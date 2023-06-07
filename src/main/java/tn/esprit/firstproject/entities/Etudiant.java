package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "Etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Etudiant implements Serializable {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idEtudiant;
    private  String prenom;
    @NonNull
    private  String nom;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Option option;
    @Temporal(TemporalType.DATE)
    private Date dateN;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Equipe> equipes;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="etudiant")
    private Set<Contrat> contrats;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    Departement departement;
   */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idEtudiant;
    private  String prenom;
    @NonNull
    private  String nom;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Option option;
    @Temporal(TemporalType.DATE)
    private Date dateN;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Contrat> contrats;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Departement departement;
}
