
/* ***Login with invalid username and valid password*** */

package firstpackage;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class loginclass {
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
  public void testlogin() throws Exception {
    driver.get(baseUrl + "/rtmedia/");
    driver.findElement(By.id("bp-login-widget-user-login")).clear();
    driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("demo");
    driver.findElement(By.id("bp-login-widget-user-pass")).clear();
    driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("demo");
    driver.findElement(By.id("bp-login-widget-submit")).click();
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
