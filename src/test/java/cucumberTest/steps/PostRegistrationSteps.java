package cucumberTest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.hamcrest.Matchers.equalTo;
import static utils.RegistrationBuilder.registerUserBuilder;

public class PostRegistrationSteps {

    private final Context testContext;

    public PostRegistrationSteps(Context context) {
        testContext = context;
    }

    @When("^I prepare request body with email: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void i_perform_get_operation_for_endpoint(String email, String password) {
        testContext.body = registerUserBuilder().email(email).password(password).build();
    }

    @And("^User get correct error message: \"([^\"]*)\" and status code: \"([^\"]*)\"$")
    public void userGetCorrectErrorMessage(String errorMessage, int statusCode) {
        testContext.response.then()
                .statusCode(statusCode)
                .body("error", equalTo(errorMessage));
    }
}
