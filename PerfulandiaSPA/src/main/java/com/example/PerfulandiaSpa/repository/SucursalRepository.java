package com.example.perfulandia.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.perfulandia.Model.Sucursal;

@Repository
public class SucursalRepository {

    public Sucursal BuscarPorId(int id){
        for (Sucursal sucursal : ListaSucursal) {
            if (sucursal.getId()==id) {
                return sucursal;
            }
        }
        return null;
    }

    public List<Sucursal> listarSucursales(){
        return ListaSucursal;
    }

     private List<Sucursal> ListaSucursal=new ArrayList<>();

        public Sucursal actualizar(Sucursal suc){
        int id=0;
        int posicion=0;
        for (int i = 0; i < ListaSucursal.size(); i++) {
            if (ListaSucursal.get(i).getId()==suc.getId()) {
                id=suc.getId();
                posicion=1;
            }
        }
        Sucursal sucu=new Sucursal();
        sucu.setId(id);
        sucu.setDireccion(suc.getDireccion());
        sucu.setHoraApertura(suc.getHoraApertura());
        sucu.setHoraCierre(suc.getHoraCierre());
        ListaSucursal.set(posicion,sucu);
        return sucu;
    }
}
