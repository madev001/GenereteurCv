import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SUtilisateur {

	public void AjoutUtilisateur(WebDriver driver,String nom,String prenom,String email,String tel,String adresse,String naissance,String image)
	{
		driver.findElement(By.id("Nom")).sendKeys( nom);
		driver.findElement(By.id("Prenom")).sendKeys(prenom);
		driver.findElement(By.id("Email")).sendKeys( email);
		driver.findElement(By.id("Tel")).sendKeys( tel);
		driver.findElement(By.id("adresse")).sendKeys(adresse);
		driver.findElement(By.id("DateNaissance")).sendKeys( naissance);
		WebElement choixImage = driver.findElement(By.id("image"));
		choixImage.sendKeys(image);
		driver.findElement(By.className("btn")).click();
	}
}
