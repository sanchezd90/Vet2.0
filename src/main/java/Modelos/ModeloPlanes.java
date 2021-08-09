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

public class ModeloPlanes {
    DBData dbData;
    

    public ModeloPlanes() {
        this.dbData = new DBData();
        
    }
    
    public boolean agregarPlan(clsPlan plan){
        
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO plan (nombre,descripcion,precio) VALUES (?,?,?)";
            PreparedStatement statementPlan = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPlan.setString(1, plan.getNombrePlan());
            statementPlan.setString(2, plan.getDescripcionPlan());
            statementPlan.setFloat(3, plan.getPrecioPlan());
            int rowsInserted = statementPlan.executeUpdate();
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
     
    public clsPlan getPlan(String nombre){
        clsPlan p= null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM plan WHERE nombre = ?";
            PreparedStatement statementPlan = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPlan.setString(1, nombre);
            ResultSet result = statementPlan.executeQuery();
            while (result.next()){
                int idPlan = result.getInt(1);
                String nombrePlan = result.getString(2);
                String descripcionPlan = result.getString(3);
                float precioPlan = result.getFloat(4);
                p = new clsPlan(idPlan,nombrePlan,descripcionPlan,precioPlan);
            }
            return p;
        } catch (SQLException e){
            return p;
        }    
    } 
    
    public boolean setPlan(clsPlan plan){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE plan SET descripcion = ?, precio = ? WHERE nombre = ?";
            PreparedStatement statementPlan = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPlan.setString(1, plan.getDescripcionPlan());
            statementPlan.setFloat(2, plan.getPrecioPlan());
            statementPlan.setString(3, plan.getNombrePlan());
            int rowsUpdated = statementPlan.executeUpdate();
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
    public boolean eliminarPlan(String nombre){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");
            try{
                String query = "DELETE FROM plan WHERE nombre = ?";
                PreparedStatement statementPlan = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                statementPlan.setString(1, nombre);
                int rowsUpdated = statementPlan.executeUpdate();
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

    public List<clsPlan> getAllPlanes(){
        List<clsPlan> planes = new ArrayList();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM plan";
            PreparedStatement statementPlan = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);            
            ResultSet result = statementPlan.executeQuery();
            while (result.next()){                
                int idPlan = result.getInt(1);
                String nombrePlan = result.getString(2);
                String descripcionPlan = result.getString(3);
                float precioPlan = result.getFloat(4);
                clsPlan p = new clsPlan(nombrePlan,descripcionPlan,precioPlan);
                planes.add(p);
            }
            return planes;
        } catch (SQLException e){
            return planes;
        }    
    } 
      
}