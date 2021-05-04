package com.cv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import com.cv.repository.UtilisateurRepository;
import com.cv.service.GlobalService;

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
	
	
}
