package com.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;

@Controller
public class FormationController {
	
	@Autowired
	FormationRepository fr;
	@Autowired
	UtilisateurRepository ur;
	@Autowired
	FormationService fs;
	/*
	@RequestMapping(value = "/saveFormation", method = { RequestMethod.GET, RequestMethod.POST })
	public void saveFormation(@ModelAttribute Formation formation,@RequestParam("id") Long id )
	{
		Utilisateur u = ur.getUtilisateur(id);
		//formation.setEtablissement(formation.getEtablissement());
		formation.setUtilisateur(u);
		fr.save(formation);
	
	}
	*/
	@RequestMapping(value = "/saveFormation", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addProfile(Utilisateur utilisateur, @ModelAttribute Formation formation,@RequestParam("id") Long id) {
        
        ModelAndView mav = new ModelAndView("Carriere");
        Utilisateur u = ur.getUtilisateur(id);
        fs.ajouterFormation(formation,u);
        //getFormations
        List<Formation> l = fs.listeFormation(u);
        mav.addObject("formations",l);
        mav.addObject("formation",new Formation());
        mav.addObject("utilisateur",utilisateur);
        return mav;
    }
}
