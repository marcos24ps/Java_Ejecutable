/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triangulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class Alumnos extends Conexion{
    
    public Alumnos(String db, String user, String pass) {
        super(db, user, pass);
    }
    
    public StringBuilder select_alumnos(){
    
        return sel_alumnos(-1);
    }
    
    public StringBuilder select_alumnos(int id){
    
        return sel_alumnos(id);
    }
    
    private StringBuilder sel_alumnos(int id){
        
        try{
            
            PreparedStatement ps=getCon().prepareStatement("alumnos_sel(?)");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            
            if(rs==null){
                
                throw new SQLException("No se han encontrado datos");
            }
            
            StringBuilder sb=new StringBuilder();
            while(rs.next()){
                
                sb.append(rs.getString(1));
                
            }
            
            rs.close();
            return sb;
            
        }
        catch(SQLException e){
            setMsgError(e.getMessage());
            return null;
        }
    }
    
}
