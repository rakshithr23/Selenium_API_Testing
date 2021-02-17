package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
@CucumberOptions(features="src/test/resources/Features", glue = {"StepDefinitions"}, monochrome=true,
plugin = {"pretty","html:target/cucumber-html-report/index.html","json:target/cucumber.json","junit:target/cucumber.xml"})
public class RunCucumberTest {
	

}
