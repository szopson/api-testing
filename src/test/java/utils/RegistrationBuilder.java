package utils;

import dto.RegistrationDataDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RegistrationBuilder {

    public static RegistrationDataDto.RegistrationDataDtoBuilder registerUserBuilder() {
        return RegistrationDataDto.builder()
                .email(RegistrationUtils.getEmail())
                .password(RegistrationUtils.getUserPassword());
    }

    public static RegistrationDataDto registerUserRqBody() {
        return registerUserRqBody(registerUserBuilder().build());
    }

    public static RegistrationDataDto registerUserRqBody(RegistrationDataDto data) {
        return RegistrationDataDto.builder()
                .email(data.getEmail())
                .password(data.getPassword())
                .build();
    }
}
