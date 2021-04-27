package com.cv.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Experiences")
public class Experience implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(updatable = false, nullable = false)
    private Long id;
    
    private String Fonction;
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFonction() {
		return Fonction;
	}


	public void setFonction(String fonction) {
		Fonction = fonction;
	}


	public String getLocalite() {
		return Localite;
	}


	public void setLocalite(String localite) {
		Localite = localite;
	}


	public String getEtablissement() {
		return Etablissement;
	}


	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}


	public String getDepuis() {
		return Depuis;
	}


	public void setDepuis(String depuis) {
		Depuis = depuis;
	}


	public String getJusqua() {
		return Jusqua;
	}


	public void setJusqua(String jusqua) {
		Jusqua = jusqua;
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


	private String Localite;
    private String Etablissement;
    private String Depuis;
    private String Jusqua;
    private String Description;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur",referencedColumnName ="id", updatable = false)
    private Utilisateur utilisateur;
}
