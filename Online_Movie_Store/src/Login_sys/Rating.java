package Login_sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Rating extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rating frame = new Rating();
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
	public Rating() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(52, 57, 46, 14);
		contentPane.add(lblRating);
		
		textField = new JTextField();
		textField.setBounds(215, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql="Select * from movie_details where Rating='"+textField.getText()+"'";
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
		btnEnter.setBounds(433, 53, 89, 23);
		contentPane.add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 121, 498, 181);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Menu d=new Search_Menu();
				d.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(235, 327, 89, 23);
		contentPane.add(btnBack);
	}

}
