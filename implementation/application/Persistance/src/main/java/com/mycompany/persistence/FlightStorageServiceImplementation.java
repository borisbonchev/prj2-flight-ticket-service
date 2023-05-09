/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import java.util.List;
import com.mycompany.datarecords.FlightData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author boris
 */
public class FlightStorageServiceImplementation implements FlightStorageService {

    @Override
    public FlightData add(FlightData flightData) {
        DataSource db = DBProvider.getDataSource("postgres");

        String route = flightData.getRoute();
        String ticketPrice = flightData.getTicketPrice();
        String aircraftID = flightData.getAircraftID();
        String dateOfTakeoff = flightData.getDateOfTakeoff();
        String timeOfTakeoff = flightData.getTimeOfTakeoff();
        String dateOfArrival = flightData.getDateOfArrival();
        String timeOfArrival = flightData.getTimeOfArrival();

        String query = "insert into flight (route, aircraft, ticket_price, date_of_takeoff, time_of_takeoff, date_of_arrival, time_of_arrival)\n" +
                "select * from (select ? as routeQ, ? as aircraftQ, ? as priceQ, ? as dTakeoffQ, CAST(? as time) as tTakeoffQ, ? as dArrivalQ, CAST(? as time) as tArrivalQ) as new_value\n" +
                "where not exists (select route from flight where route = routeQ and aircraft = aircraftQ and ticket_price = priceQ and date_of_takeoff = dTakeoffQ and time_of_takeoff = tTakeoffQ and date_of_arrival = dArrivalQ and time_of_arrival = tArrivalQ) limit 1";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            pstm.setString(1, route);
            pstm.setString(2, aircraftID);
            pstm.setString(3, ticketPrice);
            pstm.setString(4, dateOfTakeoff);
            pstm.setString(5, timeOfTakeoff);
            pstm.setString(6, dateOfArrival);
            pstm.setString(7, timeOfArrival);

            if (pstm.executeUpdate() > 0) {
                pstm.executeUpdate();
            } else {
                flightData.setRoute("ALREADY EXISTS");
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(RouteStorageServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new FlightData(flightData.getRoute(), flightData.getAircraftID(), flightData.getTicketPrice(),
                flightData.getDateOfTakeoff(), flightData.getTimeOfTakeoff(), flightData.getDateOfArrival(), flightData.getTimeOfArrival());
    }

    @Override
    public List<FlightData> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
