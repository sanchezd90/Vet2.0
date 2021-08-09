
package Controladores;


import Clases.*;
import Modelos.*;

public class ControladorPagos {
    ModeloPagos modeloPagos;
    
    public ControladorPagos(){
        this.modeloPagos = new ModeloPagos();
    }
    
    public boolean agregarPago(clsPago pago){
        try{
            modeloPagos.agregarPago(pago);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    public clsPago getPago(int idPago){
        clsPago p=null;
        try{
            p = modeloPagos.getPago(idPago);            
            return p;
        }catch(Exception e){
            return null;
        }
    } 
    
    public boolean setPago(clsPago pago){
        try{
            modeloPagos.setPago(pago);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
    public boolean eliminarPago(int idPago){
        try{
            modeloPagos.eliminarPago(idPago);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
}
