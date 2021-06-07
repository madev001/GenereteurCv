
/* import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static com.jayway.restassured.RestAssured.given;

import com.cv.CvApplication;
import com.cv.controller.FormationController;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;

import io.restassured.RestAssured;

@RunWith(MockitoJUnitRunner.class)
//@DataJpaTest
//@ContextConfiguration(classes = CvApplication.class) 
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest(classes = CvApplication.class) 
//@WebMvcTest(FormationService.class)


class fsTestTest {
	@Mock
	@Autowired
	private FormationRepository fr;
	@Spy
	@InjectMocks
	@Autowired
	private FormationService fs =new FormationService();
	@Autowired
	private UtilisateurRepository ur;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Utilisateur u = new Utilisateur();
		u.setNom("test");
		u.setPrenom("test");
		u.setEmail("test@test.test");
		u.setDateNaissance(null);
		u.setImage(null);
		u.setCodePostal(14000);
		u.setVille("oujda");
		u.setAdresse("test test test");
		ur.save(u);
		
        List<Formation> list = new ArrayList<Formation>();
        Formation formation = new Formation();
        formation.setDescription("test test test test test ");
        formation.setEtablissement("test test test ");
        formation.setIntitule("test test test ");
        formation.setUtilisateur(u);
        
        Formation formation2 = new Formation();
        formation2.setDescription("test test test test test ");
        formation2.setEtablissement("test test test ");
        formation2.setIntitule("test test test ");
        formation2.setUtilisateur(u);
        
        list.add(formation);
        list.add(formation2);
        fr.saveAll(list);
        //when(fr.findAll()).thenReturn(list);
       //  Mockito.when(fs.listeFormation(u)).thenReturn(list);

       // given(fs.listeFormation(u)).thenReturn(list);
        
        	List<Formation> exepctedList = fr.findAll();
        	assertEquals( exepctedList,list);
		
	}

}*/
