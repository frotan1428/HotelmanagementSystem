package com.tpe.HotelMangementSystem.service;


import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;
import com.tpe.HotelMangementSystem.model.Room;
import com.tpe.HotelMangementSystem.repository.HotelRepository;
import com.tpe.HotelMangementSystem.repository.RoomRepository;

import java.util.Scanner;

public class RoomServiceImpl implements RoomService{

    private static Scanner scanner;


    private  final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

//step 18d:
    @Override
    public Room saveRoom() {

        scanner= new Scanner(System.in);

        Room room = new Room();
        System.out.print("Enter The Room ID : ");
        room.setId(scanner.nextLong());

        System.out.print("Enter The Room Number : ");
        room.setNumber(scanner.next());
        System.out.print("Enter The Room Capacity : ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();//consume the newline character

        System.out.println("Please Enter Hotel id :");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        try {
            //find the existing hotel by id;

          Hotel existingHotel =  hotelRepository.findHotelById(hotelId);
          if (existingHotel==null){
              throw new HotelResourceNotFoundException("Hotel Not Found With id :" +hotelId);
          }

          //associated  the room with hotel
            room.setHotel(existingHotel);

          //save the room using Repository method

           Room saveRoom =  roomRepository.saveRoom(room);


           //add the room to the hotel's room collection

            existingHotel.getRooms().add(saveRoom);

            System.out.println("Room save successfully ! Room Id : " +saveRoom.getId());


        }catch (HotelResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return room;
    }
}
