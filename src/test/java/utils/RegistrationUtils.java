package utils;


import com.github.javafaker.Faker;
import configuration.ReqResApiConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

import static org.aeonbits.owner.ConfigCache.getOrCreate;

@UtilityClass
public class RegistrationUtils {

    private static final ReqResApiConfig reqResApiConfig = getOrCreate(ReqResApiConfig.class, System.getProperties());
    private static Faker faker = new Faker();

    private static RequestSpecBuilder rqSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured());
    }

    private static final RequestSpecification ACCOUNTS_SPEC = rqSpecBuilder()
            .setBaseUri(reqResApiConfig.url())
            .setRelaxedHTTPSValidation()
            .build();

    static String getEmail() {
        return faker.internet().uuid().replace("-", "") + "@" + faker.internet().domainName();
    }

    static String getUserPassword() {
        return faker.rickAndMorty().character() + faker.number().digits(3);
    }

    public static Response postRegister(Object registerDto) {
        return RestAssured.given()
                .spec(ACCOUNTS_SPEC)
                .body(registerDto)
                .when()
                .post(reqResApiConfig.postRegisterEndpoint());
    }

    public static Response getUsers() {
        return RestAssured.given()
                .spec(ACCOUNTS_SPEC)
                .when()
                .get(reqResApiConfig.getUserEndpoint());
    }
}

