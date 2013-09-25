/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.baibao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.baibao.BaiBaoImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class Baibaothem extends JFrame {

    JLabel mabaibao;
    JLabel tenbaibao;
    JLabel namxuatban;
    JLabel soxuatban;
    JLabel tentapchi;
    JLabel chisoISSN;
    JTextField txtmabaibao;
    JTextField txttenbaibao;
    JTextField txtnamxuatban;
    JTextField txtsoxuatban;
    JTextField txttentapchi;
    JTextField txtchisoISSN;
    JButton them;
    public static int isvisible = 0;
    BaiBaoView baiBaoView;

    public Baibaothem(BaiBaoView baiBaoView) {
        this.baiBaoView = baiBaoView;
        setTitle("Thêm Bài Báo Tạp Chí");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                isvisible = 0;
            }
        });
        mabaibao = new JLabel("Mã Bài Báo");
        tenbaibao = new JLabel("Tên Bài Báo");
        namxuatban = new JLabel("Năm Xuất Bản");
        soxuatban = new JLabel("Số Xuất Bản");
        tentapchi = new JLabel("Tên Tạp Chí");
        chisoISSN = new JLabel("Chỉ Số ISSN");
        txtmabaibao = new JTextField();
        txttenbaibao = new JTextField();
        txtnamxuatban = new JTextField();
        txtsoxuatban = new JTextField();
        txttentapchi = new JTextField();
        txtchisoISSN = new JTextField();
        them = new JButton("Thêm");
        mabaibao.setBounds(50, 50, 100, 30);
        tenbaibao.setBounds(50, 100, 100, 30);
        namxuatban.setBounds(50, 150, 100, 30);
        soxuatban.setBounds(50, 200, 200, 30);
        tentapchi.setBounds(50, 250, 200, 30);
        chisoISSN.setBounds(50, 300, 200, 30);
        txtmabaibao.setBounds(150, 50, 150, 30);
        txttenbaibao.setBounds(150, 100, 150, 30);
        txtnamxuatban.setBounds(150, 150, 150, 30);
        txtsoxuatban.setBounds(150, 200, 150, 30);
        txttentapchi.setBounds(150, 250, 150, 30);
        txtchisoISSN.setBounds(150, 300, 150, 30);
        them.setBounds(150, 340, 100, 30);
        add(mabaibao);
        add(tenbaibao);
        add(namxuatban);
        add(soxuatban);
        add(tentapchi);
        add(chisoISSN);
        add(txtmabaibao);
        add(txttenbaibao);
        add(txtnamxuatban);
        add(txtsoxuatban);
        add(txttentapchi);
        add(txtchisoISSN);
        add(them);
        act();
        setVisible(true);
    }
//

    void act() {
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = true;
                if (txtmabaibao.getText().equals("") || txttenbaibao.getText().equals("") || txtnamxuatban.getText().equals("")
                        || txtsoxuatban.getText().equals("") || txttentapchi.getText().equals("") || txtchisoISSN.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn Chưa Điền Đầy Đủ Thông Tin");
                    b = false;
                } else {
                    BaiBaoImp baoImp = new BaiBaoImp();
                    baoImp.addNew(txtmabaibao.getText(),
                            txttenbaibao.getText(),
                            txtnamxuatban.getText(),
                            txtsoxuatban.getText(),
                            txttentapchi.getText(),
                            Float.valueOf(txtchisoISSN.getText()));
                    JOptionPane.showMessageDialog(baiBaoView, "Ban Da Them Thanh Cong");
                    baiBaoView.loaddata();
                }
               

            }
        });
    }
}
