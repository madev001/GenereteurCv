

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.cv.CvApplication;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;



@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
@ContextConfiguration(classes = CvApplication.class) 
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FormationServiceTest {

	@Mock
	@Autowired
	private FormationRepository fr;
	@InjectMocks
	@Autowired
	private FormationService fs;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	
	@Test
	void testAjout() {
		final Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("test nom");
		utilisateur.setPrenom("testPrenom");
		utilisateur.setEmail("test@test.test");
		utilisateur.setAdresse("adresse aleatoire");
		utilisateur.setVille("Oujda");
		utilisateur.setCodePostal(17000);
		utilisateur.setDateNaissance(null);
		utilisateur.setImage(null);
		 utilisateurRepository.save(utilisateur);
		 
		final Formation formation = new Formation();
		formation.setDescription("test test test");
		formation.setEtablissement("test test test");
		formation.setFormation_debut_annee("2019");
		formation.setIntitule("test test test");
		formation.setLocalite("test test test");
		formation.setUtilisateur(utilisateur);
		Formation exepted = fs.ajouterFormation(formation, utilisateur);
		//Formation exepted = fr.save(formation);
		assertNotNull(exepted);
	}
	 
	 
	@Test
	public void TestList()
	{
		
		Utilisateur u = new Utilisateur();
		u.setNom("test");
		u.setPrenom("test");
		u.setEmail("test@test.test");
		u.setDateNaissance(null);
		u.setImage(null);
		u.setCodePostal(14000);
		u.setAdresse("test test test");
		
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
        
        when(fr.findAll()).thenReturn(list);
       // given(fr.findAll()).willReturn(list);
        
        	List<Formation> exepctedList = fs.listeFormation(u);
        	assertEquals( exepctedList,list);
		}
	
	@Test
	public void test()
	{
		int a=1;
		int b=2;
		assertNotEquals(a,b);
	}
}
