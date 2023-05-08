package triangulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase principal de conexión a Base de Datos.
 * @author Marcos
 */
public  class Conexion {

    private Connection con = null; //Conexión con Base de Datos.
    private String msgError = null; //Mensaje de error.

    /**
     * Devolución del error
     * @return Mensaje de error.
     */
    public String getMsgError() {
        return msgError;
    }

    /**
     * Captura del mensaje de error, es protegido porque se utiliza en la clase hija.
     * @param err  Mensaje de error.
     */
    protected void setMsgError(String err) {
        this.msgError=err;
    }
    
    //Devolución de la conexión, es protegido porque se utiliza en la clase hija
    protected Connection getCon() {
        return this.con;
    }

    /**
     * Constructor.
     * @param db Nombre de la Base de Datos.
     * @param user Usuario con el que te vas a conectar.
     * @param pass Contraseña de la Base de Datos.
     */
    public Conexion(String db, String user, String pass) {

        conectar(db, user, pass);
    }

    /**
     * Devolución del estado de la conexión. Protected ya que es para uso interno.
     * @return Si está abierta la conexión.
     */
    protected boolean isOpen() {

        try {

            boolean ret = false;

            if (this.con != null) { //Si conexión no es null.

                ret = this.con.isValid(3); //Si conexión está abierta: True, si no False.
            }
            return ret; //Devolución de la conexión.
        } catch (SQLException e) {

            this.msgError = e.getMessage(); //Si error, capturo el mensaje de error y lo asigno.
            return false; //Devuelvo falso.
        }

    }

    /**
     * Conexión con Base de Datos.
     * @param db Nombre de la Base de Datos.
     * @param user Usuario que se va a conectar.
     * @param pass  Contraseña.
     */
    private void conectar(String db, String user, String pass) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); //Establezco el Driver.
            String cadenaCon = "jdbc:mysql://localhost/" + db; //Establezco la cadena de conexión.
            this.con = DriverManager.getConnection(cadenaCon, user, pass); //Establezco la conexión.

        } catch (ClassNotFoundException e) { //Captura de la excepción, si no se encuentra el Class.forName.

            this.msgError = e.getMessage(); //Capturo el mensaje de error.
        } catch (SQLException e) { //Captura de errores de SQL.

            this.msgError = e.getMessage(); //Captura del error.
        }
    }

    /**
     * Destructor de la clase
     */
    @Override
    protected  void finalize()
    {
        try {

            if (isOpen() == true) { //Si conexión abierta.

                this.con.close(); //La cierro.
            }
        } catch (SQLException e) { //Captura del mensaje de error de SQL.

            this.msgError = e.getMessage(); //Captura del error
        }
    }

}
