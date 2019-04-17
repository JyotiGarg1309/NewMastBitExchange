package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_mailVerify;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.common.WaitStatement;
import mastbit.exchange.main.Login;
import mastbit.exchange.main.Signup;

public class TC1_BasicFunctionalityCheck extends BaseBrowser {

	@Test(dataProvider = "data")
	public void init(String name, String password, String nationality) throws IOException, InterruptedException

	{

		logger = extent.startTest("Signup****ActivationByMail*******Signin");
		Signup signup = new Signup(driver);
		signup.SignupPageNavigation(name, password, nationality);
		Mastbit_mailVerify mv = new Mastbit_mailVerify(driver, prop);
		mv.mail_verifyForActivation(name, password, nationality);
		Login login = new Login(driver);
		login.LoginBase();
		WaitStatement.sleep(5000);
		login.LoginPageNavigation(name, password, nationality);

	}

}
