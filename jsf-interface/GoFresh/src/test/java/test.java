
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--headless");
        driver = new ChromeDriver(op);
        //driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogIn() throws Exception {

        driver.get("http://localhost:8080/GoFresh/signIn.xhtml");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("j_idt6")).submit();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("veggie");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("arroz");
        driver.findElement(By.name("loginButton")).click();

        assertEquals("Procurar", driver.findElement(By.id("j_idt7:asd")).getAttribute("value"));
    }

    @Test
    public void testFailedLogIn() throws Exception {

        driver.get("http://localhost:8080/GoFresh/signIn.xhtml");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("NotRegistered");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.name("loginButton")).click();
        assertEquals("Username or password not valid!", driver.findElement(By.xpath("//form[@id='j_idt6']/span")).getText());

    }
    @Ignore
    @Test
    public void testCart() throws Exception {
        driver.get("http://localhost:8080/GoFresh/index.xhtml");
        driver.findElement(By.linkText("Cart")).click();
        System.out.println(driver.findElement(By.xpath("//h5")).getText());
        System.out.println("asdas");
        System.out.println(driver.findElement(By.linkText("Cart")).getAttribute("class"));
        assertEquals("PRODUCT", driver.findElement(By.xpath("//th[3]")).getText());
    }
    @Ignore
    @Test
    public void testProfile() throws Exception {
        driver.get("http://localhost:8080/GoFresh/index.xhtml");
        driver.findElement(By.linkText("Profile")).click();
        assertTrue(driver.findElement(By.linkText("Delete Account")).isDisplayed());
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
