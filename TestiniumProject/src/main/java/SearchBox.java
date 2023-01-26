import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class SearchBox extends BasePage {

    By searchBoxLocator = By.cssSelector("body > header > div > div > div.col-4.col-sm-4.col-md-4.col-lg-4.col-xl-6 > div > div > div > input");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator , text);
    }
}
