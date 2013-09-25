/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.nghiencuukhoahoc;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.nghiencuukhoahoc.NghienCuuKhoaHocImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class NghienCuuKhoaHocVThem extends JFrame {

    JLabel lma;
    JLabel lten;
    JLabel lcap;
    JLabel lkinhphi;
    JLabel lbatdau;
    JLabel lketthuc;
    JLabel lchutri;
    JLabel ltinhtrang;
    JLabel lketqua;
    JTextField txtma;
    JTextField txtten;
    JTextField txtcap;
    JTextField txtkinhphi;
    JTextField txtbatdau;
    JTextField txtketthuc;
    JTextField txtchutri;
    JTextField txttinhtrang;
    JTextField txtketqua;
    JButton them;
    public static int visible = 0;
NghienCuuKhoaHocV hocV;
    public NghienCuuKhoaHocVThem(NghienCuuKhoaHocV hocV) {
        this.hocV = hocV;
        setTitle("Nghiên Cứu Khoa Học Thêm");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                visible = 0;
            }
        });
        lma = new JLabel("Mã");
        lten = new JLabel("Tên");
        lcap = new JLabel("Cấp");
        lkinhphi = new JLabel("Kinh Phí");
        lbatdau = new JLabel("Bắt Đầu");
        lketthuc = new JLabel("Kết Thúc");
        lchutri = new JLabel("Chủ Trì");
        ltinhtrang = new JLabel("Tình Trạng");
        lketqua = new JLabel("Kết Quả");
        txtma = new JTextField();
        txtten = new JTextField();
        txtcap = new JTextField();
        txtkinhphi = new JTextField();
        txtbatdau = new JTextField();
        txtketthuc = new JTextField();
        txtchutri = new JTextField();
        txttinhtrang = new JTextField();
        txtketqua = new JTextField();
        them = new JButton("Thêm");

        lma.setBounds(50, 50, 100, 30);
        lten.setBounds(50, 100, 100, 30);
        lcap.setBounds(50, 150, 100, 30);
        lkinhphi.setBounds(50, 200, 100, 30);
        lbatdau.setBounds(50, 250, 100, 30);
        lketthuc.setBounds(50, 300, 100, 30);
        lchutri.setBounds(50, 350, 100, 30);
        ltinhtrang.setBounds(50, 400, 100, 30);
        lketqua.setBounds(50, 450, 100, 30);

        txtma.setBounds(200, 50, 100, 30);
        txtten.setBounds(200, 100, 100, 30);
        txtcap.setBounds(200, 150, 100, 30);
        txtkinhphi.setBounds(200, 200, 100, 30);
        txtbatdau.setBounds(200, 250, 100, 30);
        txtketthuc.setBounds(200, 300, 100, 30);
        txtchutri.setBounds(200, 350, 100, 30);
        txttinhtrang.setBounds(200, 400, 100, 30);
        txtketqua.setBounds(200, 450, 100, 30);
        them.setBounds(200, 500, 100, 30);



        add(lma);
        add(lten);
        add(lcap);
        add(lkinhphi);
        add(lbatdau);
        add(lketthuc);
        add(lchutri);
        add(ltinhtrang);
        add(lketqua);

        add(txtma);
        add(txtten);
        add(txtcap);
        add(txtkinhphi);
        add(txtbatdau);
        add(txtketthuc);
        add(txtchutri);
        add(txttinhtrang);
        add(txtketqua);
        add(them);
        act();
        setVisible(true);
    }

    void act() {
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = true;
                if (txtma.getText().equals("")
                        || txtcap.getText().equals("")
                        || txtkinhphi.getText().equals("")
                        || txtbatdau.getText().equals("")
                        || txtketthuc.getText().equals("")
                        || txtchutri.getText().equals("")
                        || txttinhtrang.getText().equals("")
                        || txtketqua.getText().equals("")) {
                    JOptionPane.showMessageDialog(lma, "Bạn Phải Nhập Đủ Các Trường");
                    b = false;
                } else {

                    NghienCuuKhoaHocImp hocImp = new NghienCuuKhoaHocImp();
                    hocImp.addNew(txtma.getText(),
                            txtten.getText(),
                            txtcap.getText(),
                            txtkinhphi.getText(),
                            txtbatdau.getText(),
                            txtketthuc.getText(),
                            txtchutri.getText(),
                            txttinhtrang.getText(),
                            txtketqua.getText());
                    JOptionPane.showMessageDialog(lma, "Bạn Đã Thêm Thành Công");
                    hocV.loaddata();
                }
            }
        });
    }
}
