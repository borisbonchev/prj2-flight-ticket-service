/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datarecords;

/**
 *
 * @author boris
 */
public class FlightData {
    private String route;
    private final String aircraftID;
    private final String ticketPrice;
    private final String dateOfTakeoff;
    private final String timeOfTakeoff;
    private final String dateOfArrival;
    private final String timeOfArrival;

    public FlightData(String route, String aircraftID, String ticketPrice, String dateOfTakeoff, String timeOfTakeoff, String dateOfArrival, String timeOfArrival) {
        if (route.isBlank() || aircraftID.isBlank() || ticketPrice.isBlank() || ticketPrice.equals("€") || dateOfTakeoff.isBlank() ||
                timeOfTakeoff.isBlank() || dateOfArrival.isBlank() || timeOfArrival.isBlank()) {
            throw new RuntimeException("All fields must be filled in.");
        }
        
        if (dateOfTakeoff.equals(dateOfArrival)) {
            if (timeOfTakeoff.equals(timeOfArrival)) {
                throw new IllegalArgumentException("Takeoff and arrival dates and time should not be the same.");
            }
        }
        
        this.route = route;
        this.aircraftID = aircraftID;
        this.ticketPrice = ticketPrice;
        this.dateOfTakeoff = dateOfTakeoff;
        this.timeOfTakeoff = timeOfTakeoff;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
    }

    public String getDateOfTakeoff() {
        return dateOfTakeoff;
    }

    public String getTimeOfTakeoff() {
        return timeOfTakeoff;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    public String getRoute() {
        return route;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Flight route = " + route + ", flying with aircraft " + aircraftID + ", ticket price = " + ticketPrice + 
                "\ndeparting at " + dateOfTakeoff + ", " + timeOfTakeoff + " and arriving at " + dateOfArrival + ", " + timeOfArrival;
    }
}
