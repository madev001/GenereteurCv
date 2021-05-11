package com.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.cv.entities.Competance;
import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.CompetanceService;

@Controller
public class CompetanceController {

	@Autowired
	UtilisateurRepository ur;
	@Autowired
	CompetanceService cs;
	
	@RequestMapping(value = "/saveCompetance", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addLangue(@ModelAttribute Competance competance,@RequestParam("id") Long id/*, BindingResult bindingResult*/) {
		
        ModelAndView mav = new ModelAndView("MesCompetances");
        Utilisateur u = ur.getUtilisateur(id);
        cs.ajouterCompetance(competance, u);
        //get Competances
        List<Competance> l =cs.getAllCompetance(u);
        mav.addObject("competances",l);
        mav.addObject("competance",new Competance());
        mav.addObject("utilisateur",u);
        return mav;
    }
	
	@RequestMapping(value = "/Competances",method = RequestMethod.GET)
	public ModelAndView loadCompetance(@RequestParam("id") Long id)
	{
        ModelAndView mav = new ModelAndView("MesCompetances");
        Utilisateur u = ur.getUtilisateur(id);
        List<Competance> l =cs.getAllCompetance(u);
        mav.addObject("competances",l);
        mav.addObject("competance",new Competance());
        mav.addObject("utilisateur",u);
        return mav;
	}

	@RequestMapping(value = "/deleteCompetance",method = RequestMethod.GET)
	public ModelAndView suppExperience(@RequestParam("Competance_id") Long id,@RequestParam("Utilisateur_id") Long Utilisateur_id)
	{
		ModelAndView mav = new ModelAndView("MesCompetances");
		cs.deleteCompetance(id);
		Utilisateur u = ur.getUtilisateur(Utilisateur_id);
		List<Competance> l =cs.getAllCompetance(u);
        mav.addObject("competances",l);
        mav.addObject("competance",new Competance());
        mav.addObject("utilisateur",u);
	        return mav;
	}
	
	
}
