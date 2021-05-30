

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.cv.CvApplication;
import com.cv.entities.Utilisateur;
import com.cv.repository.UtilisateurRepository;

@DataJpaTest
@ContextConfiguration(classes = CvApplication.class) 
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UtilisateurTest {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Test
	void testCreate() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("test nom");
		utilisateur.setPrenom("testPrenom");
		utilisateur.setEmail("test@test.test");
		utilisateur.setAdresse("adresse aleatoire");
		utilisateur.setVille("Oujda");
		utilisateur.setCodePostal(17000);
		utilisateur.setDateNaissance(null);
		utilisateur.setImage(null);
		Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		assertNotNull(savedUtilisateur);
	}
	
	
	
	

}
