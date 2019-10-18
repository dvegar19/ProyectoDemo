package com.ProyectoDemo;

import org.testng.annotations.Test;

import bsh.Capabilities;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PruebaEjemplo {
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		String nodeURL = "http://192.168.30.108:4444/wd/hub";
		DesiredCapabilities capChrome = new DesiredCapabilities().chrome();
		driver = new RemoteWebDriver(new URL(nodeURL), capChrome);
		driver.navigate().to("http://200.111.183.147:8095/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void PruebaZalenium() throws InterruptedException {
		Thread.sleep(5000);
		//Se ingresan credenciales en formulario Login
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		Thread.sleep(2000);
		//Se hace click en boton Sign In
		driver.findElement(By.xpath("//input[@class='btn btn-lg btn-danger btn-block']")).click();
		//Se captura texto de mensaje
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		//Se valida mensaje desplegado
		AssertJUnit.assertEquals(texto, "Username o Password Incorrecto");
		
	}
  
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	/*
	 	@BeforeTest
		public void beforeTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to("http://200.111.183.147:8095/login");
		}
	 
	  */
	

}
