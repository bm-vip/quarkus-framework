package smart.ix.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import smart.ix.DeviceType;
import smart.ix.WatchModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SmartModelResourceTest {

    @Test
    public void getCameraInfo_shouldReturnCameraModels() {
        given().queryParam("name","Camera1")
                .when().get("/api/v1/smart-model/camera")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].name", is("Camera1"));
    }
    @Test
    public void getWatchInfo_shouldReturnWatchModels() {
        given().queryParam("name","Watch1")
                .when().get("/api/v1/smart-model/watch")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].name", is("Watch1"),
                        "[0].burnedCalories", is(50));
    }
}