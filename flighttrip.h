#include<iostream>

#ifndef __FLIGHTTRIP_H
#define __FLIGHTTRIP_H
#include"trip.h"

class FlightTrip:public Trip
{
private:
    std::string flight_number;
    std::string flight_operator;
    double distance_btw_cities;

public:
    FlightTrip():
        Trip(),flight_number(""),flight_operator(""),distance_btw_cities(0){}
    FlightTrip(std::string source_city,std::string destination_city,std::string flight_number,std::string flight_operator,double distance_btw_cities):
        Trip(source_city,destination_city),flight_number(flight_number),flight_operator(flight_operator),distance_btw_cities(distance_btw_cities){}

    double computeFare();
    double computeTravelTime();
    std::string getFlightNumber();
    std::string getOperator();
    double getDistance();

};




#endif




/* A Trip can be specialized as FlightTrip as follows
*    - additional data members like flight number, operator,
       aerial distance between cities
*    - suitable constructor(s) for derived class
*    - override pure virtual functions computeFare, computeTravelTime. Consider that
*      fare calculation is INR 10 per mile and speed of 500 miles per hour for
*      travel time calculation.*/
