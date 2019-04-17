package mastbit.exchange.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import mastbit.exchange.POM.Mastbit_login;
import mastbit.exchange.common.BaseBrowser;
import mastbit.exchange.main.Levels;

public class TC6_ProfileWithLevels extends BaseBrowser {
	@Test(groups = { "Profile" }, priority = 1)
	public void levelsNavigation() throws InterruptedException, IOException {
		logger = extent.startTest("*******Profile With Levels********");

		Mastbit_login lg = new Mastbit_login(driver);
		lg.getMenu().click();

		Thread.sleep(3000);
		Levels level = new Levels(driver);

		level.levelNavigation();

	}

}
