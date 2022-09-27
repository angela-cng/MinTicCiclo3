package com.misiontic.reto3.controller;

import com.misiontic.reto3.entities.Boat;
import com.misiontic.reto3.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Boat")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getBoats(){
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int boatId){
        return boatService.getBoat(boatId);
    }

    @PostMapping("/save")
    public Boat save(@RequestBody Boat b){
        return boatService.save(b);
    }

    @PutMapping("/update")
    public Boat update(@RequestBody Boat b){
        return boatService.update(b);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int boatId){
        return boatService.deleteBoat(boatId);
    }

}
