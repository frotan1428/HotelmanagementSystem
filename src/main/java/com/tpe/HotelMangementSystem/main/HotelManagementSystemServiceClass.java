package com.tpe.HotelMangementSystem.main;

import com.tpe.HotelMangementSystem.repository.HotelRepository;
import com.tpe.HotelMangementSystem.repository.HotelRepositoryImpl;
import com.tpe.HotelMangementSystem.service.HotelService;
import com.tpe.HotelMangementSystem.service.HotelServiceImpl;

import java.util.Scanner;

public class HotelManagementSystemServiceClass {

private static Scanner scanner ;


     //step 11: call displayMenuHotelManagementSystem()
    public static  void displayMenuHotelManagementSystem(){

        //create an instance of hotelService and HotelRepository

        HotelRepository hotelRepository= new HotelRepositoryImpl();

        HotelService hotelService= new HotelServiceImpl(hotelRepository);


        //create  a scanner for user input
        scanner= new Scanner(System.in);

        //menu
        boolean exit = false;
        while (!exit){
            System.out.println("==== Hotel Management System  Menu ====");
            System.out.println("1. Hotel Operations");
            System.out.println("2. Room Operations");
            System.out.println("3. Guest Operations");
            System.out.println("4. Reservation Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // to consume the newline character (\n):
            switch (choice){
                case 1:
                    displayHotelOperationsMenu(hotelService);
                   break;
                case 2:
                    displayRoomOperationsMenu();
                    break;
                case 3:
                    displayGuestOperationsMenu();
                    break;
                case 4:
                    displayReservationOperationsMenu();
                    break;
                case 5:
                    exit=true;
                    System.out.println("Good Bye !!!!!");
                    break;
                default:
                    System.out.println("Invalid choice .Please try again ..");
                    break;
            }
        }


    }

    //step13:
    private static void displayHotelOperationsMenu(HotelService hotelService) {
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character// "/n"

            switch (choice) {
                case 1:
                    //step 13e:saveHotel
                    System.out.println("==== Add a new hotel ====");
                    hotelService.saveHotel();
                    break;
                case 2:
                    // //step 14e:findHotelById
                    System.out.println("Enter the hotel ID: ");
                    break;
                case 3:
                    ////step 15e :deleteHotelById
                    System.out.print("Enter the hotel ID to delete: ");

                    break;
                case 4:
                    //step 16e: findAllHotels
                    System.out.println("==== Find All Hotels ====");
                    break;
                case 5:
                    //step 17e: updateHotelById
                    System.out.println("==== Update Hotel By ID ====");

                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //step 18[a-b-c-d-e]: Room Crud operation
    //!!! open RoomRepository
    private static void displayRoomOperationsMenu() {
        scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    //step 18e: saveRoom
                    System.out.println("==== Add New Room ====");
                    break;
                case 2:
                    //step 19e : findRoomById
                    System.out.print("Enter the Room ID to Find: ");
                    break;
                case 3:
                    //step 20e: findAllRoom
                    System.out.println("==== Delete Room By ID ====");
                    System.out.print("Enter the room ID to delete: ");
                    break;
                case 4:
                    //step 21e:deleteRoomById
                    System.out.println("==== Find All Rooms ====");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    //step 22[a-b-c-d-e]: Guest Operation
    //!!! open Guest Entity -reservation

    private static void displayGuestOperationsMenu( ) {
        scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("==== Add New Guest ====");

                    break;
                case 2:
                    System.out.print("Enter the Guest ID to Find: ");
                    break;
                case 3:
                    System.out.println("==== Delete Guest By ID ====");

                    break;
                case 4:
                    System.out.println("==== Find All Guests ====");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayReservationOperationsMenu() {
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Delete Reservation By ID");
            System.out.println("4. Find All Reservations");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("==== Add a new reservation ====");
                    break;
                case 2:
                    System.out.print("Enter the reservation ID: ");
                    break;
                case 3:
                    System.out.println("==== Delete Reservation By ID ====");
                    break;
                case 4:
                    System.out.println("==== Find All Reservations ====");
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


}
