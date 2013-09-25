/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dangphi;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Tran Xuan Truong
 */
public class Dangphithem extends JFrame {

    JLabel tennhanvien;
    JLabel hesoluong;
    JLabel pcchucvu;
    JLabel phucap;
    JLabel dangphi;
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    JTextField txt4;
    JTextField txt5;
    private final JButton them;

    public Dangphithem() {
        setTitle("Sửa Thông Tin Đảng Phí");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        them = new JButton("Thêm");
        tennhanvien = new JLabel("Tên Nhân Viên");
        hesoluong = new JLabel("Hệ Số Lương");
        pcchucvu = new JLabel("PC Chức Vụ");
        phucap = new JLabel("Phụ Cấp");
        dangphi = new JLabel("Đảng Phí");
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        txt4 = new JTextField();
        txt5 = new JTextField();
        tennhanvien.setBounds(20, 20, 100, 30);
        hesoluong.setBounds(20, 70, 100, 30);
        pcchucvu.setBounds(20, 120, 100, 30);
        phucap.setBounds(20, 170, 100, 30);
        dangphi.setBounds(20, 220, 100, 30);
        txt1.setBounds(150, 20, 150, 30);
        txt2.setBounds(150, 70, 150, 30);
        txt3.setBounds(150, 120, 150, 30);
        txt4.setBounds(150, 170, 150, 30);
        txt5.setBounds(150, 220, 150, 30);
        them.setBounds(150, 270, 70, 30);
        add(tennhanvien);
        add(hesoluong);
        add(pcchucvu);
        add(phucap);
        add(dangphi);
        add(txt1);
        add(txt2);
        add(txt3);
        add(txt4);
        add(txt5);
        add(them);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dangphithem();
    }
}
