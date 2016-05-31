package br.com.findthecode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDao {

	public Connection con;
	public PreparedStatement pstmt;
	public Statement stmt;
	public ResultSet resSet;
	
	
	public void OpenDatabase ()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/findthecode?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "leogui123";
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public void CloseDatabase()throws Exception{
		if(con !=  null)
			con.close();
	}
}
