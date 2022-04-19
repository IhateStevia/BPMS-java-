
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.DatabaseMetaData;



public class DB_handler  {
	public String db_url = "jdbc:mysql://"; 
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public String usr = "";
	public String pwd = "";
	
	
	public DB_handler() throws FileNotFoundException {
		String connINFO[]=new Txt_IO().getALL("ConnINFO.txt");
		db_url=db_url+connINFO[0];
		try {
		usr=connINFO[1];
		pwd=connINFO[2];
		}catch(Exception e) {}
	}

	
	public Connection getConnection() throws ClassNotFoundException {  
	    Class.forName(DRIVER);
	    Connection connection=null;
	    try {  
	    	Class.forName(DRIVER);
			connection = DriverManager.getConnection(db_url,usr,pwd);
	    } catch (SQLException ex) {} 
	    return connection;  
	}
	
	
	public void existTable(Connection con) throws SQLException, ClassNotFoundException {
		DatabaseMetaData dbm = (DatabaseMetaData) con.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "readings", null);
		if (!tables.next()) {
			String s="create table readings (entry_no int AUTO_INCREMENT primary key ,id char(20),date date,time time,heartRate int,smmHg int,dmmHg int );";
			exec(s,con);
		}
	}
	
	
	public ArrayList<Entry> fetch() throws ClassNotFoundException, SQLException, FileNotFoundException {
		ArrayList<Entry> entries;
		Connection con=getConnection();
		existTable(con);
		String statement="SELECT * FROM readings WHERE id=?";
		PreparedStatement ps = con.prepareStatement(statement);
		ps.setString(1,new Txt_IO().get_1stLine("id.txt"));
		entries= new Entry().rs2al(ps.executeQuery());
		con.close();
		return entries;
	}
	
	public ArrayList<Entry> found(String kwd) throws ClassNotFoundException, SQLException, FileNotFoundException {
		ArrayList<Entry> entries;
		Connection con=getConnection();
		existTable(con);
		String s="%"+kwd+"%";
		String statement="SELECT * FROM readings WHERE id=? AND (date LIKE ? OR time LIKE ? OR heartRate LIKE ? OR smmHg LIKE ? OR dmmHg LIKE ?)";
		PreparedStatement ps = con.prepareStatement(statement);
		ps.setString(1,new Txt_IO().get_1stLine("id.txt"));
		for(int i=2;i<=6;i++) {
			ps.setString(i,s);
		}
		entries= new Entry().rs2al(ps.executeQuery());
		con.close();
		return entries;
	}
	
	public void del_Entry(String kwd) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Connection con=getConnection();
		existTable(con);
		String statement="DELETE FROM `readings` WHERE id=? AND entry_no = ?";
		PreparedStatement ps = con.prepareStatement(statement);
		ps.setString(1,new Txt_IO().get_1stLine("id.txt"));
		ps.setString(2,kwd);
		ps.executeUpdate();
	}
		
	public void exec(String query,Connection con) throws ClassNotFoundException, SQLException {
		Statement statement = con.createStatement();
		try {
			statement.execute(query);
		} catch (SQLException e) {}
	}
	
	
	
}
