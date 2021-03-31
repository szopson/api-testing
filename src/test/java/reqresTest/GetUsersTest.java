package reqresTest;


import dto.UserListDto.UserDataDto;
import dto.UserListDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.RegistrationUtils.getUsers;

public class GetUsersTest {

    @Test
    @DisplayName("Successful get response and not empty Users List")
    void shouldGetUsersList() {

        //when
        Response response = getUsers();

        UserListDto response2 = getUsers().thenReturn().as(UserListDto.class);
        List<UserDataDto> userData = response2.getData();

        //then
        response.then()
                .statusCode(SC_OK);

        assertNonEmptyResponse(response2);
        assertNonEmptyResponseFields(userData);
    }


    public static void assertNonEmptyResponse(UserListDto response) {
        assertFalse(response.getData().isEmpty());
    }

    public static void assertNonEmptyResponseFields(List<UserDataDto> userData) {
        userData.forEach(i -> {
            assertNotNull(i.getId());
            assertFalse(i.getAvatar().isEmpty());
            assertFalse(i.getEmail().isEmpty());
            assertFalse(i.getFirst_name().isEmpty());
            assertFalse(i.getLast_name().isEmpty());
        });
    }
}