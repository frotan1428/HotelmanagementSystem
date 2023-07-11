package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.GuestResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
//    @Override
//    public Guest findGuestById(Long guestId) {
//
//        Session session=HibernateUtils.getSessionFactory().openSession();
//        return session.get(Guest.class,guestId);
//    }

    @Override
    public Guest findGuestById(Long guestId) {

        try (Session session =HibernateUtils.getSessionFactory().openSession()){

            CriteriaBuilder cb =session.getCriteriaBuilder();
            CriteriaQuery<Guest> criteriaQuery =cb.createQuery(Guest.class);
            Root<Guest> root =criteriaQuery.from(Guest.class);
            criteriaQuery.select(root).where(cb.equal(root.get("id"),guestId)); //WHERE id =guestId;

            return session.createQuery(criteriaQuery).uniqueResult();
        }catch (GuestResourceNotFoundException e){
            e.printStackTrace();
            return null;

        }
    }


}
