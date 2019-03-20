package Login_sys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Details2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details2 frame = new Details2();
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
	public Details2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBounds(235, 21, 46, 14);
		contentPane.add(lblMenu);
		
		
		//for inserting details
		JButton btnNewButton = new JButton("1. Insert Movie Detail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert d2=new Insert();
				d2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(170, 66, 195, 23);
		contentPane.add(btnNewButton);
		
		
		//for searching details
		JButton btnNewButton_1 = new JButton("2. Search Movie Detail");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Menu d3=new Search_Menu();
				d3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(170, 117, 195, 23);
		contentPane.add(btnNewButton_1);
		
		
		//for updating details
		JButton btnNewButton_2 = new JButton("3. Update Movie Detail");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update2 d4=new Update2();
				d4.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(170, 166, 195, 23);
		contentPane.add(btnNewButton_2);
		
		
		//for deleting details
		JButton btnNewButton_3 = new JButton("4. Delete Movie Detail");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete d5=new Delete();
				d5.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(170, 219, 195, 23);
		contentPane.add(btnNewButton_3);
		
		
		//for exit
		JButton btnNewButton_4 = new JButton("5. Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem,"confirm if you want to exit","Login System",JOptionPane.YES_NO_OPTION )==JOptionPane.YES_NO_OPTION){
					System.exit(0);}
			}
		});
		btnNewButton_4.setBounds(170, 267, 195, 23);
		contentPane.add(btnNewButton_4);
		
		
	}

}
