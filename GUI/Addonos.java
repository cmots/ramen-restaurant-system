/**
 * @author: Luming Xiao
 * @description: GUI of add onos windows
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
import javax.swing.JComboBox;

public class Addonos extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("Confirm");
	JButton btnNewButton_1 = new JButton("Previous Level");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addonos frame = new Addonos();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void runAddonos() {
		try {
			Addonos frame = new Addonos();
			frame.setVisible(true);
			
			frame.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DingOpions opions = new DingOpions();
					frame.setVisible(false);
					opions.runOpions();
				}
			});

			frame.btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Order order = new Order();
					frame.setVisible(false);
					order.runOrder();
				}
			});
	/*		frame.button_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					store_order or = new store_order();
					frame.setVisible(false);
					or.runor();
				}
			});
			frame.button_4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					store_order_search oss = new store_order_search();
					frame.setVisible(false);
					oss.runoss();
				}
			});*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Addonos() {
		setTitle("Add-onos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		btnNewButton_1.setFont(new Font("����", Font.BOLD, 25));
		btnNewButton_1.setBounds(104, 352, 238, 69);
		contentPane.add(btnNewButton_1);
		

		btnNewButton.setFont(new Font("����", Font.BOLD, 25));
		btnNewButton.setBounds(438, 352, 238, 69);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Extral Nori");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(104, 36, 209, 42);
		contentPane.add(lblNewLabel);
		
        String[] listData = new String[]{"0","1", "2", "3", "4","5"};
        final JComboBox<String> comboBox = new JComboBox<String>(listData);
		comboBox.setFont(new Font("����", Font.BOLD, 20));
		comboBox.setBounds(429, 47, 152, 24);
		contentPane.add(comboBox);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Extral Boiled Egg");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_1.setBounds(104, 112, 195, 42);
		contentPane.add(lblNewLabel_1);
		
        final JComboBox<String> comboBox_1 = new JComboBox<String>(listData);
		comboBox_1.setFont(new Font("����", Font.BOLD, 20));
		comboBox_1.setBounds(429, 123, 152, 24);
		contentPane.add(comboBox_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Extral Shoots");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_2.setBounds(104, 188, 176, 42);
		contentPane.add(lblNewLabel_2);
		
        final JComboBox<String> comboBox_2 = new JComboBox<String>(listData);
		comboBox_2.setFont(new Font("����", Font.BOLD, 20));
		comboBox_2.setBounds(429, 199, 152, 24);
		contentPane.add(comboBox_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Extral Chashu");
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_3.setBounds(104, 262, 195, 42);
		contentPane.add(lblNewLabel_3);
		
        final JComboBox<String> comboBox_3 = new JComboBox<String>(listData);
		comboBox_3.setFont(new Font("����", Font.BOLD, 20));
		comboBox_3.setBounds(429, 273, 152, 24);
		contentPane.add(comboBox_3);
		

	}

}
