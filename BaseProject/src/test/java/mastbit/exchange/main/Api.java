package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_Api;
import mastbit.exchange.common.WaitStatement;

public class Api {
	public WebDriver driver;

	public Api(WebDriver driver) {
		this.driver = driver;
	}

	public void APINavigation() throws IOException, InterruptedException {
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		Mastbit_Api api = new Mastbit_Api(driver);
		api.getApikey();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		api.getGenerateApi().click();

		api.getToastMessage();
		api.getRegenerateApi().click();
		api.getToastMessage();
		api.getDeleteApi().click();
		api.getToastMessage();

	}

}
