import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    @Test
    public void bookMumbaiToDubai() throws InterruptedException {
        String url = "https://demo-travel-website.example"; // change to actual site
        String origin = "Mumbai";
        String destination = "Dubai";
        String departDate = "2025-10-15"; // use YYYY-MM-DD or adapt to site's expected format
        String passengerName = "Priyal Patil";
        String passengerDob = "1995-01-01";
        String email = "test@example.com";
        String phone = "9999999999";

        HomePage home = new HomePage(driver);
        home.open(url);

        // Enter origin/destination
        home.enterOrigin(origin);
        home.enterDestination(destination);

        // Choose date and search
        home.selectDepartureDate(departDate);
        home.clickSearch();

        // Select flight from results
        SearchResultsPage results = new SearchResultsPage(driver);
        results.selectFirstAvailableFlight();

        // Fill booking form (do not complete payment)
        BookingPage booking = new BookingPage(driver);
        booking.fillPassengerDetails(passengerName, passengerDob, email, phone);

        // Stop before payment; click proceed to reach payment screen
        // If you don't want to click, comment next line
        booking.proceedToPayment();

        // Add an assertion or wait to verify you've reached payment page
        // e.g., assert current URL contains "payment" or check for a payment form element
        Thread.sleep(3000); // small pause for demo - replace with proper asserts
    }
}
