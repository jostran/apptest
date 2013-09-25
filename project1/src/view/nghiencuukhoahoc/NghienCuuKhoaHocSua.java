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
import java.util.ArrayList;
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
public class NghienCuuKhoaHocSua extends JFrame {

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
    JButton sua;
    public static int visible = 0;
    ArrayList<model.nghiencuukhoahoc.NghienCuuKhoaHoc> list;
    NghienCuuKhoaHocV v;

    public NghienCuuKhoaHocSua(NghienCuuKhoaHocV v) {
        this.v = v;
        setTitle("Nghiên Cứu Khoa Học Sửa");
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
        sua = new JButton("Sửa");

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
        sua.setBounds(200, 500, 100, 30);



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
        add(sua);
        load();
        act();

        setVisible(true);
    }

    void load() {
        NghienCuuKhoaHocImp hocImp = new NghienCuuKhoaHocImp();
        list = (ArrayList<model.nghiencuukhoahoc.NghienCuuKhoaHoc>) hocImp.getAll();
        txtma.setText(list.get(NghienCuuKhoaHocV.idrow).getMaDeTai());
        txtten.setText(list.get(NghienCuuKhoaHocV.idrow).getTenDeTai());
        txtcap.setText(list.get(NghienCuuKhoaHocV.idrow).getCap());
        txtkinhphi.setText(String.valueOf(list.get(NghienCuuKhoaHocV.idrow).getKinhPhi()));
        txtbatdau.setText(list.get(NghienCuuKhoaHocV.idrow).getThoiGianBatDau());
        txtketthuc.setText(list.get(NghienCuuKhoaHocV.idrow).getThoiGianket());
        txtchutri.setText(list.get(NghienCuuKhoaHocV.idrow).getChuTri());
        txttinhtrang.setText(list.get(NghienCuuKhoaHocV.idrow).getTinhTrang());
        txtketqua.setText(list.get(NghienCuuKhoaHocV.idrow).getKetQua());
    }

    void act() {
        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = true;
                if (txtma.getText().equals("")
                        || txtten.getText().equals("")
                        || txtcap.getText().equals("")
                        || txtkinhphi.getText().equals("")
                        || txtbatdau.getText().equals("")
                        || txtketthuc.getText().equals("")
                        || txtchutri.getText().equals("")
                        || txttinhtrang.getText().equals("")
                        || txtketqua.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn Phải Nhập Đủ Các Trường");
                    b = false;
                } else {
                    NghienCuuKhoaHocImp hocImp = new NghienCuuKhoaHocImp();
                    list = (ArrayList<model.nghiencuukhoahoc.NghienCuuKhoaHoc>) hocImp.getAll();
                    hocImp.updateById(txtma.getText(),
                            txtten.getText(),
                            txtcap.getText(),
                            txtkinhphi.getText(),
                            txtbatdau.getText(),
                            txtketthuc.getText(),
                            txtchutri.getText(),
                            txttinhtrang.getText(),
                            txtketqua.getText());
                    JOptionPane.showMessageDialog(lma, "Bạn Đã Sửa Thành Công");
                    v.loaddata();
                }
                
            }
        });
    }
}
