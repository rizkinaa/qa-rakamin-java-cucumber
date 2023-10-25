package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue= {"StepDef"},
//        glue= {" /Users/developer/Project/Personal/qa/saucedemo-automation/src/test/java/StepDef/"},
        //        plugin ={"pretty","json:target/cucumber.json"})
        plugin ={"html:target/HTML_report.html"},
        tags="@Filter"
)
public class TestRunner {
}
