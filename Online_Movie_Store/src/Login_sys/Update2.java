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
import java.awt.event.ActionEvent;

public class Update2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update2 frame = new Update2();
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
	public Update2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setBounds(220, 22, 46, 14);
		contentPane.add(lblUpdate);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(103, 68, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblMovieName = new JLabel("MOVIE NAME");
		lblMovieName.setBounds(103, 119, 75, 14);
		contentPane.add(lblMovieName);
		
		JLabel lblNewLabel = new JLabel("Actor");
		lblNewLabel.setBounds(103, 166, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblActress = new JLabel("Actress");
		lblActress.setBounds(103, 213, 46, 14);
		contentPane.add(lblActress);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(103, 256, 46, 14);
		contentPane.add(lblCategory);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(103, 298, 46, 14);
		contentPane.add(lblRating);
		
		textField = new JTextField();
		textField.setBounds(258, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 116, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 163, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(258, 210, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(258, 253, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(258, 295, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql= "UPDATE movie_details SET movie_name=?,Actor=?,Actress=?,Category=?,Rating=? WHERE id =?";
					PreparedStatement pst=con.prepareStatement(sql);
					
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_4.getText());
					pst.setString(5, textField_5.getText());
					pst.setString(6, textField.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "updated sucessfully");
				}
				catch(Exception e2)
				{
					System.out.print("ranjan");
					JOptionPane.showMessageDialog(null, "invalid");
				}
			}
		});
		btnUpdate.setBounds(434, 115, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details2 d=new Details2();
				d.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(434, 196, 89, 23);
		contentPane.add(btnBack);
	}
}
