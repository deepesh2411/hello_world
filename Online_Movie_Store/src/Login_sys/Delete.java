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

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setBounds(239, 42, 46, 14);
		contentPane.add(lblDelete);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(192, 122, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(321, 119, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					String sql="DELETE FROM movie_details WHERE id=?" ;
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted sucessfully");
				}
				catch(Exception e3){
					JOptionPane.showMessageDialog(null, "invalid");
				}
			}
		});
		btnDelete.setBounds(321, 206, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details2 d=new Details2();
				d.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(179, 206, 89, 23);
		contentPane.add(btnBack);
	}
}
