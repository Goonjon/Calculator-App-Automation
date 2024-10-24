import config.SeriesDataset;
import config.Setup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalculatorTestRunner extends Setup {



    @Test(priority = 1, description = "Automate calculation series: 100/10*5-10+60")
    public void calculateSeries() {
        CalculatorScreen calcScreen = new CalculatorScreen(driver);

        // Perform the calculation by passing the series as a parameter
        calcScreen.seriesCalculation("100/10*5-10+60");

        // Fetch the result
        String finalResult = calcScreen.getResult();
        System.out.println("Final result of pass the series as a parameter: " + finalResult);

        // Use SoftAssert to validate the result
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(finalResult, "100");  // Expected result is "100"
        softAssert.assertAll();
    }


    @Test(priority = 2, description = "Calculate series from CSV", dataProvider = "SeriesCSVData", dataProviderClass = SeriesDataset.class)
    public void calculateFromCSV(String expression, String expected) {
        CalculatorScreen calcScreen = new CalculatorScreen(driver);

        // Perform the series calculation
        String actualResult = calcScreen.performSeriesCalculation(expression);

        // Print the actual and expected results for debugging purposes
        System.out.println("Expression: " + expression);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actualResult);

        // Soft assertion to verify the actual result against the expected
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expected, "The result of the expression " + expression + " did not match the expected value.");

        // Call to aggregate the assertions
        softAssert.assertAll();
    }


    // Clear the calculator screen after each test
    @AfterMethod
    public void clearScreen() {
        CalculatorScreen calcScreen = new CalculatorScreen(driver);
        calcScreen.btnClear.click();
    }
}
