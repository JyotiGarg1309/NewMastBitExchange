package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_yourBrokerage;
import mastbit.exchange.common.ScreenShot;
import mastbit.exchange.common.WaitStatement;

public class YourBrokerage {
	public WebDriver driver;

	public YourBrokerage(WebDriver driver) {
		this.driver = driver;
	}

	public void yourBrokerageNavigation() throws IOException, InterruptedException {

		Mastbit_yourBrokerage brokerage = new Mastbit_yourBrokerage(driver);
		brokerage.getYourbrokerage();
		WaitStatement.sleep(3000);
		ScreenShot.take_screenshot(driver, "Your Brokerage");

	}
}
