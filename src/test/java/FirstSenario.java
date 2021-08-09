

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FirstSenario {

	static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String exePath = "src/test/java/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver" , exePath);
	 	 driver = new ChromeDriver();
		//driver.get("https://moncv21.herokuapp.com/");
		driver.get("http://localhost:8081/");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testNormal() {
		
		driver.manage().window().maximize();
		//Click sur Vas y 
		driver.findElement(By.className("btn")).click();
//Remplire les infos
		
		SUtilisateur utilisateur = new SUtilisateur();
		utilisateur.AjoutUtilisateur(driver, "Alouan", "Mouad", "mouad.alouan@uit.ac.ma", "0629634735", "BD yaacoub el mansour rue brazilia N12 Oujda", "22/07/1994", "C:\\Users\\Mouad\\Desktop\\11052019\\FB_IMG_1559044222520.jpg");
		
		driver.getPageSource().contains("MOUAD ALObUAN");

//Remplire profile
		// wait 5 seconds to appear the close button
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SPT profil = new SPT();
		profil.AjoutProfile(driver);
		driver.findElement(By.id("formations")).click();
		
//ajout formation  
	
			SFormation formation= new SFormation();
			formation.AjoutFormation(driver, "Developpement Informatique", "Oujda", "Centre mixte", "09", "2013", "07", "2016", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
			formation.AjoutFormation(driver, "Licence en developpement app et mobile", "Kenitra", "Univ Ibn tofail", "09", "2018", "07", "2019", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
			formation.AjoutFormation(driver, "Master qualité logiciel", "Kenitra", "Univ Ibn tofail", "09", "2019",null,null, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

		
// Experience
						driver.findElement(By.className("next")).click();
					
						SExeperience exp = new SExeperience();
						exp.AjoutExperience(driver, "Conseiller client", "Oujda", "Ht call", "11", "2016", "04", "2017", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
						exp.AjoutExperience(driver, "Technicien informatique", "Oujda", "Ht call", "04", "2017", "08", "2018",null);
						exp.AjoutExperience(driver, "Customer service agent", "Kenitra", "Webhelp", "08", "2019", null,null,null);

						
						
			driver.findElement(By.className("next")).click();
			// Competences

			SCompetence competence = new SCompetence();
			competence.AjoutCompetence(driver, "Java", 1, "p");
			competence.AjoutCompetence(driver, "UML", 3, "t");
			competence.AjoutCompetence(driver, "Jenkins", 2, "p");
			competence.AjoutCompetence(driver, "Selenium", 1, "p");
			
//Langues
			driver.findElement(By.className("next")).click();
			
			competence.AjoutLangue(driver, "Arabic", 1);
			competence.AjoutLangue(driver, "French", 2);
			competence.AjoutLangue(driver, "English", 3);
//Loisir
			driver.findElement(By.className("next")).click();
			
			competence.AjoutLoisir(driver, "Lecture");
			competence.AjoutLoisir(driver, "Natation");
			competence.AjoutLoisir(driver, "Gaming");
			
//Choisir model
			driver.findElement(By.className("next")).click();


	}

}
