package com.cv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Formation;
import com.cv.entities.Loisire;
import com.cv.entities.Profile;
import com.cv.entities.Utilisateur;
import com.cv.repository.ProfileRepository;
import com.cv.repository.UtilisateurRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository pr;
	@Autowired
	UtilisateurRepository ur;
	
	public void ajouterProfile(Profile profile,Utilisateur u)
	{
		Profile p = new Profile();
		p.setProfile(profile.getProfile());
		p.setUtilisateur(u);
		pr.save(p);
	}
	public Profile getProfile(Utilisateur u)
	{
		return pr.getProfile(u);
		
	}
	
	public void supprimerProfile(Long id)
	{
		pr.deleteById(id);
	}
	public ModelAndView loadProfile(Long Utilisateur_id) {		
			ModelAndView mav = new ModelAndView("MonProfile");
			Utilisateur u = ur.getUtilisateur(Utilisateur_id);
			Profile p = getProfile(u);
	        mav.addObject("p",p);
	        mav.addObject("profile",new Profile());
	        mav.addObject("utilisateur",u);
	        return mav;
	}
}
