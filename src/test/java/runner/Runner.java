package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
		                            "json:target/cucumber-reports/cucumber.json"},
                 features={"features"},
                 glue= {"steps"},
                 monochrome = true
                 //,dryRun=true
                 //tags="@ex1"
                 )

public class Runner {

}
