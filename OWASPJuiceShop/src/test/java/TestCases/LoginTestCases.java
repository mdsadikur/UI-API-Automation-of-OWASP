package TestCases;

import Pages.DashBoardPage;
import Pages.LoginPage;
import Utils.BasePage;
import org.testng.annotations.Test;

public class LoginTestCases extends BasePage {
    public LoginTestCases(){
        super();
    }

    @Test
    public void loginShouldbeSuccess() throws InterruptedException {
        DashBoardPage loginPage = new DashBoardPage()
                .getpopupDismiss()
                .getaccountBtn()
                .getloginBtn()
                .getemailFld("mdsadikurrahman26@gmail.com")
                .getpasswordFld("sadik3322")
                .getLoginBtn();

    }
}
