package Login_sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		setTitle("MOVIES_4_U");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsert = new JLabel("INSERT");
		lblInsert.setBounds(182, 25, 46, 14);
		contentPane.add(lblInsert);
		
		JLabel lblMovieName = new JLabel("Movie name");
		lblMovieName.setBounds(85, 73, 78, 14);
		contentPane.add(lblMovieName);
		
		JLabel lblActor = new JLabel("Actor");
		lblActor.setBounds(85, 111, 46, 14);
		contentPane.add(lblActor);
		
		JLabel lblActerss = new JLabel("Actress");
		lblActerss.setBounds(85, 147, 46, 14);
		contentPane.add(lblActerss);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(85, 182, 46, 14);
		contentPane.add(lblCategory);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(85, 214, 46, 14);
		contentPane.add(lblRating);
		
		textField = new JTextField();
		textField.setBounds(209, 70, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 108, 108, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 144, 108, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 179, 108, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(209, 214, 108, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql="INSERT INTO movie_details"
							+"(movie_name,Actor, Actress, Category, Rating)"+" VALUES (?,?,?,?,?)" ;
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.executeUpdate();
					
					textField.setText(null);textField_1.setText(null);textField_2.setText(null);textField_3.setText(null);textField_4.setText(null);
					JOptionPane.showMessageDialog(null, "Inserted sucessfully");
				}
				catch(Exception e2)
				{
					System.out.print("ranjan");
					JOptionPane.showMessageDialog(null, "invalid");
				}
			}
		});
		btnInsert.setBounds(361, 102, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details2 d=new Details2();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(361, 157, 89, 23);
		contentPane.add(btnNewButton);
	}
}
