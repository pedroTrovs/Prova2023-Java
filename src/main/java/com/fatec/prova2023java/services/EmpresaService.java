package com.fatec.prova2023java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.prova2023java.entities.Empresa;
import com.fatec.prova2023java.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa obj) {
        return empresaRepository.save(obj);
    }
    public List<Empresa> getAll(){
        return empresaRepository.findAll();
    }
}
