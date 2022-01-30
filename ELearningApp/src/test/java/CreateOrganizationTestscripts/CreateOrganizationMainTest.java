package CreateOrganizationTestscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationMainTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		
		//String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
	//	FileInputStream fis = new FileInputStream("./src/test/resources/practData.xlsx");
		
	
		WebDriver driver=new ChromeDriver();
		
		/*WebElement ExpectedOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		Random ran = new Random();
		int randomNo= ran.nextInt(5000);
		OrgName = ExpectedOrgName+randomNo;*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("shv energy pvt ltd");
		driver.findElement(By.name("button")).click();
		
		
	}

}
