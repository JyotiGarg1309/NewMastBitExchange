package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Graph;

public class TC12_Graph extends BaseBrowser {

	@Test()
	public void graphFunctionality() throws IOException, InterruptedException {
		logger = extent.startTest("*******Graph********");
		Graph grp = new Graph(driver);
		grp.graphNavigation();

	}
}