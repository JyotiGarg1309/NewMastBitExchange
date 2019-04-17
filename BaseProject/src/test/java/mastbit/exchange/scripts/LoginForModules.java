package mastbit.exchange.scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.POM.Mastbit_signup;

public class LoginForModules {

	public static WebDriver driver;

	@BeforeSuite()
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Exefiles/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://devuser.mastbit.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Mastbit_signup sg = new Mastbit_signup(driver);
		Thread.sleep(2000);
		sg.getagreeClick().click();
		Thread.sleep(2000);

		sg.getOkButtonclick().click();
		Thread.sleep(3000);
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getLoginClick().click();

//		lg.getEmail().sendKeys("jyoti1309@mailinator.com");
//		lg.getPassword().sendKeys("Rev@1234");
//		Thread.sleep(3000);
//		lg.getLogin().click();
//		Thread.sleep(4000);
//		lg.getMenu().click();
//		Thread.sleep(2000);
	}

	@Test()
	public void modulesHistory() throws InterruptedException, RowsExceededException, WriteException, IOException {

	}

	@AfterSuite()

	public void tearDown() {
		// driver.quit();

	}
}
