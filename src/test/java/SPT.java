import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SPT {

	
	public void AjoutProfile(WebDriver driver)
	{
		driver.findElement(By.className("tox-notification__dismiss")).click();
		
		//need to add the Profile
		((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')");

		driver.findElement(By.className("save")).click();
	}
}
