
package Controladores;

import Clases.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorPlanes {
      ModeloPlanes modeloPlanes;

    public ControladorPlanes() {
        this.modeloPlanes = new ModeloPlanes();  
    }
    
    public boolean agregarPlan(clsPlan plan){
        try{
            modeloPlanes.agregarPlan(plan);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    public clsPlan getPlan(String nombre){
        clsPlan p=null;
        try{
            p = modeloPlanes.getPlan(nombre);
            return p;
        }catch(Exception e){
            return null;
        }
    } 
    
    public boolean setPlan(clsPlan plan){
        try{
            modeloPlanes.setPlan(plan);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
    public boolean eliminarPlan(String nombre){
        try{
            modeloPlanes.eliminarPlan(nombre);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    public List<clsPlan> getAllPlanes(){
        List<clsPlan> planes=new ArrayList();
        try{
            planes = modeloPlanes.getAllPlanes();
            return planes;
        }catch(Exception e){
            return null;
        }
    }
    
}
