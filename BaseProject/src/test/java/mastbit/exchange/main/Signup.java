package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_signup;
import mastbit.exchange.common.ScreenShot;

public class Signup {
	public WebDriver driver;

	public Signup(WebDriver driver) {
		this.driver = driver;
	}

	public void SignupPageNavigation(String name, String password, String nationality)
			throws IOException, InterruptedException {

		Mastbit_signup sg = new Mastbit_signup(driver);

		sg.getagreeClick().click();

		sg.getOkButtonclick().click();

		sg.getSignupclick().click();

		sg.getFullName().sendKeys(name);

		sg.getEmail().sendKeys(name + "@mailinator.com");
		sg.getPassword().sendKeys(password);

		sg.getConfirmPassword().sendKeys(password);

		sg.getNationality(nationality);

		sg.getTermsCondition();

		sg.getRegister().click();

		ScreenShot.take_screenshot(driver, "Register");
		sg.getToastMessage();

	}

}
