
package Clases;


public class clsPlan {
    private int codigoPlan;
    private String nombrePlan;
    private String descripcionPlan;
    private float precioPlan;

    public clsPlan(String nombrePlan){
        this.nombrePlan = nombrePlan;
    };
    
    public clsPlan(String nombrePlan, String descripcionPlan, float precioPlan) {
        this.nombrePlan = nombrePlan;
        this.descripcionPlan = descripcionPlan;
        this.precioPlan = precioPlan;
    }
    public clsPlan(int codigoPlan, String nombrePlan, String descripcionPlan, float precioPlan) {
        this.codigoPlan = codigoPlan;    
        this.nombrePlan = nombrePlan;
        this.descripcionPlan = descripcionPlan;
        this.precioPlan = precioPlan;
    }


    public int getCodigoPlan() {
        return codigoPlan;
    }


    public void setCodigoPlan(int codigoPlan) {
        this.codigoPlan = codigoPlan;
    }


    public String getNombrePlan() {
        return nombrePlan;
    }


    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }


    public String getDescripcionPlan() {
        return descripcionPlan;
    }

    public void setDescripcionPlan(String descripcionPlan) {
        this.descripcionPlan = descripcionPlan;
    }


    public float getPrecioPlan() {
        return precioPlan;
    }


    public void setPrecioPlan(float precioPlan) {
        this.precioPlan = precioPlan;
    }
    
    
    
}
