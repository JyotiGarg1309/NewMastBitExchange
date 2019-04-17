package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_walletTransaction;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class WalletTransaction {
	public WebDriver driver;

	public WalletTransaction(WebDriver driver) {
		this.driver = driver;
	}

	public void WalletTransactionNavigation() throws IOException, InterruptedException {

		Mastbit_walletTransaction wt = new Mastbit_walletTransaction(driver);
		wt.getWalletTransaction();
		WaitStatement.sleep(2000);
		ScreenShot.take_screenshot(driver, "Wallet Transaction");

	}
}
