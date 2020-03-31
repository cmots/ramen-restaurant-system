/**
 * @author: Luming Xiao
 * @description: GUI of regist windows
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btnNewButton = new JButton("Previous Level");
	JButton btnNewButton_1 = new JButton("Confirm");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void runRegist() {
		try {
			Regist frame = new Regist();
			frame.setVisible(true);
			
			frame.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					LoyaltyNumber loyalty = new LoyaltyNumber();
					frame.setVisible(false);
					loyalty.runLoyalty();
				}
			});

			frame.btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					RegistSuccess success = new RegistSuccess();
					frame.setVisible(false);
					success.runSuccess();
				}
			});


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Regist() {
		setTitle("Regist");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		btnNewButton.setFont(new Font("����", Font.BOLD, 20));
		btnNewButton.setBounds(113, 352, 204, 64);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setFont(new Font("����", Font.BOLD, 20));
		btnNewButton_1.setBounds(479, 352, 187, 64);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 40, 131, 43);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setFont(new Font("����", Font.BOLD, 20));
		textField.setBounds(424, 51, 175, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_1.setBounds(113, 120, 105, 43);
		contentPane.add(lblNewLabel_1);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.BOLD, 20));
		textField_1.setBounds(424, 131, 175, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_2.setBounds(113, 200, 105, 43);
		contentPane.add(lblNewLabel_2);
		textField_2 = new JTextField();
		textField_2.setFont(new Font("����", Font.BOLD, 20));
		textField_2.setBounds(424, 211, 175, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_3.setBounds(113, 280, 105, 43);
		contentPane.add(lblNewLabel_3);
		textField_3 = new JTextField();
		textField_3.setFont(new Font("����", Font.BOLD, 20));
		textField_3.setBounds(424, 291, 175, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}
