package com.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Experience;
import com.cv.entities.Langue;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.LangueService;

@Controller
public class LangueController {

	@Autowired
	UtilisateurRepository ur;
	@Autowired
	LangueService ls;
	
	@RequestMapping(value = "/saveLangue", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addLangue(@ModelAttribute Langue langue,@RequestParam("id") Long id/*, BindingResult bindingResult*/) {
		/*if(bindingResult.hasErrors())
		{
	        ModelAndView mav = new ModelAndView("");
	        return mav;

			}*/
        ModelAndView mav = new ModelAndView("MesLangues");
        Utilisateur u = ur.getUtilisateur(id);
        ls.ajouterLangue(langue, u);
        //getLangue
        List<Langue> l =ls.getAllLangue(u);
        mav.addObject("langues",l);
        mav.addObject("langue",new Langue());
        mav.addObject("utilisateur",u);
        return mav;
    }
	@RequestMapping(value = "/Langues",method = RequestMethod.GET)
	public ModelAndView loadLangue(@RequestParam("id") Long id)
	{
        ModelAndView mav = new ModelAndView("MesLangues");
        Utilisateur u = ur.getUtilisateur(id);
        List<Langue> l =ls.getAllLangue(u);
        mav.addObject("langues",l);
        mav.addObject("langue",new Langue());
        mav.addObject("utilisateur",u);
        return mav;
	}
	
	@RequestMapping(value = "/deleteLangue",method = RequestMethod.GET)
	public ModelAndView suppExperience(@RequestParam("Langue_id") Long langue_id,@RequestParam("Utilisateur_id") Long Utilisateur_id)
	{
		ModelAndView mav = new ModelAndView("MesLangues");
		ls.deleteLangue(langue_id);
		Utilisateur u = ur.getUtilisateur(Utilisateur_id);
        List<Langue> l =ls.getAllLangue(u);
        mav.addObject("langues",l);
        mav.addObject("langue",new Langue());
        mav.addObject("utilisateur",u);
	        return mav;
	}
}
