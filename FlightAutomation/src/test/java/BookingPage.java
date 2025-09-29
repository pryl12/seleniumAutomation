
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class BookingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Example selectors - change per site
    private By passengerNameInput = By.cssSelector("input[name='passengerName'], input#name");
    private By passengerDob = By.cssSelector("input[name='dob'], input#dob");
    private By emailInput = By.cssSelector("input[type='email'], input[name='email']");
    private By phoneInput = By.cssSelector("input[type='tel'], input[name='phone']");
    private By continueToPaymentButton = By.cssSelector("button.continue, button.to-payment, button#continue");

    public void fillPassengerDetails(String name, String dobIso, String email, String phone) {
        WebElement nameEl = wait.until(ExpectedConditions.elementToBeClickable(passengerNameInput));
        nameEl.clear(); nameEl.sendKeys(name);

        try {
            WebElement dobEl = driver.findElement(passengerDob);
            dobEl.clear();
            dobEl.sendKeys(dobIso);
            dobEl.sendKeys(Keys.TAB);
        } catch (NoSuchElementException ignored) {}

        try {
            WebElement emailEl = driver.findElement(emailInput);
            emailEl.clear(); emailEl.sendKeys(email);
        } catch (NoSuchElementException ignored) {}

        try {
            WebElement phoneEl = driver.findElement(phoneInput);
            phoneEl.clear(); phoneEl.sendKeys(phone);
        } catch (NoSuchElementException ignored) {}
    }

    public void proceedToPayment() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueToPaymentButton));
        btn.click();
        // stop here - don't enter payment details
    }
}
