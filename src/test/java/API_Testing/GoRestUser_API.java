package API_Testing;

import API_Testing.POJOClasses.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GoRestUser_API {

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String randomEmail() {
        return RandomStringUtils.randomAlphabetic(6) + "@test.com";
    }

    User user;
    User userFromResponse;

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    void setup() {
        baseURI = "https://gorest.co.in/public/v2/users";
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer 048656d02345c44096d64f531cd55dc97c303cd2ac32779b2896b77dbfb5a254")
                .setContentType(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test(priority = 1)
    void getListOfUsersTest() {
        given()
                .spec(requestSpecification)
                .when()
                .get()
                .then()
                .spec(responseSpecification)
                .statusCode(200);

    }

    @Test(priority = 2)
    void createNewUser() {
        user = new User(randomName(), randomEmail(), "male", "active");
        userFromResponse = given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(201)
                .body("email", equalTo(user.getEmail()))
                .extract().as(User.class);
    }

    @Test(dependsOnMethods = "createNewUser",priority = 3)
    void createNewUserNegativeTest() {
        user.setName(randomName());
        user.setGender("female");

        given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .spec(responseSpecification)
                .statusCode(422)
                .body("[0].message", equalTo("has already been taken"));
    }

    @Test(dependsOnMethods = "createNewUser",priority = 4)
    void getUserByIDTest() {
        given()
                .spec(requestSpecification)
                .pathParam("userID", userFromResponse.getId())
                .when()
                .get("/{userID}")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .body("email", equalTo(userFromResponse.getEmail()));

    }

    @Test(dependsOnMethods = "createNewUser",priority = 5)
    void updateUserTest() {
        userFromResponse.setName(randomName());

        given()
                .spec(requestSpecification)
                .body(userFromResponse)
                .pathParam("userID", userFromResponse.getId())
                .when()
                .put("/{userID}")
                .then()
                .log().body()
                .body("id", equalTo(userFromResponse.getId()))
                .body("name", equalTo(userFromResponse.getName()))
                .statusCode(200);


    }

    @Test(dependsOnMethods = "createNewUser",priority = 6)
    void deleteUserTest() {
        given()
                .spec(requestSpecification)
                .pathParam("userID", userFromResponse.getId())
                .when()
                .delete("/{userID}")
                .then()
                .statusCode(204);
    }

    @Test(dependsOnMethods = {"createNewUser","deleteUserTest"},priority = 7)
    void deleteUserNegativeTest() {
        given()
                .spec(requestSpecification)
                .pathParam("userID", userFromResponse.getId())
                .when()
                .delete("/{userID}")
                .then()
                .statusCode(404);
    }

    @Test(dependsOnMethods = {"createNewUser","deleteUserTest"},priority = 18)
    void getUserByIDNegativeAfterDeleteTest() {
        given()
                .spec(requestSpecification)
                .pathParam("userID", userFromResponse.getId())
                .when()
                .get("/{userID}")
                .then()
                .statusCode(404);


    }


}
