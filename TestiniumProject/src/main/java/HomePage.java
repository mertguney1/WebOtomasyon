import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class HomePage extends BasePage {

    ProductsDetailPage productsDetailPage;
    SearchBox searchBox;
    By dashboardControl = new By.ByCssSelector("swiper-button-next");
    By CookiesLocator = By.id("onetrust-accept-btn-handler");
    By AlertLocator = By.id("genderManButton");
    public HomePage(WebDriver driver){
        super(driver);
        searchBox  = new SearchBox(driver);
    }
    public  void  CookiesClose(){
        click(CookiesLocator);
    }
    public  void AlertClose(){
        click(AlertLocator);
    }

    public SearchBox searchBox() {
        return  this.searchBox;
    }
    public boolean isProductPriceControl(){
        boolean isPriceEqual = true;
        int price = productsDetailPage.GetProductPrice();
        int priceDetail = productsDetailPage.GetProductDetailPrice();
        if(price != priceDetail ){
            isPriceEqual  = false;
        }
        return isPriceEqual;
    }


}
