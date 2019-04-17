package mastbit.exchange.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String take_screenshot(WebDriver driver, String path) throws IOException {

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String str = "./ScreenShotCollection/" + File.separator + "/Failed TestCase ScreenShot/" + path + " "
				+ timestamp + ".png";

		FileUtils.copyFile(f, new File(str));

		return str;
	}

}
