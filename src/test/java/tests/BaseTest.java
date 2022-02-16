package tests;

import org.testng.ITestResult;
import org.testng.Reporter;
import utilitys.API;
import org.testng.annotations.*;

public class BaseTest {
    API api;

    /**
     * Evaluate the test results
     * If the test fails, write message on console
     * @param result: Test result
     */
    @AfterMethod
    public void afterTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            String testName = result.getName();

            System.out.println("ERROR");
            Reporter.log("Error in testcase: " + testName);
        }
    }
}
