package API_Testing;

import API_Testing.POJOClasses.User;
import Utilities.ExcelUtilities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GoRestUser_ApachePOI {
    public String randomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public String randomEmail() {
        return RandomStringUtils.randomAlphabetic(6) + "@test.com";
    }

    User user;
    List<User> userFromResponse = new ArrayList<>();

    List<List<String>> userData;

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
        userData = ExcelUtilities.getFromExcel("src/test/java/API_Testing/ApachePOI/Resources/UserData.xlsx", "userInfo", 4);
        for (int i = 1; i < userData.size(); i++) {
            user = new User(userData.get(i).get(0), userData.get(i).get(1), userData.get(i).get(2), userData.get(i).get(3));
            userFromResponse.add(given()
                    .spec(requestSpecification)
                    .body(user)
                    .when()
                    .post()
                    .then()
                    .spec(responseSpecification)
                    .statusCode(201)
                    .body("email", equalTo(user.getEmail()))
                    .extract().as(User.class));


        }


    }

    @Test(dependsOnMethods = "createNewUser", priority = 6)
    void deleteUserTest() {

        for (int i = 0; i < userData.size() - 1; i++) {
            given()
                    .spec(requestSpecification)
                    .pathParam("userID", userFromResponse.get(i).getId())
                    .when()
                    .delete("/{userID}")
                    .then()
                    .log().body()
                    .statusCode(204);
        }

    }

    @Test(dependsOnMethods = "createNewUser", priority = 4)
    void getUserByIDTest() {
        for (int i = 0; i < userData.size() - 1; i++) {
            given()
                    .spec(requestSpecification)
                    .pathParam("userID", userFromResponse.get(i).getId())
                    .when()
                    .get("/{userID}")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .body("email", equalTo(userFromResponse.get(i).getEmail()));

        }

    }

    @Test(dependsOnMethods = "createNewUser", priority = 5)
    void updateUserTest() {

        for (int i = 0; i < userData.size() - 1; i++) {
            userFromResponse.get(i).setName(randomName());

            given()
                    .spec(requestSpecification)
                    .body(userFromResponse.get(i))
                    .pathParam("userID", userFromResponse.get(i).getId())
                    .when()
                    .put("/{userID}")
                    .then()
                    .body("id", equalTo(userFromResponse.get(i).getId()))
                    .body("name", equalTo(userFromResponse.get(i).getName()))
                    .statusCode(200);

        }


    }

    @Test(dependsOnMethods = {"createNewUser", "deleteUserTest"}, priority = 7)
    void deleteUserNegativeTest() {
        for (int i = 0; i < userData.size() - 1; i++) {
            given()
                    .spec(requestSpecification)
                    .pathParam("userID", userFromResponse.get(i).getId())
                    .when()
                    .delete("/{userID}")
                    .then()
                    .statusCode(404);
        }

    }

    @Test(dependsOnMethods = {"createNewUser", "deleteUserTest"}, priority = 18)
    void getUserByIDNegativeAfterDeleteTest() {
        for (int i = 0; i < userData.size() - 1; i++) {
            given()
                    .spec(requestSpecification)
                    .pathParam("userID", userFromResponse.get(i).getId())
                    .when()
                    .get("/{userID}")
                    .then()
                    .statusCode(404);
        }


    }

}
