package Page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage  extends AbstractPage{

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardSign;

    @FindBy(xpath = "//p[text()='Janna2 Kowalska2']")
    private WebElement userMeniu;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;





    public HomePage(WebDriver driver){
        super(driver);
    }
}
