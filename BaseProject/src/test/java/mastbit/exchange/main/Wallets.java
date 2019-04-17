package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mastbit.exchange.POM.Mastbit_wallet;
import mastbit.exchange.common.WaitStatement;

public class Wallets {
	public WebDriver driver;

	public Wallets(WebDriver driver) {
		this.driver = driver;
	}

	public void walletHistory() throws IOException, InterruptedException, RowsExceededException, WriteException {

		Mastbit_wallet wallet = new Mastbit_wallet(driver);
		wallet.getWallets();
		WaitStatement.pageLoad(driver, 10);

		wallet.getWalletAddress();

	}
}
