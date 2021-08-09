
package Clases;


public class clsPago {
    private int idPago;
    private float monto;
    private int cuotas;
    private String fecha;
    private clsMascota mascotaPago;
    private clsPlan planPago;

    public clsPago (float monto, int cuotas, String fecha,clsMascota mascotaPago,clsPlan planPago){
        this.monto = monto;
        this.cuotas = cuotas;
        this.fecha = fecha;
        this.mascotaPago = mascotaPago;
        this.planPago = planPago;
    }
    public clsPago (int idPago, float monto, int cuotas, String fecha,clsMascota mascotaPago,clsPlan planPago){
        this.idPago = idPago;
        this.monto = monto;
        this.cuotas = cuotas;
        this.fecha = fecha;
        this.mascotaPago = mascotaPago;
        this.planPago = planPago;
    }
    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @return the cuotas
     */
    public int getCuotas() {
        return cuotas;
    }

    /**
     * @param cuotas the cuotas to set
     */
    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the mascotaPago
     */
    public clsMascota getMascotaPago() {
        return mascotaPago;
    }

    /**
     * @param mascotaPago the mascotaPago to set
     */
    public void setMascotaPago(clsMascota mascotaPago) {
        this.mascotaPago = mascotaPago;
    }

    /**
     * @return the planPago
     */
    public clsPlan getPlanPago() {
        return planPago;
    }

    /**
     * @param planPago the planPago to set
     */
    public void setPlanPago(clsPlan planPago) {
        this.planPago = planPago;
    }

    /**
     * @return the idPago
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * @param idPago the idPago to set
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    
    
}
