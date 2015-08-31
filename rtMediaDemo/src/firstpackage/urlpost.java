
/* ***Upload image in media by URL*** */


package firstpackage;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class urlpost {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://demo.rtcamp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testurlpost() throws Exception {
    driver.get(baseUrl + "/rtmedia/");
    driver.findElement(By.id("bp-login-widget-user-login")).clear();
    driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("demo");
    driver.findElement(By.id("bp-login-widget-user-pass")).clear();
    driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("demo");
    driver.findElement(By.id("bp-login-widget-submit")).click();
    driver.findElement(By.linkText("Howdy, Demo")).click();
    driver.findElement(By.id("user-media")).click();
    driver.findElement(By.id("rtm_show_upload_ui")).click();
    driver.findElement(By.cssSelector("li.rtm-url-import-tab")).click();
    driver.findElement(By.id("rtmedia_url_upload_input")).sendKeys("https://s.w.org/about/images/logos/wordpress-logo-notext-rgb.png");
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("input.start-media-upload")).click();
    driver.findElement(By.linkText("Activity")).click();
    driver.findElement(By.linkText("Log Out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
