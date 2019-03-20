package Login_sys;

import java.awt.EventQueue;
import java.awt.Image;

//import java.awt.Toolkit;
//import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Login_s {

	private JFrame frame;
	private JFrame frmLoginSystem;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_s window = new Login_s();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public Login_s() {
		initialize();
	}
	/**public void close()
	{
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	**/
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setForeground(new Color(60, 179, 113));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(199, 26, 165, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel UserName = new JLabel("USER NAME");
		UserName.setBounds(113, 99, 72, 25);
		frame.getContentPane().add(UserName);
		
		JLabel Password = new JLabel("PASSWORD");
		Password.setBounds(113, 150, 72, 25);
		frame.getContentPane().add(Password);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(232, 101, 97, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(232, 152, 97, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=txtPassword.getText();
				String username=txtUsername.getText();
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","");
					Statement st=con.createStatement();
					String sql="Select * from user where username='"+txtUsername.getText()+"' and password='"+txtPassword.getText()+"'";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "login sucessfully");
							Details2 d=new Details2();
							d.setVisible(true);
							frame.dispose();
						}
					else
						{
							JOptionPane.showMessageDialog(null, "invalid");
							txtUsername.setText(null);
							txtPassword.setText(null);
						}
					con.close();
				}
				catch(Exception e1){
					System.out.println("deepesh");
				}
			}
		});
		btnLogin.setBounds(85, 246, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		
		//reset
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(246, 246, 89, 23);
		frame.getContentPane().add(btnReset);
		
		
		//exit
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if you want to exit","Login System",JOptionPane.YES_NO_OPTION )==JOptionPane.YES_NO_OPTION){
					System.exit(0);}
			}
		});
		btnExit.setBounds(403, 246, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(370, 65, 204, 145);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
