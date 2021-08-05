import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SExeperience {

	public void AjoutExperience(WebDriver driver,String intitule,String ville,String etab,String moisDebut,String anneeDebut,String moisFin,String anneeFin,String tiny)
	{
			driver.findElement(By.className("add")).click();
			driver.findElement(By.id("Fonction")).sendKeys(intitule);
			driver.findElement(By.id("ville")).sendKeys(ville);
			driver.findElement(By.id("Etablissement")).sendKeys(etab);
			WebElement webElement =  driver.findElement(By.id("Depuis"));
			webElement.sendKeys(moisDebut);
			webElement.sendKeys(Keys.TAB);
			webElement.sendKeys(anneeDebut);
			
			if(moisFin ==null && anneeFin ==null)
			{driver.findElement(By.id("checkJusqua")).click();}
			else {
				WebElement webElement2 =  driver.findElement(By.id("jusqu"));
				webElement2.sendKeys(moisFin);
				webElement2.sendKeys(Keys.TAB);
				webElement2.sendKeys(anneeFin );
			}
			if(tiny != null) {
			((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('"+tiny+"')");
			}
			driver.findElement(By.className("save")).click();
			
	}
}
