package com.cv.controller;

import org.springframework.web.bind.annotation.RequestParam;

import com.cv.service.CompetanceService;
import com.cv.service.GlobalService;
import com.cv.service.PdfService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PdfController {
    private PdfService pdfService;
    private GlobalService globalService;
	
    @Autowired
    public void StudentController(GlobalService globalService, PdfService pdfService) {
        this.globalService = globalService;
        this.pdfService = pdfService;
    }

    @GetMapping("/showpdf")
    public ModelAndView studentsView(@RequestParam("id") Long id) {
        return globalService.getAllinfo(id);
    }

    @GetMapping(path="/download-pdf", produces="application/pdf")
    public void downloadPDFResource(HttpServletResponse response,@RequestParam("id") Long id,@RequestParam("model") String model) {
        try {
            Path file = Paths.get(pdfService.generatePdf(id,model).getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
