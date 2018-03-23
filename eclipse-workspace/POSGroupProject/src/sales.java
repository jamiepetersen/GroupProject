import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sales extends JFrame {

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
					sales frame = new sales();
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
	
	public static void getSales() {
		try {
			String query = " SELECT * FROM Sales";
			ResultSet rs = stmt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public sales() {
		setTitle("Little Restaurant Sales Database");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnterS = new JButton("Enter Sales Database");
		btnEnterS.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEnterS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);
				table.setShowGrid(true);
				try {
					connect();
					getSales();
				} catch (Exception f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
				btnEnterS.setVisible(false);
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
