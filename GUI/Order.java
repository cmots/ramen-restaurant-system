
/**
 * @author: Luming Xiao
 * @description: GUI of order windows
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Order extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    JButton btnNewButton = new JButton("Add-onos");
    JButton btnNewButton_1 = new JButton("Confirm");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Order frame = new Order();
                    //		frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void runOrder() {
        try {
            Order frame = new Order();
            frame.setVisible(true);

            frame.btnNewButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Ramen ramen = new Ramen("s", "n", "o", true, false, true, 3);
                    Bill bill = new Bill(ramen,null,false,false,false,0,null);
                    Addonos add = new Addonos();
                    frame.setVisible(false);
                    add.runAddonos(bill);
                }
            });

            frame.btnNewButton_1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Ramen ramen = new Ramen("s", "n", "o", true, false, true, 3);
                    Addon addon = new Addon(0,0,0,0);
                    Bill bill = new Bill(ramen,addon,false,false,false,0,null);
                    DingOpions options = new DingOpions();
                    frame.setVisible(false);
                    options.runOpions(bill);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     */
    public Order() {
        setTitle("Order dishes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        btnNewButton.setFont(new Font("����", Font.BOLD, 25));
        btnNewButton.setBounds(147, 355, 164, 85);
        contentPane.add(btnNewButton);


        btnNewButton_1.setFont(new Font("����", Font.BOLD, 25));
        btnNewButton_1.setBounds(447, 355, 164, 85);
        contentPane.add(btnNewButton_1);

        lblNewLabel = new JLabel("Soup");
        lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel.setBounds(15, 15, 190, 45);
        contentPane.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Tonkostu");
        rdbtnNewRadioButton.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton.setBounds(210, 25, 139, 27);
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("Shoyu");
        rdbtnNewRadioButton_0.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_0.setBounds(405, 25, 78, 27);
        contentPane.add(rdbtnNewRadioButton_0);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Shio");
        rdbtnNewRadioButton_2.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_2.setBounds(600, 25, 157, 27);
        contentPane.add(rdbtnNewRadioButton_2);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnNewRadioButton);
        btnGroup.add(rdbtnNewRadioButton_0);
        btnGroup.add(rdbtnNewRadioButton_2);
        rdbtnNewRadioButton.setSelected(true);

        JLabel lblNewLabel_1 = new JLabel("Noodles");
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_1.setBounds(15, 85, 190, 45);
        contentPane.add(lblNewLabel_1);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Soft");
        rdbtnNewRadioButton_1.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_1.setBounds(210, 95, 78, 27);
        contentPane.add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Medium");
        rdbtnNewRadioButton_3.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_3.setBounds(405, 95, 106, 27);
        contentPane.add(rdbtnNewRadioButton_3);

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Firm");
        rdbtnNewRadioButton_4.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_4.setBounds(600, 95, 157, 27);
        contentPane.add(rdbtnNewRadioButton_4);

        ButtonGroup btnGroup1 = new ButtonGroup();
        btnGroup1.add(rdbtnNewRadioButton_1);
        btnGroup1.add(rdbtnNewRadioButton_3);
        btnGroup1.add(rdbtnNewRadioButton_4);
        rdbtnNewRadioButton_1.setSelected(true);

        JLabel lblNewLabel_2 = new JLabel("Onion");
        lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_2.setBounds(15, 155, 190, 45);
        contentPane.add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("No");
        rdbtnNewRadioButton_5.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_5.setBounds(210, 165, 78, 27);
        contentPane.add(rdbtnNewRadioButton_5);

        JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("A little");
        rdbtnNewRadioButton_6.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_6.setBounds(405, 165, 133, 27);
        contentPane.add(rdbtnNewRadioButton_6);

        JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("A lot");
        rdbtnNewRadioButton_7.setFont(new Font("����", Font.BOLD, 18));
        rdbtnNewRadioButton_7.setBounds(600, 165, 157, 27);
        contentPane.add(rdbtnNewRadioButton_7);

        ButtonGroup btnGroup2 = new ButtonGroup();
        btnGroup2.add(rdbtnNewRadioButton_5);
        btnGroup2.add(rdbtnNewRadioButton_6);
        btnGroup2.add(rdbtnNewRadioButton_7);
        rdbtnNewRadioButton_5.setSelected(true);

        JLabel lblNewLabel_3 = new JLabel("Ingredient");
        lblNewLabel_3.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_3.setBounds(15, 225, 190, 45);
        contentPane.add(lblNewLabel_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Nori");
        chckbxNewCheckBox.setFont(new Font("����", Font.BOLD, 18));
        chckbxNewCheckBox.setBounds(210, 235, 121, 27);
        contentPane.add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Chashu");
        chckbxNewCheckBox_1.setFont(new Font("����", Font.BOLD, 18));
        chckbxNewCheckBox_1.setBounds(405, 235, 121, 27);
        contentPane.add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Boiled egg");
        chckbxNewCheckBox_2.setFont(new Font("����", Font.BOLD, 18));
        chckbxNewCheckBox_2.setBounds(600, 235, 133, 27);
        contentPane.add(chckbxNewCheckBox_2);

        JLabel lblNewLabel_4 = new JLabel("Spiciness");
        lblNewLabel_4.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_4.setBounds(15, 295, 133, 45);
        contentPane.add(lblNewLabel_4);

        JSlider slider = new JSlider();
        slider.setMinimum(1);
        slider.setMaximum(5);
        slider.setBounds(300, 309, 278, 26);
        contentPane.add(slider);
        slider.setMajorTickSpacing(5);

        JLabel lblNewLabel_5 = new JLabel("NO");
        lblNewLabel_5.setFont(new Font("����", Font.BOLD, 18));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(227, 324, 61, 18);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("MAX");
        lblNewLabel_6.setFont(new Font("����", Font.BOLD, 18));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(576, 324, 72, 18);
        contentPane.add(lblNewLabel_6);

    }
}
