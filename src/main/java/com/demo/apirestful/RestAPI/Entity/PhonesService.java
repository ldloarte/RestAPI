package com.demo.apirestful.RestAPI.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonesService {
    @Autowired
    private PhonesRepository phonesRepository;


    public List<Phones> getAllPhones(){
        return phonesRepository.findAll();
    }


    public Phones createPhones(Phones phones){
        return phonesRepository.save(phones);
    }


    public Phones updatePhones(Phones phones){

        return phonesRepository.save(phones);
    }

    public void deletePhones(Long id){
        phonesRepository.deleteById(id);
    }
}