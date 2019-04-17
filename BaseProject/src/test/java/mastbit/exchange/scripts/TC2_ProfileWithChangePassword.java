package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.ChangePassword;

public class TC2_ProfileWithChangePassword extends BaseBrowser {

	@Test(groups = { "Profile" }, priority = 4)
	public void profileFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******Profile With Change Password********");
		/*
		 * Mastbit_login lg = new Mastbit_login(driver); lg.getMenu().click();
		 */
		Thread.sleep(2000);
		ChangePassword cp = new ChangePassword(driver);
		cp.ProfileNavigation();

	}

}
