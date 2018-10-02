
package clinicaveterinaria;

import java.time.LocalDate;
import java.sql.Date;

public class Mascota {
    
    private int idMascota = -1;
    private String alias;
    private String especie;
    private String sexo;
    private String raza;
    private String colorPelo;
    private Date fecNac;
    private double pesoMedio;
    private double pesoActual;

    public Mascota(String alias, String especie, String sexo, String raza, String colorPelo, Date fecNac, double pesoMedio, double pesoActual) {
        this.alias = alias;
        this.especie = especie;
        this.sexo = sexo;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fecNac = fecNac;
        this.pesoMedio = pesoMedio;
        this.pesoActual = pesoActual;
    }
    
    public Mascota(){
        
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }
    
    
}
