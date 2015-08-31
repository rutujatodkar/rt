
/* ***Check the process of post updating with media*** */

package firstpackage;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class publicpost {
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
	  public void testpublicpost() throws Exception {
	    driver.get(baseUrl + "/rtmedia/");
	    driver.findElement(By.id("bp-login-widget-user-login")).clear();
	    driver.findElement(By.id("bp-login-widget-user-login")).sendKeys("demo");
	    driver.findElement(By.id("bp-login-widget-user-pass")).clear();
	    driver.findElement(By.id("bp-login-widget-user-pass")).sendKeys("demo");
	    driver.findElement(By.id("bp-login-widget-submit")).click();
	    driver.findElement(By.id("whats-new")).clear();
	    driver.findElement(By.id("whats-new")).sendKeys("Demo Test");
	    driver.findElement(By.id("rtmedia-add-media-button-post-update")).click();

	    Thread.sleep(5000);
	   
	    // Set the image name in clipboard 
	    StringSelection ss=new StringSelection("E:\\Newfolder(2)\\Newfolder\\image1.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    
	    // Perform keystrokes for CTRL+V and ENTER key
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyPress(KeyEvent.VK_ENTER);	    
	    
	    driver.findElement(By.id("aw-whats-new-submit")).click();
	    robot.keyPress(KeyEvent.VK_ENTER);	  
	    robot.keyPress(KeyEvent.VK_CONTROL);
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
