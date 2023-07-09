package com.tpe.HotelMangementSystem.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_Guests")
public class Guest {

    //step 22 : add filed about guest

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;


    private LocalDateTime createdDate;// we want see persist /save date

    @PrePersist
    public void PrePersist(){
        createdDate =LocalDateTime.now();
    }


    //getter and setter


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createdDate=" + createdDate +
                '}';
    }


}
