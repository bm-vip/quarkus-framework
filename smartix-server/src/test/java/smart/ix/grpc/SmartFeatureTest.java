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
public class SmartFeatureTest {
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
    public void forecastWeather_passTehranWith2DaysForecastAndReturn2result() {
        WeathersResponse reply = MutinySmartFeatureGrpc.newMutinyStub(channel)
                .forecastWeather(WeatherRequest.newBuilder().setQuery("Tehran").setDays(2).build())
                .await().atMost(Duration.ofSeconds(5));
        assertThat(reply.getWeathersCount()).isEqualTo(2);
    }
//    @Test
//    public void searchMovies_passMatrixAndReturnsTheInformation() {
//        MoviesResponse reply = MutinySmartFeatureGrpc.newMutinyStub(channel)
//                .searchMovies(MovieRequest.newBuilder().setQuery("matrix").build())
//                .await().atMost(Duration.ofSeconds(5));
//        assertThat(reply.getMoviesCount()).isEqualTo(8);
//    }
}
