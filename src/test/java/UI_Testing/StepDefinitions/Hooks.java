package UI_Testing.StepDefinitions;

import Utilities.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    LocalDateTime startTime;
    LocalDateTime endTime;

    @Before
    public void beforeScenario() {
        startTime = LocalDateTime.now();
    }

    @After
    public void afterScenario(Scenario scenario) {
        endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);

        if (scenario.isFailed()) {

            final byte[] byteImage = ((TakesScreenshot) (BaseDriver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());

            BaseDriver.quitDriver();

//        ExcelUtilities.writeInExcel("src/test/java/ApachePOI/Resources/ScenarioResult.xlsx",scenario,startTime,endTime,duration);

        }
        BaseDriver.quitDriver();
    }
}
