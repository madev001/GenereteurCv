package com.cv.service;

import com.cv.entities.Competance;
import com.cv.entities.Experience;
import com.cv.entities.Formation;
import com.cv.entities.Langue;
import com.cv.entities.Loisire;
import com.cv.entities.Utilisateur;
import com.cv.repository.CompetanceRepository;
import com.cv.repository.UtilisateurRepository;
import com.lowagie.text.DocumentException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class PdfService {

	private static final String PDF_RESOURCES = "/pdf-resources/";
    private GlobalService globalService;
  
    private SpringTemplateEngine templateEngine;
    @Autowired
    private UtilisateurRepository ur;
    @Autowired
	FormationService fs;
	@Autowired
	ExperienceService es;
	@Autowired
	LangueService ls;
	@Autowired
	CompetanceRepository cr;
	@Autowired
	LoisireService lservice;
	
    @Autowired
    public PdfService(GlobalService globalService, SpringTemplateEngine templateEngine) {
        this.globalService = globalService;
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Long id,String model) throws IOException, DocumentException {
        Context context = getContext(id);
        String html = loadAndFillTemplate(context,model);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("MonCv", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html,  new ClassPathResource("/templates/").getURL().toExternalForm());//, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm()
        renderer.layout();
        try {
			renderer.createPDF(outputStream);
		} catch (com.itextpdf.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext(Long id) {
        Context context = new Context();
        Utilisateur u = ur.getUtilisateur(id);
        context.setVariable("utilisateur",u);
        //context.setVariable("competances", competanceService.getAllCompetance(u));
        List<Formation> formations = fs.listeFormation(u);
		List<Experience> experiences = es.getAllExperience(u);
		List<Langue> langues = ls.getAllLangue(u);
		List<Competance> competances = cr.getAllCompetance(u);
		List<Loisire> loisires = lservice.listeLoisire(u);
		context.setVariable("loisires",loisires);
		context.setVariable("utilisateur",u);
		context.setVariable("formations",formations);
		context.setVariable("langues",langues);
		context.setVariable("experiences",experiences);
		context.setVariable("competances",competances);
		
        return context;
    }

    private String loadAndFillTemplate(Context context,String model) {
        //return templateEngine.process("pdf_model1", context);
        return templateEngine.process(model, context);
    }

}
