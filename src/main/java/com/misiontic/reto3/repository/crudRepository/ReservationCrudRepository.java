package com.misiontic.reto3.repository.crudRepository;

import com.misiontic.reto3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
