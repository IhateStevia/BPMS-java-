
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;



public class DB_handler  {
	
	public String db_url = "jdbc:mysql://"; 
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public String usr = "";
	public String pwd = "";

	public DB_handler(String con,String usrn,String pwrd) {
		db_url=db_url+con;
		usr=usr+usrn;
		pwd=pwd+pwrd;
	}

	public Connection getConnection() throws ClassNotFoundException {  
	    Class.forName(DRIVER);  
	    Connection connection = null;  
	    try {  
	    	Class.forName(DRIVER);
			//connection = DriverManager.getConnection(db_url);
			//connection = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11485186","sql11485186","2iZkzJjCnT");
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
	
	public void sendToDB(String id,String date,String time,int heartRate,int smmHg,int dmmHg) throws ClassNotFoundException, SQLException {
		Connection con=getConnection();
		existTable(con);
		String statement="insert into readings values (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps= con.prepareStatement(statement);
		ps.setString(1,null);
		ps.setString(2,id);
		ps.setString(3,date);
		ps.setString(4,time);
		ps.setInt(5,heartRate);
		ps.setInt(6,smmHg);
		ps.setInt(7,dmmHg);
		ps.executeUpdate();
		con.close();
	}
	
	public void exec(String query,Connection con) throws ClassNotFoundException, SQLException {
		Statement statement = con.createStatement();
		try {
			statement.execute(query);
		} catch (SQLException e) {}
		
	}
	
}
