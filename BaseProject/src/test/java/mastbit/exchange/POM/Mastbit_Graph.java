package mastbit.exchange.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mastbit.exchange.common.ScreenShotGraph;
import mastbit.exchange.common.WaitStatement;

public class Mastbit_Graph {
	public WebDriver driver;
	By BTC = By.xpath("//*[@id='BTC-panel']/div/div/div/table/tbody/tr/td[1]");
	By ETH = By.xpath("//*[@id='ETH-panel']/div/div/div/table/tbody/tr/td[1]");
	By USDT = By.xpath("//*[@id='USDT-panel']/div/div/div/table/tbody/tr/td[1]");
	By list = By
			.xpath("//*[@id='app-wrapper']/app-dashboard/section[1]/div/div[4]/div/div[1]/div/div/ngb-tabset/ul/li");

	public Mastbit_Graph(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void getBTCCoinGraph() throws InterruptedException {

		List<WebElement> allcoin = driver.findElements(BTC);
		int count = allcoin.size();

		System.out.println("Count Of Coins:" + " " + allcoin.size());

		for (int i = 1; i < count; i++) {
			WebElement coin = allcoin.get(i);
			String coinName = coin.getText();

			boolean b = coin.isDisplayed();
			if (b == true) {
				System.out.println(coinName);

				coin.click();
				Thread.sleep(4000);
				ScreenShotGraph.take_screenshot(driver, coinName);

			} else
				continue;
		}

	}

	public void getETHCoinGraph() throws InterruptedException {

		List<WebElement> allcoinheader = driver.findElements(list);
		allcoinheader.get(1).click();
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		List<WebElement> allcoin = driver.findElements(ETH);
		int count = allcoin.size();

		System.out.println("Count Of Coins:" + " " + allcoin.size());

		for (int i = 0; i < count; i++) {

			WebElement coin = allcoin.get(i);

			String coinName = coin.getText();

			boolean b = coin.isDisplayed();
			if (b == true) {
				System.out.println(coinName);

				coin.click();
				Thread.sleep(4000);
				ScreenShotGraph.take_screenshot(driver, coinName);

			} else
				continue;

		}
	}

	public void getUSDTCoinGraph() throws InterruptedException {

		List<WebElement> allcoinheader = driver.findElements(list);
		allcoinheader.get(2).click();

		WaitStatement.implicitlywaitForSeconds(driver, 10);

		List<WebElement> allcoin = driver.findElements(USDT);
		int count = allcoin.size();

		System.out.println("Count Of Coins:" + " " + allcoin.size());

		for (int i = 0; i < count; i++) {
			WebElement coin = allcoin.get(i);
			String coinName = coin.getText();

			boolean b = coin.isDisplayed();
			if (b == true) {
				System.out.println(coinName);

				coin.click();
				Thread.sleep(4000);
				ScreenShotGraph.take_screenshot(driver, coinName);

			} else
				continue;

		}
	}
}
