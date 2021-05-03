package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.entities.Competance;
import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;
import com.cv.repository.CompetanceRepository;
@Service
public class CompetanceService {

	@Autowired
	CompetanceRepository cr;
	public void ajouterCompetance(Competance competance,Utilisateur u)
	{
		Competance c = new Competance();
		c.setCompetance(competance.getCompetance());
		c.setNiveau(competance.getNiveau());
		c.setCtype(competance.getCtype());
		c.setUtilisateur(u);
		cr.save(c);
		
	}
	public List<Competance> getAllCompetance (Utilisateur u)
	{
		List<Competance> l = cr.getAllCompetance(u);
		return l;
	}
	public void deleteCompetance(Long id)
	{
		cr.deleteById(id);
	}
}
