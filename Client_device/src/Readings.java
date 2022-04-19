import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Readings {
	
	Readings_gen rg=new Readings_gen();
	Readings_handler rh;
	
	public Readings(Readings_handler rh) {
		this.rh=rh;
	}
		
	public void get() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("id.txt"));
		rh.setId(in.nextLine());
		in.close();
		in = new Scanner(new FileReader("ConnINFO.txt"));
		rh.setCon(in.nextLine());
		try {rh.setUsr(in.nextLine());}catch(Exception e){rh.setUsr("");}
		try {rh.setPwd(in.nextLine());}catch(Exception e){rh.setPwd("");}
		in.close();
		rh.setHeartRate(rg.gen_heartRate());
		rh.setSmmHg(rg.gen_smmHg());
		rh.setDmmHg(rg.gen_dmmHg());
		rh.setDate(rg.gen_date());
		rh.setTime(rg.gen_time());
	}

}
