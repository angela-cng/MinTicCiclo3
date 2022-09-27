package com.misiontic.reto3.service;

import com.misiontic.reto3.entities.Message;
import com.misiontic.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message b){
        if(b.getIdMessage()==null){
            return messageRepository.save(b);
        }else{
            Optional<Message> e= messageRepository.getMessage(b.getIdMessage());
            if(e.isEmpty()){
                return messageRepository.save(b);
            }else{
                return b;
            }
        }
    }

    public Message update(Message b){
        if(b.getIdMessage()!=null){
            Optional<Message> q= messageRepository.getMessage(b.getIdMessage());
            if(!q.isEmpty()){
                if (b.getMessageText()!=null){
                    q.get().setMessageText(b.getMessageText());
                }

                messageRepository.save(q.get());
                return q.get();
            }else{
                return b;
            }
        }else{
            return b;
        }

    }

    public boolean deleteMessage(int id){
        Boolean flag=false;
        Optional<Message> b= messageRepository.getMessage(id);
        if(b.isPresent()){
            messageRepository.delete(b.get());
            flag=true;
        }
        return flag;
    }
}
