package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;

@Service
public class FormationService {

	@Autowired
	FormationRepository fr;
	@Autowired
	UtilisateurRepository ur;
	public Formation ajouterFormation(Formation formation,Utilisateur u)
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
		return fr.save(f);
	}
	
	

	public List<Formation> listeFormation(Utilisateur u){
		List<Formation> l = fr.getAllFormation(u);
		return l;
	}
	
	public void supprimerFormation(Long id)
	{
		fr.deleteById(id);
	}
	public ModelAndView loadFormation(Long Utilisateur_id) {		
			ModelAndView mav = new ModelAndView("Carriere");
			Utilisateur u = ur.getUtilisateur(Utilisateur_id);
			List<Formation> l = listeFormation(u);
	        mav.addObject("formations",l);
	        mav.addObject("formation",new Formation());
	        mav.addObject("utilisateur",u);
	        return mav;
}
}
