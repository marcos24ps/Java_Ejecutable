private String conexion() {
		
		String valor=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost/test";
			Connection conn = DriverManager.getConnection(url,"root","");
			//lblNewLabel_1.setText(conn.toString());
			
			//Consulta. CRUD
			PreparedStatement ps = conn.prepareStatement("select * from clientes");
			ResultSet rs = ps.executeQuery();
			//lblNewLabel_1.setText(rs.toString());
			StringBuilder  sb= new StringBuilder();
			while(rs.next()) {
				sb.append(rs.getString(1));
				sb.append(rs.getString(2));
			}
			valor=sb.toString();
			conn.close();
			return valor;

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			valor= e1.getMessage();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			valor=e1.getMessage();
		}
		return valor;
	}
