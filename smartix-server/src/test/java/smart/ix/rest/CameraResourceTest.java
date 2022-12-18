package smart.ix.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import smart.ix.CameraModel;
import smart.ix.DeviceType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CameraResourceTest {

    @Test
    public void findAll_shouldReturnCameraModels() {
        given()
                .when().get("/api/v1/camera")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].name", is("Camera1"));
    }
    @Test
    public void save_shouldSaveCameraModelToDatabase() {
        CameraModel model = CameraModel.newBuilder()
                .setName("Camera2")
                .setType(DeviceType.CAMERA)
                .build();
        given()
                .when().get("/api/v1/camera")
                .then()
                .statusCode(200);
    }
}