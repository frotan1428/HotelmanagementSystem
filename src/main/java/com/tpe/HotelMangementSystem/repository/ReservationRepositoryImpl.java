package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImpl implements ReservationRepository {


    //step26b :saveReservation
    @Override
    public Reservation saveReservation(Reservation reservation) {

        try(Session session= HibernateUtils.getSessionFactory().openSession()) {

          Transaction transaction = session.beginTransaction();

          session.save(reservation);

          transaction.commit();
          return reservation;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
