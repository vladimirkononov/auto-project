package com.sqa.vk;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class AmazonTest {

	private WebDriver driver;

	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "https://www.amazon.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	@Test
	public void testAmazonTest1() throws Exception {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.id("twotabsearchtextbox")).click();
		this.driver.findElement(By.id("twotabsearchtextbox")).clear();
		this.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mug");
		this.driver.findElement(By.cssSelector("input.nav-input")).click();
		this.driver.findElement(By.xpath("(//img[@alt='Product Details'])[2]")).click();
		this.driver.findElement(By.id("quantity")).click();
		new Select(this.driver.findElement(By.id("quantity"))).selectByVisibleText("2");
		this.driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
		this.driver.findElement(By.id("add-to-cart-button")).click();
		this.driver.findElement(By.xpath("//span/span/span/a")).click();
		this.driver.findElement(By.xpath("//span/span/span/a")).click();
	}
}
