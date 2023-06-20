package com.fatec.prova2023java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.prova2023java.entities.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Integer>{
    
}
