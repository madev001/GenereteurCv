package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.entities.Experience;
import com.cv.entities.Utilisateur;
import com.cv.repository.ExperienceRepository;
@Service
public class ExperienceService {

	@Autowired
	ExperienceRepository er;
	
	public void ajouterExperience(Experience exp,Utilisateur u)
	{
		Experience e = new Experience();
		e.setFonction(exp.getFonction());
		e.setLocalite(exp.getLocalite());
		e.setEtablissement(exp.getEtablissement());
		e.setDepuis(exp.getDepuis());
		e.setJusqua(exp.getJusqua());
		e.setDescription(exp.getDescription());
		e.setUtilisateur(u);
		er.save(e);
	}
	public List<Experience> getAllExperience (Utilisateur u)
	{
		List<Experience> l = er.getAllExperience(u);
		return l;
	}
	public void deleteExperience(Long id)
	{
		er.deleteById(id);
	}
}
