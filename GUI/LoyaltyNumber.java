
/**
 * @author: Luming Xiao
 * @description: GUI of loyalty number windows
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class LoyaltyNumber extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    JButton btnNewButton = new JButton("Log In");
    JButton btnNewButton_1 = new JButton("Regist");
    JButton btnNewButton_2 = new JButton("No Thanks");
    boolean flag;//true is log false is not

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoyaltyNumber frame = new LoyaltyNumber();
                    //	frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void runLoyalty(Bill bill) {
        try {
            LoyaltyNumber frame = new LoyaltyNumber();
            frame.setVisible(true);

            frame.btnNewButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    String logNumber = frame.textField.getText();
                    System.out.println(logNumber);
                    flag = true;
                    System.out.println(flag);
                    bill.setLogin(true);
                    User testUser = new UserClass().login(Integer.parseInt(logNumber));
                    if (testUser == null) {
                        //TODO
                    } else {
                        Payment pay = new Payment(testUser.getUserID());
                        frame.setVisible(false);
                        pay.runPayment(flag, testUser.getUserID(), bill);
                    }
                }
            });

            frame.btnNewButton_2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    flag = false;
                    bill.setLogin(false);
                    System.out.println(flag);
                    Payment pay = new Payment(0);
                    frame.setVisible(false);
                    pay.runPayment(flag, 0, bill);
                }
            });
            frame.btnNewButton_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    bill.setLogin(true);
                    Regist regist = new Regist();
                    frame.setVisible(false);
                    regist.runRegist(bill);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public LoyaltyNumber() {
        setTitle("Loyalty Scheme");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 800, 500);
        ;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Would you like to log your loyalty number?");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel.setBounds(85, 42, 598, 80);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textField.setBounds(85, 160, 598, 44);
        contentPane.add(textField);
        textField.setColumns(10);


        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBounds(85, 327, 160, 54);
        contentPane.add(btnNewButton);


        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton_1.setBounds(523, 327, 160, 54);
        contentPane.add(btnNewButton_1);


        btnNewButton_2.setFont(new Font("����", Font.BOLD, 20));
        btnNewButton_2.setBounds(308, 327, 160, 54);
        contentPane.add(btnNewButton_2);
    }

}
