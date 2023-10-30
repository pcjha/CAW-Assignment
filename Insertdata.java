	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	
public class Insertdata {

	    public static void main(String[] args) {
	        
	    	WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        // Step 1: Open the URL
	        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
          
	        // maximize window
			driver.manage().window().maximize();
			
	        // Step 2: Click on the "Table Data" button
	        driver.findElement(By.xpath("//summary[normalize-space()='Table Data']")).click();


	        // Step 3: Insert the JSON data into the input text box and click "Refresh Table"
	        String jsonData = "[{\"name\":\"Bob\",\"age\":20,\"gender\":\"male\"},{\"name\":\"George\",\"age\":42,\"gender\":\"male\"},{\"name\":\"Sara\",\"age\":42,\"gender\":\"female\"},{\"name\":\"Conor\",\"age\":40,\"gender\":\"male\"},{\"name\":\"Jennifer\",\"age\":42,\"gender\":\"female\"}]";
//	        WebElement inputTextBox = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
//	        inputTextBox.clear();
//	        inputTextBox.sendKeys(jsonData);
            
	        driver.findElement(By.xpath("//textarea[@id='jsondata']")).sendKeys(jsonData);
	        
	        driver.findElement(By.id("refreshtable")).click();
	      

	        // Step 4: Verify if the entered data is populated in the table
	          WebElement table = driver.findElement(By.id("dynamictable"));

	        // Step 5: Retrieve and assert the data from the table
	        String tableText = table.getText();
	        assert tableText.contains("Bob") && tableText.contains("George") && tableText.contains("Sara")
	                && tableText.contains("Conor") && tableText.contains("Jennifer");

	        // Clean up: Close the browser
	        driver.quit();
	    }
	}