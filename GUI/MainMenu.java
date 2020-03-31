/**
 * @author: Luming Xiao
 * @description: GUI of main menu windows
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("Customor");
	JButton btnNewButton_1 = new JButton("Store");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
				//	frame.setVisible(true);
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

/*			frame.button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					store_comment co = new store_comment();
					frame.setVisible(false);
					co.runco();
				}
			});*/

			
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
		setBounds(700, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton.setBounds(250, 70, 296, 86);
		contentPane.add(btnNewButton);

		btnNewButton_1.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton_1.setBounds(250, 250, 296, 86);
		contentPane.add(btnNewButton_1);
	}
}
