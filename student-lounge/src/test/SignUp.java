package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://ec2-18-223-184-253.us-east-2.compute.amazonaws.com:8080/student-lounge/index.html");
    driver.findElement(By.linkText("Sign up")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@gmail.com");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test");
    driver.findElement(By.name("firtsname")).clear();
    driver.findElement(By.name("firtsname")).sendKeys("test");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("one");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Test@1234");
    driver.findElement(By.name("repassword")).clear();
    driver.findElement(By.name("repassword")).sendKeys("Test@1234");
    driver.findElement(By.name("signup")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.linkText("Sign up")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("testing1@email.com");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("testing1");
    driver.findElement(By.name("firtsname")).clear();
    driver.findElement(By.name("firtsname")).sendKeys("test");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("one");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Test@1234");
    driver.findElement(By.name("repassword")).clear();
    driver.findElement(By.name("repassword")).sendKeys("Test@1234");
    driver.findElement(By.name("signup")).click();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("testing1@email.com");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("Test@1234");
    driver.findElement(By.name("login")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

