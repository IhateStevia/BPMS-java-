import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random; 

public class Readings_gen {
	Random rand = new Random();
	
	public int gen_heartRate() {
		//40-100 ->range 60
		return rand.nextInt(61) + 40;
	}

	public int gen_smmHg() {
		//90-140 ->range 50
		return rand.nextInt(51) + 90;
	}	
	
	public int gen_dmmHg() {
		//60-90 ->range 30
		return rand.nextInt(31) + 60;
	}
	
	public String gen_date(){
		Date dNow = new Date( );
	    SimpleDateFormat date =  new SimpleDateFormat ("yyyy/MM/dd");
	    return date.format(dNow);
	}
	
	public String gen_time() {
		Date dNow = new Date( );
		SimpleDateFormat time =  new SimpleDateFormat ("kk:mm:ss");
		return time.format(dNow);
	}

}
