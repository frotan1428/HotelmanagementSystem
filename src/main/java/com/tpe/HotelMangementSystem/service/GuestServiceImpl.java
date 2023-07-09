package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import com.tpe.HotelMangementSystem.repository.GuestRepository;

import java.util.Scanner;

public class GuestServiceImpl implements GuestService{

    //step 22D :save guest


    private Scanner scanner;

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }


    @Override
    public Guest saveGuest() {

        scanner= new Scanner(System.in);


        //create guest object
        Guest guest= new Guest();

        System.out.println("Enter Guest Name:");
        guest.setName(scanner.nextLine());

        //create address Object

        Address address= new Address();

        System.out.println("Enter Guest Street : ");
        address.setStreet(scanner.nextLine());

        System.out.println("Enter Guest City : ");
        address.setCity(scanner.nextLine());

        System.out.println("Enter Guest Country : ");
        address.setCountry(scanner.nextLine());

        System.out.println("Enter Guest zipCode : ");
        address.setZipCode(scanner.nextInt());

        //set address for the Guest
        guest.setAddress(address);

        guestRepository.saveGuest(guest);

        System.out.println("Guest  Save Successfully  ! Guest Id:  "+guest.getId());

       return guest;


    }
}
