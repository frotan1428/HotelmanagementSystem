package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Guest;

public interface GuestRepository {

    //step 22a: save Guest

    void saveGuest(Guest guest);

    //23a findGuestById
    Guest findGuestById(Long id);

}
