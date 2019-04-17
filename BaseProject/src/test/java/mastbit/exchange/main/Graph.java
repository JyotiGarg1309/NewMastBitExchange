package mastbit.exchange.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mastbit.exchange.POM.Mastbit_Graph;
import mastbit.exchange.common.WaitStatement;

public class Graph {
	public WebDriver driver;

	public Graph(WebDriver driver) {
		this.driver = driver;
	}

	public void graphNavigation() throws IOException, InterruptedException {
		WaitStatement.implicitlywaitForSeconds(driver, 10);
		Mastbit_Graph grp = new Mastbit_Graph(driver);
		grp.getBTCCoinGraph();
		grp.getETHCoinGraph();
		grp.getUSDTCoinGraph();

	}
}