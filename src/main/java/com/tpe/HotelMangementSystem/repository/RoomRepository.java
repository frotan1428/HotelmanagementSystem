package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.model.Room;

public interface RoomRepository {

    //step 18 a  saveRoom

    Room saveRoom(Room ro);


    //step 19a: findRoomById
    Room findRoomById(Long roomId);

}
