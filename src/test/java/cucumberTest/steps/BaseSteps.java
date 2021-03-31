package cucumberTest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.RegistrationUtils;

public class BaseSteps {

    private final Context testContext;

    public BaseSteps(Context context) {
        testContext = context;
    }

    @Given("^I perform GET operation for getUsers endpoint$")
    public void i_perform_get_operation_for_endpoint() {
        testContext.response = RegistrationUtils.getUsers();
        testContext.response.then().statusCode(200);
    }

    @Then("^I perform POST operation for postRegister endpoint$")
    public void i_perform_post_operation_for_endpoint() {
        testContext.response = RegistrationUtils.postRegister(testContext.body);
    }


}
