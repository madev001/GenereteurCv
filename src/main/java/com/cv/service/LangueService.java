package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;
import com.cv.repository.LangueRepository;

@Service
public class LangueService {

	@Autowired
	LangueRepository lr;
	
	public void ajouterLangue(Langue langue,Utilisateur u)
	{
		Langue l = new Langue();
		l.setLangue(langue.getLangue());
		l.setNiveau(langue.getNiveau());
		l.setUtilisateur(u);
		lr.save(l);
	
	}
	public List<Langue> getAllLangue (Utilisateur u)
	{
		List<Langue> l = lr.getAllLangue(u);
		return l;
	}
	public void deleteLangue(Long id)
	{
		lr.deleteById(id);
	}
}
