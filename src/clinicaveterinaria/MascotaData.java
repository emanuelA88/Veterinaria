
package clinicaveterinaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MascotaData {
    private Connection connection = null;

    public MascotaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error conexion");
        }
    }
    
    //ALTA NUEVA MASCOTA
    public void guardarMascota(Mascota mascota){
        try {
            
            String sql = "INSERT INTO mascota (alias, especie, sexo, raza, colorPelo, fecNac, pesoMedio, pesoActual) VALUES ( ? , ? , ? , ? , ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, mascota.getAlias());
            statement.setString(2, mascota.getEspecie());
            statement.setString(3, mascota.getSexo());
            statement.setString(4, mascota.getRaza());
            statement.setString(5, mascota.getColorPelo());
            statement.setDate(6, mascota.getFecNac());
            statement.setDouble(7, mascota.getPesoMedio());
            statement.setDouble(8, mascota.getPesoActual());
            
            statement.executeUpdate();           
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mascota.setIdMascota(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar la mascota");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar mascota: " + ex.getMessage());
        }
    }
    
    //BAJA MASCOTA
    public void borrarMascota(int id){
    try {
            
            String sql = "DELETE FROM mascota WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar mascota: " + ex.getMessage());
        }
    }
    
    //MODIFICACION MASCOTA
    public void actualizarMascota (Mascota mascota){
    
        try {
            
            
            String sql = "UPDATE mascota SET alias = ?, especie = ?, sexo = ?, raza = ?, colorPelo = ?, fecNac = ?, pesoMedio = ?, pesoActual = ?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
            statement.setString(1, mascota.getAlias());
            statement.setString(2, mascota.getEspecie());
            statement.setString(3, mascota.getSexo());
            statement.setString(4, mascota.getRaza());
            statement.setString(5, mascota.getColorPelo());
            statement.setDate(6, mascota.getFecNac());
            statement.setDouble(7, mascota.getPesoMedio());
            statement.setDouble(8, mascota.getPesoActual());
            
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar mascota: " + ex.getMessage());
        }
    }
    
    
    public List<Mascota> obtenerMascotas(){
        List<Mascota> mascotas = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM mascota;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mascota mascota;
            while(resultSet.next()){
                mascota = new Mascota();
                mascota.setIdMascota(resultSet.getInt("idMascota"));
                mascota.setAlias(resultSet.getString("alias"));
                mascota.setEspecie(resultSet.getString("especie"));
                mascota.setSexo(resultSet.getString("sexo"));
                mascota.setRaza(resultSet.getString("raza"));
                mascota.setColorPelo(resultSet.getString("colorPelo"));
                mascota.setFecNac(resultSet.getDate("fecNac"));
                mascota.setPesoMedio(resultSet.getDouble("pesoMedio"));
                mascota.setPesoActual(resultSet.getDouble("pesoActual"));
                mascotas.add(mascota);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las mascotas: " + ex.getMessage());
        }
        
        
        return mascotas;
    }

    public Mascota buscarMascota(int id){
    Mascota mascota=null;
    try {  
            String sql = "SELECT * FROM mascota WHERE id =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                 mascota = new Mascota();
                mascota.setIdMascota(resultSet.getInt("idMascota"));
                mascota.setAlias(resultSet.getString("alias"));
                mascota.setEspecie(resultSet.getString("especie"));
                mascota.setSexo(resultSet.getString("sexo"));
                mascota.setRaza(resultSet.getString("raza"));
                mascota.setColorPelo(resultSet.getString("colorPelo"));
                mascota.setFecNac(resultSet.getDate("fecNac"));
                mascota.setPesoMedio(resultSet.getDouble("pesoMedio"));
                mascota.setPesoActual(resultSet.getDouble("pesoActual"));
                
            }      
            statement.close();    
        } catch (SQLException ex) {
            System.out.println("Error al buscar la mascota: " + ex.getMessage());
        }
        return mascota;
    }
}