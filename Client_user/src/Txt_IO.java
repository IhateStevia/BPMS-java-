import java.awt.TextArea;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Txt_IO {
	
	//////////////////////////////////////////////////////////////////////	
	public String get_1stLine(String s) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(s));
		String id=in.nextLine();
		in.close();
		return id;
	}

	//////////////////////////////////////////////////////////////////////
	public String[] getALL(String s) throws FileNotFoundException {
		String connINFO[]=new String[3];
		int i=0;
		Scanner in = new Scanner(new FileReader(s));
		while(in.hasNextLine()) {
			connINFO[i++]=in.nextLine();
		}
		in.close();
		return connINFO;
	}
	
	//////////////////////////////////////////////////////////////////////
	public void printE(ArrayList<Entry> entries) {
		for(int i=0;i<entries.size();i++) {
			System.out.println(
					entries.get(i).getEntryNo()+".  "+
					"Id:" +entries.get(i).getId()+
					" " +entries.get(i).getTime()+
					" " +entries.get(i).getDate()+
					" hR:" +entries.get(i).getHeartRate()+
					" SmmHg:" +entries.get(i).getSmmHg()+
					" DmmHg:" +entries.get(i).getDmmHg()
					);
			}
		
	}
	
	//////////////////////////////////////////////////////////////////////
	public void printD(ArrayList<Entry> entries,TextArea txt) {
		String texx="";
		for(int i=0;i<entries.size();i++) {
		texx=   texx  +
				entries.get(i).getEntryNo()+".  "+
				"   ID: " +entries.get(i).getId()+
				"    " +entries.get(i).getDate()+
				",   " +entries.get(i).getTime()+
				"   hR:" +entries.get(i).getHeartRate()+
				"   SmmHg:" +entries.get(i).getSmmHg()+
				"   DmmHg:" +entries.get(i).getDmmHg()+
				"\n"
				;}
		txt.setText(texx);
	}
	

}
