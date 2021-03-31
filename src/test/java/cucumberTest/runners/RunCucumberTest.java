package cucumberTest.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumberTest/features",
        glue = {"cucumberTest/steps"},
        tags = "@regression",
        plugin = {"pretty"}
)
public class RunCucumberTest {
}
