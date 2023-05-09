/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.businesslogic;

import com.mycompany.datarecords.RouteData;
import com.mycompany.persistence.RouteStorageService;

/**
 *
 * @author boris
 */
public class RouteManager {
    private final RouteStorageService routeStorageService;

    public RouteManager(RouteStorageService routeStorageService) {
        this.routeStorageService = routeStorageService;
    }
    
    public RouteData add(RouteData routeData) {
        return routeStorageService.add(routeData);
    }
}
