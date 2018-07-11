/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionalTests;

/**
 *
 * @author carlos
 */

import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/carlos/NetBeansProjects/TQS-WORK/jsf-interface/GoFresh/src/main/resources/Drivers/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

  
  @Test
  public void testLogIn() throws Exception {
    driver.get("http://localhost:8080/GoFresh/signIn.xhtml");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("veggie");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("arroz");
    driver.findElement(By.name("j_idt12")).click();
    
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_idt7:j_idt11")));
    assertTrue(driver.findElement(By.name("j_idt7:j_idt11")).isDisplayed());
  }

  @Test
  public void testLoginFailure() throws Exception {
    driver.get("http://localhost:8080/GoFresh/signIn.xhtml");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("NotRegistered");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.name("j_idt12")).click();
    assertEquals("Username or password not valid!", driver.findElement(By.xpath("//form[@id='j_idt6']/span")).getText());
  }
  
   
  @Test
  public void testCart() throws Exception {
    driver.get("http://localhost:8080/GoFresh/index.xhtml");
    driver.findElement(By.linkText("Cart")).click();
    assertEquals("Cart Totals", driver.findElement(By.xpath("//h5")).getText());
  }
  
  @Test
  public void testProfile() throws Exception {
    driver.get("http://localhost:8080/GoFresh/index.xhtml");
    driver.findElement(By.linkText("Profile")).click();
    assertTrue(driver.findElement(By.linkText("Delete Account")).isDisplayed());
  }
  
   @Ignore
   @Test
  public void testCartAddProduct() throws Exception {
    driver.get("http://localhost:8080/GoFresh/cart.xhtml");
    driver.findElement(By.xpath("//button[2]")).click();
    assertEquals("2", driver.findElement(By.name("num-product1")).getAttribute("value"));
  }
  
    @Test
  public void testHomeFilter() throws Exception {
    driver.get("http://localhost:8080/GoFresh/index.xhtml");
    driver.findElement(By.name("categoria:j_idt14")).click();
    assertThat("batata", is(not(driver.findElement(By.name("j_idt42:j_idt43")).getText())));
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
    } catch (Exception e) {
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


