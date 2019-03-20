package Login_sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class Search_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Menu frame = new Search_Menu();
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
	public Search_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchmenu = new JLabel("Search_Menu");
		lblSearchmenu.setForeground(new Color(165, 42, 42));
		lblSearchmenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchmenu.setBounds(195, 22, 176, 29);
		contentPane.add(lblSearchmenu);
		
		JButton btnNewButton = new JButton("1. Search by Actor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actor a=new Actor();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(181, 71, 171, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2. Search by Actress");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actress a=new Actress();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(181, 122, 171, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3. Search by Category");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category a=new Category();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(181, 177, 171, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4. Search by Rating");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rating a=new Rating();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(181, 230, 171, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5. Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 JFrame	frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if you want to exit","Login System",JOptionPane.YES_NO_OPTION )==JOptionPane.YES_NO_OPTION){
					System.exit(0);}
			}
		});
		btnNewButton_4.setBounds(181, 282, 171, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details2 d=new Details2();
				d.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(410, 140, 89, 23);
		contentPane.add(btnBack);
	}
}
