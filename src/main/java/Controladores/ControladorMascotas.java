
package Controladores;

import Clases.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorMascotas {
      ModeloMascotas modeloMascotas;

    public ControladorMascotas() {
        this.modeloMascotas = new ModeloMascotas();  
    }
    
    public boolean agregarMascota(clsMascota mascota){
        try{
            modeloMascotas.agregarMascota(mascota);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    public clsMascota getMascota(int idMascota){
        clsMascota m=null;
        try{
            m = modeloMascotas.getMascota(idMascota);
            return m;
        }catch(Exception e){
            return null;
        }
    } 
    
    public boolean setMascota(clsMascota mascota){
        try{
            modeloMascotas.setMascota(mascota);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
    public boolean eliminarMascota(int idMascota){
        try{
            modeloMascotas.eliminarMascota(idMascota);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
    public List getMascotasCliente(String documento){
        List mascotas;
        try{
            mascotas = modeloMascotas.getMascotasCliente(documento);
            return mascotas;
        }catch(Exception e){
            return null;
        }
    } 
    
}
