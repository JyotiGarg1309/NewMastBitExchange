package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Api;


public class TC11_Api extends BaseBrowser {

	@Test()
	public void createTicketFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******API********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();
		Thread.sleep(3000);
		Api api = new Api(driver);
		api.APINavigation();

	}

}
