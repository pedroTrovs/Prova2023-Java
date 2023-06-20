package com.fatec.prova2023java.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.prova2023java.entities.Empresa;
import com.fatec.prova2023java.services.EmpresaService;

@RestController
@CrossOrigin
@RequestMapping("empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa obj){
        Empresa resposta = empresaService.save(obj);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(obj.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(resposta);
    }

    @GetMapping
    public List<Empresa> getEmpresas(){
       return empresaService.getAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable int id){
        empresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    } 
}
