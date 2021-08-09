package Modelos;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloMascotas {
    DBData dbData;
    

    public ModeloMascotas() {
        this.dbData = new DBData();
        
    }
    
    public boolean agregarMascota(clsMascota mascota){
        
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO mascotas (nombre,edad,peso,especie,idCliente) VALUES (?,?,?,?,?)";
            PreparedStatement statementMascota = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementMascota.setString(1, mascota.getNombreMascota());
            statementMascota.setInt(2, mascota.getEdadMascota());
            statementMascota.setFloat(3, mascota.getPesoMascota());
            statementMascota.setString(4, mascota.getEspecieMascota());
            statementMascota.setInt(5, mascota.getDuenoMascota().getIdCliente());

            int rowsInserted = statementMascota.executeUpdate();
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
     
    public clsMascota getMascota(int idMascota){
        clsMascota m= null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM mascotas JOIN cliente ON mascotas.idCliente = cliente.idCliente WHERE idMascota = ?";
            PreparedStatement statementMascota = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementMascota.setInt(1, idMascota);
            ResultSet result = statementMascota.executeQuery();
            while (result.next()){
                String nombre = result.getString(2);
                int edad = result.getInt(3);
                float peso = result.getFloat(4);
                String especie = result.getString(5);
                String documentoCliente = result.getString(8);
                String nombresCliente = result.getString(9);
                String apellidosCliente = result.getString(10);
                String direccion = result.getString(11);
                String telefono = result.getString(12);
                clsCliente c = new clsCliente(documentoCliente,nombresCliente,apellidosCliente,direccion,telefono);
                m = new clsMascota(idMascota,nombre,edad,peso,especie,c);
            }
            return m;
        } catch (SQLException e){
            return m;
        }    
    } 
    
    public boolean setMascota(clsMascota mascota){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE mascotas SET nombre = ?, edad = ?, peso = ?, especie = ? WHERE documento = ?";
            PreparedStatement statementMascota = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementMascota.setString(1, mascota.getNombreMascota());
            statementMascota.setInt(2, mascota.getEdadMascota());
            statementMascota.setFloat(3, mascota.getPesoMascota());
            statementMascota.setString(4, mascota.getEspecieMascota());
            statementMascota.setInt(1, mascota.getDuenoMascota().getIdCliente());
            int rowsUpdated = statementMascota.executeUpdate();
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
    public boolean eliminarMascota(int idMascota){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");
            try{
                String query = "DELETE FROM mascotas WHERE idMascota = ?";
                PreparedStatement statementMascota = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                statementMascota.setInt(1, idMascota);
                int rowsUpdated = statementMascota.executeUpdate();
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
    
    public List getMascotasCliente(String documento){
        List mascotas = new ArrayList();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT idMascota, nombre FROM mascotas JOIN cliente ON mascotas.idCliente = cliente.idCliente WHERE cliente.documento = ?";
            PreparedStatement statementCliente = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementCliente.setString(1, documento);
            ResultSet result = statementCliente.executeQuery();
            while (result.next()){
                String datos="";
                int idMascota = result.getInt(1);
                datos = datos + idMascota + " - ";
                String nombre = result.getString(2);
                datos= datos + nombre;
                mascotas.add(datos);
            }
            return mascotas;
        } catch (SQLException e){
            return mascotas;
        }    
    } 

}