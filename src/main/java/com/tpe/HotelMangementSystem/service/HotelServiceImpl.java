package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.repository.HotelRepository;
import com.tpe.HotelMangementSystem.repository.HotelRepositoryImpl;

import java.util.Scanner;

public class HotelServiceImpl implements HotelService{



    private  static Scanner scanner;

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;

    }
   // HotelRepository hotelRepository= new HotelRepositoryImpl();

    //stp13d: saveHotel
    @Override
    public Hotel saveHotel() {


        scanner= new Scanner(System.in);
        Hotel hotel= new Hotel();

        System.out.println("Enter hotel Id :");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();//consume the new Line
        System.out.println("Enter The Hotel Name :");
        hotel.setName(scanner.nextLine());
        System.out.println("Enter the Hotel Location : ");
        hotel.setLocation(scanner.nextLine());

        //save the hotel object using hotelRepository
        hotelRepository.saveHotel(hotel);

        System.out.println("Hotel saved  successfully! :  "+hotel.getId());
        return hotel;


    }
}
