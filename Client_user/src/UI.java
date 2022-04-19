import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI {
	public JFrame frame;
	public ArrayList<Entry> entries;
	
	
	public UI(ArrayList<Entry> entries) {
		initialize();
		this.entries=entries;
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setTitle("Christos Georgakis 228017");
		
		////////////////////////////////////////////////////////////////////////////////////
		String txtDSP=  "-Press any of the BUTTONS on the \"right\", to show results"+"\n\n"+
						"-To refresh, press \"fetch\""+"\n\n"+
						"-Use \"white\" input box, on the bottom with del/search";
		TextArea txt=new TextArea(txtDSP,0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		txt.setEditable(false);
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Arial", Font.PLAIN, 14));
		txt.setBackground(Color.BLUE);
		
		////////////////////////////////////////////////////////////////////////////////////
		JTextField multiPurposeTF = new JTextField();
		
		multiPurposeTF.setToolTipText("Delete/\uD83D\uDD0D");
		multiPurposeTF.setColumns(6);
		

		////////////////////////////////////////////////////////////////////////////////////
		JButton print = new JButton("          Print         ");
		
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Txt_IO().printE(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
				
		////////////////////////////////////////////////////////////////////////////////////
		JButton sortBySmmHg = new JButton("SortBySmmHg");
		
		sortBySmmHg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_SmmHg(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
				
		////////////////////////////////////////////////////////////////////////////////////
		JButton sortByDmmHg = new JButton("SortByDmmHg");
		
		sortByDmmHg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_DmmHg(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
				
		////////////////////////////////////////////////////////////////////////////////////
		JButton sortByhR = new JButton("     SortByHR     ");
		
		sortByhR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_HeartRate(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		JButton sortById = new JButton("SortByEntryNo ");
		
		sortById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_EntryNo(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		JButton sortByDate = new JButton("   SortByDate    ");
		
		sortByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_Date(entries);
				new Txt_IO().printD(entries,txt);
			
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////	
		JButton sortBytime = new JButton("   SortBytime    ");
		
		sortBytime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Entry().sortBy_Time(entries);
				new Txt_IO().printD(entries,txt);
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		JButton delete = new JButton("! DELETE .row");
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new DB_handler().del_Entry(multiPurposeTF.getText());
					entries=new DB_handler().fetch();
					new Txt_IO().printD(entries,txt);
				} catch (ClassNotFoundException | FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		JButton fetch = new JButton("fetch");
		
		fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					entries=new DB_handler().fetch();
					new Txt_IO().printD(entries,txt);
				} catch (ClassNotFoundException | FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		JButton search = new JButton("\uD83D\uDD0D");
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					entries=new DB_handler().found(multiPurposeTF.getText());
					new Txt_IO().printD(entries,txt);
				} catch (ClassNotFoundException | FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txt, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(print)
						.addComponent(sortBySmmHg)
						.addComponent(sortByDmmHg)
						.addComponent(sortByhR)
						.addComponent(sortById)
						.addComponent(sortByDate)
						.addComponent(sortBytime)
						.addComponent(fetch)/**/
							))
					.addGroup(groupLayout.createSequentialGroup()
							.addComponent(delete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(search)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(multiPurposeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)//
							))
					.addContainerGap())
		);
		
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(txt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(13)
								.addComponent(print)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortBySmmHg)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortByDmmHg)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortByhR)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortById)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortByDate)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sortBytime)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(delete)
							.addComponent(multiPurposeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(fetch)
							.addComponent(search)
							/**/)
						.addContainerGap())
			);
		
		frame.getContentPane().setLayout(groupLayout);
		

		

	}


}
