
/**
 * @author: Luming Xiao
 * @description: GUI of payment successful windows
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistSuccess extends JFrame {

    private JPanel contentPane;
    JButton btnNewButton_1 = new JButton("Confirm");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistSuccess frame = new RegistSuccess();
                    //		frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void runSuccess(int userID, Bill bill) {
        try {
            RegistSuccess frame = new RegistSuccess();
            frame.setVisible(true);

            frame.btnNewButton_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Payment pay = new Payment();
                    frame.setVisible(false);
                    pay.runPayment(true, userID, bill);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public RegistSuccess() {
        setTitle("Success!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("You regist successful!");
        lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel.setBounds(86, 74, 542, 74);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Your loyalty number is aaaaa!");//����������
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_1.setBounds(86, 212, 542, 74);
        contentPane.add(lblNewLabel_1);


        btnNewButton_1.setFont(new Font("����", Font.BOLD, 20));
        btnNewButton_1.setBounds(479, 352, 187, 64);
        contentPane.add(btnNewButton_1);
    }

}
