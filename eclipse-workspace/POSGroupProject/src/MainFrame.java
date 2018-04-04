import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.swing.*;



public class MainFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// Runs the program displaying the MainFrame content
			public void run() {
				try {
					MainFrame window = new MainFrame(); 
					window.frmLittleRestaurant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Frame and text variables
	private JFrame frmLittleRestaurant;
	static JTextField txtB;
	static JTextField txtMS;
	static JTextField txtGB;
	static JTextField txtP;
	static JTextField txtLN;
	static JTextField txtFF;
	static JTextField txtMV;
	static JTextField txtR;
	static JTextField txtCS;
	static JTextField txtBP;
	static JTextField txtS;
	static JTextField txtJ;
	static JTextField txtM;
	static JTextField txtW;
	static JTextField txtPi;
	static JTextField txtIC;
	static JTextField txtC;
	static JTextField txtCa;
	static JTextField txtPu;
	static JTextField txtSp;
	static JTextField txtCB;
	static JTextField txtChB;
	static JTextField txtVS;
	static JTextField txtCh;
	static JTextField txtBC;
	static JTextField txtSu;
	static JTextField txtBR;
	static JTextField txtSt;
	static JTextField txtSa;
	static JTextField txtSubtotal;
	static JTextField txtTax;
	static JTextField txtTotal;
	static JTextField txtBeer;
	static DecimalFormat df = new DecimalFormat("####0.00"); 	//ensures only 2 decimal places in result (used for the totals and tax)
	
	public static void clear() {
		txtB.setText("0");
		txtMS.setText("0");
		txtGB.setText("0");
		txtP.setText("0");
		txtLN.setText("0");
		txtFF.setText("0");
		txtMV.setText("0");
		txtR.setText("0");
		txtCS.setText("0");
		txtBP.setText("0");
		txtS.setText("0");
		txtJ.setText("0");
		txtBeer.setText("0");
		txtM.setText("0");
		txtW.setText("0");
		txtSp.setText("0");
		txtCB.setText("0");
		txtChB.setText("0");
		txtVS.setText("0");
		txtCh.setText("0");
		txtBC.setText("0");
		txtSu.setText("0");
		txtBR.setText("0");
		txtSt.setText("0");
		txtSa.setText("0");
		txtPi.setText("0");
		txtIC.setText("0");
		txtC.setText("0");
		txtCa.setText("0");
		txtPu.setText("0");
		txtSubtotal.setText("0");
		txtTax.setText("0");
		txtTotal.setText("0");
		
	}
	/**
	 * Creates the application.
	 */
	public MainFrame() { //invokes the method that initializes all contents in the frame
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLittleRestaurant = new JFrame(); 
		frmLittleRestaurant.setTitle("Little Restaurant - Simple POS System");
		frmLittleRestaurant.getContentPane().setBackground(SystemColor.control);
		frmLittleRestaurant.setBounds(100, 100, 1155, 610);
		frmLittleRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLittleRestaurant.getContentPane().setLayout(null);
		
		JPanel menupanel = new JPanel();
		menupanel.setBackground(new Color(153, 255, 255));
		menupanel.setBounds(32, 70, 760, 482);
		frmLittleRestaurant.getContentPane().add(menupanel);
		menupanel.setLayout(null);
		
		JPanel pnlAppetizers = new JPanel();
		pnlAppetizers.setBackground(SystemColor.menu);
		pnlAppetizers.setBounds(10, 40, 240, 196);
		menupanel.add(pnlAppetizers);
		pnlAppetizers.setLayout(null);
		
		JButton btnB = new JButton("Bruschetta");
		btnB.addActionListener(new ActionListener() { 				//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {			//When the button is clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtB.getText()); //checks for number in Bruschetta amount text box
				double amnt = amount +1; 							//adds one to current amount
				txtB.setText(" " + amnt); 							//displays new amount in amount text box
				calculate4();										
			}
		});
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnB.setBounds(10, 28, 144, 23);
		pnlAppetizers.add(btnB);
		
		txtB = new JTextField(); 				//text box that hold the amount of Bruschetta
		txtB.setText("0");
		txtB.setBackground(SystemColor.window);
		txtB.setEditable(false);
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtB.setBounds(164, 28, 66, 22);
		pnlAppetizers.add(txtB);
		txtB.setColumns(10);
		
		JLabel lblAmountA = new JLabel("Amount");
		lblAmountA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountA.setBounds(154, 0, 86, 25);
		pnlAppetizers.add(lblAmountA);
		
		JLabel lblItemA = new JLabel("Item");
		lblItemA.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemA.setBounds(10, 0, 142, 25);
		pnlAppetizers.add(lblItemA);
		
		JButton btnMS = new JButton("Mozzarela Sticks");
		btnMS.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtMS.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtMS.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal
				double price = subtotal + 3.75; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnMS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMS.setBounds(10, 62, 144, 23);
		pnlAppetizers.add(btnMS);
		
		txtMS = new JTextField();		//textbox holding the amount of Mozzarela Sticks
		txtMS.setText("0");
		txtMS.setHorizontalAlignment(SwingConstants.CENTER);
		txtMS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMS.setEditable(false);
		txtMS.setColumns(10);
		txtMS.setBackground(Color.WHITE);
		txtMS.setBounds(164, 62, 66, 22);
		pnlAppetizers.add(txtMS);
		
		JButton btnGB = new JButton("Garlic Bread");
		btnGB.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtGB.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtGB.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText()); //checks amount in subtotal, adds item cost, outputs new subtotal
				double price = subtotal + 3.50; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 
				txtTax.setText("" + df.format(tax)); 						//calculates tax on new subtotal, displays new tax amount
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnGB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGB.setBounds(10, 95, 144, 23);
		pnlAppetizers.add(btnGB);
		
		txtGB = new JTextField();		//textbox holding the amount of Garlic Bread
		txtGB.setText("0");
		txtGB.setHorizontalAlignment(SwingConstants.CENTER);
		txtGB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGB.setEditable(false);
		txtGB.setColumns(10);
		txtGB.setBackground(Color.WHITE);
		txtGB.setBounds(164, 95, 66, 22);
		pnlAppetizers.add(txtGB);
		
		JButton btnP = new JButton("Perogies");
		btnP.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtP.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtP.setText(" " + amnt); 
				calculate5();
			}
		});
		btnP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnP.setBounds(10, 129, 144, 23);
		pnlAppetizers.add(btnP);
		
		JButton btnLN = new JButton("Loaded Nachos");
		btnLN.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtLN.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;	
				txtLN.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 4.75; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnLN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLN.setBounds(10, 162, 144, 23);
		pnlAppetizers.add(btnLN);
		
		txtP = new JTextField();		//textbox holding the amount of Perogies
		txtP.setText("0");
		txtP.setHorizontalAlignment(SwingConstants.CENTER);
		txtP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtP.setEditable(false);
		txtP.setColumns(10);
		txtP.setBackground(Color.WHITE);
		txtP.setBounds(164, 128, 66, 22);
		pnlAppetizers.add(txtP);
		
		txtLN = new JTextField();		//textbox holding the amount of Loaded Nachos
		txtLN.setText("0");
		txtLN.setHorizontalAlignment(SwingConstants.CENTER);
		txtLN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLN.setEditable(false);
		txtLN.setColumns(10);
		txtLN.setBackground(Color.WHITE);
		txtLN.setBounds(164, 162, 66, 22);
		pnlAppetizers.add(txtLN);
		
		JLabel lblAppetizers = new JLabel("Appetizers");
		lblAppetizers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAppetizers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppetizers.setBounds(10, 11, 240, 29);
		menupanel.add(lblAppetizers);
		
		JPanel pnlSides = new JPanel();
		pnlSides.setLayout(null);
		pnlSides.setBackground(SystemColor.menu);
		pnlSides.setBounds(260, 40, 240, 196);
		menupanel.add(pnlSides);
		
		JButton btnFF = new JButton("French Fries");
		btnFF.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtFF.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtFF.setText(" " + amnt); 
				calculate2();
			}
		});
		btnFF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFF.setBounds(10, 28, 144, 23);
		pnlSides.add(btnFF);
		
		txtFF = new JTextField();		//textbox holding the amount of French Fries
		txtFF.setText("0");
		txtFF.setHorizontalAlignment(SwingConstants.CENTER);
		txtFF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFF.setEditable(false);
		txtFF.setColumns(10);
		txtFF.setBackground(Color.WHITE);
		txtFF.setBounds(164, 28, 66, 22);
		pnlSides.add(txtFF);
		
		JLabel lblAmountS = new JLabel("Amount");
		lblAmountS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountS.setBounds(154, 0, 86, 25);
		pnlSides.add(lblAmountS);
		
		JLabel lblItemS = new JLabel("Item");
		lblItemS.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemS.setBounds(10, 0, 142, 25);
		pnlSides.add(lblItemS);
		
		JButton btnMV = new JButton("Mixed Veggies");
		btnMV.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtMV.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtMV.setText(" " + amnt); 
				calculate2(); 
			}
		});
		btnMV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMV.setBounds(10, 62, 144, 23);
		pnlSides.add(btnMV);
		
		txtMV = new JTextField();		//textbox holding the amount of Mixed Veggies
		txtMV.setText("0");
		txtMV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMV.setEditable(false);
		txtMV.setColumns(10);
		txtMV.setBackground(Color.WHITE);
		txtMV.setBounds(164, 62, 66, 22);
		pnlSides.add(txtMV);
		
		JButton btnR = new JButton("Rice");
		btnR.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtR.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtR.setText(" " + amnt); 
				calculate2();
			}
		});
		btnR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnR.setBounds(10, 95, 144, 23);
		pnlSides.add(btnR);
		
		txtR = new JTextField();		//textbox holding the amount of Rice
		txtR.setText("0");
		txtR.setHorizontalAlignment(SwingConstants.CENTER);
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtR.setEditable(false);
		txtR.setColumns(10);
		txtR.setBackground(Color.WHITE);
		txtR.setBounds(164, 95, 66, 22);
		pnlSides.add(txtR);
		
		JButton btnCS = new JButton("Ceasar Salad");
		btnCS.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtCS.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtCS.setText(" " + amnt); 
				calculate2();
			}
		});
		btnCS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCS.setBounds(10, 129, 144, 23);
		pnlSides.add(btnCS);
		
		JButton btnBP = new JButton("Baked Potatoe");
		btnBP.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtBP.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtBP.setText(" " + amnt); 
				calculate3();
			}
		});
		btnBP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBP.setBounds(10, 162, 144, 23);
		pnlSides.add(btnBP);
		
		txtCS = new JTextField();		//textbox holding the amount of Ceasar Salad
		txtCS.setText("0");
		txtCS.setHorizontalAlignment(SwingConstants.CENTER);
		txtCS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCS.setEditable(false);
		txtCS.setColumns(10);
		txtCS.setBackground(Color.WHITE);
		txtCS.setBounds(164, 128, 66, 22);
		pnlSides.add(txtCS);
		
		txtBP = new JTextField();		//textbox holding the amount of Baked Potatoe
		txtBP.setText("0");
		txtBP.setHorizontalAlignment(SwingConstants.CENTER);
		txtBP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBP.setEditable(false);
		txtBP.setColumns(10);
		txtBP.setBackground(Color.WHITE);
		txtBP.setBounds(164, 162, 66, 22);
		pnlSides.add(txtBP);
		
		JPanel pnlDrinks = new JPanel();
		pnlDrinks.setLayout(null);
		pnlDrinks.setBackground(SystemColor.menu);
		pnlDrinks.setBounds(510, 40, 240, 196);
		menupanel.add(pnlDrinks);
		
		JButton btnS = new JButton("Soda");
		btnS.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtS.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtS.setText(" " + amnt); 
				calculate2();
			}
		});
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnS.setBounds(10, 28, 144, 23);
		pnlDrinks.add(btnS);
		
		txtS = new JTextField();		//textbox holding the amount of Soda
		txtS.setText("0");
		txtS.setHorizontalAlignment(SwingConstants.CENTER);
		txtS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtS.setEditable(false);
		txtS.setColumns(10);
		txtS.setBackground(Color.WHITE);
		txtS.setBounds(164, 28, 66, 22);
		pnlDrinks.add(txtS);
		
		JLabel lblAmountD = new JLabel("Amount");
		lblAmountD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountD.setBounds(154, 0, 86, 25);
		pnlDrinks.add(lblAmountD);
		
		JLabel lblItemD = new JLabel("Item");
		lblItemD.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemD.setBounds(10, 0, 142, 25);
		pnlDrinks.add(lblItemD);
		
		JButton btnJ = new JButton("Juice");
		btnJ.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtJ.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtJ.setText(" " + amnt); 
				calculate15();
			}
		});
		btnJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJ.setBounds(10, 62, 144, 23);
		pnlDrinks.add(btnJ);
		
		txtJ = new JTextField();		//textbox holding the amount of Juice
		txtJ.setText("0");
		txtJ.setHorizontalAlignment(SwingConstants.CENTER);
		txtJ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtJ.setEditable(false);
		txtJ.setColumns(10);
		txtJ.setBackground(Color.WHITE);
		txtJ.setBounds(164, 62, 66, 22);
		pnlDrinks.add(txtJ);
		
		JButton btnBeer = new JButton("Beer");
		btnBeer.addActionListener(new ActionListener() {					//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtBeer.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtBeer.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 5.50; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnBeer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBeer.setBounds(10, 95, 144, 23);
		pnlDrinks.add(btnBeer);
		
		JButton btnM = new JButton("Milk");
		btnM.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				DecimalFormat df = new DecimalFormat("####0.00");
				
				double amount = Double.parseDouble(txtM.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtM.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 1.50; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnM.setBounds(10, 129, 144, 23);
		pnlDrinks.add(btnM);
		
		JButton btnW = new JButton("Wine");
		btnW.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtW.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtW.setText(" " + amnt); 
				calculate5();
			}
		});
		btnW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnW.setBounds(10, 162, 144, 23);
		pnlDrinks.add(btnW);
		
		txtM = new JTextField();		//textbox holding the amount of Milk
		txtM.setText("0");
		txtM.setHorizontalAlignment(SwingConstants.CENTER);
		txtM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtM.setEditable(false);
		txtM.setColumns(10);
		txtM.setBackground(Color.WHITE);
		txtM.setBounds(164, 128, 66, 22);
		pnlDrinks.add(txtM);
		
		txtW = new JTextField();		//textbox holding the amount of Wine
		txtW.setText("0");
		txtW.setHorizontalAlignment(SwingConstants.CENTER);
		txtW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtW.setEditable(false);
		txtW.setColumns(10);
		txtW.setBackground(Color.WHITE);
		txtW.setBounds(164, 162, 66, 22);
		pnlDrinks.add(txtW);
		
		txtBeer = new JTextField();		//textbox holding the amount of Beer
		txtBeer.setText("0");
		txtBeer.setHorizontalAlignment(SwingConstants.CENTER);
		txtBeer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBeer.setEditable(false);
		txtBeer.setColumns(10);
		txtBeer.setBackground(Color.WHITE);
		txtBeer.setBounds(164, 95, 66, 22);
		pnlDrinks.add(txtBeer);
		
		JLabel lblSides = new JLabel("Sides");
		lblSides.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSides.setBounds(260, 11, 240, 29);
		menupanel.add(lblSides);
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDrinks.setBounds(510, 11, 240, 29);
		menupanel.add(lblDrinks);
		
		JLabel lblEntrees = new JLabel("Entrees");
		lblEntrees.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrees.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEntrees.setBounds(10, 247, 490, 29);
		menupanel.add(lblEntrees);
		
		JLabel lblDesserts = new JLabel("Desserts");
		lblDesserts.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesserts.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesserts.setBounds(510, 247, 240, 29);
		menupanel.add(lblDesserts);
		
		JPanel pnlDesserts = new JPanel();
		pnlDesserts.setLayout(null);
		pnlDesserts.setBackground(SystemColor.menu);
		pnlDesserts.setBounds(510, 274, 240, 196);
		menupanel.add(pnlDesserts);
		
		JButton btnPi = new JButton("Pie");
		btnPi.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtPi.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtPi.setText(" " + amnt); 
				calculate4();
			}
		});
		btnPi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPi.setBounds(10, 28, 144, 23);
		pnlDesserts.add(btnPi);
		
		txtPi = new JTextField();		//textbox holding the amount of Pie
		txtPi.setText("0");
		txtPi.setHorizontalAlignment(SwingConstants.CENTER);
		txtPi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPi.setEditable(false);
		txtPi.setColumns(10);
		txtPi.setBackground(Color.WHITE);
		txtPi.setBounds(164, 28, 66, 22);
		pnlDesserts.add(txtPi);
		
		JLabel lblAmountDes = new JLabel("Amount");
		lblAmountDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountDes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountDes.setBounds(154, 0, 86, 25);
		pnlDesserts.add(lblAmountDes);
		
		JLabel lblItemDes = new JLabel("Item");
		lblItemDes.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemDes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemDes.setBounds(10, 0, 142, 25);
		pnlDesserts.add(lblItemDes);
		
		JButton btnIC = new JButton("Ice Cream");
		btnIC.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtIC.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtIC.setText(" " + amnt); 
				calculate3();
			}
		});
		btnIC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIC.setBounds(10, 62, 144, 23);
		pnlDesserts.add(btnIC);
		
		txtIC = new JTextField();		//textbox holding the amount of Ice Cream
		txtIC.setText("0");
		txtIC.setHorizontalAlignment(SwingConstants.CENTER);
		txtIC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIC.setEditable(false);
		txtIC.setColumns(10);
		txtIC.setBackground(Color.WHITE);
		txtIC.setBounds(164, 62, 66, 22);
		pnlDesserts.add(txtIC);
		
		JButton btnC = new JButton("Cookies");
		btnC.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtC.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtC.setText(" " + amnt); 
				calculate2();
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnC.setBounds(10, 95, 144, 23);
		pnlDesserts.add(btnC);
		
		txtC = new JTextField();		//textbox holding the amount of Cookies
		txtC.setText("0");
		txtC.setHorizontalAlignment(SwingConstants.CENTER);
		txtC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtC.setEditable(false);
		txtC.setColumns(10);
		txtC.setBackground(Color.WHITE);
		txtC.setBounds(164, 95, 66, 22);
		pnlDesserts.add(txtC);
		
		JButton btnCa = new JButton("Cake");
		btnCa.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtCa.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtCa.setText(" " + amnt); 
				calculate4();
			}
		});
		btnCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCa.setBounds(10, 129, 144, 23);
		pnlDesserts.add(btnCa);
		
		JButton btnPu = new JButton("Pudding");
		btnPu.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:	
				
				double amount = Double.parseDouble(txtPu.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtPu.setText(" " + amnt); 
				calculate3(); 
			}
		});
		btnPu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPu.setBounds(10, 162, 144, 23);
		pnlDesserts.add(btnPu);
		
		txtCa = new JTextField();		//textbox holding the amount of Cake
		txtCa.setText("0");
		txtCa.setHorizontalAlignment(SwingConstants.CENTER);
		txtCa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCa.setEditable(false);
		txtCa.setColumns(10);
		txtCa.setBackground(Color.WHITE);
		txtCa.setBounds(164, 128, 66, 22);
		pnlDesserts.add(txtCa);
		
		txtPu = new JTextField();		//textbox holding the amount of Pudding
		txtPu.setText("0");
		txtPu.setHorizontalAlignment(SwingConstants.CENTER);
		txtPu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPu.setEditable(false);
		txtPu.setColumns(10);
		txtPu.setBackground(Color.WHITE);
		txtPu.setBounds(164, 162, 66, 22);
		pnlDesserts.add(txtPu);
		
		JPanel pnlEntrees = new JPanel();
		pnlEntrees.setLayout(null);
		pnlEntrees.setBackground(SystemColor.menu);
		pnlEntrees.setBounds(10, 274, 490, 196);
		menupanel.add(pnlEntrees);
		
		JButton btnSp = new JButton("Spaghetti");
		btnSp.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtSp.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtSp.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 9.25; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSp.setBounds(10, 28, 144, 23);
		pnlEntrees.add(btnSp);
		
		txtSp = new JTextField();		//textbox holding the amount of Spaghetti
		txtSp.setText("0");
		txtSp.setHorizontalAlignment(SwingConstants.CENTER);
		txtSp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSp.setEditable(false);
		txtSp.setColumns(10);
		txtSp.setBackground(Color.WHITE);
		txtSp.setBounds(164, 28, 66, 22);
		pnlEntrees.add(txtSp);
		
		JLabel lblAmountE1 = new JLabel("Amount");
		lblAmountE1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountE1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountE1.setBounds(154, 0, 86, 25);
		pnlEntrees.add(lblAmountE1);
		
		JLabel lblItemE1 = new JLabel("Item");
		lblItemE1.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemE1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemE1.setBounds(10, 0, 142, 25);
		pnlEntrees.add(lblItemE1);
		
		JButton btnCB = new JButton("Cheeseburger");
		btnCB.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtCB.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtCB.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 8.00; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCB.setBounds(10, 62, 144, 23);
		pnlEntrees.add(btnCB);
		
		txtCB = new JTextField();		//textbox holding the amount of CheeseBurger
		txtCB.setText("0");
		txtCB.setHorizontalAlignment(SwingConstants.CENTER);
		txtCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCB.setEditable(false);
		txtCB.setColumns(10);
		txtCB.setBackground(Color.WHITE);
		txtCB.setBounds(164, 62, 66, 22);
		pnlEntrees.add(txtCB);
		
		JButton btnChB = new JButton("Chicken Burger");
		btnChB.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtChB.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtChB.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 8.25; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnChB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChB.setBounds(10, 95, 144, 23);
		pnlEntrees.add(btnChB);
		
		txtChB = new JTextField();		//textbox holding the amount of Chicken Burger
		txtChB.setText("0");
		txtChB.setHorizontalAlignment(SwingConstants.CENTER);
		txtChB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChB.setEditable(false);
		txtChB.setColumns(10);
		txtChB.setBackground(Color.WHITE);
		txtChB.setBounds(164, 95, 66, 22);
		pnlEntrees.add(txtChB);
		
		JButton btnVS = new JButton("Vegetable Soup");
		btnVS.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtVS.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtVS.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 7.00; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnVS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVS.setBounds(10, 129, 144, 23);
		pnlEntrees.add(btnVS);
		
		JButton btnCh = new JButton("Chilli");
		btnCh.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtCh.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtCh.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 7.25; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCh.setBounds(10, 162, 144, 23);
		pnlEntrees.add(btnCh);
		
		txtVS = new JTextField();		//textbox holding the amount of Vegetable Soup
		txtVS.setText("0");
		txtVS.setHorizontalAlignment(SwingConstants.CENTER);
		txtVS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVS.setEditable(false);
		txtVS.setColumns(10);
		txtVS.setBackground(Color.WHITE);
		txtVS.setBounds(164, 128, 66, 22);
		pnlEntrees.add(txtVS);
		
		txtCh = new JTextField();		//textbox holding the amount of Chilli
		txtCh.setText("0");
		txtCh.setHorizontalAlignment(SwingConstants.CENTER);
		txtCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCh.setEditable(false);
		txtCh.setColumns(10);
		txtCh.setBackground(Color.WHITE);
		txtCh.setBounds(164, 162, 66, 22);
		pnlEntrees.add(txtCh);
		
		JButton btnBC = new JButton("Butter Chicken");
		btnBC.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtBC.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtBC.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal
				double price = subtotal + 8.50; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnBC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBC.setBounds(260, 28, 144, 23);
		pnlEntrees.add(btnBC);
		
		JButton btnSu = new JButton("Sushi");
		btnSu.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtSu.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtSu.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 10.50; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnSu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSu.setBounds(260, 62, 144, 23);
		pnlEntrees.add(btnSu);
		
		JButton btnBR = new JButton("BBQ Ribs");
		btnBR.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtBR.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtBR.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 10.75; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnBR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBR.setBounds(260, 95, 144, 23);
		pnlEntrees.add(btnBR);
		
		JButton btnSt = new JButton("Steak");
		btnSt.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent arg0) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtSt.getText()); 		//checks amount in textbox, adds 1, outputs new amount		
				double amnt = amount +1;
				txtSt.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 11.00; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnSt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSt.setBounds(260, 129, 144, 23);
		pnlEntrees.add(btnSt);
		
		JButton btnSa = new JButton("Salmon");
		btnSa.addActionListener(new ActionListener() {						//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {					//Once clicked, the following actions take place:
				
				double amount = Double.parseDouble(txtSa.getText()); 		//checks amount in textbox, adds 1, outputs new amount
				double amnt = amount +1;
				txtSa.setText(" " + amnt); 
				
				double subtotal = Double.parseDouble(txtSubtotal.getText());//checks amount in subtotal, adds item cost, outputs new subtotal 
				double price = subtotal + 10.25; 
				txtSubtotal.setText("" + df.format(price)); 
				
				double tax = price * 0.13; 									//calculates tax on new subtotal, displays new tax amount
				txtTax.setText("" + df.format(tax)); 
				
				double total = price + tax;									//sums subtotal and tax, displays sum in total box
				txtTotal.setText("" + df.format(total)); 
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSa.setBounds(260, 162, 144, 23);
		pnlEntrees.add(btnSa);
		
		txtBC = new JTextField(); 		//textbox holding the amount of Butter Chicken
		txtBC.setText("0");
		txtBC.setHorizontalAlignment(SwingConstants.CENTER);
		txtBC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBC.setEditable(false);
		txtBC.setColumns(10);
		txtBC.setBackground(Color.WHITE);
		txtBC.setBounds(414, 28, 66, 22);
		pnlEntrees.add(txtBC);
		
		txtSu = new JTextField();		//textbox holding the amount of Sushi
		txtSu.setText("0");
		txtSu.setHorizontalAlignment(SwingConstants.CENTER);
		txtSu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSu.setEditable(false);
		txtSu.setColumns(10);
		txtSu.setBackground(Color.WHITE);
		txtSu.setBounds(414, 62, 66, 22);
		pnlEntrees.add(txtSu);
		
		txtBR = new JTextField();		//textbox holding the amount of BBQ Ribs
		txtBR.setText("0");
		txtBR.setHorizontalAlignment(SwingConstants.CENTER);
		txtBR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBR.setEditable(false);
		txtBR.setColumns(10);
		txtBR.setBackground(Color.WHITE);
		txtBR.setBounds(414, 95, 66, 22);
		pnlEntrees.add(txtBR);
		
		txtSt = new JTextField();		//textbox holding the amount of Steak
		txtSt.setText("0");
		txtSt.setHorizontalAlignment(SwingConstants.CENTER);
		txtSt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSt.setEditable(false);
		txtSt.setColumns(10);
		txtSt.setBackground(Color.WHITE);
		txtSt.setBounds(414, 129, 66, 22);
		pnlEntrees.add(txtSt);
		
		txtSa = new JTextField();		//textbox holding the amount of Salmon
		txtSa.setText("0");
		txtSa.setHorizontalAlignment(SwingConstants.CENTER);
		txtSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSa.setEditable(false);
		txtSa.setColumns(10);
		txtSa.setBackground(Color.WHITE);
		txtSa.setBounds(414, 162, 66, 22);
		pnlEntrees.add(txtSa);
		
		JLabel lblItemE2 = new JLabel("Item");
		lblItemE2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemE2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemE2.setBounds(262, 0, 142, 25);
		pnlEntrees.add(lblItemE2);
		
		JLabel lblAmountE2 = new JLabel("Amount");
		lblAmountE2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountE2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountE2.setBounds(404, 0, 86, 25);
		pnlEntrees.add(lblAmountE2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(802, 233, 306, 319);
		frmLittleRestaurant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSales = new JButton("See Sales Database");
		btnSales.addActionListener(new ActionListener() {		//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {
				SalesDatabase saleFrame = new SalesDatabase();	//Starts instance of the SaleDatabase class
				saleFrame.setVisible(true);
			}
		});
		btnSales.setBounds(10, 261, 286, 47);
		panel.add(btnSales);
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnPricing = new JButton("See Menu Pricing Database");
		btnPricing.addActionListener(new ActionListener() {		//Waits for user to click on button
			public void actionPerformed(ActionEvent arg0) {
				MenuPricing priceFrame = new MenuPricing();		//Starts instance of the MenuPricing class
				priceFrame.setVisible(true);
			}
		});
		btnPricing.setBounds(10, 69, 286, 47);
		panel.add(btnPricing);
		btnPricing.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {		//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {
				// makes all the following textboxes 0
				clear();
				
			}
		});
		btnReset.setBounds(10, 11, 286, 47);
		panel.add(btnReset);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnFinishOrder = new JButton("Finish Order");
		btnFinishOrder.addActionListener(new ActionListener() {			//Waits for user to click on button
			public void actionPerformed(ActionEvent e) {
				double total = Double.parseDouble(txtTotal.getText());	//checks for number in total textbox
				double tax = Double.parseDouble(txtTax.getText());		//checks for number in tax textbox
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());	//gets the current time and date
				if (total == 0) {
					JOptionPane.showMessageDialog(null, "Sale could not be recorded! Error 4659: No sale amount to record.");
				}
				else
				try {     //connects to the Sales table of the database
					Class.forName("com.mysql.jdbc.Driver");    
					Connection con = DriverManager.getConnection("jdbc:mysql://107.180.40.144:3306/jamie_trent", "trentuproject", "Passw0rd");    
					Statement statement = con.createStatement();  
					//executes a statement that inserts values of Total, tax, and current timestamp into the Sales table
					statement.executeUpdate("INSERT INTO Sales VALUES ( Default, '"+ timestamp +"' , '"+ total +"' , '"+ tax +"')"); 
					JOptionPane.showMessageDialog(null, "Sale of $" + total + " successfully recorded into the database");
			    }
				catch(Exception x)        
			    {      
			       System.out.println(x);      
			    }    
				// sets all the text boxes back to 0 in preparation for a new sale
				clear();
				
			}
		});
		btnFinishOrder.setBounds(10, 129, 286, 121);
		panel.add(btnFinishOrder);
		btnFinishOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 255));
		panel_1.setBounds(802, 70, 306, 152);
		frmLittleRestaurant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 11, 286, 130);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(10, 9, 135, 33);
		panel_2.add(lblSubtotal);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubtotal.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblTax = new JLabel("13% Tax:");
		lblTax.setBounds(10, 42, 135, 33);
		panel_2.add(lblTax);
		lblTax.setHorizontalAlignment(SwingConstants.LEFT);
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(10, 86, 135, 33);
		panel_2.add(lblTotal);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		txtSubtotal = new JTextField();		//textbox holding the subtotal amount
		txtSubtotal.setText("0");
		txtSubtotal.setBounds(155, 11, 119, 28);
		panel_2.add(txtSubtotal);
		txtSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSubtotal.setEditable(false);
		txtSubtotal.setColumns(10);
		txtSubtotal.setBackground(Color.WHITE);
		
		txtTax = new JTextField();		//textbox holding the tax amount
		txtTax.setText("0");
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTax.setEditable(false);
		txtTax.setColumns(10);
		txtTax.setBackground(Color.WHITE);
		txtTax.setBounds(155, 42, 119, 28);
		panel_2.add(txtTax);
		
		txtTotal = new JTextField();		//textbox holding the total amount
		txtTotal.setText("0");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBackground(Color.WHITE);
		txtTotal.setBounds(155, 86, 119, 33);
		panel_2.add(txtTotal);
		
		JLabel lbldolsign = new JLabel("$");
		lbldolsign.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldolsign.setBounds(140, 11, 15, 26);
		panel_2.add(lbldolsign);
		
		JLabel lbldolsign2 = new JLabel("$");
		lbldolsign2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldolsign2.setBounds(140, 42, 15, 26);
		panel_2.add(lbldolsign2);
		
		JLabel lbldolsign3 = new JLabel("$");
		lbldolsign3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldolsign3.setBounds(140, 86, 15, 33);
		panel_2.add(lbldolsign3);
		
		JLabel lblhelp = new JLabel("1. Click an Item button to add to the order     2. Once finished, click 'Finish Order' to log the sale ");
		lblhelp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblhelp.setBounds(32, 37, 950, 22);
		frmLittleRestaurant.getContentPane().add(lblhelp);
		
		JLabel lblHow = new JLabel("How To Tips:");
		lblHow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHow.setBounds(32, 11, 110, 25);
		frmLittleRestaurant.getContentPane().add(lblHow);
	}
	
	//The following methods are for item prices that are the same amongst multiple items
	
	public static void calculate4() { //used for items costing $4 : Bruschetta, Pie, Cake
		double subtotal = Double.parseDouble(txtSubtotal.getText()); 	//checks for number in subtotal
		double price = subtotal + 4.00; 								//adds current price to subtotal
		txtSubtotal.setText("" + df.format(price)); 					//displays new subtotal
		
		double tax = price * 0.13; 							//takes new subtotal and calculates tax
		txtTax.setText("" + df.format(tax)); 				//displays new tax amount
		
		double total = price + tax; 						//sums new tax and subtotal amount
		txtTotal.setText("" + df.format(total)); 			//displays new total
		
	}
	public static void calculate5() { //used for items costing $5 : Perogies, Wine
		double subtotal = Double.parseDouble(txtSubtotal.getText()); 	//checks for number in subtotal
		double price = subtotal + 5.00; 								//adds current price to subtotal
		txtSubtotal.setText("" + df.format(price)); 					//displays new subtotal
		
		double tax = price * 0.13; 							//takes new subtotal and calculates tax
		txtTax.setText("" + df.format(tax)); 				//displays new tax amount
		
		double total = price + tax; 						//sums new tax and subtotal amount
		txtTotal.setText("" + df.format(total)); 			//displays new total
		
	}
	public static void calculate2() { //used for items costing $2 : FrenchFries Mixed Veggies, Rice, Ceasar Salad, Soda, Cookies
		double subtotal = Double.parseDouble(txtSubtotal.getText()); 	//checks for number in subtotal
		double price = subtotal + 2.00; 								//adds current price to subtotal
		txtSubtotal.setText("" + df.format(price)); 					//displays new subtotal
		
		double tax = price * 0.13; 							//takes new subtotal and calculates tax
		txtTax.setText("" + df.format(tax)); 				//displays new tax amount
		
		double total = price + tax; 						//sums new tax and subtotal amount
		txtTotal.setText("" + df.format(total)); 			//displays new total
		
	}
	public static void calculate3() { //used for items costing $3 : Baked Potatoe, Ice Cream, Pudding
		double subtotal = Double.parseDouble(txtSubtotal.getText()); 	//checks for number in subtotal
		double price = subtotal + 3.00; 								//adds current price to subtotal
		txtSubtotal.setText("" + df.format(price)); 					//displays new subtotal
		
		double tax = price * 0.13; 							//takes new subtotal and calculates tax
		txtTax.setText("" + df.format(tax)); 				//displays new tax amount
		
		double total = price + tax; 						//sums new tax and subtotal amount
		txtTotal.setText("" + df.format(total)); 			//displays new total
		
	}
	public static void calculate15() { //used for items costing $1.50 : Juice, Milk
		double subtotal = Double.parseDouble(txtSubtotal.getText()); 	//checks for number in subtotal
		double price = subtotal + 1.50; 								//adds current price to subtotal
		txtSubtotal.setText("" + df.format(price)); 					//displays new subtotal
		
		double tax = price * 0.13; 							//takes new subtotal and calculates tax
		txtTax.setText("" + df.format(tax)); 				//displays new tax amount
		
		double total = price + tax; 						//sums new tax and subtotal amount
		txtTotal.setText("" + df.format(total)); 			//displays new total
		
	}
	
	
	
	
	
	
	
}
