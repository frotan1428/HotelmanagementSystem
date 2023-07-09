package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;

import java.util.List;

public interface HotelService {


    //step 13c: saveHotel
    Hotel saveHotel();

    //step14C findHotelById;

    Hotel findHotelById(Long id);

    //step 15c : deleteHotel By id:
    void deleteHotelById(Long id);

    //step16c: findAllHotels

    List<Hotel> findAllHotels();

    //17c :updateHotelByID
    void updateHotelByID(Long id,Hotel updateHotel) throws HotelResourceNotFoundException;




    //

}
