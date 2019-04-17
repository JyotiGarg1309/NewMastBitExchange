package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.YourOrderHistory;

public class TC10_YourOrderHistory extends BaseBrowser {

	@Test()
	public void yourOrderHistoryFunctionality() throws InterruptedException, IOException {
		logger = extent.startTest("*******Your Order History********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();
		Thread.sleep(2000);
		YourOrderHistory oh = new YourOrderHistory(driver);
		oh.yourOrderhistoryNavigation();

	}

}
