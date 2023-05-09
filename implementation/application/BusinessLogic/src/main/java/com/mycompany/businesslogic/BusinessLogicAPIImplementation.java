/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.businesslogic;

import com.mycompany.persistence.PersistenceAPI;

/**
 *
 * @author boris
 */
public class BusinessLogicAPIImplementation implements BusinessLogicAPI {
    final PersistenceAPI persistenceAPI;

    BusinessLogicAPIImplementation (PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }
    
    @Override
    public FlightManager getFlightManager() {
        return new FlightManager(persistenceAPI.getFlightStorageService());
    }

    @Override
    public RouteManager getRouteManager() {
        return new RouteManager(persistenceAPI.getRouteStorageService());
    }
}
