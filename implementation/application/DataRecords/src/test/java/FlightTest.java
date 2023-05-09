import com.mycompany.datarecords.FlightData;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author boris
 */
public class FlightTest {

    String route = "SOF-EIND";
    String aircraftID = "test1234";
    String ticketPrice = "15";
    String dateTakeoff = "2022-06-06";
    String timeTakeoff = "12:30";
    String dateArrival = "2022-06-06";
    String timeArrival = "14:20";

    FlightData flightData = new FlightData(route, aircraftID, ticketPrice, dateTakeoff, timeTakeoff, dateArrival, timeArrival);

    @Test
    public void constructorTest() {
        assertThat(flightData).as("Flight object should be created.").isExactlyInstanceOf(FlightData.class);
    }

    @Test
    public void getRoute() {
        assertThat(flightData.getRoute()).as("Should return the route of the airflight.").isEqualTo(route);
    }

    @Test
    public void setRoute() {
        String testRoute = "TOKYO-AMSTERDAM";
        flightData.setRoute(testRoute);

        assertThat(flightData.getRoute()).as("Should set a new route.").isEqualTo(testRoute);
    }
}
