package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class DashBoardPage extends BasePage {
    public DashBoardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Dismiss']")
    WebElement popupalartDismiss;

    @FindBy(xpath = "//span[normalize-space()='Account']")
    WebElement accountBtn;

    @FindBy(id = "navbarLoginButton")
    WebElement loginBtn;

    @FindBy(xpath = "(//span[contains(text(),'Add to Basket')])[1]")
    WebElement addToBasket;

    @FindBy(xpath = "//span[normalize-space()='Your Basket']")
    WebElement yourBasketBtn;

    @FindBy(xpath = "//mat-icon[normalize-space()='search']")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchFld;

    public DashBoardPage getpopupDismiss() {
        if (popupalartDismiss.isDisplayed())
            popupalartDismiss.click();
        return this;
    }

    public DashBoardPage getaccountBtn() {
        accountBtn.isDisplayed();
        accountBtn.click();
        return this;
    }

    public LoginPage getloginBtn() {
        loginBtn.isDisplayed();
        loginBtn.click();
        return new LoginPage();
    }

    public DashBoardPage getaddToBasket() {
        addToBasket.isDisplayed();
        addToBasket.click();
        return this;
    }

    public BasketPage getyourBasketBtn() {
        yourBasketBtn.isDisplayed();
        yourBasketBtn.click();
        return new BasketPage();
    }

 /*   public DashBoardPage searchBtn(String inputsearchFld) throws InterruptedException, AWTException {
        if (searchBtn.isDisplayed() && searchBtn.isEnabled()) {
            searchBtn.click();
            System.out.println("Search button is present and clickable.");
        } else {
            System.out.println("Search button is not clickable.");
        }
        Thread.sleep(2000);

        searchFld(inputsearchFld);
        return this;
    }

    public void searchFld(String inputsearchFld) throws AWTException, InterruptedException {
        searchFld.sendKeys(inputsearchFld);
        Robot rb= new Robot();
        rb.delay(2000);

        // enter key
        rb.keyPress(KeyEvent.VK_ENTER);// press on enter key
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

    }*/

    public DashBoardPage getsearchBtn() {
        try {
            // Verify the search button
            WebElement searchButton = driver.findElement(
                    By.xpath("//mat-icon[normalize-space()='search']")); // Adjust selector as needed
            if (searchButton.isDisplayed() && searchButton.isEnabled()) {
                System.out.println("Search button is present and clickable.");
                searchBtn.click();
            } else {
                System.out.println("Search button is not clickable.");
            }

            // Perform the search
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']")); // Adjust selector as needed
            searchBox.sendKeys("apple");
            Robot rb= new Robot();
            rb.delay(2000);

            // enter key
            rb.keyPress(KeyEvent.VK_ENTER);// press on enter key
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);

            // Verify search results
            List<WebElement> results = driver.findElements(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile")); // Adjust selector as needed
            System.out.println("Search results count: " + results.size());
            int appleCount = 0;
            boolean bananaFound = false;
            for (WebElement result : results) {
                String productName = result.getText().toLowerCase();
                if (productName.contains("apple")) {
                    appleCount++;
                }
                if (productName.contains("banana")) {
                    bananaFound = true;
                }
            }

            // Validate the results
            if (appleCount == 2) {
                System.out.println("Exactly 2 apple products found.");
            } else {
                System.out.println("Expected 2 apple products, but found " + appleCount);
            }

            if (!bananaFound) {
                System.out.println("No banana products found.");
            } else {
                System.out.println("Banana product found in the search results.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}
