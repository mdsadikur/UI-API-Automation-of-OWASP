package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage {
    public BasketPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkoutButton")
    WebElement checkoutBtn;



    public AddressPage getbasketItems() throws InterruptedException {
       int size = driver.findElements(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row")).size();
        System.out.println("Item size is "+ size);

        if (size>1){
            checkoutBtn.isDisplayed();
            checkoutBtn.click();
        }
        Thread.sleep(2000);
        return new AddressPage();
    }
}
