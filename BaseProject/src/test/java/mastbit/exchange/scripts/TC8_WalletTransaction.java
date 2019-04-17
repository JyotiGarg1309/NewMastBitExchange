package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.WalletTransaction;

public class TC8_WalletTransaction extends BaseBrowser {
	@Test()
	public void yourBrokerageFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******Wallet Transaction********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();
		WalletTransaction wt = new WalletTransaction(driver);
		wt.WalletTransactionNavigation();

	}

}
