package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_mailVerify;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Forgot_Password;
import mastbit.exchange.main.Login;
import mastbit.exchange.main.ResetPassword;
import mastbit.exchange.main.Signup;

public class TC13_ForgotPassword extends BaseBrowser {

	@Test(dataProvider = "data")
	public void init(String name, String password, String nationality) throws IOException, InterruptedException

	{

		logger = extent.startTest("Signup****ActivationByMail*******ResetPassword*********Signin");
		Signup signup = new Signup(driver);
		Login login = new Login(driver);
		signup.SignupPageNavigation(name, password, nationality);
		Thread.sleep(6000);
		Mastbit_mailVerify mv = new Mastbit_mailVerify(driver, prop);
		mv.mail_verifyForActivation(name, password, nationality);
		login.LoginBase();

		Thread.sleep(3000);
		Forgot_Password fp = new Forgot_Password(driver, prop);
		fp.forgotPasswordNavigation(name, password, nationality);
		Thread.sleep(3000);
		ResetPassword rp = new ResetPassword(driver, prop);
		rp.resetPasswordNavigation(name, password, nationality);
		Thread.sleep(3000);
		login.LoginPageNavigation(name, password, nationality);

	}

}
