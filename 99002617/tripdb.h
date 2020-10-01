#include<iostream>
#ifndef __TRIPDB_H
#define __TRIPDB_H
#include<list>
#include"flighttrip.h"

class FlightTripDb
{
private:
    std::list<FlightTrip> trips;
public:
    void addTrip(std::string,std::string,std::string,std::string,double);
    void removeTrip(std::string);
    FlightTrip* findTripById(std::string);
    int countAll();
    double computeMaxFare();
    double computeMinTravelTime();
    int countTripsByOperator(std::string);


};



#endif // __TRIPDB_H
 /*Implement another class say FlightTripDatabase with collection of flight trips
* using suitable data set (right STL container)
* Implement some operations on collection of flight trips as per following test calls
*    - addTrip("Bengaluru", "Mumbai", "6E123", 1000, "Indigo", 600)
*    - removeTrip("AI850")
*    - findTripById("SG302");
*    - countAll()
*    - computeMaxFare()
*    - computeMinTravelTime()
*    - countTripsByOperator("Indigo")*/
