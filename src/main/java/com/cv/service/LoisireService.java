package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Formation;
import com.cv.entities.Loisire;
import com.cv.entities.Utilisateur;
import com.cv.repository.LoisireRepository;
import com.cv.repository.UtilisateurRepository;
@Service
public class LoisireService {

	@Autowired
	LoisireRepository lr;
	@Autowired
	UtilisateurRepository ur;
	
	public void ajouterLoisire(Loisire loisire,Utilisateur u)
	{
		Loisire l = new Loisire();
		l.setLoisire(loisire.getLoisire());
		l.setUtilisateur(u);
		lr.save(l);
	}
	
	public List<Loisire> listeLoisire(Utilisateur u){
		List<Loisire> l = lr.getAllLoisire(u);
		return l;
	}
	
	public void supprimerLoisire(Long id)
	{
		lr.deleteById(id);
	}
	public ModelAndView loadLoisire(Long Utilisateur_id) {		
			ModelAndView mav = new ModelAndView("MesLoisires");
			Utilisateur u = ur.getUtilisateur(Utilisateur_id);
			List<Loisire> l = listeLoisire(u);
	        mav.addObject("loisires",l);
	        mav.addObject("loisire",new Formation());
	        mav.addObject("utilisateur",u);
	        return mav;
	}
}
