package TestCases;

import Pages.AddressPage;
import Pages.DashBoardPage;
import Utils.BasePage;
import org.testng.annotations.Test;

import java.awt.*;

public class SearchAppleTestCase extends BasePage {
    public SearchAppleTestCase(){
        super();
    }

    @Test
    public void searchAppleShouldBeSuccess() throws InterruptedException, AWTException {
        DashBoardPage addressPage = new DashBoardPage()
                .getpopupDismiss()
                .getaccountBtn()
                .getloginBtn()
                .getemailFld("mdsadikurrahman26@gmail.com")
                .getpasswordFld("sadik3322")
                .getLoginBtn()
                .getsearchBtn();
//                .searchBtn("Apple");
    }
}
