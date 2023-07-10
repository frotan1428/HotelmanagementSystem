package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Guest;
import org.hibernate.annotations.common.util.impl.Log;

public interface GuestService {


    //step 22c:save guest

    Guest saveGuest();
        //23c findGuestById
    void findGuestById(Long id);

}
