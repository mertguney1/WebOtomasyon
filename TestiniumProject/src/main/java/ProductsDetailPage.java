import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailPage extends BasePage {
    public  ProductsDetailPage(WebDriver driver){
        super(driver);
    }
    By addInsertProductButtonLocator = By.id("addBasket");
    By addInsertProductSize  = By.cssSelector("#sizes > div > span:nth-child(2)");
    By ProductPrice = By.cssSelector("m-productCard__newPrice");
    By ProducDetailtPrice = By.id("priceNew");
    By goToBasketLocator = By.cssSelector("div > button.m-notification__button.btn");
    By deleteProductLocator = By.id("removeCartItemBtn0-key-0");

    public void InsertProduct() {
        click(addInsertProductButtonLocator);
    }
    public void InsertSize(){
        click(addInsertProductSize);
    }
    public void GoToBasket(){
        click(goToBasketLocator);
    }
    public int GetProductPrice(){
    String price = find(ProductPrice).getText();
    return Integer.parseInt(price);
    }
    public int GetProductDetailPrice(){
        String priceDetail = find(ProducDetailtPrice).getText();
        return Integer.parseInt(priceDetail);
    }
    public void DeleteProductInBasket(){
        click(deleteProductLocator);
    }
}
