package mastbit.exchange.main;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_forgetPassword;
import mastbit.exchange.POM.Mastbit_signup;
import mastbit.exchange.common.WaitStatement;

public class ResetPassword {
	public WebDriver driver;
	public Properties prop;

	public ResetPassword(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void resetPasswordNavigation(String name, String password, String nationality)
			throws InterruptedException, IOException {

		Mastbit_signup sg = new Mastbit_signup(driver);
		Mastbit_forgetPassword fp = new Mastbit_forgetPassword(driver);

		WaitStatement.implicitlywaitForSeconds(driver, 10);
		fp.getResetPasswordWindow();
		fp.getPassword().sendKeys(password);

		fp.getConfirmPassword().sendKeys(password);

		fp.getSend().click();

		sg.getToastMessage();

	}
}
