package Modelos;

import Clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class ModeloPagos {
    DBData dbData;
    ModeloMascotas modeloMascotas;
    ModeloPlanes modeloPlanes;    

    public ModeloPagos() {
        this.dbData = new DBData();
        this.modeloMascotas = new ModeloMascotas();
        this.modeloPlanes = new ModeloPlanes();
        
    }
    
    public boolean agregarPago(clsPago pago){
        
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO pagos (monto,cuotas,fecha,idMascota,idPlan) VALUES (?,?,?,?,?)";
            PreparedStatement statementPago = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPago.setFloat(1, pago.getMonto());
            statementPago.setInt(2, pago.getCuotas());
            System.out.println("Lo que setea en el modelo - "+pago.getCuotas());
            statementPago.setString(3, pago.getFecha());
            statementPago.setInt(4, pago.getMascotaPago().getCodigoMascota());
            statementPago.setInt(5, pago.getPlanPago().getCodigoPlan());
            int rowsInserted = statementPago.executeUpdate();
            if (rowsInserted >0){
                System.out.println("Conexión exitosa");
                return true;
            }
            System.out.println("Error en la conexion");
            return false;
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
     
    public clsPago getPago(int idPago){
        clsPago p= null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM pagos JOIN plan ON pagos.idPlan = plan.idPlan WHERE idPago = ?";
            PreparedStatement statementPago = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPago.setInt(1, idPago);
            ResultSet result = statementPago.executeQuery();
            while (result.next()){
                
                float monto = result.getFloat(2);
                int cuotas = result.getInt(3);
                String fecha = result.getString(4);
                int idMascota = result.getInt(5);
                int idPlan = result.getInt(6);
                String nombrePlan = result.getString(8);
                clsMascota mascota = this.modeloMascotas.getMascota(idMascota);
                clsPlan plan = this.modeloPlanes.getPlan(nombrePlan);
                p = new clsPago(monto,cuotas,fecha,mascota,plan);
            }
            return p;
        } catch (SQLException e){            
            return p;
        }    
    } 
    
    public boolean setPago(clsPago pago){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "UPDATE pagos SET monto = ?, cuotas= ?, fecha = ?, idMascota = ?, idPlan = ? WHERE idPago = ?";
            PreparedStatement statementPago = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementPago.setFloat(1, pago.getMonto());
            statementPago.setInt(2, pago.getCuotas());
            statementPago.setString(3, pago.getFecha());
            statementPago.setInt(4, pago.getMascotaPago().getCodigoMascota());
            statementPago.setInt(5, pago.getPlanPago().getCodigoPlan());
            statementPago.setInt(6, pago.getIdPago());
            int rowsUpdated = statementPago.executeUpdate();
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
    public boolean eliminarPago(int idPago){
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            conn.setAutoCommit(false);
            Savepoint savePoint = conn.setSavepoint("deletePoint");
            try{
                String query = "DELETE FROM pagos WHERE idPago = ?";
                PreparedStatement statementPago = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                statementPago.setInt(1, idPago);
                int rowsUpdated = statementPago.executeUpdate();
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