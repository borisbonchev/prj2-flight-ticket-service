/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datarecords;

/**
 *
 * @author boris
 */
public class RouteData {
    private String origin;
    private String destination;

    public RouteData(String origin, String destination) {
        
    if (origin.equals("") || destination.equals("")) {
        throw new RuntimeException("Origin and destination fields cannot be empty.");
    }    
        
    if (origin.equals(destination)) {
        throw new IllegalArgumentException("Origin and destination are not allowed to be the same.");
    }
     
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "New RouteData record created: " + "Origin=" + origin + ", destination=" + destination + ".";
    }
}
