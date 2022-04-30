package runConfig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/CreateOrder"},
		glue = {"stepDefinitions"},
		plugin = {"json:target/cucumber/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}/*,
		tags = ("@test1")*/
)
public class Junit4Runner {

}
