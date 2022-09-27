package com.misiontic.reto3.service;

import com.misiontic.reto3.entities.Reservation;
import com.misiontic.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation b){
        if(b.getIdReservation()==null){
            b.setStatus("created");
            return reservationRepository.save(b);
        }else{
            Optional<Reservation> e= reservationRepository.getReservation(b.getIdReservation());
            if(e.isEmpty()){
                b.setStatus("created");
                return reservationRepository.save(b);
            }else{
                return b;
            }
        }
    }

    public Reservation update(Reservation b){
        if(b.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getReservation(b.getIdReservation());
            if(!q.isEmpty()){
                if (b.getStartDate()!=null){
                    q.get().setStartDate(b.getStartDate());
                }
                if(b.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(b.getDevolutionDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return b;
            }
        }else{
            return b;
        }

    }

    public boolean deleteReservation(int id){
        Boolean flag=false;
        Optional<Reservation> b=reservationRepository.getReservation(id);
        if(b.isPresent()){
            reservationRepository.delete(b.get());
            flag=true;
        }
        return flag;
    }
}
