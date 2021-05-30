/*package com.service.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cv.entities.Formation;
import com.cv.repository.FormationRepository;
import com.cv.service.FormationService;

@RunWith(MockitoJUnitRunner.class)
public class FormationServiceTest {

	@Mock
	private FormationRepository formationRepository;
	@InjectMocks
	private FormationService formationService;
	@Test
	public void whenSaveFormation_shouldReturnFormation()
	{
		
		Formation formation = new Formation();
		formation.setIntitule("Intitulé");
		when(formationRepository.save(ArgumentMatchers.any(Formation.class))).thenReturn(formation);
		Formation created = formationService.ajouterFormation(formation,null );
		//assertThat(created.getIntitule()).isSameAs(formation.getIntitule());
		//assertThat(formation.getIntitule()).isSameAs(created.getIntitule());
	    assertEquals(created.getIntitule(), formation.getIntitule());
		verify(formationRepository).save(formation);
		}
}
*/