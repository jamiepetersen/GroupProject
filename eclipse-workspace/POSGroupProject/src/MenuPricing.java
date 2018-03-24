import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class MenuPricing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	public static Connection conn;
	static Statement stmt = null;	
	static PreparedStatement pstmt;
	static ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPricing frame = new MenuPricing();
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
				Class.forName("com.mysql.jdbc.Driver"); //loads mysql driver
			}
			catch (ClassNotFoundException e) {			//if it cannot load, produce error
				throw new Exception ("Database not reachable");
			}
			
			//connects to database
			conn = DriverManager.getConnection("jdbc:mysql://107.180.40.144:3306/jamie_trent", "trentuproject", "Passw0rd");
			stmt = conn.createStatement();
		}
		
		public static void getMenu() {
			try {
				String query = " SELECT * FROM Menu";
				rs = stmt.executeQuery(query);		//holds statement that executes above string query
				table.setModel(DbUtils.resultSetToTableModel(rs)); //places results in table
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	/**
	 * Create the frame.
	 */
	public MenuPricing() {
		setTitle("Little Restaurant Pricing Table ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnter = new JButton("Enter Pricing Database");
		btnEnter.addActionListener(new ActionListener() {		//waits for click
			public void actionPerformed(ActionEvent arg0) {		//once clicked it shows the table
				table.setEnabled(true);
				table.setShowGrid(true);
				try {
					connect(); //connects to the database
					getMenu(); //shows table filled from database result query
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnEnter.setVisible(false); //make the button disappear
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnter.setBounds(85, 227, 271, 52);
		contentPane.add(btnEnter);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.setEnabled(false);
		table.setBounds(10, 26, 423, 485);
		contentPane.add(table);
		
		JLabel lblItemID = new JLabel("Item ID");
		lblItemID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemID.setBounds(10, 0, 134, 29);
		contentPane.add(lblItemID);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName.setBounds(154, 0, 134, 29);
		contentPane.add(lblItemName);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemPrice.setBounds(295, 0, 86, 29);
		contentPane.add(lblItemPrice);
	}
}
