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

public class WebTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohdk\\Downloads\\chrome\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://ec2-18-223-184-253.us-east-2.compute.amazonaws.com:8080/student-lounge/index.html");
//    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.linkText("Sign up")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test@test.com");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test");
    driver.findElement(By.name("firtsname")).clear();
    driver.findElement(By.name("firtsname")).sendKeys("test");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("test");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Test@1234");
    driver.findElement(By.name("repassword")).clear();
    driver.findElement(By.name("repassword")).sendKeys("Test@1234");
    driver.findElement(By.name("signup")).click();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("test@test.com");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("Test@1234");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.linkText("Settings")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Test@1234");
    driver.findElement(By.name("confirm")).clear();
    driver.findElement(By.name("confirm")).sendKeys("Test@1234");
    driver.findElement(By.name("changePassword")).click();
    driver.findElement(By.linkText("Settings")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test1@test.com");
    driver.findElement(By.name("changeEmail")).click();
    driver.findElement(By.linkText("Settings")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test1");
    driver.findElement(By.name("changeUserName")).click();
    driver.findElement(By.linkText("Settings")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test1234");
    driver.findElement(By.name("changeUserName")).click();
    driver.findElement(By.linkText("Profile Info")).click();
    driver.findElement(By.linkText("Manage Books")).click();
    driver.findElement(By.linkText("Add Book")).click();
    driver.findElement(By.name("AUTHOR")).click();
    driver.findElement(By.name("AUTHOR")).clear();
    driver.findElement(By.name("AUTHOR")).sendKeys("J.K Rowling");
    driver.findElement(By.xpath("//div[@id='addBookModal']/div/div/div[2]")).click();
    driver.findElement(By.name("AUTHOR")).clear();
    driver.findElement(By.name("AUTHOR")).sendKeys("12");
    driver.findElement(By.name("TITLE")).click();
    driver.findElement(By.name("TITLE")).clear();
    driver.findElement(By.name("TITLE")).sendKeys("2");
    driver.findElement(By.name("ISBN")).click();
    driver.findElement(By.name("ISBN")).clear();
    driver.findElement(By.name("ISBN")).sendKeys("222");
    driver.findElement(By.name("MAJOR")).click();
    driver.findElement(By.name("MAJOR")).clear();
    driver.findElement(By.name("MAJOR")).sendKeys("1212");
    driver.findElement(By.name("CLASS")).click();
    driver.findElement(By.name("CLASS")).clear();
    driver.findElement(By.name("CLASS")).sendKeys("3445");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Manage Books")).click();
    driver.findElement(By.linkText("Edit Book")).click();
    driver.findElement(By.id("EditModal")).click();
    driver.findElement(By.xpath("//div[@id='book']/div/form/div/input")).clear();
    driver.findElement(By.xpath("//div[@id='book']/div/form/div/input")).sendKeys("test(c)");
    driver.findElement(By.name("id")).click();
    acceptNextAlert = true;
    driver.findElement(By.linkText("Manage Books")).click();
    driver.findElement(By.linkText("Delete")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete this book[\\s\\S]$"));
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Explore")).click();
    driver.findElement(By.id("keyword")).click();
    driver.findElement(By.id("keyword")).clear();
    driver.findElement(By.id("keyword")).sendKeys("data");
    driver.findElement(By.id("keyword")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//button[@onclick='getAllBooks()']")).click();
    driver.findElement(By.xpath("//body[@id='top']/div[2]")).click();
    driver.findElement(By.linkText("Log in")).click();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.xpath("//html")).click();
    driver.findElement(By.linkText("Forgot password?")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("mohdkiller2000@gmail");
    driver.findElement(By.name("email")).sendKeys(Keys.ENTER);
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("alharrsiali@gmail.com");
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
