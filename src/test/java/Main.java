import Utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    @Test
    public void calculatorTest() {
        WebElements we = new WebElements();

        WebDriver driver = Driver.getDriver();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        for (int i = 0; i < 5; i++) {

            int sayi1 = (int) (Math.random() * 100);
            int sayi2 = (int) (Math.random() * 100) + 1;

            for (int j = 0; j < 5; j++) {

                we.getNumber1().clear();
                we.getNumber1().sendKeys(String.valueOf(sayi1));

                we.getNumber2().clear();
                we.getNumber2().sendKeys(String.valueOf(sayi2));

                Select select = new Select(we.getSelectDropDown());
                select.selectByIndex(j);
                we.getCalculateButton().click();
                int sonuc;

                switch (j) {
                    case 0 -> {
                        sonuc = sayi1 + sayi2;
                        Assert.assertEquals(we.getResult().getAttribute("value"), String.valueOf(sonuc));
                        we.getClearButton().click();
                    }
                    case 1 -> {
                        sonuc = sayi1 - sayi2;
                        Assert.assertEquals(we.getResult().getAttribute("value"), String.valueOf(sonuc));
                        we.getClearButton().click();
                    }
                    case 2 -> {
                        sonuc = sayi1 * sayi2;
                        Assert.assertEquals(we.getResult().getAttribute("value"), String.valueOf(sonuc));
                        we.getClearButton().click();
                    }
                    case 3 -> {
                        String sonuc1 = "";
                        if (sayi1 % sayi2 != 0) {
                            sonuc1 = String.valueOf((double) sayi1 / (double) sayi2);
                        } else sonuc1 = String.valueOf(sayi1 / sayi2);
                        Assert.assertEquals(we.getResult().getAttribute("value"), sonuc1);
                        we.getClearButton().click();
                    }
                    case 4 -> {
                        String str1 = String.valueOf(sayi1);
                        String str2 = String.valueOf(sayi2);
                        Assert.assertEquals(we.getResult().getAttribute("value"), str1 + str2);
                        we.getClearButton().click();
                    }
                }
                wait.until(ExpectedConditions.visibilityOf(we.getResult()));
            }
        }
        Driver.quitDriver();
    }
}
