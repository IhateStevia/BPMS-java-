import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Entry {
	int heartRate,smmHg,dmmHg,entry_no;
	String date,time,id;
	
	///////////////////////////////////////////////////////////
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	///////////////////////////////////////////////////////////	
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int hearRate) {
		this.heartRate = hearRate;
	}
	
	///////////////////////////////////////////////////////////	
	public int getSmmHg() {
		return smmHg;
	}
	public void setSmmHg(int smmHg) {
		this.smmHg = smmHg;
	}
	
	///////////////////////////////////////////////////////////	
	public int getDmmHg() {
		return dmmHg;
	}
	public void setDmmHg(int dmmHg) {
		this.dmmHg = dmmHg;
	}
	
	///////////////////////////////////////////////////////////	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	///////////////////////////////////////////////////////////	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	///////////////////////////////////////////////////////////	
	public int getEntryNo() {
		return entry_no;
	}
	public void setEntryNo(int entry_no) {
		this.entry_no = entry_no;
	}
	
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	public ArrayList<Entry> rs2al(ResultSet rs) throws SQLException{
		ArrayList<Entry> entries=new ArrayList<Entry>();
		while(rs.next()) {
			Entry entry=new Entry();
			entry.setEntryNo(rs.getInt("entry_no"));
			entry.setId(rs.getString("id"));
			entry.setDate(rs.getString("date"));
			entry.setTime(rs.getString("time"));
			entry.setHeartRate(rs.getInt("heartRate"));
			entry.setSmmHg(rs.getInt("smmHg"));
			entry.setDmmHg(rs.getInt("dmmHg"));
			entries.add(entry);
		}
		return entries;
	}
	
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	public void sortBy_EntryNo(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				return Integer.valueOf(o1.entry_no).compareTo(o2.entry_no);
			}});
	}
	
	
	public void sortBy_Date(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				StringBuilder date1 = new StringBuilder(o1.date);
				StringBuilder date2 = new StringBuilder(o2.date);
				date1.deleteCharAt(4);
				date1.deleteCharAt(6);
				date2.deleteCharAt(4);
				date2.deleteCharAt(6);
				String d1 = date1.toString();
				String d2 = date2.toString();
				return Integer.valueOf(Integer.parseInt(d1)).compareTo(Integer.parseInt(d2));
			}});
	}
	
	
	public void sortBy_Time(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				StringBuilder time1 = new StringBuilder(o1.time);
				StringBuilder time2 = new StringBuilder(o2.time);
				time1.deleteCharAt(2);
				time1.deleteCharAt(4);
				time2.deleteCharAt(2);
				time2.deleteCharAt(4);
				String t1 = time1.toString();
				String t2 = time2.toString();
				return Integer.valueOf(Integer.parseInt(t1)).compareTo(Integer.parseInt(t2));
			}});
	}
	
	
	public void sortBy_HeartRate(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				return Integer.valueOf(o1.heartRate).compareTo(o2.heartRate);
			}});
	}
	
	
	public void sortBy_SmmHg(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				return Integer.valueOf(o1.smmHg).compareTo(o2.smmHg);
			}});
	}
	
	
	public void sortBy_DmmHg(ArrayList<Entry> entries) {
		Collections.sort(entries,new Comparator<Entry>(){
			@Override
			public int compare(Entry o1, Entry o2) {
				return Integer.valueOf(o1.dmmHg).compareTo(o2.dmmHg);
			}});
	}	

}
