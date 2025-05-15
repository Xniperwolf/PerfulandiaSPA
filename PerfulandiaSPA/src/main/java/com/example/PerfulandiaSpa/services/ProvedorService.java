package com.example.PerfulandiaSpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PerfulandiaSpa.model.Provedor;
import com.example.PerfulandiaSpa.repository.ProvedorRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProvedorService {
    @Autowired
    private ProvedorRepositoryJPA provedorRepository;

    public List<Provedor> getProvedor(){
        return provedorRepository.findAll();
    }

    public Provedor getProvedorById(int id){
        return provedorRepository.findById(id);
    }

    public Provedor saveProvedor(Provedor prov){
        return provedorRepository.save(prov);
    }

    public Provedor updateProvedor(Provedor prov){
        return provedorRepository.save(prov);

    }

    public String deleteProvedor(Provedor prov){
        provedorRepository.delete(prov);
        return "Provedor eliminado....";
    }

}
