package clinicaveterinaria;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class Conexion {
    
    public static void main(String[] args){
        
        String url = "jdbc:mysql://localhost/veterinaria";
        String usuario = "root";
        String password = "";
        Connection conexion;
        PreparedStatement ps;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
            
        //CREATE
            ps = conexion.prepareStatement("INSERT INTO cliente (nombre) VALUES ( ? );");
            ps.setString(1, "Lucero");
            ps.executeUpdate();
            ps.close();
        
        //UPDATE
                /*ps=conexion.prepareStatement("UPDATE alumno SET activo=0");
                ps.executeUpdate();
                ps.close();*/
        
        //DELETE
        /*ps=conexion.prepareStatement("DELETE FROM alumno where ID=?;");
        ps.setInt(1, 2);
        ps.executeUpdate();
        ps.close();*/
        
        //READ
        /*ps=conexion.prepareStatement("SELECT * FROM alumno");
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            System.out.println("Nombre: "+rs.getString(2));
        }
        ps.close();*/
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
