package clinicaveterinaria;

import java.sql.Date;
import java.time.LocalDate;

public class VisitaDeAtencion {
    private int idVisita = -1;
    private Date fechaDeVisita;
    private double pesoMascota;
    private double importeTotal;

    public VisitaDeAtencion(Date fechaDeVisita, double pesoMascota, double importeTotal) {
        this.fechaDeVisita = fechaDeVisita;
        this.pesoMascota = pesoMascota;
        this.importeTotal = importeTotal;
    }
    
    public VisitaDeAtencion(){
    
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Date getFechaDeVisita() {
        return fechaDeVisita;
    }

    public void setFechaDeVisita(Date fechaDeVisita) {
        this.fechaDeVisita = fechaDeVisita;
    }

    public double getPesoMascota() {
        return pesoMascota;
    }

    public void setPesoMascota(double pesoMascota) {
        this.pesoMascota = pesoMascota;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }
    
    
}
