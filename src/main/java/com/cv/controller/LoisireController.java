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
import com.cv.entities.Loisire;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.LoisireService;

@Controller
public class LoisireController {

	@Autowired
	UtilisateurRepository ur;
	@Autowired
	LoisireService ls;
	
	@RequestMapping(value = "/saveLoisire", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView addLangue(@ModelAttribute Loisire loisire,@RequestParam("id") Long id/*, BindingResult bindingResult*/) {
		
        ModelAndView mav = new ModelAndView("MesLoisires");
        Utilisateur u = ur.getUtilisateur(id);
        ls.ajouterLoisire(loisire, u);
       
        //get loisire
        List<Loisire> l =ls.listeLoisire(u);
        mav.addObject("loisires",l);
        mav.addObject("loisire",new Loisire());
        mav.addObject("utilisateur",u);
        return mav;
    }
	
	@RequestMapping(value = "/Loisire",method = RequestMethod.GET)
	public ModelAndView loadCompetance(@RequestParam("id") Long id)
	{
        
        Utilisateur u = ur.getUtilisateur(id);
        List<Loisire> l =ls.listeLoisire(u);
        ModelAndView mav = new ModelAndView("MesLoisires");
        mav.addObject("loisires",l);
        mav.addObject("loisire",new Loisire());
        mav.addObject("utilisateur",u);
        return mav;
	}

	@RequestMapping(value = "/deleteLoisire",method = RequestMethod.GET)
	public ModelAndView suppExperience(@RequestParam("Loisire_id") Long id,@RequestParam("Utilisateur_id") Long Utilisateur_id)
	{
		ModelAndView mav = new ModelAndView("MesLoisires");
		ls.supprimerLoisire(id);
		Utilisateur u = ur.getUtilisateur(Utilisateur_id);
		List<Loisire> l =ls.listeLoisire(u);
        mav.addObject("loisires",l);
        mav.addObject("loisire",new Loisire());
        mav.addObject("utilisateur",u);
	        return mav;
	}

}
