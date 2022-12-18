package smart.ix.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import smart.ix.DeviceType;
import smart.ix.WatchModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WatchResourceTest {

    @Test
    public void findAll_shouldReturnWatchModels() {
        given()
                .when().get("/api/v1/watch")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].name", is("Watch1"),
                        "[0].burnedCalories", is(50));
    }
    @Test
    public void save_shouldSaveWatchModelToDatabase() {
        WatchModel model = WatchModel.newBuilder()
                .setName("Watch2")
                .setType(DeviceType.WATCH)
                .build();
        given()
                .when().get("/api/v1/watch")
                .then()
                .statusCode(200);
    }
}