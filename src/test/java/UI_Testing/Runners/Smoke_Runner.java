package UI_Testing.Runners;

import Utilities.BaseDriver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/UI_Testing/FeatureFiles",
        glue = "UI_Testing.StepDefinitions",
        tags = "@Smoke",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class Smoke_Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters(value = "browser")
    public void setUp(@Optional(value = "chrome") String browser) {
        BaseDriver.setBrowserName(browser);
    }

    @AfterClass
    public void testEnd() {
        ExtentService.getInstance().setSystemInfo("Computer User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User Name", "Mert Ayar");
        ExtentService.getInstance().setSystemInfo("Application Name", "Portfolio");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Additional line", "Additional info");
    }
}