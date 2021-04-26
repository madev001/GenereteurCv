package com.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.ExperienceService;

@Controller
public class ExperienceController {
	@Autowired
	UtilisateurRepository ur;
	@Autowired
	ExperienceService es;
	
	
	@GetMapping("/MesExperiences")
	public ModelAndView getExperienceForm(@RequestParam("id") Long id)
	{
        Utilisateur u = ur.getUtilisateur(id);
		ModelAndView mav = new ModelAndView("MesExperiences");
        mav.addObject("experience",new Experience());
        mav.addObject("utilisateur",u);
        return mav;
	}
	
	@RequestMapping(value = "/saveExperience", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addExperience(@ModelAttribute Experience experience,@RequestParam("id") Long id/*, BindingResult bindingResult*/) {
		/*if(bindingResult.hasErrors())
		{
	        ModelAndView mav = new ModelAndView("Carriere");
	        return mav;

			}*/
        ModelAndView mav = new ModelAndView("MesExperiences");
        Utilisateur u = ur.getUtilisateur(id);
        es.ajouterExperience(experience, u);
        //getExperience
        List<Experience> l = es.getAllExperience(u);
        mav.addObject("experiences",l);
        mav.addObject("experience",new Experience());
        mav.addObject("utilisateur",u);
        return mav;
    }
	
	@RequestMapping(value = "/deleteExperience",method = RequestMethod.GET)
	public ModelAndView suppFormation(@RequestParam("Experience_id") Long Experience_id,@RequestParam("Utilisateur_id") Long Utilisateur_id)
	{
		ModelAndView mav = new ModelAndView("MesExperiences");
		es.deleteExperience(Experience_id);
		Utilisateur u = ur.getUtilisateur(Utilisateur_id);
		List<Experience> l = es.getAllExperience(u);
        mav.addObject("experiences",l);
        mav.addObject("experience",new Experience());
        mav.addObject("utilisateur",u);
	        return mav;
	}
}
