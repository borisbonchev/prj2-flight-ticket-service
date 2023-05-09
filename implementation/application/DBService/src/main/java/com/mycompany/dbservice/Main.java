/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.dbservice;

import com.mycompany.persistence.DBProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author boris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource db = DBProvider.getDataSource("postgres");

        System.out.println("\nTesting database connection\n");

        try ( Connection con = db.getConnection();   
              Statement stm = con.createStatement();) {

            ResultSet result = stm.executeQuery("SELECT * FROM flight");

            while (result.next()) {
                int flightId = result.getInt("flightid");
                String route = result.getString("route");
                String aircraft = result.getString("aircraft");
                String ticket_price = result.getString("ticket_price");
                LocalDate date_of_flight = result.getObject("date_of_flight", LocalDate.class);
                String time_of_flight = result.getString("time_of_flight");

                System.out.println("Flight with id: " + flightId + ", " + route + ", " + aircraft + ", " + ticket_price + ", " + date_of_flight + ", " + time_of_flight);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
