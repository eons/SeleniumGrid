package Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SE_Grid_Chrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("test-type");
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		
		cap.setCapability("chrome.binary", "C:\\Drivers\\chromedriver.exe");
		cap.setVersion("88.0");
		//cap.setPlatform(Platform.WIN10);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new RemoteWebDriver(new URL("http://192.168.1.70:4444/wd/hub"),cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		
		driver.findElement(By.name("search_query")).sendKeys("Alvaro845");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-shelf-renderer[1]/div[1]/div[2]/ytd-vertical-list-renderer/div[1]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string")).click();
		
		Thread.sleep(2000);
		driver.close();

	}

}
