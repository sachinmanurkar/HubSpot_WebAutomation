package listners;

import com.tesults.tesults.Results;
import myPages.BasePage;
import myPages.ScreenshotHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import properties.SystemProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TesultsListener extends ScreenshotHandler implements ITestListener {

    // A list to hold your test cases.
    List<Map<String, Object>> testCases = new ArrayList<Map<String, Object>>();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();

    }

    public static Object[] getTestParams(ITestResult iTestResult) {
        return iTestResult.getParameters();
    }

    public byte[] saveScreenShotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Map<String, Object> to hold your test results data.
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("target", SystemProperties.MYFIRST_PROJECT_TOKEN);

        Map<String, Object> results = new HashMap<String, Object>();
        results.put("cases", testCases);
        data.put("results", results);

        // Upload
        Map<String, Object> response = Results.upload(data);
        System.out.println("success: " + response.get("success"));
        System.out.println("message: " + response.get("message"));
        System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
        System.out.println("errors: " + ((List<String>) response.get("errors")).size());
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(iTestResult));
        testCase.put("suite", "TesultsExample");
        testCase.put("result", "pass");
        testCases.add(testCase);
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(iTestResult));
        testCase.put("suite", "TesultsExample");
        testCase.put("reason", iTestResult.getThrowable().toString());
        testCase.put("result", "fail");
        testCase.put("params", getTestParams(iTestResult));
        List<String> files = new ArrayList<String>();
        files.add(getScreenshot(iTestResult.getMethod().getMethodName()));
        testCase.put("files", files);
        testCases.add(testCase);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        Map<String, Object> testCase = new HashMap<String, Object>();
        testCase.put("name", getTestMethodName(iTestResult));
        testCase.put("suite", "TesultsExample");
        testCase.put("result", "unknown");
        testCases.add(testCase);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }
}

