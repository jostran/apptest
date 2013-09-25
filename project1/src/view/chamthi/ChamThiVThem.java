/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.chamthi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.chamthi.ChamThiImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class ChamThiVThem extends JFrame {

    JLabel lmalop;
    JLabel lmacanbo;
    JLabel lmamonhoc;
    JLabel lngaynop;
    JLabel lsobaithi;
    JTextField txtmalop;
    JTextField txtmacanbo;
    JTextField txtmamonhoc;
    JTextField txtngaynop;
    JTextField txtsobaithi;
    JButton them;
    public static int visible = 0;
    private final JLabel lngaynhan;
    private final JTextField txtngaynhan;
    ChamThiV thi;
    private final JLabel llanthi;
    private final JTextField txtlanthi;

    public ChamThiVThem(ChamThiV thi) {
        this.thi = thi;
        setTitle("Thêm Chấm Thi");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                visible = 0;
            }
        });
        lmalop = new JLabel("Mã Lớp");
        lmacanbo = new JLabel("Mã Cán Bộ");
        lmamonhoc = new JLabel("Mã Học Viên");
        lngaynop = new JLabel("Ngày Nộp");
        lngaynhan = new JLabel("Ngày Nhận");
        lsobaithi = new JLabel("Số Bài Thi");
        llanthi = new JLabel("Lần Thi");
        txtmalop = new JTextField();
        txtmacanbo = new JTextField();
        txtmamonhoc = new JTextField();
        txtngaynop = new JTextField();
        txtngaynhan = new JTextField();
        txtsobaithi = new JTextField();
        txtlanthi = new JTextField();
        them = new JButton("Thêm");

        lmalop.setBounds(50, 50, 100, 30);
        lmacanbo.setBounds(50, 100, 100, 30);
        lmamonhoc.setBounds(50, 150, 100, 30);
        lngaynop.setBounds(50, 200, 100, 30);
        lngaynhan.setBounds(50, 250, 100, 30);
        lsobaithi.setBounds(50, 300, 100, 30);
        llanthi.setBounds(50, 350, 100, 30);

        txtmalop.setBounds(200, 50, 100, 30);
        txtmacanbo.setBounds(200, 100, 100, 30);
        txtmamonhoc.setBounds(200, 150, 100, 30);
        txtngaynop.setBounds(200, 200, 100, 30);
        txtngaynhan.setBounds(200, 250, 100, 30);
        txtsobaithi.setBounds(200, 300, 100, 30);
        txtlanthi.setBounds(200, 350, 100, 30);
        them.setBounds(200, 400, 100, 30);



        add(lmalop);
        add(lmacanbo);
        add(lmamonhoc);
        add(lngaynop);
        add(lngaynhan);
        add(lsobaithi);
        add(llanthi);


        add(txtmalop);
        add(txtmacanbo);
        add(txtmamonhoc);
        add(txtngaynop);
        add(txtngaynhan);
        add(txtsobaithi);
        add(txtlanthi);

        add(them);
        act();
        setVisible(true);
    }

    void act() {
        them.addActionListener(new ActionListener() {
            
            boolean b = true;

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtmacanbo.getText().equals("")
                        || txtmamonhoc.getText().equals("")
                        || txtmalop.getText().equals("")
                        || txtsobaithi.getText().equals("")
                        || txtngaynop.getText().equals("")
                        || txtngaynhan.getText().equals("")
                        || txtlanthi.getText().equals("")) {
                    JOptionPane.showMessageDialog(thi, "Bạn Phải Nhập Đủ Các Trường");
                    b = false;
                } else {
                    ChamThiImp imp = new ChamThiImp();
                    imp.addnew(txtmacanbo.getText(),
                            txtmamonhoc.getText(),
                            txtmalop.getText(),
                            txtsobaithi.getText(),
                            txtngaynop.getText(),
                            txtngaynhan.getText(),
                            txtlanthi.getText());
                    JOptionPane.showMessageDialog(thi, "Bạn Đã Thêm Thành Công");
//                    thi.load();
                }
            }
        });
    }
}
