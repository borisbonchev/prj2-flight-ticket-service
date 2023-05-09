/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.businesslogic;

import com.mycompany.datarecords.FlightData;
import com.mycompany.persistence.FlightStorageService;


/**
 *
 * @author boris
 */
public class FlightManager {
    private final FlightStorageService flightStorageService;

    public FlightManager(FlightStorageService flightStorageService) {
        this.flightStorageService = flightStorageService;
    }
    
    public FlightData add(FlightData flightData){
        return flightStorageService.add(flightData);
    }
}
