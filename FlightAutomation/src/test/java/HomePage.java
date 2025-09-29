import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Update selectors below to match the target website
    private By originInput = By.cssSelector("input#origin, input[name='origin'], input[placeholder*='From']"); // generic
    private By destinationInput = By.cssSelector("input#destination, input[name='destination'], input[placeholder*='To']");
    private By datePickerOpen = By.cssSelector("input[name='departure'], input[placeholder*='Depart']");
    private By datePickerDayTemplate = By.xpath("//button[contains(@aria-label, '%s') or text()='%s']"); // format with date string
    private By searchButton = By.cssSelector("button[type='submit'], button.search-button, button#search");

    public void open(String url) {
        driver.get(url);
    }

    public void enterOrigin(String origin) {
        WebElement originEl = wait.until(ExpectedConditions.elementToBeClickable(originInput));
        originEl.clear();
        originEl.sendKeys(origin);
        // some sites show suggestions - press Enter or select first suggestion
        originEl.sendKeys(Keys.ENTER);
    }

    public void enterDestination(String dest) {
        WebElement destEl = wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
        destEl.clear();
        destEl.sendKeys(dest);
        destEl.sendKeys(Keys.ENTER);
    }

    /**
     * Pick a date string in format like "2025-10-15" or adapt to site's datepicker label expectations.
     * Many date pickers accept clicking a calendar cell; you will need to adapt the locator.
     */
    public void selectDepartureDate(String dateIso) {
        WebElement dateOpen = wait.until(ExpectedConditions.elementToBeClickable(datePickerOpen));
        dateOpen.click();
        // attempt to click a button that contains the date
        String dayLocator = String.format("//button[contains(@data-date, '%s') or contains(@aria-label, '%s') or text()='%s']",
                dateIso, dateIso, dateIso);
        try {
            WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayLocator)));
            day.click();
        } catch (TimeoutException e) {
            // fallback: send date as text if input allows typing
            dateOpen.sendKeys(dateIso);
            dateOpen.sendKeys(Keys.ENTER);
        }
    }

    public void clickSearch() {
        WebElement sb = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        sb.click();
    }
}

