package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.YourBrokerage;

public class TC7_YourBrokerage extends BaseBrowser {
	@Test()
	public void yourBrokerageFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******Your Brokerage********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();
		YourBrokerage yb = new YourBrokerage(driver);
		yb.yourBrokerageNavigation();

	}
}