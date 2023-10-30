package Cawassement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Assement {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	@Test
	public void assement() {
			        // Set the path to your ChromeDriver executable
			       WebDriverManager.chromedriver().setup();
			        
			        // Create a new instance of the ChromeDriver
			        WebDriver driver = new ChromeDriver();
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			        
			        // Navigate to the URL
			        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

			        driver.manage().window().maximize();
			     
		            // Click on the "Table Data" button
		            WebElement tableDataButton = driver.findElement(By.xpath("//summary[normalize-space()='Table Data']"));
		            tableDataButton.click();

		            // Find the input text box and input the JSON data
		            WebElement dataInput = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
		            
		            // define object for json data
		            String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
		                             "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
		                             "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
		                             "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
		                             "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
		            
		            
		            // Clear the json data field
		            dataInput.clear();
		            
		            // Insert the Json data
		            dataInput.sendKeys(jsonData);

		            // Click the "Refresh Table" button
		            WebElement refreshButton = driver.findElement(By.xpath("//button[@id='refreshtable']"));
		            refreshButton.click();

		            // Verify the data in the table
		            WebElement table = driver.findElement(By.xpath("//table[@id='dynamictable']"));
		            String tableText = table.getText();
		            
		            //Print the table text
		            System.out.println(tableText);
		
		            //Assert the table data 
		            assert tableText.contains("Bob") && tableText.contains("20") && tableText.contains("male") && tableText.contains("George") && tableText.contains("Sara")
	                   && tableText.contains("Conor") && tableText.contains("Jennifer")&& tableText.contains("female")&& tableText.contains("42")&& tableText.contains("40");
                            // close the driver
		            driver.quit();		            
			        	
}
}		        



