package com.GenericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.Date;

public class ListenerImplementationClass implements ITestListener {

    ExtentReports report;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter htmlreports = new ExtentSparkReporter("./Reports/"+new Date().getHours()+".html");
        htmlreports.config().setDocumentTitle("FlipKart");
        htmlreports.config().setTheme(Theme.DARK);
        htmlreports.config().setReportName("");
        report = new ExtentReports();
        report.attachReporter(htmlreports);
        report.setSystemInfo("OS", "Windows");
        report.setSystemInfo("Base-Browser", "chrome");
        report.setSystemInfo("Base-url", "");
        report.setSystemInfo("Reporter Name", "Subramani");
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test = report.createTest(methodName);
        Reporter.log(methodName+ "---testScript execution started ");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test.generateLog(Status.PASS, methodName+"---> passed");
        Reporter.log(methodName+"-->testScript passed");
    }

    @Override
    public void onFinish(ITestContext context) {

        report.flush();
    }
}
