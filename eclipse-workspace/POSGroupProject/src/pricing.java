import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class pricing extends JFrame {

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
					pricing frame = new pricing();
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
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			throw new Exception ("Database not reachable");
		}
		
		conn = DriverManager.getConnection("jdbc:mysql://107.180.40.144:3306/jamie_trent", "trentuproject", "Passw0rd");
		JOptionPane.showMessageDialog(null, "Connection To Database Successful");
		stmt = conn.createStatement();
	}
	
	public static void getMenu() {
		try {
			String query = " SELECT * FROM Menu";
			rs = stmt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e){
				System.out.println("Connection unable to close");
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public pricing() {
		setTitle("Little Restaurant Pricing Table ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnter = new JButton("Enter Pricing Database");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setEnabled(true);
				table.setShowGrid(true);
				try {
					connect();
					getMenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnEnter.setVisible(false);
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
