import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void bookFlights() {
        driver.get("https://www.ixigo.com/?utm_source=Google_Search&utm_medium=paid_search_google&utm_campaign=Generic_Search_Feb23_NewUser&utm_source=Google_Search&utm_medium=paid_search_google&utm_campaign=Generic_Search_Feb23_NewUserGGL&gad_source=1&gad_campaignid=19655732088&gbraid=0AAAAAC5edWDKmpAKQchB_PScHvF2aJlnT&gclid=Cj0KCQjwss3DBhC3ARIsALdgYxOFQgxb1sQhzD8_A8Ndomx2YAAjXfmqa7jayw9UAV1Gm7amO6sv7i4aAjAJEALw_wcB");
        // Click on the dropdown input to open the dropdown list
        String dropdownInputXpath = "//div[@class='flex-1 h-full flex flex-col justify-center px-15 py-10 ']";
        WebElement dropdownInput = driver.findElement(By.xpath(dropdownInputXpath));
        dropdownInput.click();

        // Wait for the dropdown options to be visible (simple sleep for demo, use WebDriverWait in real tests)
        try { Thread.sleep(1000); } catch (InterruptedException e) { }

        // Select the value from the dropdown list by visible text using 'contains(text(), ... )'
        String optionXpath = "//p[contains(text(), 'Chatrapati Shivaji International Airport')]";
        WebElement option = driver.findElement(By.xpath(optionXpath));
        option.click();

        String dropdown_ToDateInputXpath = "//p[@class='body-lg max-w-[190px] truncate text-primary font-medium font-medium']";
        WebElement dropdownInput_Destination = driver.findElement(By.xpath(dropdown_ToDateInputXpath));
        dropdownInput_Destination.click();

        try { Thread.sleep(1000); } catch (InterruptedException e) { }

        String optionXpath_destination = "//p[contains(text(), 'Chennai International Airport')]";
        WebElement destination = driver.findElement(By.xpath(optionXpath_destination));
        destination.click();
        //assertTrue(driver.getTitle().contains("Selenium") || driver.getPageSource().toLowerCase().contains("selenium"));
    }


}
