package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_profile;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class KYC {

	public WebDriver driver;

	public KYC(WebDriver driver) {
		this.driver = driver;
	}

	public void kycNavigation(String Fname, String Lname, String contact, String nation, String residence,
			String idNumber) throws InterruptedException, IOException {

		Mastbit_profile pf = new Mastbit_profile(driver);

		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getKyc().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getFirstname().sendKeys(Fname);
		pf.getLastname().sendKeys(Lname);
		pf.getDOB().click();

		pf.getDOBActual().click();
		pf.getContact().sendKeys(contact);

		pf.getResidenceCountry(residence);
		pf.getNationality(nation);

		pf.getNext1().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,380)");

		pf.getIdNumber().sendKeys(idNumber);

		pf.getIdfrontimage();
		pf.getIdbackimage();
		Thread.sleep(3000);

		pf.getNext2().click();
		pf.getUserimage();
		pf.getSubmit().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		ScreenShot.take_screenshot(driver, "KYC");
		pf.getToastMessage();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-300)");

	}

}
