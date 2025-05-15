package com.example.PerfulandiaSpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PerfulandiaSpa.model.Provedor;
import com.example.PerfulandiaSpa.services.ProvedorService;

@RestController
@RequestMapping("/api/v1/Provedor")
public class ProvedorController {
    @Autowired
    private ProvedorService provService;

    @GetMapping()
    public ResponseEntity<List<Provedor>> listaProvedor(){
        List<Provedor> provedores= provService.getProvedor();
        if (provedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(provedores);
    }

    @PostMapping()
    public ResponseEntity<Provedor> agregarProvedor(@RequestBody Provedor provedor ){
        Provedor prove=provService.saveProvedor(provedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(prove);
    }

    @GetMapping("{id}")
    public ResponseEntity<Provedor> buscarProvedor(@PathVariable int id){
        try {
            Provedor prov=provService.getProvedorById(id);
            return ResponseEntity.ok(prov);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Provedor> actualizarProvedor(@PathVariable int id, @RequestBody Provedor prov){
        try {
            Provedor prove=provService.updateProvedor(prov);
            
            prove.setContacto(prov.getContacto());
            prove.setDireccion(prov.getDireccion());
            prove.setEmail(prov.getEmail());
            prove.setNombre(prov.getNombre());
            prove.setTelefono(prov.getTelefono());
            provService.saveProvedor(prove);
            return ResponseEntity.ok(prove); 
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping()
    public ResponseEntity<String> eliminarProvedor(@RequestBody Provedor prove){
        try {
            provService.deleteProvedor(prove);
            return ResponseEntity.ok("Provedor eliminado....");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provedor no encontrado");
        }
    }
}
