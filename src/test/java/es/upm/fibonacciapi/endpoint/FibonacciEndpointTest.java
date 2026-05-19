package es.upm.fibonacciapi.endpoint;
import io.restassured.RestAssured;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FibonacciEndpointTest {
    @LocalServerPort
    private int port;

    @Test
    void shouldReturnFibonacciResult() {
        RestAssured
            .given()
                .baseUri("http://localhost")
                .port(port)
            .when()
                .get("/api/fibonacci/{n}", 7)
            .then()
                .statusCode(200)
                .body("input", equalTo(7))
                .body("result", equalTo(13))
                .body("type", equalTo("Recursive"));
    }

    @Disabled("Enabled later in the workshop")
    @Test
    void shouldReturnBadRequestWhenInputIsNegative() {
        RestAssured
            .given()
                .baseUri("http://localhost")
                .port(port)
            .when()
                .get("/api/fibonacci/{n}", -1)
            .then()
                .statusCode(400)
                .body("error", equalTo("The number must be between 0 and 92"));
    }

    @Disabled("Enabled later in the workshop")
    @Test
    void shouldReturnBadRequestWhenInputIsGreaterThanNinetyTwo() {
        RestAssured
            .given()
                .baseUri("http://localhost")
                .port(port)
            .when()
                .get("/api/fibonacci/{n}", 93)
            .then()
                .statusCode(400)
                .body("error", equalTo("The number must be between 0 and 92"));
    }
}

