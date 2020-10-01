#include<iostream>
#ifndef __TRIP_H
#define __TRIP_H


class Trip
{
    private:
        std::string source_city;
        std::string destination_city;


    public:
        Trip();
        Trip(std::string ,std::string );
        virtual double computeFare()=0;
        virtual double computeTravelTime()=0;
        std::string getOrigin();
        std::string getDestination();



};




#endif // __TRIP_H



/** A Trip can be associated with
*    - data members like source city, destination city,
       (distance metric - miles)
     - suitable constructor
*    - suitable abstract operations (pure virtual) like computeFare, computeTravelTime*/
