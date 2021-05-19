package com.cv.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.cv.entities.Competance;
import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Langue;
import com.cv.entities.Loisire;
import com.cv.entities.Profile;
import com.cv.entities.Utilisateur;
import com.cv.repository.CompetanceRepository;
import com.cv.repository.UtilisateurRepository;
import com.itextpdf.io.IOException;


@Service
public class GlobalService {

	@Autowired
	FormationService fs;
	@Autowired
	ExperienceService es;
	@Autowired
	LangueService ls;
	@Autowired
	CompetanceRepository cr;
	@Autowired
	UtilisateurRepository ur;
	@Autowired
	LoisireService lservice;
	@Autowired
	ProfileService ps;
	public  ModelAndView getAllinfo(Long id)
	{
		ModelAndView mav = new ModelAndView("pdf_model1");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		Profile profile = ps.getProfile(u);
		mav.addObject("profile",profile);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("loisires",loisires);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
	
	public  ModelAndView getAllinfo_green(Long id)
	{
		ModelAndView mav = new ModelAndView("pdf_model1_green");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		Profile profile = ps.getProfile(u);
		mav.addObject("profile",profile);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("loisires",loisires);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
	
	public  ModelAndView getAllinfo_grey(Long id)
	{
		ModelAndView mav = new ModelAndView("pdf_model1_grey");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		Profile profile = ps.getProfile(u);
		mav.addObject("profile",profile);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("loisires",loisires);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
	public  ModelAndView getAllinfo2(Long id)
	{
		ModelAndView mav = new ModelAndView("pdf_model2");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		Profile profile = ps.getProfile(u);
		mav.addObject("profile",profile);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("loisires",loisires);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
	//green_model2
	public  ModelAndView getAllinfo2_green(Long id)
	{
		ModelAndView mav = new ModelAndView("pdf_model2_green");
		Utilisateur u = ur.getOne(id);
		List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		Profile profile = ps.getProfile(u);
		mav.addObject("profile",profile);
		mav.addObject("utilisateur",u);
		mav.addObject("formations",formations);
		mav.addObject("langues",langues);
		mav.addObject("loisires",loisires);
		mav.addObject("experiences",experiences);
		mav.addObject("competances",competances);
        return mav;
		
	}
	//grey_model2
		public  ModelAndView getAllinfo2_grey(Long id)
		{
			ModelAndView mav = new ModelAndView("pdf_model2_grey");
			Utilisateur u = ur.getOne(id);
			List<Formation> formations = fs.listeFormation(u);
			List<Experience> experiences = es.getAllExperience(u);
			List<Langue> langues = ls.getAllLangue(u);
			List<Competance> competances = cr.getAllCompetance(u);
			List<Loisire> loisires = lservice.listeLoisire(u);
			Profile profile = ps.getProfile(u);
			mav.addObject("profile",profile);
			mav.addObject("utilisateur",u);
			mav.addObject("formations",formations);
			mav.addObject("langues",langues);
			mav.addObject("loisires",loisires);
			mav.addObject("experiences",experiences);
			mav.addObject("competances",competances);
	        return mav;
			
		}
	
	
    
}
