package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Hotel;

import java.util.List;

public interface HotelRepository {

    //step13a :create aveHotel

    Hotel saveHotel(Hotel hotel);

    //step 14a findHotelById
    Hotel findHotelById(Long id);


    //step15a : deleteHotelById
    void deleteHotelById(Long id);



    //16a: find All Hotels
    List<Hotel> findAllHotels();

    //step 17a :update hotel

    void updateHotel(Hotel existingHotel);

}
