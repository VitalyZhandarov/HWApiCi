import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class MobileBankTest {
    @Test
    void shouldReturnSchema () {

        given()
                .baseUri("http://localhost:9999/api/v1")

                .when()
                .get("/demo/accounts")

                .then().log().all()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
