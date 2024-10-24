import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorScreen {

    // Page elements defined using @FindBy
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;

    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnMinus;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMultiply;

    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDivide;

    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement txtResult;

    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btnClear;



    // AndroidDriver instance
    AndroidDriver driver;

    // Constructor to initialize the PageFactory and AppiumFieldDecorator
    public CalculatorScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Utility method to click on a digit button
    public void clickDigit(int number) {
        String numberAsString = String.valueOf(number);
        for (char digit : numberAsString.toCharArray()) {
            driver.findElement(By.id("com.google.android.calculator:id/digit_" + digit)).click();
        }
    }

    // Method to handle dynamic series calculation (moving this from test runner to here)
    public void seriesCalculation(String expression) {
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Click the digit based on the character
                clickDigit(Character.getNumericValue(ch));
            } else {
                // Identify and click the corresponding operator button
                switch (ch) {
                    case '+':
                        btnPlus.click();
                        break;
                    case '-':
                        btnMinus.click();
                        break;
                    case '*':
                        btnMultiply.click();
                        break;
                    case '/':
                        btnDivide.click();
                        break;
                }
            }
        }
        // Press the equals button to complete the calculation
        btnEqual.click();
    }

    // Method to get the result from the calculator display
    public String getResult() {
        return txtResult.getText();
    }


    // New method to handle dynamic series calculations from a string expression
    public String performSeriesCalculation(String expression) {
        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Click the digit
                driver.findElement(By.id("com.google.android.calculator:id/digit_" + ch)).click();
            } else {
                switch (ch) {
                    case '+':
                        btnPlus.click();
                        break;
                    case '-':
                        btnMinus.click();
                        break;
                    case '*':
                        btnMultiply.click();
                        break;
                    case '/':
                        btnDivide.click();
                        break;
                        //I use p instead of pi sign
                    case 'p':
                        driver.findElement(By.id("com.google.android.calculator:id/const_pi")).click();
                        break;
                    case '^':
                        driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();
                        break;
                }
            }
        }

        // Press the equals button to complete the calculation
        btnEqual.click();

        // Fetch the result from the calculator (as a string)
        String resultText = txtResult.getText();

        // Convert the result to a BigDecimal for precise arithmetic
        BigDecimal result = new BigDecimal(resultText);

        // Check if the result has decimal places (scale > 0)
        if (result.scale() > 0) {
            // If it has decimal places, round it to 2 decimal places
            result = result.setScale(2, RoundingMode.HALF_UP);
        } else {
            // If it's a whole number, set scale to 0 (remove unnecessary decimals)
            result = result.setScale(0, RoundingMode.UNNECESSARY);
        }

        // Return the formatted result as a string
        return result.toPlainString();
    }

}


