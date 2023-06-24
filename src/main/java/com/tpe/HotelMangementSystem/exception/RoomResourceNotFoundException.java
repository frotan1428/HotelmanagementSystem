package com.tpe.HotelMangementSystem.exception;


//step 8a : create costume  exception
public class RoomResourceNotFoundException extends RuntimeException{

    public RoomResourceNotFoundException(String message){
        super(message);
    }
}
