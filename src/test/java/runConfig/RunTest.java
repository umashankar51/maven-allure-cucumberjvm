package runConfig;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/CreateOrder", 
		glue = {"stepdefinitions"},
		plugin = {"json:target/cucumber/cucumber.json",
				  "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
		 //tags="@TestType1"
)
public class RunTest {

}
