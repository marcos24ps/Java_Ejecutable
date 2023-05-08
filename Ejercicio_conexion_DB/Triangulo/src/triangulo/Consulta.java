/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triangulo;

/**
 *
 * @author Marcos
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase Hija. Extiende los métodos de su padre, la clase conexión.
 * @author Marcos
 */
public class Consulta extends Conexion {
    
    /**
     * Constructor de la clase.
     * @param db Nombe de la Base de Datos.
     * @param user Usuario.
     * @param pass Constraseña.
     */
    public Consulta(String db, String user, String pass) {
        super(db, user, pass); //Al ser el hijo, pasa los parámetros al padre, porque se puede llamar al hijo diréctamente.
    }
    
    
    /**
     * Llamada al procedimiento de inserción.
     * @param base Base del Triángulo.
     * @param altura Altura del triángulo.
     * @return True:correcto, False: Incorrecto.
     */
    public boolean procedureInsert(double base, double altura) {

        try {
            PreparedStatement ps = getCon().prepareStatement("call insertar(?,?)"); //Llamada al procedimiento.
            ps.setDouble(1, base); //Establezco el parámetro Base.
            ps.setDouble(2, altura); //Establezco el parámetro Altura.
            ResultSet rs = ps.executeQuery(); //Ejecuto la consulta.

            if (rs == null) { //Si ResulSet nulo.

                throw new SQLException("No se han encontrado datos"); //Provoco un error.
            }

            StringBuilder sb = new StringBuilder(); //StringBuilder para la captura de los datos.

            while (rs.next()) { //Mientras ResulSet tenga datos.

                sb.append(rs.getString(1)); //meto base en StringBuilder.
                sb.append(rs.getString(2)); //Meto altura en StringBuilder.
            }
            
            rs.close(); //Cierro ResulSet
            return true; //Devuelvo true.
        } catch (SQLException e) { //Si error
            setMsgError(e.getMessage()); //Capturo el error con su método padre.
            return false;
        }

    }
    
    /**
     * Finalización de la clase
     */
    protected void finalize(){
        
        super.finalize(); //Llámo al método de su padre.
    }
    
}
