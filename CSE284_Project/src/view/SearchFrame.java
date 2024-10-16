package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author macbook
 */
public class SearchFrame extends JFrame {
    private MainFrame mainFrame;
    private JButton btnTimKiem;
    private JLabel label;
    private JTextField txtMaHocSinh;
    private JPanel panel;
    public SearchFrame(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        
        // Create GUI
        setTitle("Tim Kiem Hoc Sinh");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        label = new JLabel("Nhap Ma Hoc Sinh", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        txtMaHocSinh = new JTextField();
        btnTimKiem = new JButton("Tim Kiem");
        
        panel.add(label);
        panel.add(txtMaHocSinh);
        panel.add(btnTimKiem);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
        
        /**
         * Process Event
         */
        btnTimKiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maHS = txtMaHocSinh.getText();
                mainFrame.searchHocSinh(maHS);
                dispose();
            }
            
        });
    }
}
