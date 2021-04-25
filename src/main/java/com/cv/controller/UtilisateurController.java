package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;
@Controller
public class UtilisateurController {

	@Autowired
	UtilisateurRepository ur;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	/*@GetMapping("/DonneesPersonelles")
	public String GetDonneesPersonelles(@ModelAttribute Model model) {
		model.addAttribute("utilisateur",new Utilisateur());
		return "DonneesPersonelles";
	}*/
	
	/*@GetMapping("/Carriere")
	public ModelAndView getCarriereForm()
	{
		ModelAndView mav = new ModelAndView("Carriere");
        mav.addObject("utilisateur",new Utilisateur());
        //initialisé l'objet formation pour l"ajouter
        mav.addObject("formation",new Formation());
        return mav;
	}*/
	
	@GetMapping("/DonneesPersonelles")
	public ModelAndView getProfileForm()
	{
		ModelAndView mav = new ModelAndView("DonneesPersonelles");
        mav.addObject("utilisateur",new Utilisateur());
        return mav;
	}
	@PostMapping("/save_profile")
    public ModelAndView addProfile(Utilisateur utilisateur, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){}
        ModelAndView mav = new ModelAndView("Carriere");
        ur.save(utilisateur);
        mav.addObject("formation",new Formation());
        mav.addObject("utilisateur",utilisateur);
        return mav;
    }
	/*
	@PostMapping("/save_profile")
    public String addProfile(Utilisateur utilisateur, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "DonneesPersonelles";}
        ur.save(utilisateur);
        return "redirect:/Carriere";
    }
	*/
}
