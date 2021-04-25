package com.cv.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;

@Service
public class FormationService {

	@Autowired
	FormationRepository fr;
	
	public void ajouterFormation(Formation formation,Utilisateur u)
	{
		Formation f = new Formation();
		f.setEtablissement(formation.getEtablissement());
		f.setDescription(formation.getDescription());
		f.setFormation_debut_annee(formation.getFormation_debut_annee());
		f.setFormation_debut_mois(formation.getFormation_debut_mois());
		f.setFormation_fin_annee(formation.getFormation_fin_annee());
		f.setFormation_fin_mois(formation.getFormation_fin_mois());
		f.setIntitule(formation.getIntitule());
		f.setLocalite(formation.getLocalite());
		f.setUtilisateur(u);
		fr.save(f);
	}
	
	public List<Formation> listeFormation(Utilisateur u){
		List<Formation> l = fr.getAllFormation(u);
		return l;
	}
	
	public void supprimerFormation(Long id)
	{
		fr.deleteById(id);
	}
}
