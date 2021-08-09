
package Clases;

import java.util.ArrayList;
import java.util.List;

public class clsCliente {
    private int idCliente;
    private String documentoCliente;
    private String nombresCliente;
    private String apellidosCliente;
    private String direccionCliente;
    private String telefonoCliente;
    
    private List<clsMascota> mascotas;

    public clsCliente(String documentoCliente, String nombresCliente, String apellidosCliente, String direccionCliente, String telefonoCliente) {
        this.documentoCliente = documentoCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.mascotas = new ArrayList<clsMascota>();
    }
    
    public clsCliente(int idCliente, String documentoCliente, String nombresCliente, String apellidosCliente, String direccionCliente, String telefonoCliente) {
        this.idCliente = idCliente;
        this.documentoCliente = documentoCliente;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.mascotas = new ArrayList<clsMascota>();
    }

    public void asignarMascota(clsMascota mascota){
        this.getMascotas().add(mascota);
        mascota.setDuenoMascota(this);
    }
    
    public void eliminarMascota(clsMascota mascota){
        this.mascotas.remove(mascota);
    }
    
    public String getDocumentoCliente() {
        return documentoCliente;
    }


    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }


    public String getNombresCliente() {
        return nombresCliente;
    }


    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }


    public String getApellidosCliente() {
        return apellidosCliente;
    }


    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }


    public String getDireccionCliente() {
        return direccionCliente;
    }


    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }


    public String getTelefonoCliente() {
        return telefonoCliente;
    }


    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }


    public List<clsMascota> getMascotas() {
        return mascotas;
    }


    public void setMascotas(List<clsMascota> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
