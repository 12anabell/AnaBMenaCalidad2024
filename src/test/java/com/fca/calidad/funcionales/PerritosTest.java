package com.fca.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class PerritosTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
  /* driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://www.google.com/search?q=perro&rlz=1C1GCEU_esMX1123MX1123&oq=perro&gs_lcrp=EgZjaHJvbWUqDQgAEAAY4wIYsQMYgAQyDQgAEAAY4wIYsQMYgAQyCggBEC4YsQMYgAQyCggCEC4YsQMYgAQyCggDEC4YsQMYgAQyBwgEEAAYgAQyBwgFEAAYgAQyCggGEC4YsQMYgAQyCggHEC4YsQMYgAQyCggIEC4YsQMYgAQyCggJEC4YsQMYgATSAQgxMDcxajBqN6gCALACAA&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.id("APjFqb")).click();
    driver.get("https://www.google.com/search?q=perro+wikipedia&sca_esv=a257fc97035ed9c3&rlz=1C1GCEU_esMX1123MX1123&sxsrf=ADLYWIIEn0m28ux1YLK8Lr59WRO0r4sWfg%3A1733185165009&ei=jU5OZ80VkOXA3g_XiJSRDg&oq=perro+wiki&gs_lp=Egxnd3Mtd2l6LXNlcnAiCnBlcnJvIHdpa2kqAggAMgUQABiABDIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHkiqG1AVWPoQcAF4AZABAJgBeaABwwSqAQMwLjW4AQPIAQD4AQGYAgagAuYEwgIKEAAYsAMY1gQYR8ICDRAAGIAEGLADGEMYigXCAg4QABiwAxjkAhjWBNgBAcICExAuGIAEGLADGEMYyAMYigXYAQHCAhYQLhiABBiwAxhDGNQCGMgDGIoF2AEBwgINEAAYgAQYsQMYQxiKBcICChAAGIAEGEMYigXCAg0QLhiABBixAxhDGIoFwgIIEC4YgAQYsQPCAgUQLhiABMICFBAuGIAEGJcFGNwEGN4EGN8E2AEBwgIHEC4YgAQYCpgDAIgGAZAGEroGBggBEAEYCZIHAzEuNaAHoWg&sclient=gws-wiz-serp");
    driver.findElement(By.id("APjFqb")).clear();
    driver.findElement(By.id("APjFqb")).sendKeys("perro wikipedia");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/div/div/div/div/div/span/a/h3")).click();*/
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://es.wikipedia.org/wiki/Canis_familiaris");
    //Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Wikipedia[\\s\\S]*$"));
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
