/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sach;

import control.frame.ViewBaiBao;
import control.frame.ViewSach;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.PanelPeer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.sach.SachImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class SachThem extends JFrame {

    JLabel masach;
    JLabel tensach;
    JLabel namxuatban;
    JLabel nhaxuatban;
    public JButton them;
    TextField txtmasach;
    TextField txttensach;
    TextField txtnamxb;
    TextField txtnhaxb;
    Sachview sachview;
    public static int isVisiable = 0;

    public SachThem(Sachview sachview) {
        this.sachview = sachview;
        setTitle("Thêm Giáo Trình");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                isVisiable = 0;
            }
        });
        masach = new JLabel("Mã Sách");
        tensach = new JLabel("Tên Sách");
        namxuatban = new JLabel("Năm Xuất Bản");
        nhaxuatban = new JLabel("Nhà Xuất Bản");
        txtmasach = new TextField();
        txttensach = new TextField();
        txtnamxb = new TextField();
        txtnhaxb = new TextField();
        them = new JButton("Thêm");
        masach.setBounds(20, 20, 100, 30);
        tensach.setBounds(20, 70, 100, 30);
        namxuatban.setBounds(20, 120, 100, 30);
        nhaxuatban.setBounds(20, 170, 100, 30);
        txtmasach.setBounds(150, 20, 150, 30);
        txttensach.setBounds(150, 70, 150, 30);
        txtnamxb.setBounds(150, 120, 150, 30);
        txtnhaxb.setBounds(150, 170, 150, 30);
        them.setBounds(150, 220, 100, 30);
        add(masach);
        add(tensach);
        add(namxuatban);
        add(nhaxuatban);
        add(txtmasach);
        add(txttensach);
        add(txtnamxb);
        add(txtnhaxb);
        add(them);
        act();
        setVisible(true);
    }
    void act() {
        them.addActionListener(new ActionListener() {
            boolean b = true;

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtmasach.getText().equals("")
                        || txttensach.getText().equals("")
                        || txtnamxb.getText().equals("")
                        || txtnhaxb.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn Chưa Nhập Đủ Các Trường");
                    b = false;
                } else {
                    SachImp sachImp = new SachImp();
                    sachImp.addNew(txtmasach.getText(), txttensach.getText(), txtnamxb.getText(), txtnhaxb.getText());
                    JOptionPane.showMessageDialog(rootPane, "Ban Da Them Thanh Cong");
                    sachview.loaddata();
                }
//                }
            }
        });
    }
}
