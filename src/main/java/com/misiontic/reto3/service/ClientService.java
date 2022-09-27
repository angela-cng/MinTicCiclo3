package com.misiontic.reto3.service;

import com.misiontic.reto3.entities.Client;
import com.misiontic.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client b){
        if(b.getIdClient()==null){
            return clientRepository.save(b);
        }else{
            Optional<Client> e= clientRepository.getClient(b.getIdClient());
            if(e.isEmpty()){
                return clientRepository.save(b);
            }else{
                return b;
            }
        }
    }

    public Client update(Client b){
        if(b.getIdClient()!=null){
            Optional<Client> q= clientRepository.getClient(b.getIdClient());
            if(!q.isEmpty()){
                if (b.getName()!=null){
                    q.get().setName(b.getName());
                }
                if(b.getEmail()!=null){
                    q.get().setEmail(b.getEmail());
                }
                if(b.getPassword()!=null){
                    q.get().setPassword(b.getPassword());
                }
                if(b.getAge()!=null){
                    q.get().setAge(b.getAge());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return b;
            }
        }else{
            return b;
        }

    }

    public boolean deleteClient(int id){
        Boolean flag=false;
        Optional<Client> b= clientRepository.getClient(id);
        if(b.isPresent()){
            clientRepository.delete(b.get());
            flag=true;
        }
        return flag;
    }
}
