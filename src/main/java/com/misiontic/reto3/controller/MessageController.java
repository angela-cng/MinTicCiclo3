package com.misiontic.reto3.controller;


import com.misiontic.reto3.entities.Message;
import com.misiontic.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int mesId){
        return messageService.getMessage(mesId);
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message b){
        return messageService.save(b);
    }

    @PutMapping("/update")
    public Message update(@RequestBody Message b){
        return messageService.update(b);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int mesId){
        return messageService.deleteMessage(mesId);
    }

}
