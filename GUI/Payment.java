/**
 * @author: Luming Xiao
 * @description: GUI of payment
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Payment extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton = new JButton("Previous Level");
	JButton btnNewButton_1 = new JButton("Confirm");
	JRadioButton rdbtnNewRadioButton = new JRadioButton("10 virtual stamps");
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cash/Card");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	rdbtnNewRadioButton.setEnabled(false);
					Payment frame = new Payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void runPayment(boolean flag) {
		try {


			Payment frame = new Payment();
			frame.rdbtnNewRadioButton.setEnabled(flag);
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
					PaymentSuccess paySu = new PaymentSuccess();
					frame.setVisible(false);
					paySu.runPaySuccess();

				}
			});


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Payment() {
		setTitle("Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		rdbtnNewRadioButton.setFont(new Font("����", Font.BOLD, 25));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setBounds(118, 46, 487, 103);
		contentPane.add(rdbtnNewRadioButton);//������д��û�е�½��Ա����ǲ���ѡ��
		

		rdbtnNewRadioButton_1.setFont(new Font("����", Font.BOLD, 25));
		rdbtnNewRadioButton_1.setBounds(118, 154, 487, 103);
		contentPane.add(rdbtnNewRadioButton_1);
		
        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(rdbtnNewRadioButton_1);
        btnGroup1.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton_1.setSelected(true);
		
		JLabel lblNewLabel = new JLabel("You have aaa virtual stamps(\u65B9\u6CD5\u4E2D\u8F93\u5165)");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 266, 487, 80);
		contentPane.add(lblNewLabel);//������д��û�е�½��Ա�ǲ���ʾ��
		
		

		btnNewButton.setFont(new Font("����", Font.BOLD, 20));
		btnNewButton.setBounds(113, 352, 204, 64);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setFont(new Font("����", Font.BOLD, 20));
		btnNewButton_1.setBounds(479, 352, 187, 64);
		contentPane.add(btnNewButton_1);
	}

}
