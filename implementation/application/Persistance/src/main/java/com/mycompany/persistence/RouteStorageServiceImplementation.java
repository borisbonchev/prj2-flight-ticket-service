    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

import com.mycompany.datarecords.RouteData;
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
public class RouteStorageServiceImplementation implements RouteStorageService {

    @Override
    public RouteData add(RouteData routeData) {
        // implementation
        DataSource db = DBProvider.getDataSource("postgres");
        
        String origin = routeData.getOrigin();
        String destination = routeData.getDestination();
        
        String query = "insert into route (Origin, Destination)\n" +
                       "select * from (select ? as originQ, ? as destinationQ) as new_value\n" +
                       "where not exists (select origin from route where origin = originQ and destination = destinationQ) limit 1";
        
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            
            pstm.setString(1, origin);
            pstm.setString(2, destination);
            
            if (pstm.executeUpdate() > 0) {
                pstm.executeUpdate(); 
            } else {
                routeData.setOrigin("ALREADY EXISTS");
            }
            
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(RouteStorageServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new RouteData(routeData.getOrigin(), routeData.getDestination());
    }
    
}
