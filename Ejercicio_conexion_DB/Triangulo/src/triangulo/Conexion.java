package triangulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	private Connection con=null;
	private String msgError=null;
	

	public String getMsgError() {
		return msgError;
	}

	public Conexion(String db,String user,String pass) {
		
		conectar(db,user,pass);
	}
	
	public boolean isOpen() {
		
		try {
			
			boolean ret=false; 
			
			if(this.con!=null) {
				
				ret=this.con.isValid(3);
			}
			return ret;
		}
		catch(SQLException e) {
			
			this.msgError=e.getMessage();
			return false;
		}
		
	}
	
	public String consulta() {
		
		try {
			
			PreparedStatement ps=this.con.prepareStatement("select * from triangulo");
			ResultSet rs=ps.executeQuery();
			StringBuilder sb=new StringBuilder();
			
			while(rs.next()) {
				
				sb.append(" Id:" + rs.getString(1));
				sb.append(" base:" + rs.getString(2));
                                sb.append(" altura:" + rs.getString(3));
				sb.append("\n");
			}

			return sb.toString();
		}
		catch(SQLException e) {
			
			this.msgError=e.getMessage();
			return null;
		}
	}
        
        public boolean insert(){
        
            try {
			
			PreparedStatement ps=this.con.prepareStatement("insert into triangulo(base,altura) values (?,?)");
                        ps.setDouble(1,0.25);
                        ps.setDouble(2,0.59);
			if(ps.executeUpdate()==0){
                            
                            throw new SQLException("No se ha establecido conexión");
                        }
			return true;
		}
		catch(SQLException e) {
			
			this.msgError=e.getMessage();
			return false;
		}
        }
	
	private void conectar(String db,String user,String pass) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String cadenaCon = "jdbc:mysql://localhost/" + db;
			this.con = DriverManager.getConnection(cadenaCon,user,pass);

		} catch (ClassNotFoundException e) {
			
			this.msgError=e.getMessage();
		} catch (SQLException e) {
			
			this.msgError=e.getMessage();
		}
	}
	
	@Override
	protected void finalize() {
		
		try {
			
			if(isOpen()==true) {
				
				this.con.close();
			}
		}
		catch(SQLException e) {
			
			this.msgError=e.getMessage();
		}
	}
	

}
