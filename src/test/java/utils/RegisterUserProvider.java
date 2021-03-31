package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static utils.RegistrationBuilder.registerUserBuilder;



public class RegisterUserProvider {

    private static String EMAIL_DEFINED = "george.bluth@reqres.in";

    public static class CorrectField implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    arguments(registerUserBuilder().email(EMAIL_DEFINED).build(), SC_OK)
            );
        }
    }
    public static class IncorrectField implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            String empty = "";
            return Stream.of(
                    arguments(registerUserBuilder().password(empty).build(),
                            SC_BAD_REQUEST, "Missing password"),
                    arguments(registerUserBuilder().email(empty).build(),
                            SC_BAD_REQUEST, "Missing email or username"),
                    arguments(registerUserBuilder().build(),
                            SC_BAD_REQUEST, "Note: Only defined users succeed registration"));
        }
    }
}

