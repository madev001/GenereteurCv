package com.cv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Formations")
public class Formation implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    private Long id;
    
    private String intitule;
    private String localite;
    private String Etablissement;
    private String Formation_debut_mois;
    private String Formation_debut_annee;
    private String Formation_fin_mois;
    private String Formation_fin_annee;
    @Lob
    private String Description;
    
    //@MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur",referencedColumnName ="id")
    private Utilisateur utilisateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getEtablissement() {
		return Etablissement;
	}

	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}

	public String getFormation_debut_mois() {
		return Formation_debut_mois;
	}

	public void setFormation_debut_mois(String formation_debut_mois) {
		Formation_debut_mois = formation_debut_mois;
	}

	public String getFormation_debut_annee() {
		return Formation_debut_annee;
	}

	public void setFormation_debut_annee(String formation_debut_annee) {
		Formation_debut_annee = formation_debut_annee;
	}

	public String getFormation_fin_mois() {
		return Formation_fin_mois;
	}

	public void setFormation_fin_mois(String formation_fin_mois) {
		Formation_fin_mois = formation_fin_mois;
	}

	public String getFormation_fin_annee() {
		return Formation_fin_annee;
	}

	public void setFormation_fin_annee(String formation_fin_annee) {
		Formation_fin_annee = formation_fin_annee;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
