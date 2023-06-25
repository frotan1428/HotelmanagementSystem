package com.tpe.HotelMangementSystem.model;
//step 9b : Entity  Room

import javax.persistence.*;

@Entity
@Table(name = "tbl_rooms")
public class Room {

    //step 13 : add filed room
    @Id
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    private Hotel hotel;

    //constructor -getter -setter and to string method


    public Room(Long id, String number, int capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
//                ", hotel=" + hotel +
                '}';
    }
}
