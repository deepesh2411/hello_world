package Login_sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Actor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actor frame = new Actor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Actor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActorName = new JLabel("Actor name");
		lblActorName.setBounds(106, 65, 93, 14);
		contentPane.add(lblActorName);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			/**	try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql="Select * from movie_details where Actor='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					//pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e3){
					//JOptionPane.showMessageDialog(null, "invalid");
				}
				**/
			}
		});
		textField.setBounds(209, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql="Select * from movie_details where Actor='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					//pst.setString(1, textField.getText());
					ResultSet rs=pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e3){
					JOptionPane.showMessageDialog(null, "invalid");
				}
				
				
				
			
			}
		});
		btnEnter.setBounds(381, 61, 89, 23);
		contentPane.add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 321, 415, 109);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search_Menu d=new Search_Menu();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(381, 108, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DE40024423\\Desktop\\50aabad1ca1ee.image.jpg"));
		lblNewLabel.setBounds(0, 0, 614, 441);
		contentPane.add(lblNewLabel);
	}
}
