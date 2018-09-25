
package clinicaveterinaria;

public class Cliente {

    
    private int id = -1;
    private String dni;
    private String apellido;
    private String nombre;
    private String direccion;
    private String telefono;
    private String personaAlternativa;
    
    public Cliente(int id, String dni, String apellido, String nombre, String direccion, String telefono, String personaAlternativa) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaAlternativa = personaAlternativa;
    }
  
    public Cliente(String dni, String apellido, String nombre, String telefono) {
        this.id = -1;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Cliente (){
        this.id = -1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPersonaAlternativa() {
        return personaAlternativa;
    }

    public void setPersonaAlternativa(String personaAlternativa) {
        this.personaAlternativa = personaAlternativa;
    }
    
}
