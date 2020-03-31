/**
 * @author: Luming Xiao
 * @description: GUI of ding opions windows
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DingOpions extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("Eat in");
	JButton btnNewButton_1 = new JButton("Take-away");
	boolean flag;//flag true is eat in flase is take-away

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DingOpions frame = new DingOpions();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void runOpions() {
		try {
			DingOpions frame = new DingOpions();
			frame.setVisible(true);
			
			frame.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = true;
					System.out.println(flag);
					LoyaltyNumber loyalty = new LoyaltyNumber();
					frame.setVisible(false);
					loyalty.runLoyalty();
				}
			});

			frame.btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					flag = false;
					System.out.println(flag);
					LoyaltyNumber loyalty = new LoyaltyNumber();
					frame.setVisible(false);
					loyalty.runLoyalty();
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
	public DingOpions() {
		setTitle("Ding Opions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		btnNewButton.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(250, 70, 296, 86);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setFont(new Font("����", Font.BOLD, 30));
		btnNewButton_1.setBounds(250, 250, 296, 86);
		contentPane.add(btnNewButton_1);
	}

}
