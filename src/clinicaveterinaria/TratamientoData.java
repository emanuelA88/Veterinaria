
package clinicaveterinaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TratamientoData {
    private Connection connection = null;

    public TratamientoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error conexion");
        }
    }
    
    //ALTA NUEVO TRATAMIENTO
    public void guardarTratamiento(Tratamiento tratamiento){
        try {
            
            String sql = "INSERT INTO tratamiento (tipo, descripcion, activo, importe) VALUES ( ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, tratamiento.getTipo());
            statement.setString(2, tratamiento.getDescripcion());
            statement.setBoolean(3, tratamiento.getActivo());
            statement.setDouble(4, tratamiento.getImporte());            
            statement.executeUpdate();           
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                tratamiento.setIdTratamiento(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar el tratamiento");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar el tratamiento: " + ex.getMessage());
        }
    }
    
    //BAJA TRATAMIENTO
    public void borrarTratamiento(int id){
    try {
            
            String sql = "DELETE FROM tratamiento WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar el tratamiento: " + ex.getMessage());
        }
        
    
    }
    
    //MODIFICACION TRATAMIENTO
    public void actualizarTratamiento (Tratamiento tratamiento){
    
        try {
            
            
            String sql = "UPDATE tratamiento SET tipo = ?, descripcion = ?, activo = ?, importe = ?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, tratamiento.getTipo());
            statement.setString(2, tratamiento.getDescripcion());
            statement.setBoolean(3, tratamiento.getActivo());
            statement.setDouble(4, tratamiento.getImporte());
            
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar el tratamiento: " + ex.getMessage());
        }
    }
    
    
    public List<Tratamiento> obtenerTratamientos(){
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
            

        try {
            String sql = "SELECT * FROM tratamiento;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Tratamiento tratamiento;
            while(resultSet.next()){
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(resultSet.getInt("idTratamiento"));
                tratamiento.setTipo(resultSet.getString("tipo"));
                tratamiento.setDescripcion(resultSet.getString("descripcion"));
                tratamiento.setActivo(resultSet.getBoolean("activo"));
                tratamiento.setImporte(resultSet.getDouble("importe"));
                tratamientos.add(tratamiento);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tratamientos: " + ex.getMessage());
        }
        
        
        return tratamientos;
    }

    public Tratamiento buscarTratamiento(int id){
    Tratamiento tratamiento=null;
    try {  
            String sql = "SELECT * FROM tratamiento WHERE id =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                 tratamiento = new Tratamiento();
                tratamiento.setIdTratamiento(resultSet.getInt("idTratamiento"));
                tratamiento.setTipo(resultSet.getString("tipo"));
                tratamiento.setDescripcion(resultSet.getString("descripcion"));
                tratamiento.setActivo(resultSet.getBoolean("activo"));
                tratamiento.setImporte(resultSet.getDouble("importe"));
                
            }      
            statement.close();    
        } catch (SQLException ex) {
            System.out.println("Error al buscar el tratamiento: " + ex.getMessage());
        }
        return tratamiento;
    }
}

