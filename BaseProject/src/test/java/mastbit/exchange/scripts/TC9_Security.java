package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Security;

public class TC9_Security extends BaseBrowser {
	@Test(groups = { "Profile" }, priority = 3)
	public void securityFunctionality() throws InterruptedException, IOException {

		logger = extent.startTest("*******Security********");
		Security sc = new Security(driver);
		sc.SecurityNavigation();

	}
}
