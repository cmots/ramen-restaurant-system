
/**
 * @author: Luming Xiao
 * @description: GUI of main menu windows
 *
 * @update 2020-04-27
 * 		   Hide the entrance of the management system from the main menu
 * @update 2020-05-01 Zhecan Yang
 * jump to the authentication interface while pressing the manage button
 *
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;import java.awt.Dimension;import java.awt.Font; import javax.swing.ImageIcon;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JTextField;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("TOUCH TO START");
	JButton btnNewButton_1 = new JButton("manage");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					
			//		frame.setVisible(true);
					frame.runMainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void runMainMenu() {
		try {
			MainMenu frame = new MainMenu();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			frame.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Order order = new Order();
					frame.setVisible(false);
					order.runOrder();
				}
			});

			frame.btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					LoginManager co = new LoginManager();
					frame.setVisible(false);
					co.runLogin();
				}
			});

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 680, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton.setBounds(0, 378, 680, 75);
		contentPane.add(btnNewButton);

		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_1.setBounds(14, 13, 90, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel jl3=new JLabel(new ImageIcon("image/MainMenu.jpg"));
		contentPane.add(jl3);
		jl3.setBounds(-74, 0, 806, 578);

	}
}
