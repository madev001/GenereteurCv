import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String exePath = "src/test/java/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver" , exePath);
	 	 WebDriver driver = new ChromeDriver();
		//driver.get("https://moncv21.herokuapp.com/");
		driver.get("http://localhost:8081/");
		driver.manage().window().maximize();
		//Click sur Vas y 
		driver.findElement(By.className("btn")).click();
//Remplire les infos
		driver.findElement(By.id("Nom")).sendKeys( "Alouan");
		driver.findElement(By.id("Prenom")).sendKeys( "Mouad");
		driver.findElement(By.id("Email")).sendKeys( "mouad.alouan@uit.ac.ma");
		driver.findElement(By.id("Tel")).sendKeys( "0629634735");
		driver.findElement(By.id("adresse")).sendKeys( "BD yaacoub el mansour rue brazilia N12 Oujda");
		driver.findElement(By.id("DateNaissance")).sendKeys( "22/07/1994");
		WebElement choixImage = driver.findElement(By.id("image"));
		choixImage.sendKeys("C:\\Users\\Mouad\\Desktop\\11052019\\FB_IMG_1559044222520.jpg");
		driver.findElement(By.className("btn")).click();
		
//Remplire profile
		// wait 5 second to appair the close button
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.className("tox-notification__dismiss")).click();
		
		//need to add the Profile
		((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");

		/*driver.findElement(By.id("tinymce")).click();
		driver.findElement(By.id("tinymce")).sendKeys(Keys.TAB);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Some Sample Text Here");*/
		driver.findElement(By.className("save")).click();
		driver.findElement(By.id("formations")).click();
		
//ajout formation  
		driver.findElement(By.className("add")).click();
		
		// Premiere formation
			driver.findElement(By.id("Intitule")).sendKeys("Developpement Informatique");
			driver.findElement(By.id("ville")).sendKeys("Oujda");
			driver.findElement(By.id("Etablissement")).sendKeys("Centre mixte");
			WebElement webElement =  driver.findElement(By.id("Formation_debut_mois"));
			webElement.sendKeys("09");
			webElement.sendKeys(Keys.TAB);
			webElement.sendKeys("2013");
			WebElement webElement2 =  driver.findElement(By.id("jusqu"));
			webElement2.sendKeys("07");
			webElement2.sendKeys(Keys.TAB);
			webElement2.sendKeys("2016");
			((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
			driver.findElement(By.className("save")).click();
			
			// Deuxieme formation
			driver.findElement(By.className("add")).click();
						driver.findElement(By.id("Intitule")).sendKeys("Licence en developpement app et mobile");
						driver.findElement(By.id("ville")).sendKeys("Kenitra");
						driver.findElement(By.id("Etablissement")).sendKeys("Univ Ibn tofail");
						WebElement webElementF2 =  driver.findElement(By.id("Formation_debut_mois"));
						webElementF2.sendKeys("09");
						webElementF2.sendKeys(Keys.TAB);
						webElementF2.sendKeys("2018");
						WebElement webElementF22 =  driver.findElement(By.id("jusqu"));
						webElementF22.sendKeys("07");
						webElementF22.sendKeys(Keys.TAB);
						webElementF22.sendKeys("2019");
						((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
						driver.findElement(By.className("save")).click();
			// Troixieme formation
			driver.findElement(By.className("add")).click();
						driver.findElement(By.id("Intitule")).sendKeys("Master qualité logiciel");
						driver.findElement(By.id("ville")).sendKeys("Kenitra");
						driver.findElement(By.id("Etablissement")).sendKeys("Univ Ibn tofail");
						WebElement webElementF3 =  driver.findElement(By.id("Formation_debut_mois"));
						webElementF3.sendKeys("09");
						webElementF3.sendKeys(Keys.TAB);
						webElementF3.sendKeys("2019");
						driver.findElement(By.id("checkJusqua")).click();
						
						((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
						driver.findElement(By.className("save")).click();
			
// Experience
						driver.findElement(By.className("next")).click();
						// Premiere Experience
						driver.findElement(By.className("add")).click();
						driver.findElement(By.id("Fonction")).sendKeys("Conseiller client");
						driver.findElement(By.id("ville")).sendKeys("Oujda");
						driver.findElement(By.id("Etablissement")).sendKeys("Ht call");
						WebElement webElementExp =  driver.findElement(By.id("Depuis"));
						webElementExp.sendKeys("11");
						webElementExp.sendKeys(Keys.TAB);
						webElementExp.sendKeys("2016");
						WebElement webElementExpF =  driver.findElement(By.id("jusqu"));
						webElementExpF.sendKeys("04");
						webElementExpF.sendKeys(Keys.TAB);
						webElementExpF.sendKeys("2017");
						//((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
						driver.findElement(By.className("save")).click();
			// Deuxieme Experience
						driver.findElement(By.className("add")).click();
						driver.findElement(By.id("Fonction")).sendKeys("Technicien informatique");
						driver.findElement(By.id("ville")).sendKeys("Oujda");
						driver.findElement(By.id("Etablissement")).sendKeys("Ht call");
						WebElement webElementExp2 =  driver.findElement(By.id("Depuis"));
						webElementExp2.sendKeys("04");
						webElementExp2.sendKeys(Keys.TAB);
						webElementExp2.sendKeys("2017");
						WebElement webElementExpF2 =  driver.findElement(By.id("jusqu"));
						webElementExpF2.sendKeys("08");
						webElementExpF2.sendKeys(Keys.TAB);
						webElementExpF2.sendKeys("2018");
						//((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
						driver.findElement(By.className("save")).click();
			// Troixieme Experience
						driver.findElement(By.className("add")).click();
						driver.findElement(By.id("Fonction")).sendKeys("Customer service agent");
						driver.findElement(By.id("ville")).sendKeys("Kenitra");
						driver.findElement(By.id("Etablissement")).sendKeys("Webhelp");
						WebElement webElementExp3 =  driver.findElement(By.id("Depuis"));
						webElementExp3.sendKeys("08");
						webElementExp3.sendKeys(Keys.TAB);
						webElementExp3.sendKeys("2019");
						driver.findElement(By.id("checkJusqua")).click();
						//((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");
						driver.findElement(By.className("save")).click();
						
			driver.findElement(By.className("next")).click();
			// Competences
			 // Premiere competence
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Competance")).sendKeys("Java");
			Select level = new Select(driver.findElement(By.id("Niveau")));
			level.selectByIndex(1);
			driver.findElement(By.id("Ctype2")).click();
			driver.findElement(By.className("save")).click();
			 // deuxieme competence
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Competance")).sendKeys("UML");
			Select level2 = new Select(driver.findElement(By.id("Niveau")));
			level2.selectByIndex(3);
			driver.findElement(By.id("Ctype1")).click();
			driver.findElement(By.className("save")).click();
			 // troixieme competence
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Competance")).sendKeys("Jenkins");
			Select level3 = new Select(driver.findElement(By.id("Niveau")));
			level3.selectByIndex(2);
			driver.findElement(By.id("Ctype2")).click();
			driver.findElement(By.className("save")).click();
			 // quatrieme competence
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Competance")).sendKeys("Selenium");
			Select level4 = new Select(driver.findElement(By.id("Niveau")));
			level4.selectByIndex(1);
			driver.findElement(By.id("Ctype2")).click();
			driver.findElement(By.className("save")).click();
//Langues
			driver.findElement(By.className("next")).click();
		//premiere langue
			driver.findElement(By.className("add")).click();
			Select Langue = new Select(driver.findElement(By.id("Langue")));
			Langue.selectByVisibleText("Arabic");
			Select Niveau = new Select(driver.findElement(By.id("Niveau")));
			Niveau.selectByIndex(1);
			driver.findElement(By.className("save")).click();
			//deuxieme langue
			driver.findElement(By.className("add")).click();
			Select Langue2 = new Select(driver.findElement(By.id("Langue")));
			Langue2.selectByVisibleText("French");
			Select Niveau2 = new Select(driver.findElement(By.id("Niveau")));
			Niveau2.selectByIndex(2);
			driver.findElement(By.className("save")).click();
			//troisieme langue
			driver.findElement(By.className("add")).click();
			Select Langue3 = new Select(driver.findElement(By.id("Langue")));
			Langue3.selectByVisibleText("English");
			Select Niveau3 = new Select(driver.findElement(By.id("Niveau")));
			Niveau3.selectByIndex(3);
			driver.findElement(By.className("save")).click();
//Loisir
			driver.findElement(By.className("next")).click();
			//premier loisir
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Loisire")).sendKeys("Lecture");
			driver.findElement(By.className("save")).click();
			//deuxiem loisir
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Loisire")).sendKeys("Natation");
			driver.findElement(By.className("save")).click();
			//troisiem loisir
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Loisire")).sendKeys("Gaming");
			driver.findElement(By.className("save")).click();
//Choisir model
			driver.findElement(By.className("next")).click();

	}
	

}
