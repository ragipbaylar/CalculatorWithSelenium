import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements {
    public WebElements() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "number1Field")
    private WebElement number1;

    @FindBy(id = "number2Field")
    private WebElement number2;

    @FindBy(id = "selectOperationDropdown")
    private WebElement selectDropDown;

    @FindBy(id = "calculateButton")
    private WebElement calculateButton;

    @FindBy(id = "numberAnswerField")
    private WebElement result;

    @FindBy(id = "clearButton")
    private WebElement clearButton;

    public WebElement getNumber1() {
        return number1;
    }

    public WebElement getNumber2() {
        return number2;
    }

    public WebElement getSelectDropDown() {
        return selectDropDown;
    }

    public WebElement getCalculateButton() {
        return calculateButton;
    }

    public WebElement getResult() {
        return result;
    }

    public WebElement getClearButton() {
        return clearButton;
    }
}
