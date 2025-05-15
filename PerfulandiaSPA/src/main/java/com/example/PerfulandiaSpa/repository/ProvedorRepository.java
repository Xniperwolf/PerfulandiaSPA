package com.example.PerfulandiaSpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.PerfulandiaSpa.model.Provedor;

@Repository
public class ProvedorRepository {
    private List<Provedor> ListaProvedor=new ArrayList<>();

    public Provedor BuscarporId(int id){
        for (Provedor provedor : ListaProvedor) {
            if (provedor.getId()==id) {
                return provedor;
            }
        }
        return null;
    }

    public List<Provedor> listaProvedors(){
        return ListaProvedor;
    }

    public Provedor actualizar(Provedor prov){
        int id=0;
        int posicion=0;
        for (int i = 0; i < ListaProvedor.size(); i++) {
            if (ListaProvedor.get(i).getId()==prov.getId()) {
                id=prov.getId();
                posicion=1;
            }
        }
        Provedor prove= new Provedor();
        prove.setContacto(prov.getContacto());
        prove.setDireccion(prov.getDireccion());
        prove.setEmail(prov.getEmail());
        prove.setNombre(prov.getNombre());
        prove.setTelefono(prov.getTelefono());
        ListaProvedor.set(posicion, prove);
        return prove;
    }
    public Provedor agregaProvedor(Provedor prov){
        ListaProvedor.add(prov);
        return prov; 
    }

    public void eliminar(int id){
        Provedor prov=BuscarporId(id);
        if (prov!=null) {
            ListaProvedor.remove(prov);
        }
        
    }
}
