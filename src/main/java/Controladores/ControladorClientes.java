
package Controladores;

import Clases.*;
import Modelos.*;


public class ControladorClientes {
      ModeloClientes modeloClientes;

    public ControladorClientes() {
        this.modeloClientes = new ModeloClientes();  
    }
    
    public boolean agregarCliente(clsCliente cliente){
        try{
            modeloClientes.agregarCliente(cliente);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    public clsCliente getCliente(String documento){
        clsCliente c=null;
        try{
            c = modeloClientes.getCliente(documento);
            return c;
        }catch(Exception e){
            return null;
        }
    } 
    
    public boolean setCliente(clsCliente cliente){
        try{
            modeloClientes.setCliente(cliente);
            return true;
        }catch(Exception e){
             return false;
        }
    } 
    
    public boolean eliminarCliente(String documento){
        try{
            modeloClientes.eliminarCliente(documento);
            return true;
        }catch(Exception e){
             return false;
        }
    }
    
    
}
