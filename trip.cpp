#include <iostream>
#include"trip.h"


Trip::Trip():
    source_city(""),destination_city(""){}

Trip::Trip(std::string source_city,std::string destination_city):
            source_city(source_city),destination_city(destination_city){}

std::string Trip::getOrigin(){
return source_city;}

std::string Trip::getDestination(){
return destination_city;}


