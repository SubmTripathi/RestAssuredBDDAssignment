package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\SHUBHAM\\Documents\\Cucumber\\src\\test\\java\\features",
		glue="stepDefination",
		//monochrome = true,
		tags="@tag4"
		//strict = true
		//dryRun = false
		)

public class TestRunnerGetURLNegative {

}
