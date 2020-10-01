#include<iostream>
#include"tripdb.h"
#include"flighttrip.h"
#include<list>


    void FlightTripDb::addTrip(std::string source_city,std::string destination_city,std::string flight_number,std::string flight_operator,double distance_btw_cities){
    trips.push_back(FlightTrip(source_city,destination_city,flight_number,flight_operator,distance_btw_cities));
    }

    void FlightTripDb::removeTrip(std::string flight_number){
    std::list<FlightTrip>::iterator iter;
    for(iter=trips.begin();iter!=trips.end();++iter)
    {
        if(iter->getFlightNumber()==flight_number)
        {
            break;

        }
    }
    if(iter!=trips.end())
    {trips.erase(iter);
    }
    }


    FlightTrip* FlightTripDb::findTripById(std::string flight_number){
    std::list<FlightTrip>::iterator iter;
    for(iter=trips.begin();iter!=trips.end();++iter)
    {
        if(iter->getFlightNumber()==flight_number)
        {
            return &(*iter);
        }
    }
    return NULL;
    }


    int FlightTripDb::countAll(){
    int count=0;
    std::list<FlightTrip>::iterator iter;
    for(iter=trips.begin();iter!=trips.end();++iter)
    {
        count++;
    }
    return count;
    }

    double FlightTripDb::computeMaxFare(){
    std::list<FlightTrip>::iterator iter=trips.begin();
    auto MaxIter=iter;
    double MaxFare=iter->computeFare();
    for(;iter!=trips.end();++iter)
    {
        if(iter->computeFare()>MaxFare)
        {
            MaxIter=iter;
            MaxFare=iter->computeFare();
        }
    }
    return MaxFare;

    }

    double FlightTripDb::computeMinTravelTime(){
    std::list<FlightTrip>::iterator iter=trips.begin();
    auto MinIter=iter;
    double MinTime=iter->computeTravelTime();

    for(;iter!=trips.end();++iter)
    {
        if(iter->computeTravelTime()<MinTime)
        {
            MinIter=iter;
            MinTime=iter->computeTravelTime();
        }
    }
    return MinTime;
    }



    int FlightTripDb::countTripsByOperator(std::string operatorname){
        int count=0;
    std::list<FlightTrip>::iterator iter;
    for(iter=trips.begin();iter!=trips.end();++iter)
    {
        if(iter->getOperator()==operatorname)
        {
            count++;
        }

    }
    return count;
    }
