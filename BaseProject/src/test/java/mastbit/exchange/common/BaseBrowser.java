package mastbit.exchange.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class BaseBrowser {

	public static WebDriver driver;
	public Properties prop;
	public final String username = RandomStringUtils.randomAlphabetic(5);
	public static ExtentReports extent;
	public static ExtentTest logger;
	public ITestResult result;
	public static String parentWinHandle;
	static {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/test" + timestamp + ".html", false);
	}

	public void excelCreation() throws IOException, RowsExceededException, WriteException {
		File file = new File("./Test-Data/mastbiteclipse.xls");
		FileOutputStream fos = new FileOutputStream(file);

		WritableWorkbook wb = Workbook.createWorkbook(file);
		WritableSheet sht = wb.createSheet("data", 0);

		sht.addCell(new Label(0, 0, username));
		sht.addCell(new Label(1, 0, "Rev@1234"));
		sht.addCell(new Label(2, 0, "India"));
		fos.close();

		wb.write();
		wb.close();
		System.out.println("Workbook is created with name:" + " " + username);
	}

	@BeforeSuite(alwaysRun = true)
	public void initializeDriver() throws IOException, RowsExceededException, WriteException, InterruptedException {
		excelCreation();

		prop = new Properties();
		FileInputStream fis = new FileInputStream("./Test-Data/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is:" + " " + browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Exefiles/chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Exefiles/geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Exefiles/IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else
			System.out.println("No Browser Found");

		WaitStatement.implicitlywaitForSeconds(driver, 30);

		driver.get(prop.getProperty("url"));

		parentWinHandle = driver.getWindowHandle();
		System.out.println("Parent window handle: " + parentWinHandle);

		driver.manage().window().maximize();

	}

	@DataProvider(name = "data")
	public Object[][] data() throws BiffException, IOException {

		File f = new File("./Test-Data/mastbiteclipse.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet("data");

		int row = sheet.getRows();
		int col = sheet.getColumns();
		Object[][] obj = new Object[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell c1 = sheet.getCell(j, i);
				obj[i][j] = c1.getContents();
			}
		}
		return obj;
	}

	@DataProvider(name = "KycData")
	public Object[][] KycData() throws BiffException, IOException {

		File f = new File("./Test-Data/MastbitKYC.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet("Sheet1");

		int row = sheet.getRows();
		int col = sheet.getColumns();
		Object[][] obj = new Object[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell c1 = sheet.getCell(j, i);
				obj[i][j] = c1.getContents();
			}
		}
		return obj;
	}

	@AfterMethod(alwaysRun = true)

	public void teardown(ITestResult result) throws IOException {
		if (result.getStatus() == result.SUCCESS) {
			logger.log(LogStatus.PASS, result.getName() + " " + "is passed");

		} else if (result.getStatus() == result.FAILURE) {
			// ScreenShot.take_screenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, result.getName() + " " + "is failed" + result.getThrowable());

			String path = ScreenShot.take_screenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, "Snapshot Below:" + logger.addScreenCapture(path));
		} else if (result.getStatus() == result.SKIP) {
			logger.log(LogStatus.SKIP, result.getName() + " " + "is skipped" + result.getThrowable());

		}
		extent.endTest(logger);

	}

	@AfterSuite(alwaysRun = true)
	public void end() {
		// driver.close();
		extent.flush();
		extent.close();

	}

}
