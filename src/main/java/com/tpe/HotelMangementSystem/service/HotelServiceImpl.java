package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.repository.HotelRepository;
import com.tpe.HotelMangementSystem.repository.HotelRepositoryImpl;

import java.util.List;
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

    //step14D :FindHotelById
    @Override
    public Hotel findHotelById(Long id) {

        try {
            Hotel foundHotel=hotelRepository.findHotelById(id);
            if (foundHotel!=null){
                System.out.println("-----------------------------------");
                System.out.println(foundHotel);
                return foundHotel;
            }else {
                throw new HotelResourceNotFoundException("Hotel not found With Id :" +id);
            }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
             return null;
        }
    }


    //step :  15d delete hotelByd id:
    @Override
    public void deleteHotelById(Long id) {
        scanner= new Scanner(System.in);

        try {
           Hotel hotelDeleted =  hotelRepository.findHotelById(id);
           if (hotelDeleted==null){
               throw new HotelResourceNotFoundException("Hotel not found With Id ; "+id);
           }
            System.out.println(hotelDeleted);

            System.out.println("Are you sure You want to delete the hotel with id  :" +hotelDeleted.getId());//101
           String confirmation =  scanner.nextLine();
           if (confirmation.equalsIgnoreCase("Y")){
               hotelRepository.deleteHotelById(hotelDeleted.getId());
               System.out.println("Hotel deleted successfully Id :" +hotelDeleted.getId());
           }else {
               System.out.println("Delete operation canceled ....");
           }
        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
        }

    }


    //step16D : find all hotels
    @Override
    public List<Hotel> findAllHotels() {
        try {
          List<Hotel> hotels =  hotelRepository.findAllHotels();

          if (!hotels.isEmpty()){
              System.out.println("List of Hotels: ");

              for (Hotel hotel:hotels){
                  System.out.println(hotel);
                  System.out.println("------------------------------");
              }
          }else {
              System.out.println("Hotel List is Empty ..");
          }
          return hotels;
        }catch (Exception e){
            System.out.println("An error occurred while retrieving hotel : "+e.getMessage());
            return null;
        }
    }


    //17d :updateHotelByID
    @Override
    public void updateHotelByID(Long id, Hotel updateHotel) throws HotelResourceNotFoundException {

        try {
           Hotel existingHotel = hotelRepository.findHotelById(id);
           if (existingHotel==null){
               throw new HotelResourceNotFoundException("Hotel not found With Id : "+id);
           }

           existingHotel.setName(updateHotel.getName());
           existingHotel.setName(updateHotel.getName());

           hotelRepository.updateHotel(existingHotel);

            System.out.println("Hotel updated Successfully ...");

        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());

        }

    }


}
