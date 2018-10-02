package clinicaveterinaria;

public class Tratamiento {
  
    private int idTratamiento = -1;
    private String tipo;
    private String descripcion;
    private boolean activo;
    private double importe;

    public Tratamiento(String tipo, String descripcion, boolean activo, double importe) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.activo = activo;
        this.importe = importe;
    }
    
    public Tratamiento (){
    
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
 
}
