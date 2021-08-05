import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SCompetence {

	public void AjoutCompetence(WebDriver driver,String competence,int niveau,String Ctype)
	{
		driver.findElement(By.className("add")).click();
		driver.findElement(By.id("Competance")).sendKeys(competence);
		Select level = new Select(driver.findElement(By.id("Niveau")));
		level.selectByIndex(niveau);
		if(Ctype=="p")
		{
		driver.findElement(By.id("Ctype2")).click();
		}
		else 
		{
			driver.findElement(By.id("Ctype1")).click();
		}
		driver.findElement(By.className("save")).click();
	}
	
	public void AjoutLangue(WebDriver driver,String langue,int niveau)
	{
		driver.findElement(By.className("add")).click();
		Select Langue = new Select(driver.findElement(By.id("Langue")));
		Langue.selectByVisibleText(langue);
		Select Niveau = new Select(driver.findElement(By.id("Niveau")));
		Niveau.selectByIndex(niveau);
		driver.findElement(By.className("save")).click();
		
	}
	public void AjoutLoisir(WebDriver driver,String loisir)
	{
		driver.findElement(By.className("add")).click();
		driver.findElement(By.id("Loisire")).sendKeys(loisir);
		driver.findElement(By.className("save")).click();
	}
}
