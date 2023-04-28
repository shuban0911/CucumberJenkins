package steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
	
	WebDriver driver;
	
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		System.out.println("in LoginStepDefinitions");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
	}
	
	
	@Given("User is on the page {string}")
	public void user_is_on_the_page(String string) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		//throw new Exception();
	}
	
	@When("User enters user and pass")
	public void user_enters_user_and_pass(io.cucumber.datatable.DataTable dataTable) throws Exception {
	  List<Map<String, String>> credentials = dataTable.asMaps();
	  System.out.println(credentials.get(0).get("username"));
	  System.out.println(credentials.get(0).get("password"));
	  driver.findElement(By.id("username")).sendKeys(credentials.get(0).get("username"));
	  driver.findElement(By.id("password")).sendKeys(credentials.get(0).get("password"));


		throw new Exception();
	}
	
	
	@Then("User enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("in LoginStepDefinitions");
		driver.findElement(By.id("username")).sendKeys("oct2022@abcd.com");
		driver.findElement(By.id("password")).sendKeys("shuban0911");
	}
	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		System.out.println("in LoginStepDefinitions");
		driver.findElement(By.id("Login")).click();
		
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf("table")));
	}
	
	@Then("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		
		System.out.println("in LoginStepDefinitions with inputs");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@Then("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		
		System.out.println("in LoginStepDefinitions with inputs scenario outline");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@Then("User enters logindetails")
	public void user_enters_logindetails(DataTable dataTable) {
		 List<List<String>> rows = dataTable.asLists();
		 List<String> row = dataTable.row(0);
		    	
		    	//System.out.println("in LoginStepDefinitions with datatable" + rows.get(0)+" : "+rows.get(1));
				driver.findElement(By.id("username")).sendKeys(rows.get(0).get(0));
				driver.findElement(By.id("password")).sendKeys(rows.get(0).get(1));
		    
	}
	
	@After
	public void teardown(Scenario scenario) {
		TakesScreenshot takesScreenshot	= (TakesScreenshot)driver;
		byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png", scenario.getName());
		
	}

}
