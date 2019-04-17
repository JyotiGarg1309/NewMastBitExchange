package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_profile;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class ChangePassword {
	public WebDriver driver;

	public ChangePassword(WebDriver driver) {
		this.driver = driver;
	}

	public void ProfileNavigation() throws IOException, InterruptedException {

		Mastbit_profile pf = new Mastbit_profile(driver);

		pf.getProfileIn().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getChangepassword().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getOldPassword().sendKeys("Rev@1234");
		pf.getPassword().sendKeys("Rev@12345");
		pf.getconfirmPassword().sendKeys("Rev@12345");
		pf.getPasswordchange().click();
		pf.getToastMessage();
		ScreenShot.take_screenshot(driver, "Password Changed");

	}
}
