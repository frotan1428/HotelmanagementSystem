package com.tpe.HotelMangementSystem.exception;

////step 8b : create costume  exception
public class HotelResourceNotFoundException extends RuntimeException{
    public HotelResourceNotFoundException(String message){
        super(message);
    }
}
