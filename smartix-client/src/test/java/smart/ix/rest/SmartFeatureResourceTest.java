package smart.ix.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import smart.ix.CameraModel;
import smart.ix.DeviceType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SmartFeatureResourceTest {

    @Test
    public void forecastWeather_passTehranWith2DaysForecastAndReturn2result() {
        given().queryParam("q","Tehran").queryParam("days",2)
                .when().get("/api/v1/smart-feature/forecast")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    public void searchMovies_passMatrixAndReturnsTheInformation() {
        given().queryParam("q","matrix")
                .when().get("/api/v1/smart-feature/movies")
                .then()
                .statusCode(200)
                .body("$.size()", is(8));
    }
}