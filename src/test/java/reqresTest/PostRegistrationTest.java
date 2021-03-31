package reqresTest;


import dto.RegistrationDataDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import utils.RegisterUserProvider;

import static org.hamcrest.Matchers.*;
import static utils.RegistrationBuilder.registerUserRqBody;
import static utils.RegistrationUtils.postRegister;

class PostRegistrationTest {


    @ParameterizedTest(name = "[{index}] DefinedUser")
    @DisplayName("Successful registration - response 200 along with token")
    @ArgumentsSource(RegisterUserProvider.CorrectField.class)
    void shouldRegisterUser(RegistrationDataDto bodyRequest, int StatusCode) {
        // given
        RegistrationDataDto requestBody = registerUserRqBody(bodyRequest);

        //when
        Response response = postRegister(requestBody);

        //then
        response.then()
                .statusCode(StatusCode)
                .body("token", not(isEmptyOrNullString()),
                        "id", notNullValue());
    }

    @ParameterizedTest(name = "[{index}] error:{2} ")
    @DisplayName("Unsuccessful registration - response 400 with error")
    @ArgumentsSource(RegisterUserProvider.IncorrectField.class)
    void shouldNotRegisterUser(RegistrationDataDto bodyRequest, int StatusCode, String errorMessage) {
        // given
        RegistrationDataDto requestBody = registerUserRqBody(bodyRequest);

        //when
        Response response = postRegister(requestBody);

        //then
        response.then()
                .statusCode(StatusCode)
                .body("error", equalTo(errorMessage));
    }
}
