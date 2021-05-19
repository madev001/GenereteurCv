package com.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Loisire;
import com.cv.entities.Profile;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	UtilisateurRepository ur;
	@Autowired
	ProfileService ps;
	
	@RequestMapping(value = "/savePro", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addProfile(@ModelAttribute Profile profile,@RequestParam("id") Long id/*, BindingResult bindingResult*/) {
		
        Utilisateur u = ur.getUtilisateur(id);
        ps.ajouterProfile(profile, u);
        //get profile

        return loadProfile(id);
    }
	
	@RequestMapping(value = "/Profile",method = RequestMethod.GET)
	public ModelAndView loadProfile(@RequestParam("id") Long id)
	{
        
        Utilisateur u = ur.getUtilisateur(id);
        Profile p = ps.getProfile(u);
        ModelAndView mav = new ModelAndView("MonProfile");
        mav.addObject("p",p);
        mav.addObject("profile",new Profile());
        mav.addObject("utilisateur",u);
        return mav;
	}
	@RequestMapping(value = "/deleteProfile",method = RequestMethod.GET)
	public ModelAndView suppProfile(@RequestParam("Profile_id") Long Profile_id,@RequestParam("Utilisateur_id") Long Utilisateur_id)
	{
		ps.supprimerProfile(Profile_id);

		return ps.loadProfile(Utilisateur_id);
	}
	
}
