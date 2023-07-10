package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepositoryImpl implements GuestRepository{



    //step 22 b : save Guest
    @Override
    public void saveGuest(Guest guest) {

        try (Session session= HibernateUtils.getSessionFactory().openSession()){

          Transaction transaction= session.beginTransaction();

          //create  a new Address object and set properties

            Address address= new Address();
            address.setStreet(guest.getAddress().getStreet());
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            //set address to Guest
            guest.setAddress(address);

            session.save(guest);

            transaction.commit();
            HibernateUtils.closeSession(session);
//            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //23 b findGuestById
    @Override
    public Guest findGuestById(Long guestId) {

        Session session=HibernateUtils.getSessionFactory().openSession();
        return session.get(Guest.class,guestId);

    }
}
