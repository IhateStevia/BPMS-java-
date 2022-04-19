

public class Main {
	public static void main(String[] args) throws Exception {

		/*ArrayList<Entry> entries;
				
		entries=new DB_handler().fetch();
		new UI(entries).frame.setVisible(true);
			*/
		new UI(new DB_handler().fetch()).frame.setVisible(true);
		
	}
}
