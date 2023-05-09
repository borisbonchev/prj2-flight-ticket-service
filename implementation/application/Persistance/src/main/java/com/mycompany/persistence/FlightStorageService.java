/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistence;

import java.util.List;
import com.mycompany.datarecords.FlightData;

/**
 *
 * @author boris
 */
public interface FlightStorageService {
    
    FlightData add(FlightData flightData);
    List<FlightData> getAll();
}
