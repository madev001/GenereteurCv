package com.cv.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	@GetMapping("/test")
	public String test() {
		return "model2";
	}
	
	
	
	@GetMapping("/DonneesPersonelles")
	public ModelAndView getProfileForm()
	{
		ModelAndView mav = new ModelAndView("DonneesPersonelles");
        mav.addObject("utilisateur",new Utilisateur());
        return mav;
	}
	@PostMapping("/save_profile")
    public ModelAndView addProfile(@ModelAttribute MultipartFile image, Utilisateur utilisateur, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){}
        ModelAndView mav = new ModelAndView("Carriere");
        
        String fileName= org.springframework.util.StringUtils.cleanPath(image.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("File not valide");
		}
		try {
			
			utilisateur.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		}
		catch(IOException e){ e.printStackTrace();}
		
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
