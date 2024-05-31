package Pages;

import Utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    WebElement emailFld;

    @FindBy(name = "password")
    WebElement passwordFld;

    @FindBy(id = "loginButton")
    WebElement loginBtn;

    public LoginPage getemailFld(String inputemailFld){
        emailFld.isDisplayed();
        emailFld.sendKeys(inputemailFld);
        return this;
    }

    public LoginPage getpasswordFld(String inputpasswordFld){
        passwordFld.isDisplayed();
        passwordFld.sendKeys(inputpasswordFld);
        return this;
    }

    public DashBoardPage getLoginBtn() throws InterruptedException {
        loginBtn.isDisplayed();
        loginBtn.click();
        Thread.sleep(2000);
        return new DashBoardPage();
    }
}
