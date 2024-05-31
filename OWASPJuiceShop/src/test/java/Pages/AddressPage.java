package Pages;

import Utils.BasePage;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BasePage {
    public AddressPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='Add New Address']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a country.\"]")
    WebElement countryName;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a name.\"]")
    WebElement nameFld;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a mobile number.\"]")
    WebElement phoneNumberFld;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a ZIP code.\"]")
    WebElement zipCodeFLd;

    @FindBy(xpath = "//textarea[@placeholder=\"Please provide an address.\"]")
    WebElement addressFld;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a city.\"]")
    WebElement cityFld;

    @FindBy(xpath = "//input[@placeholder=\"Please provide a state.\"]")
    WebElement stateFld;

    @FindBy(id = "submitButton")
    WebElement addressSubmitBtn;

    @FindBy(xpath = "//label[@for='mat-radio-43-input']//span[@class='mat-radio-outer-circle']")
    WebElement selectAddress;

    @FindBy(xpath = "//span[normalize-space()='Continue']")
    WebElement continueBtn;

    public AddressPage getselectAddress() throws InterruptedException {
        int size = driver.findElements(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-address-select/div/app-address/mat-card/mat-table/mat-row")).size();
        if(size>1){
            driver.findElement(By.xpath("(//span[@class='mat-radio-outer-circle'])[1]")).click();
            continueBtn.click();
            Thread.sleep(2000);
        }
        return this;
    }

    public AddressPage getaddAddressBtn(){
        addAddressBtn.isDisplayed();
        addAddressBtn.click();
        return this;
    }

    public AddressPage getcountryName(String inputcountryName) throws InterruptedException {
        countryName.isDisplayed();
        countryName.sendKeys(inputcountryName);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getnameFld(String inputnameFld) throws InterruptedException {
        nameFld.isDisplayed();
        nameFld.sendKeys(inputnameFld);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getphoneNumberFld(String inputphoneNumberFld) throws InterruptedException {
        phoneNumberFld.isDisplayed();
        phoneNumberFld.sendKeys(inputphoneNumberFld);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getzipCodeFLd(String inputzipCodeFLd) throws InterruptedException {
        zipCodeFLd.isDisplayed();
        zipCodeFLd.sendKeys(inputzipCodeFLd);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getaddressFld(String inputaddressFld) throws InterruptedException {
        addressFld.isDisplayed();
        addressFld.sendKeys(inputaddressFld);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getcityFld(String inputcityFld) throws InterruptedException {
        cityFld.isDisplayed();
        cityFld.sendKeys(inputcityFld);
        Thread.sleep(1000);
        return this;
    }

    public AddressPage getstateFld(String inputstateFld) throws InterruptedException {
        stateFld.isDisplayed();
        stateFld.sendKeys(inputstateFld);
        Thread.sleep(2000);
        return this;
    }

    public AddressPage getaddressSubmitBtn() throws InterruptedException {
        addressSubmitBtn.isDisplayed();
        addressSubmitBtn.click();
        Thread.sleep(2000);
        return this;
    }
}
