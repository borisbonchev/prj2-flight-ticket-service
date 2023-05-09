import com.mycompany.businesslogic.FlightManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import com.mycompany.datarecords.FlightData;
import com.mycompany.persistence.FlightStorageService;
import org.junit.jupiter.api.extension.ExtendWith;
import java.sql.SQLException;
import org.assertj.core.api.SoftAssertions;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 *
 * @author boris
 */
@ExtendWith(MockitoExtension.class)
public class FlightManagerTest {

    private FlightData flightData;
    private FlightData exceptionData;

    @Mock
    FlightStorageService flightStorageService;

    @Mock
    FlightManager fm;

    @BeforeEach
    void setUp() {
        String route = "SOF-EIND";
        String aircraftID = "AB1234";
        String ticketPrice = "15";
        String dateTakeoff = "2022-06-06";
        String timeTakeoff = "12:30";
        String dateArrival = "2022-06-06";
        String timeArrival = "14:20";

        flightData = new FlightData(route, aircraftID, ticketPrice, dateTakeoff, timeTakeoff, dateArrival, timeArrival);
    }

    @Test
    public void addFlightTest() {
        fm = new FlightManager(flightStorageService);

        when(flightStorageService.add(flightData)).thenReturn(flightData);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(fm.add(flightData)).isExactlyInstanceOf(FlightData.class);
            softly.assertThat(fm.add(flightData)).isEqualTo(flightData);
        });
    }
    
    @Test
    public void flightMissingFields() {
        fm = new FlightManager(flightStorageService);
        
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    exceptionData = new FlightData("", "test", "test", "test", "test", "test", "test");
                    fm.add(exceptionData);
                }).withMessage("All fields must be filled in.");
    }
    
    @Test
    public void flightWithEqualDateAndTime() {
        fm = new FlightManager(flightStorageService);
        
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    exceptionData = new FlightData("test", "test", "test", "2022-06-06", "12:00", "2022-06-06", "12:00");
                    fm.add(exceptionData);
                }).withMessage("Takeoff and arrival dates and time should not be the same.");
    }
}
