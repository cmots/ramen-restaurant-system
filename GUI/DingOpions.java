
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
	/**
	 * flag true is eat in
	 * false is take-away
	 */
	boolean flag;

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
	
	public void runOpions(Bill bill) {
		try {
			DingOpions frame = new DingOpions();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			frame.btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					/**
					 * eat in
					 */
					bill.setTakeAway(false);
					flag = true;
					LoyaltyNumber loyalty = new LoyaltyNumber();
					frame.setVisible(false);
					loyalty.runLoyalty(bill);
				}
			});

			frame.btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					/**
					 * take away
					 */
					bill.setTakeAway(true);
					flag = false;
					LoyaltyNumber loyalty = new LoyaltyNumber();
					frame.setVisible(false);
					loyalty.runLoyalty(bill);
				}
			});
			
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
		

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(250, 70, 296, 86);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(250, 250, 296, 86);
		contentPane.add(btnNewButton_1);
	}

}
