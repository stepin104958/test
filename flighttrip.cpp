#include<iostream>
#include"flighttrip.h"
#include"trip.h"
#include "tripdb.h"




    double FlightTrip::computeFare()
    {
        double Fare=distance_btw_cities*10;
        return Fare;

    }

    double FlightTrip::computeTravelTime()
    {

        return (double(60)/double(500))*distance_btw_cities;
    }


    std::string FlightTrip::getFlightNumber()
    {
        return flight_number;
    }
    std::string FlightTrip::getOperator()
    {
        return flight_operator;
    }


    double FlightTrip::getDistance()
    {
        return distance_btw_cities;
    }






