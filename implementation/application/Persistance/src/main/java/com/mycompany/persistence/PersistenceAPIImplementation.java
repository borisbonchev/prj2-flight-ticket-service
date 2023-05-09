/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistence;

/**
 *
 * @author boris
 */
public class PersistenceAPIImplementation implements PersistenceAPI {
    
    @Override
    public FlightStorageService getFlightStorageService() {
        return new FlightStorageServiceImplementation();
    }

    @Override
    public RouteStorageService getRouteStorageService() {
        return new RouteStorageServiceImplementation();
    }
}
