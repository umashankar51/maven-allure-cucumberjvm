package runConfig;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/CreateOrder"},
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        Object[][] test = super.scenarios();
        return test;
    }
}