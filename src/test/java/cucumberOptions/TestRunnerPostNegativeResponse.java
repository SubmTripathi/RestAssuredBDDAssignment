package cucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\SHUBHAM\\Documents\\Cucumber\\src\\test\\java\\features",
		glue="stepDefination",		
		tags="@tag3"		
		)
public class TestRunnerPostNegativeResponse {

}
