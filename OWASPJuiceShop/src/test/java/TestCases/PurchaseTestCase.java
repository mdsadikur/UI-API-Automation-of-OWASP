package TestCases;

import Pages.AddressPage;
import Pages.DashBoardPage;
import Utils.BasePage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

public class PurchaseTestCase extends BasePage {
    public PurchaseTestCase(){
        super();
    }

    @Test
    public void purchaseShouldbeSuccess() throws InterruptedException {
        AddressPage addressPage = new DashBoardPage()
                .getpopupDismiss()
                .getaccountBtn()
                .getloginBtn()
                .getemailFld("mdsadikurrahman26@gmail.com")
                .getpasswordFld("sadik3322")
                .getLoginBtn()
                .getaddToBasket()
                .getyourBasketBtn()
                .getbasketItems()
//                .getselectAddress()
                .getaddAddressBtn()
                .getcountryName(LoremIpsum.getInstance().getCountry())
                .getnameFld(LoremIpsum.getInstance().getName())
                .getphoneNumberFld("3453453453")
                .getzipCodeFLd(LoremIpsum.getInstance().getZipCode())
                .getaddressFld(LoremIpsum.getInstance().getStateFull())
                .getcityFld(LoremIpsum.getInstance().getCity())
                .getstateFld(LoremIpsum.getInstance().getStateFull())
                .getaddressSubmitBtn();
    }
}
