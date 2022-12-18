package smart.ix.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smart.ix.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class SmartModelTest {
    private ManagedChannel channel;

    @BeforeEach
    public void init() {
        channel = ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
    }

    @AfterEach
    public void cleanup() throws InterruptedException {
        channel.shutdown();
        channel.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    public void getCameraInfo_shouldReturnCameraInfo() {
        CameraModels reply = MutinySmartModelGrpc.newMutinyStub(channel)
                .getCameraInfo(CameraModel.newBuilder().setName("Camera1").build())
                .await().atMost(Duration.ofSeconds(5));
        assertThat(reply.getModelsCount()).isEqualTo(1);
        assertThat(reply.getModels(0).getName()).isEqualTo("Camera1");
    }

    @Test
    public void getWatchInfo_shouldReturnWatchInfo() {
        WatchModels reply = MutinySmartModelGrpc.newMutinyStub(channel)
                .getWatchInfo(WatchModel.newBuilder().setName("Watch1").build())
                .await().atMost(Duration.ofSeconds(5));
        assertThat(reply.getModelsCount()).isEqualTo(1);
        assertThat(reply.getModels(0).getName()).isEqualTo("Watch1");
    }
}
