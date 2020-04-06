
/**
 * @author: Luming Xiao
 * @description: GUI of add onos windows
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addonos extends JFrame {

    private JPanel contentPane;
    JButton btnNewButton = new JButton("Confirm");
    JButton btnNewButton_1 = new JButton("Previous Level");

    String[] listData = new String[]{"0", "1", "2", "3", "4", "5"};
    final JComboBox<String> comboBox = new JComboBox<String>(listData);
    final JComboBox<String> comboBox_1 = new JComboBox<String>(listData);
    final JComboBox<String> comboBox_2 = new JComboBox<String>(listData);
    final JComboBox<String> comboBox_3 = new JComboBox<String>(listData);
    int a, b, c, d = 0;

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

    public void runAddonos(Bill bill) {
        try {
            Addonos frame = new Addonos();
            frame.setVisible(true);

            frame.btnNewButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    a = frame.comboBox.getSelectedIndex();
                    b = frame.comboBox_1.getSelectedIndex();
                    c = frame.comboBox_2.getSelectedIndex();
                    d = frame.comboBox_3.getSelectedIndex();
                    Addon addon = new Addon(a, b, c, d);
                    bill.setAddon(addon);
                    DingOpions opions = new DingOpions();
                    frame.setVisible(false);
                    opions.runOpions(bill);
                }
            });

            frame.btnNewButton_1.addActionListener(new ActionListener() {
                //previous level
                @Override
                public void actionPerformed(ActionEvent e) {
                    Order order = new Order();
                    frame.setVisible(false);
                    order.runOrder();
                }
            });

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

        Addon addonInfo = new RamenClass().getAddonInfo();
        float e = addonInfo.getBambooCost();
        float f = addonInfo.getChashuCost();
        float g = addonInfo.getEggCost();
        float h = addonInfo.getNoriCost();
        JLabel lblNewLabel = new JLabel("Extral Nori: ￡" + h);
        JLabel lblNewLabel_1 = new JLabel("Extral Boiled Egg: ￡" + g);
        JLabel lblNewLabel_2 = new JLabel("Extral Shoots: ￡" + e);
        JLabel lblNewLabel_3 = new JLabel("Extral Chashu: ￡" + f);

        if (e == -1) {
            comboBox.setEnabled(false);
        }
        if (f == -1) {
            comboBox_1.setEnabled(false);
        }
        if (g == -1) {
            comboBox_2.setEnabled(false);
        }
        if (h == -1) {
            comboBox_3.setEnabled(false);
        }

        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton_1.setBounds(104, 352, 238, 69);
        contentPane.add(btnNewButton_1);

        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton.setBounds(438, 352, 238, 69);
        contentPane.add(btnNewButton);

        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(104, 36, 230, 42);
        contentPane.add(lblNewLabel);

        comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        comboBox.setBounds(429, 47, 152, 24);
        contentPane.add(comboBox);

        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(104, 112, 280, 42);
        contentPane.add(lblNewLabel_1);

        comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        comboBox_1.setBounds(429, 123, 152, 24);
        contentPane.add(comboBox_1);

        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(104, 188, 230, 42);
        contentPane.add(lblNewLabel_2);

        comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        comboBox_2.setBounds(429, 199, 152, 24);
        contentPane.add(comboBox_2);


        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setBounds(104, 262, 230, 42);
        contentPane.add(lblNewLabel_3);


        comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        comboBox_3.setBounds(429, 273, 152, 24);
        contentPane.add(comboBox_3);
    }

}
