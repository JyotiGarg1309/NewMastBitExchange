package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.KYC;

public class TC4_ProfileWithKYC extends BaseBrowser {

	@Test(dataProvider = "KycData", groups = { "Profile" }, priority = 2)
	public void kycFunctionality(String Fname, String Lname, String contact, String nation, String residence,
			String idNumber) throws InterruptedException, IOException {
		logger = extent.startTest("*******KYC Functionality******");
		/*
		 * Mastbit_login lg = new Mastbit_login(driver);
		 * 
		 * lg.getMenu().click();
		 */
		Thread.sleep(2000);
		KYC kyc = new KYC(driver);
		kyc.kycNavigation(Fname, Lname, contact, nation, residence, idNumber);

	}

}
