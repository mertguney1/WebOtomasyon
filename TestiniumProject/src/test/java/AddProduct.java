import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AddProduct extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductsDetailPage productsDetailPage;

    @Test
    @Order(1)
    public void OpenDashboard(){
        homePage = new HomePage(driver);
        homePage.CookiesClose();
        homePage.AlertClose();
    }
    @Test
    @Order(2)
    public void SearchProduct() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("body > header > div > div > div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > div > div > input"));
        element.sendKeys("sort");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';",element);
        homePage.searchBox().search("Gömlek");
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Test
    @Order(3)
    public void SelectProduct() throws InterruptedException {
        productsDetailPage = new ProductsDetailPage(driver);
        WebElement element = driver.findElement(By.cssSelector("#productList > div:nth-child(2) > div > div > div.m-productCard__photo > a > div.m-productImageList"));
        element.click();

        // Product ile ilgili bilgi tutar yaz text'e
    }
    @Test
    @Order(4)
    public void InsertBasketProduct() throws InterruptedException {
        productsDetailPage.InsertSize();
        productsDetailPage.InsertProduct();
        Thread.sleep(1000);
        productsDetailPage.GoToBasket();
        Assertions.assertTrue(driver.findElement(By.cssSelector("body > div.wrapper > div.container.m-basket > div > div > div.col-12.col-md-12.col-lg-8 > div.m-basket__body > div.m-basket__item > div:nth-child(2) > div > div.m-basket__productTools > div.m-basket__productInfo > div.m-basket__productPrice > div > div.m-productPrice__content > span.m-productPrice__salePrice")).getText().contains("799,00"),
                "Karşılaştırma yanlıştır.");
        Select quantity = new Select(driver.findElement(By.id("quantitySelect0-key-0")));
        quantity.selectByIndex(1);
        Assertions.assertTrue(driver.findElement(By.id("quantitySelect0-key-0")).getText().contains("2"),
                "2 adet değildir.");
        Thread.sleep(3000);
        productsDetailPage.DeleteProductInBasket();
        Thread.sleep(3000);
    }
}
