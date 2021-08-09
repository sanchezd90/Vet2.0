package Modelos;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class ModeloClientes {
    DBData dbData;
    
    

    public ModeloClientes() {
        this.dbData = new DBData();
        
        
    }
    
    public boolean agregarCliente(clsCliente cliente){
        
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO cliente (documento,nombres,apellidos,direccion,telefono) VALUES (?,?,?,?,?)";
            PreparedStatement statementCliente = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementCliente.setString(1, cliente.getDocumentoCliente());
            statementCliente.setString(2, cliente.getNombresCliente());
            statementCliente.setString(3, cliente.getApellidosCliente());
            statementCliente.setString(4, cliente.getDireccionCliente());
            statementCliente.setString(5, cliente.getTelefonoCliente());
            int rowsInserted = statementCliente.executeUpdate();
            if (rowsInserted >0){
                System.out.println("Conexión exitosa");
                return true;
            }
            System.out.println("Error en la conexion");
            return false;
        } catch (SQLException e){
            return false;
        }
    }
     
    public clsCliente getCliente(String documento){
        clsCliente c= null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM cliente WHERE documento = ?";
            PreparedStatement statementCliente = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementCliente.setString(1, documento);
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){
                int idCliente = result.getInt(1);
                String nombres = result.getString(3);
                String apellidos = result.getString(4);
                String direccion = result.getString(5);
                String telefono = result.getString(6);
                c = new clsCliente(idCliente,documento,nombres,apellidos,direccion,telefono);
            }
            return c;
        } catch (SQLException e){
            return c;
        }    
    } 
    
    public boolean setCliente(clsCliente cliente){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE cliente SET nombres = ?, apellidos = ?, direccion = ?, telefono = ? WHERE documento = ?";
            PreparedStatement statementCliente = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementCliente.setString(1, cliente.getNombresCliente());
            statementCliente.setString(2, cliente.getApellidosCliente());
            statementCliente.setString(3, cliente.getDireccionCliente());
            statementCliente.setString(4, cliente.getTelefonoCliente());
            statementCliente.setString(5, cliente.getDocumentoCliente());
            int rowsUpdated = statementCliente.executeUpdate();
            if (rowsUpdated >0){
                System.out.println("Conexión exitosa");
                return true;
            }
            System.out.println("Error en la conexion");
            return false;
        } catch (SQLException e){
            return false;
        }
        
    } 
    public boolean eliminarCliente(String documento){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");
            try{
                String query = "DELETE FROM cliente WHERE documento = ?";
                PreparedStatement statementCliente = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                statementCliente.setString(1, documento);
                int rowsUpdated = statementCliente.executeUpdate();
                conn.commit();
                return rowsUpdated > 0;
            }catch(Exception e){                
                conn.rollback(savePoint);
            }
        } catch (SQLException e){
            return false;
        }
        return false;
    } 
    
      
}