package org.test;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class BrowserLaunch {

	public static void main(String[] args)throws AWTException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe" );
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		WebElement dndcars = driver.findElement(By.id("cars"));
		Select s=new Select(dndcars);
		boolean multiple = s.isMultiple();
		List<WebElement> options = s.getOptions();
		int size = options.size();
		
		if(multiple==false)
		{
			for(int i=0;i<size;i++) {
				s.selectByIndex(i);
				
			}
		}
	for(int i=0;i<size;i=i+2) {
			s.selectByIndex(i);
			
		}
		
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement eachselected: allSelectedOptions) {
			
			String text = eachselected.getText();
			System.out.println(text);
		}
		
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
		
		if (multiple==false) {
			for(WebElement eachoption:options) {
				String data = eachoption.getText();
				s.selectByVisibleText(data);
				
			}
		}
		for(WebElement eachoption:options) {
			String attribute = eachoption.getAttribute("value");
			s.selectByValue(attribute);
			
		}
		s.deselectAll();
	}
	
}
