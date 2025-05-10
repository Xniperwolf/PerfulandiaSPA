package com.example.perfulandia.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.perfulandia.Model.Pedido;
import com.example.perfulandia.Service.PedidoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/v1/Pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pediService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> getPedido() {
        List<Pedido> pedidos = pediService.getPedidos();
        if (pedidos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedidos);
    }
    @PostMapping()
    public ResponseEntity<Pedido> postPedido(@RequestBody Pedido ped) {
        Pedido pedi=pediService.savePedido(ped);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedi);
    }
    @GetMapping("{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable int id) {
        try {
            Pedido pedi= pediService.getPedidoById(id);
            return ResponseEntity.ok(pedi)
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido ped) {
        try {
            Pedido pedi= pediService.getPedidoById(id);
            pedi.setEstado(ped.getEstado());
            pedi.setFechaCreacion(ped.getFechaCreacion());
            pedi.setProductos(ped.getProductos());
            pediService.savePedido(pedi);
            return ResponseEntity.ok(pedi);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        
        
    }

    

    
    
}
