/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sinhvien;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Sinhvien3 extends JPanel {

    Myframe m;
    JPanel panel;
    JPanel paneltop;
    JPanel panelcenter;
    JPanel panelbottom;
    JLabel lable1;
    JLabel lable2;
    JButton button;

    public Sinhvien3(Myframe m) {
        this.m = m;
        load();
    }

    void load() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        paneltop = new JPanel();
        panelcenter = new JPanel();
        panelbottom = new JPanel();
        lable1 = new JLabel("Đặng Ngọc Thuyên");
        lable2 = new JLabel("MSSV:20102277--CNTT1 K55");
        button = new JButton();
        ImageIcon icon = new ImageIcon("ngocthuyen.jpg");
        button.setIcon(icon);
        panelcenter.add(button);
        paneltop.add(lable1);
        panelbottom.add(lable2);
        panel.add(paneltop, BorderLayout.NORTH);
        panel.add(panelbottom, BorderLayout.SOUTH);
        panel.add(panelcenter, BorderLayout.CENTER);
        add(panel);
    }
}
