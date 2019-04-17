package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_profile;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class Levels {

	public WebDriver driver;

	public Levels(WebDriver driver) {
		this.driver = driver;
	}

	public void levelNavigation() throws IOException, InterruptedException {

		Mastbit_profile pf = new Mastbit_profile(driver);

		pf.getProfile();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getLevelClick().click();

		String str = pf.getLevelText().getAttribute("innerHTML");
		System.out.println("**********Level Text is:" + " " + str + "***********");
		ScreenShot.take_screenshot(driver, "Levels");

	}
}