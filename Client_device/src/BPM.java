import java.io.*;
import java.sql.SQLException;

public class BPM {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
		
		Readings_handler rh=new Readings_handler();
		new Readings(rh).get();
		//DB_handler dbh=new DB_handler(rh.getCon(),rh.getUsr(),rh.getPwd());
		//dbh.sendToDB(rh.getId(),rh.getDate(),rh.getTime(),rh.getHeartRate(),rh.getSmmHg(),rh.getDmmHg());	
		new DB_handler(rh.getCon(),rh.getUsr(),rh.getPwd()).sendToDB(rh.getId(),rh.getDate(),rh.getTime(),rh.getHeartRate(),rh.getSmmHg(),rh.getDmmHg());	
	    
	}
	

}
