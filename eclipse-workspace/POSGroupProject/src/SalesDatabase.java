import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class SalesDatabase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	static Statement stmt;
	public static Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesDatabase frame = new SalesDatabase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void connect () throws Exception {
		if (conn != null) return;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //loads the MySQL driver
		}
		catch (ClassNotFoundException e) {
			throw new Exception ("Database not reachable"); //if cant load, show error
		}
		//connects to the following database
		conn = DriverManager.getConnection("jdbc:mysql://107.180.40.144:3306/jamie_trent", "trentuproject", "Passw0rd");
		stmt = conn.createStatement();
		
	}
	
	public static void getSales() {
		try {
			String query = " SELECT * FROM Sales";
			ResultSet rs = stmt.executeQuery(query); //variable for the result of the statement running the query on the database
			table.setModel(DbUtils.resultSetToTableModel(rs)); //fills the table with all results returned from the database
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public SalesDatabase() {
		setTitle("Little Restaurant Sales Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnterS = new JButton("Enter Sales Database");
		btnEnterS.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnterS.addActionListener(new ActionListener() {		//waits for click
			public void actionPerformed(ActionEvent e) {		//once clicked it shows the table
				table.setEnabled(true);
				table.setShowGrid(true);
				try {
					connect(); //connects to the database
					getSales();//sows the table filled with results 
				} catch (Exception f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
				btnEnterS.setVisible(false); //makes the button disappear
			}
		});
		btnEnterS.setBounds(176, 202, 286, 45);
		contentPane.add(btnEnterS);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.setBounds(10, 34, 634, 405);
		contentPane.add(table);
		
		JLabel lblSaleID = new JLabel("Sale ID");
		lblSaleID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaleID.setBounds(10, 0, 91, 34);
		contentPane.add(lblSaleID);
		
		JLabel lblSaleTimestamp = new JLabel("Date and Time");
		lblSaleTimestamp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaleTimestamp.setBounds(170, 0, 122, 34);
		contentPane.add(lblSaleTimestamp);
		
		JLabel lblSaleTotal = new JLabel("Sale Total");
		lblSaleTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaleTotal.setBounds(329, 0, 116, 34);
		contentPane.add(lblSaleTotal);
		
		JLabel lblTaxesPaid = new JLabel("Taxes Paid");
		lblTaxesPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaxesPaid.setBounds(487, 0, 127, 34);
		contentPane.add(lblTaxesPaid);
	}

}

