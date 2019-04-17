package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Wallets;

public class TC3_WalletsHistory extends BaseBrowser {
	@Test()
	public void profileFunctionality() throws IOException, InterruptedException, RowsExceededException, WriteException {
		logger = extent.startTest("*******Wallets History********");
		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();

		Wallets wallet = new Wallets(driver);
		wallet.walletHistory();

	}

}
