package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomRepositoryImpl implements RoomRepository{

    //step18b : saeRoom
    @Override
    public Room saveRoom(Room room) {

        try (Session session = HibernateUtils.getSessionFactory().openSession()){

            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
            session.close();

            return room;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
