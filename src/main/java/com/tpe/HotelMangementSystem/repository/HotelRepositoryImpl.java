package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
