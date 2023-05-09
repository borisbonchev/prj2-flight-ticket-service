import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import com.mycompany.datarecords.FlightData;
import com.mycompany.persistence.FlightStorageService;
import org.junit.jupiter.api.extension.ExtendWith;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author boris
 */
@ExtendWith( MockitoExtension.class )
public class FlightStorageServiceImplementationTest {

    private FlightStorageService flightStorageService;
    private FlightData flightData;
    private String query;

    @Mock
    DataSource ds;

    @Mock
    Connection con;
    
    @Mock
    PreparedStatement pstm;
    
    @BeforeEach
    void setUp() throws SQLException {
        String route = "SOF-EIND";
        String aircraftID = "test1234";
        String ticketPrice = "15";
        String dateTakeoff = "2022-06-06";
        String timeTakeoff = "12:30";
        String dateArrival = "2022-06-06";
        String timeArrival = "14:20";
        
        
        flightData = new FlightData(route, aircraftID, ticketPrice, dateTakeoff, timeTakeoff, dateArrival, timeArrival);
    }
    
//    @Test
//    public void addFlightAlreadyExists() throws SQLException {
//        when(pstm.executeUpdate()).thenReturn(0);
//        
//        assertThatExceptionOfType(SQLException.class)
//                .isThrownBy(() -> {
//                    
//                }).withMessage("Takeoff and arrival dates and time should not be the same.");
//    }
//    
//    
//    
//    @Test
//    public void addFlightTest() throws SQLException {   
//        when(pstm.executeUpdate()).thenReturn(1);
//        
//        flightStorageService.add(flightData);
//        verify(pstm, times(1)).equals(1);
//    }
//  
}
