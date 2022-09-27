package com.misiontic.reto3.repository;

import com.misiontic.reto3.entities.Boat;
import com.misiontic.reto3.repository.crudRepository.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {

    @Autowired
    private BoatCrudRepository boatCrudRepository;

    public List<Boat> getAll(){
         return (List<Boat>) boatCrudRepository.findAll();
     }

     public Optional<Boat> getBoat(int id){
        return boatCrudRepository.findById(id);
     }

     public Boat save(Boat b){
        return boatCrudRepository.save(b);
     }

     public void delete(Boat b){
        boatCrudRepository.delete(b);
     }
}
