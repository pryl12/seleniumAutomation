
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class SearchResultsPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public SearchResultsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        // Update selectors: these are generic
        private By flightResultRow = By.cssSelector(".flight-result, .flight-row, .result-item");
        private By selectButtonWithinRow = By.cssSelector("button.select, button.book, .select-flight");

        /**
         * Select the first available flight result
         */
        public void selectFirstAvailableFlight() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(flightResultRow));
            WebElement first = driver.findElements(flightResultRow).get(0);
            // try find a select/book button inside it
            try {
                WebElement btn = first.findElement(selectButtonWithinRow);
                wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
            } catch (NoSuchElementException e) {
                // fallback: click the row itself
                first.click();
            }
        }
    }

