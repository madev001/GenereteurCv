package com.cv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cv.entities.Competance;
import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Langue;
import com.cv.entities.Loisire;
import com.cv.entities.Utilisateur;
import com.cv.repository.CompetanceRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.ExperienceService;
import com.cv.service.FormationService;
import com.cv.service.GlobalService;
import com.cv.service.LangueService;

@Controller
public class GlobalController {

	@Autowired
	GlobalService globalService;
	@Autowired
	UtilisateurRepository ur;

	
	@RequestMapping(value = "/Model1",method = RequestMethod.GET)
	public ModelAndView genererCv(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo(id);
	}
	
	@RequestMapping(value = "/pdf_model1",method = RequestMethod.GET)
	public ModelAndView model1(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo(id);
	}
	
	@RequestMapping(value = "/pdf_model1_green",method = RequestMethod.GET)
	public ModelAndView model1_green(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo_green(id);
	}
	@RequestMapping(value = "/pdf_model1_grey",method = RequestMethod.GET)
	public ModelAndView model1_grey(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo_grey(id);
	}
	@RequestMapping(value = "/pdf_model2",method = RequestMethod.GET)
	public ModelAndView model2(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo2(id);
	}
	@RequestMapping(value = "/pdf_model2_green",method = RequestMethod.GET)
	public ModelAndView model2_green(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo2_green(id);
	}
	@RequestMapping(value = "/pdf_model2_grey",method = RequestMethod.GET)
	public ModelAndView model2_grey(@RequestParam("id") Long id)
	{
		return globalService.getAllinfo2_grey(id);
	}
	@RequestMapping(value = "/models",method = RequestMethod.GET)
	public ModelAndView choisireModel(@RequestParam("id") Long id)
	{
        
        Utilisateur u = ur.getUtilisateur(id);
        ModelAndView mav = new ModelAndView("choisire_model");
        mav.addObject("utilisateur",u);
        return mav;
	}
}
