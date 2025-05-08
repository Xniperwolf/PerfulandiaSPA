package com.example.perfulandia.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.perfulandia.Model.Sucursal;
import com.example.perfulandia.Service.SucursalService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/v1/Sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;
    @GetMapping()
    public ResponseEntity <List<Sucursal>> listarSucursal() {
        List<Sucursal> sucursales=sucursalService.getSucursal();
        if(sucursales.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sucursales);
    }

    @PutMapping("{id}")
    public ResponseEntity <Sucursal>actualizarSucursal(@PathVariable int id, @RequestBody Sucursal sucu) {
        try {
            Sucursal suc=sucursalService.getSucursalById(id);
            suc.setDireccion(sucu.getDireccion());
            suc.setHoraApertura(sucu.getHoraApertura());
            suc.setHoraCierre(sucu.getHoraCierre());
            sucursalService.saveSucursal(suc);
            return ResponseEntity.ok(suc);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
