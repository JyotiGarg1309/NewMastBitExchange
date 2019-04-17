package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_profile;
import mastbit.exchange.common.WaitStatement;

public class Security {
	public WebDriver driver;

	public Security(WebDriver driver) {
		this.driver = driver;
	}

	public void SecurityNavigation() throws IOException, InterruptedException {

		Mastbit_profile pf = new Mastbit_profile(driver);

		pf.getSecurity().click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		pf.getLoginalertEnable();

		pf.getLoginshieldView();

		driver.navigate().back();

		pf.getSecurity().click();

		pf.getLoginShieldEnable();

	}
}
