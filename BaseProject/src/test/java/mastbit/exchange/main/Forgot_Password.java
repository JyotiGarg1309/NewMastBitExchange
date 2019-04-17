package mastbit.exchange.main;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_forgetPassword;
import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.POM.Mastbit_mailVerify;
import mastbit.exchange.POM.Mastbit_signup;
import mastbit.exchange.common.WaitStatement;

public class Forgot_Password {
	public WebDriver driver;
	public Properties prop;

	public Forgot_Password(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}

	public void forgotPasswordNavigation(String name, String password, String nationality)
			throws InterruptedException, IOException {
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getLoginClick().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		lg.getForgotPasswordClick();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		Mastbit_forgetPassword fp = new Mastbit_forgetPassword(driver);
		fp.getForgotemail().sendKeys(name + "@mailinator.com");

		fp.getForgotsend().click();

		Mastbit_signup sg = new Mastbit_signup(driver);
		sg.getToastMessage();
		Mastbit_mailVerify mv = new Mastbit_mailVerify(driver, prop);
		mv.mail_verifyForPassword(name, password, nationality);

	}
}
