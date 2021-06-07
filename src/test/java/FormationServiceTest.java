

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
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
		assertEquals(a,b);
	}
}
