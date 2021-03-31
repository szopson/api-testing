package cucumberTest.steps;

import dto.UserListDto;
import io.cucumber.java.en.And;

import java.util.List;

import static reqresTest.GetUsersTest.assertNonEmptyResponse;
import static reqresTest.GetUsersTest.assertNonEmptyResponseFields;
import static utils.RegistrationUtils.getUsers;

public class GetUsersSteps {

    private final Context testContext;

    public GetUsersSteps(Context context) {
        testContext = context;
    }

    @And("Users required fields are not empty")
    public void i_perform_get_operation_for_endpoint() {
        UserListDto response2 = getUsers().thenReturn().as(UserListDto.class);
        List<UserListDto.UserDataDto> userData = response2.getData();

        assertNonEmptyResponse(response2);
        assertNonEmptyResponseFields(userData);
    }

}
