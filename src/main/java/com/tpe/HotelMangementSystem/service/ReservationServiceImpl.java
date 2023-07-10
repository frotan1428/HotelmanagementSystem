package com.tpe.HotelMangementSystem.service;

import com.tpe.HotelMangementSystem.exception.GuestResourceNotFoundException;
import com.tpe.HotelMangementSystem.exception.RoomResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Guest;
import com.tpe.HotelMangementSystem.model.Reservation;
import com.tpe.HotelMangementSystem.model.Room;
import com.tpe.HotelMangementSystem.repository.GuestRepository;
import com.tpe.HotelMangementSystem.repository.ReservationRepository;
import com.tpe.HotelMangementSystem.repository.RoomRepository;
import com.tpe.HotelMangementSystem.repository.RoomRepositoryImpl;
import org.hibernate.annotations.common.util.impl.Log;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationServiceImpl implements ReservationService{

    //step 26d :saveReservation

    private Scanner scanner;

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;

   // RoomRepository roomRepository= new RoomRepositoryImpl();

    public ReservationServiceImpl(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public Reservation saveReservation() {

        scanner=new Scanner(System.in);

        System.out.println("Enter guest Id :");
        Long guestId=scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the Room Id :");
        Long roomId=scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the checkinDate (yyyy-MM-dd)");//2023-12-12

        LocalDate checkInDate=LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the checkoutDate (yyyy-MM-dd)");//2023-12-12

        LocalDate checkoutDate=LocalDate.parse(scanner.nextLine());

        try {

           Room existRoom = roomRepository.findRoomById(roomId);

           if (existRoom==null){
               throw new RoomResourceNotFoundException("Room not found with Id : "+roomId);
           }

          Guest existGuest=  guestRepository.findGuestById(guestId);
            if (existGuest==null){
                throw new GuestResourceNotFoundException("Guest not found with Id : "+guestId);
            }

            Reservation reservation = new Reservation();
            reservation.setGuest(existGuest);
            reservation.setRoom(existRoom);
            reservation.setCheckinDate(checkInDate);
            reservation.setCheckoutDate(checkoutDate);

            reservationRepository.saveReservation(reservation);
            System.out.println("Reservation saved successfully .! Reservation Id :" +reservation.getId());

            return reservation;

        }catch (GuestResourceNotFoundException | RoomResourceNotFoundException gr){
            System.out.println(gr.getMessage());

        }

        return null;
    }
}
