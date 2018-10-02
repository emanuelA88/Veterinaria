package clinicaveterinaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitaDeAtencionData {
    private Connection connection = null;

    public VisitaDeAtencionData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error conexion");
        }
    }
    
    //ALTA NUEVA VISITA
    public void guardarVisita(VisitaDeAtencion visita){
        try {
            
            String sql = "INSERT INTO visitadeatencion (fechaDeVisita, pesoMascota, importeTotal) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setDate(1, visita.getFechaDeVisita());
            statement.setDouble(2, visita.getPesoMascota());
            statement.setDouble(3, visita.getImporteTotal());
            
            statement.executeUpdate();           
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                visita.setIdVisita(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar la visita");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar el tratamiento: " + ex.getMessage());
        }
    }
    
    //BAJA VISITA
    public void borrarVisita(int id){
    try {
            
            String sql = "DELETE FROM visitadeatencion WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar la visita: " + ex.getMessage());
        }
        
    
    }
    
    //MODIFICACION VISITA
    public void actualizarVisita (VisitaDeAtencion visita){
    
        try {
            
            
            String sql = "UPDATE visitadeatencion SET fechaDeVisita = ?, pesoMascota = ?, importeTotal = ?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setDate(1, visita.getFechaDeVisita());
            statement.setDouble(2, visita.getPesoMascota());
            statement.setDouble(3, visita.getImporteTotal());
          
            
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar la visita: " + ex.getMessage());
        }
    }
    
    
    public List<VisitaDeAtencion> obtenerVisitas(){
        List<VisitaDeAtencion> visitas = new ArrayList<VisitaDeAtencion>();
            

        try {
            String sql = "SELECT * FROM visitadeatencion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            VisitaDeAtencion visita;
            while(resultSet.next()){
                visita = new VisitaDeAtencion();
                visita.setIdVisita(resultSet.getInt("idVisita"));
                visita.setFechaDeVisita(resultSet.getDate("fechaDeVisita"));
                visita.setPesoMascota(resultSet.getDouble("pesoMascota"));
                visita.setImporteTotal(resultSet.getDouble("importeTotal"));
               
                visitas.add(visita);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las visitas: " + ex.getMessage());
        }
        
        
        return visitas;
    }

    public VisitaDeAtencion buscarVisita(int id){
    VisitaDeAtencion visita=null;
    try {  
            String sql = "SELECT * FROM visitadeatencion WHERE id =?;";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                 visita = new VisitaDeAtencion();
                visita.setIdVisita(resultSet.getInt("idVisita"));
                visita.setFechaDeVisita(resultSet.getDate("fechaDeVisita"));
                visita.setPesoMascota(resultSet.getDouble("pesoMascota"));
                visita.setImporteTotal(resultSet.getDouble("importeTotal"));
              
                
            }      
            statement.close();    
        } catch (SQLException ex) {
            System.out.println("Error al buscar la visita: " + ex.getMessage());
        }
        return visita;
    }
}