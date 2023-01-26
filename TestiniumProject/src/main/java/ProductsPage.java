import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.List;

public class ProductsPage extends  BasePage {
    By productNameLocator =  By.cssSelector("#productList > div:nth-child(3) > div > div > div.m-productCard__photo > a > div.m-productImageList");
    By AddBasketLocator = By.cssSelector("#addBasket");
    public  ProductsPage(WebDriver driver){
        super(driver);
    }
    public void AddBasket(){
        click(AddBasketLocator);
    }
}
