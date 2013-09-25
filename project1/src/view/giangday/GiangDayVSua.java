/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.giangday;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.giangday.GiangDay;
import model.giangday.GiangDayImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class GiangDayVSua extends JFrame {

    JLabel lmacanbo;
    JLabel lmamon;
    JLabel lmalop;
    JLabel lthu;
    JLabel ltietbatdau;
    JLabel lsotietday;
    JLabel lnamhoc;
    JLabel ltinhtrang;
    JLabel lketqua;
    JTextField txtmacanbo;
    JTextField txtmamon;
    JTextField txtmalop;
    JTextField txtthu;
    JTextField txtbatdau;
    JTextField txtsotietdayc;
    JTextField txtnamhoc;
    JTextField txttinhtrang;
    JTextField txtketqua;
    JButton sua;
    public static int visible = 0;
    JLabel lsosinhvien;
    JTextField txtsinhvien;
    GiangDayV dayV;

    public GiangDayVSua(GiangDayV dayV) {
        this.dayV = dayV;
        setTitle("Sửa Thông Tin Giảng Dạy");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                visible = 0;
            }
        });
        lmacanbo = new JLabel("Mã CB");
        lmamon = new JLabel("Mã Môn");
        lmalop = new JLabel("Mã Lớp");
        lthu = new JLabel("Thứ");
        ltietbatdau = new JLabel("Tiết BĐ");
        lsotietday = new JLabel("Số Tiết");
        lnamhoc = new JLabel("Năm Học");
        lsosinhvien = new JLabel("Số SV");
        txtmacanbo = new JTextField();
        txtmamon = new JTextField();
        txtmalop = new JTextField();
        txtthu = new JTextField();
        txtbatdau = new JTextField();
        txtsotietdayc = new JTextField();
        txtnamhoc = new JTextField();
        txtsinhvien = new JTextField();
        sua = new JButton("Sửa");

        lmacanbo.setBounds(50, 50, 100, 30);
        lmamon.setBounds(50, 100, 100, 30);
        lmalop.setBounds(50, 150, 100, 30);
        lthu.setBounds(50, 200, 100, 30);
        ltietbatdau.setBounds(50, 250, 100, 30);
        lsotietday.setBounds(50, 300, 100, 30);
        lnamhoc.setBounds(50, 350, 100, 30);
        lsosinhvien.setBounds(50, 400, 100, 30);

        txtmacanbo.setBounds(200, 50, 100, 30);
        txtmamon.setBounds(200, 100, 100, 30);
        txtmalop.setBounds(200, 150, 100, 30);
        txtthu.setBounds(200, 200, 100, 30);
        txtbatdau.setBounds(200, 250, 100, 30);
        txtsotietdayc.setBounds(200, 300, 100, 30);
        txtnamhoc.setBounds(200, 350, 100, 30);
        txtsinhvien.setBounds(200, 400, 100, 30);
        sua.setBounds(200, 450, 100, 30);



        add(lmacanbo);
        add(lmamon);
        add(lmalop);
        add(lthu);
        add(ltietbatdau);
        add(lsotietday);
        add(lnamhoc);
        add(lsosinhvien);


        add(txtmacanbo);
        add(txtmamon);
        add(txtmalop);
        add(txtthu);
        add(txtbatdau);
        add(txtsotietdayc);
        add(txtnamhoc);
        add(txtsinhvien);

        add(sua);
        loaddata1();
        act();
        setVisible(true);
    }

    void loaddata1() {
        GiangDayImp imp = new GiangDayImp();
        ArrayList<GiangDay> list = imp.getAll();
        txtmacanbo.setText(list.get(GiangDayV.idrow).getMaCanBo());
        txtmamon.setText(list.get(GiangDayV.idrow).getMaMon());
        txtmalop.setText(list.get(GiangDayV.idrow).getMaLopHoc());
        txtthu.setText(list.get(GiangDayV.idrow).getThu());
        txtbatdau.setText(list.get(GiangDayV.idrow).getTietBatDau());
        txtsotietdayc.setText(list.get(GiangDayV.idrow).getSoTietDay());
        txtnamhoc.setText(list.get(GiangDayV.idrow).getNamHoc());
        txtsinhvien.setText(list.get(GiangDayV.idrow).getSoSinhVien());
    }

    void act() {
        sua.addActionListener(new ActionListener() {
            Matcher m1;
            Matcher m2;
            Matcher m3;
            Matcher m4;
            Pattern p1;
            Pattern p2;
            Pattern p3;
            Pattern p4;
            Pattern p5;
            Matcher m5;

            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = true;
                String thu = "[2-7]";
                String tietbatdau ="([1-4])|([6-9])";
                String sotiet ="[1-5]";
                String namhoc ="(\\d{4})-(([0-9])|(1[0-2]))-(([0-9])|(1[0-9])|(2[0-9]|(3[01])))";
                String sosinhvien ="([0-9][0-9])|([0-9])|([0-9][0-9][0-9])";
                p1 = Pattern.compile(thu);
                p2 = Pattern.compile(tietbatdau);
                p3 = Pattern.compile(sotiet);
                p4 = Pattern.compile(namhoc);
                p5 = Pattern.compile(sosinhvien);
                m1 = p1.matcher(txtthu.getText());
                m2 = p2.matcher(txtbatdau.getText());
                m3 = p3.matcher(txtsotietdayc.getText());
                m4 = p4.matcher(txtnamhoc.getText());
                m5 = p5.matcher(txtsinhvien.getText());
                if (txtmacanbo.getText().equals("")
                        || txtmamon.getText().equals("")
                        || txtmalop.getText().equals("")
                        || txtthu.getText().equals("")
                        || txtbatdau.getText().equals("")
                        || txtsotietdayc.getText().equals("")
                        || txtnamhoc.getText().equals("")
                        || txtsinhvien.getText().equals("")) {
                    JOptionPane.showMessageDialog(dayV, "Bạn Phải Nhập Đủ Các Trường");
                    b = false;

                } else if (!m1.matches()||!m2.matches()||!m3.matches()||!m4.matches()||!m5.matches()) {
                    JOptionPane.showMessageDialog(dayV, "Hãy Kiểm Tra Lại, Bạn Đã Nhập Sai Trường Nào Đó");
                }else{
                    GiangDayImp imp = new GiangDayImp();
                    imp.update(txtmacanbo.getText(),
                            txtmamon.getText(),
                            txtmalop.getText(),
                            txtthu.getText(),
                            txtbatdau.getText(),
                            txtsotietdayc.getText(),
                            txtnamhoc.getText(),
                            txtsinhvien.getText());
                    JOptionPane.showMessageDialog(dayV, "Bạn Đã Sửa Thành Công");
                    dayV.loaddata();
                }





//                else {
//                    
//
//                    GiangDayImp imp = new GiangDayImp();
//                    imp.update(txtmacanbo.getText(),
//                            txtmamon.getText(),
//                            txtmalop.getText(),
//                            txtthu.getText(),
//                            txtbatdau.getText(),
//                            txtsotietdayc.getText(),
//                            txtnamhoc.getText(),
//                            txtsinhvien.getText());
//                    JOptionPane.showMessageDialog(dayV, "Bạn Đã Sửa Thành Công");
//                    dayV.loaddata();
//                }
            }
        });
    }
}
