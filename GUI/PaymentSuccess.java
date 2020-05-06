/**
 * @update: 2020-05-01 Qi Lin
 *          Set the initial value of amountPaid to 0 (line 84-87)
 *          Only when isUseStamp() is false will set the value of amountPaid to the bill price
 *
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
import javax.swing.JLabel;

public class PaymentSuccess extends JFrame {

    private JPanel contentPane;
    JButton btnNewButton_1 = new JButton("Confirm");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PaymentSuccess frame = new PaymentSuccess(null, 0);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void runPaySuccess(Bill bill, int userID) {
        try {
            PaymentSuccess frame = new PaymentSuccess(bill, userID);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.btnNewButton_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    frame.setVisible(false);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public PaymentSuccess(Bill bill, int userID) {
        setTitle("Payment Success");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("You have paid successfully!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel.setBounds(76, 54, 576, 48);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("We will give your meal quickly!");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1.setBounds(76, 126, 576, 58);
        contentPane.add(lblNewLabel_1);

        float amountPaid = 0;
        if (bill.isUseStamp() == false) {
            amountPaid = bill.getPrice();
        }

        JLabel lblNewLabel_2 = new JLabel("Actual amount paid: " + amountPaid);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_2.setBounds(76, 216, 576, 48);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3;
        if (userID != 0) {
            int stampsNo = new UserClass().login(userID).getStamp();

            lblNewLabel_3 = new JLabel("Remainder virtual stamps: " + stampsNo);
        } else {
            lblNewLabel_3 = new JLabel("You haven't login");
        }
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_3.setBounds(76, 301, 583, 48);
        contentPane.add(lblNewLabel_3);

        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton_1.setBounds(479, 352, 187, 64);
        contentPane.add(btnNewButton_1);
    }
}
