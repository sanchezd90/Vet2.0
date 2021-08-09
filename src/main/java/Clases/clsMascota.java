
package Clases;

public class clsMascota {
    private int codigoMascota;
    private String nombreMascota;
    private int edadMascota;
    private float pesoMascota;
    private String especieMascota;
    private clsCliente duenoMascota;

    public clsMascota(int codigoMascota, String nombreMascota, int edadMascota, float pesoMascota, String especieMascota, clsCliente duenoMascota) {
        this.codigoMascota = codigoMascota;
        this.nombreMascota = nombreMascota;
        this.edadMascota = edadMascota;
        this.pesoMascota = pesoMascota;
        this.especieMascota = especieMascota;
        this.duenoMascota = duenoMascota;
    }
    
    public clsMascota(String nombreMascota, int edadMascota, float pesoMascota, String especieMascota, clsCliente duenoMascota) {
        this.nombreMascota = nombreMascota;
        this.edadMascota = edadMascota;
        this.pesoMascota = pesoMascota;
        this.especieMascota = especieMascota;
        this.duenoMascota = duenoMascota;
    }
    

    public int getCodigoMascota() {
        return codigoMascota;
    }


    public void setCodigoMascota(int codigoMascota) {
        this.codigoMascota = codigoMascota;
    }


    public String getNombreMascota() {
        return nombreMascota;
    }


    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }


    public int getEdadMascota() {
        return edadMascota;
    }


    public void setEdadMascota(int edadMascota) {
        this.edadMascota = edadMascota;
    }


    public float getPesoMascota() {
        return pesoMascota;
    }


    public void setPesoMascota(float pesoMascota) {
        this.pesoMascota = pesoMascota;
    }


    public String getEspecieMascota() {
        return especieMascota;
    }


    public void setEspecieMascota(String especieMascota) {
        this.especieMascota = especieMascota;
    }


    public clsCliente getDuenoMascota() {
        return duenoMascota;
    }


    public void setDuenoMascota(clsCliente duenoMascota) {
        this.duenoMascota = duenoMascota;
    }
    
    
    
}
