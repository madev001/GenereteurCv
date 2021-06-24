package cv.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;

@RunWith(MockitoJUnitRunner.class)
class UtilisateurServiceTest {

	@Before
	public void init() throws Exception {
		//MockitoAnnotations.initMocks(this);
		FormationService fs = mock(FormationService.class);
		final Formation formation = new Formation();
		formation.setIntitule("qualite logiciel");
		when(fs.ajouterFormation(formation, null)).thenReturn(formation);
		Formation created = new Formation();
		created.setIntitule(formation.getIntitule());
	}
	/*@Autowired
	@Mock
    FormationRepository fr;
	@Mock
	UtilisateurRepository ur;
	@InjectMocks
    FormationService fs;
     */
    
    
	@Test
	void test() {
		
		/*utilisateur.setNom("test");
		utilisateur.setPrenom("test");
		utilisateur.setAdresse("test");
		utilisateur.setEmail("test");
		utilisateur.setCodePostal(1200);
		Utilisateur saved = repo.save(utilisateur);
		assertEquals(1, repo.findAll().size());
		*/
		
		//when(fr.save(ArgumentMatchers.any(Formation.class))).thenReturn(formation);
		//Formation created = fr.save(formation); //fs.ajouterFormation(formation, null); // error when execute this
		//Assert.assertThat(created.getIntitule()).isSameAs(formation.getIntitule());
		//assertEquals(created.getIntitule(), formation.getIntitule());
		
		//assertEquals("qualite logiciel", formation.getIntitule());
		//verify(fr).save(formation);
	}

}
