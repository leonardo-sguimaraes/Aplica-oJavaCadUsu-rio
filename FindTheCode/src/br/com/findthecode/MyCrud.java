package br.com.findthecode;
import java.util.*;
public class MyCrud  extends MyDao{
	
	
	public void  register(Client c)throws Exception{
		OpenDatabase();
		String SQL =  "INSERT INTO CLIENT VALUE (?,?,?,?)";
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(1, c.getCod());
		pstmt.setString(2, c.getName());
		pstmt.setString(3, c.getAdress());
		pstmt.setString(4, c.getPhone());
		pstmt.execute();
		
		CloseDatabase();
	}
	
	public List<Client> query()throws Exception{
		OpenDatabase();
		String SQL = "SELECT * FROM CLIENT ORDER BY name ASC";
		pstmt = con.prepareStatement(SQL);
		
		resSet = pstmt.executeQuery();
		
		Client c = null;
		List<Client> listClients = new ArrayList<Client>();
		while(resSet.next()){
			c = new Client();
			c.setCod(resSet.getInt("cod"));
			c.setName(resSet.getString("name"));
			c.setPhone(resSet.getString("phone"));
			c.setAdress(resSet.getString("adress"));
			
			listClients.add(c);
		}
		
		return listClients;
	}
	public void update(Client c)throws Exception{
		OpenDatabase();
		String SQL =  "update CLIENT set name=?, adress=?, phone=?"+ "where cod=?";
		pstmt = con.prepareStatement(SQL);
		pstmt.setInt(4, c.getCod());
		pstmt.setString(1, c.getName());
		pstmt.setString(2, c.getAdress());
		pstmt.setString(3, c.getPhone());
		pstmt.executeUpdate();
		
	}
	public void delete(int cod)throws Exception{
		OpenDatabase();
		String SQL = "DELETE from CLIENT WHERE cod="+cod;
		
		stmt.executeUpdate(SQL);
	}
	
	public Client findByCod(int cod)throws Exception{
		OpenDatabase();
		
		stmt = con.createStatement();
		String SQL = "select * from client where cod="+cod;
		resSet = stmt.executeQuery(SQL);
		Client c = new Client();
		
		if(!resSet.next()){
			System.out.println("The cod not exist");
		}else{
			c.setCod(resSet.getInt("cod"));
			c.setName(resSet.getString("name"));
			c.setAdress(resSet.getString("adress"));
			c.setPhone(resSet.getString("phone"));
		}
		return c;
	}
}
