package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.exception.HotelResourceNotFoundException;
import com.tpe.HotelMangementSystem.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelRepositoryImpl implements HotelRepository{

    //step13b :implement HotelRepository
    @Override
    public Hotel saveHotel(Hotel hotel) {

        try (
            Session session = HibernateUtils.getSessionFactory().openSession()){
              Transaction transaction = session.beginTransaction();

              session.save(hotel);
              transaction.commit();
              HibernateUtils.closeSession(session);//session.close()
              return hotel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //step 14B findHotelById()
    @Override
    public Hotel findHotelById(Long id) {
        Session session= HibernateUtils.getSessionFactory().openSession();
        return session.get(Hotel.class,id);
    }


    //step 15b; deleteHotelBy id:
    @Override
    public void deleteHotelById(Long id) {

        try (Session session= HibernateUtils.getSessionFactory().openSession()){

            Transaction transaction=session.beginTransaction();

             Hotel deleteHotel =    session.get(Hotel.class,id);

             if (deleteHotel!=null){
                 session.delete(deleteHotel);
                 transaction.commit();
                 HibernateUtils.closeSession(session);
             }else {
                 throw new HotelResourceNotFoundException("Hotel not Found with Id : " +id);
             }

        }catch (HibernateException e){
            e.printStackTrace();
        }

    }


    //step 16b : find All hotels
    @Override
    public List<Hotel> findAllHotels() {
        Session session= HibernateUtils.getSessionFactory().openSession();
            List<Hotel>  hotels  = session.createQuery("FROM Hotel",Hotel.class).getResultList();
             return hotels;
            //return session.createQuery("FROM Hotel",Hotel.class).getResultList();
    }


    //17b :updateHotel

    @Override
    public void updateHotel(Hotel hotel) {

        try (Session session=HibernateUtils.getSessionFactory().openSession()){

            Transaction transaction= session.beginTransaction();

            //load the Hotel Entity using same session

            Hotel existingHotel= session.load(Hotel.class,hotel.getId());
            if (existingHotel!=null){
                existingHotel.setName(hotel.getName());
                existingHotel.setLocation(hotel.getLocation());
                session.update(existingHotel);
            }
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }

    }

}
