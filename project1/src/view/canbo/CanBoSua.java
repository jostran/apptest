/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.canbo;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.canbo.CanBoImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class CanBoSua extends JFrame {

    JLabel macb;
    JLabel tencb;
    JLabel ngaysinh;
    JLabel gioitinh;
    JLabel diachi;
    JLabel sodt;
    JLabel sotk;
    JLabel email;
    JLabel chucvu;
    JLabel chucdanh;
    JLabel hsluong;
    JLabel phucapgiangday;
    JLabel phucapchucvu;
    JLabel msthue;
    JTextField txtmacb;
    JTextField txttencb;
    JTextField txtngaysinh;
//    JTextField txtgioitinh;
    JTextField txtdiachi;
    JTextField txtsodt;
    JTextField txtsotk;
    JTextField txtemail;
    JTextField txtchucvu;
    JTextField txtchucdanh;
    JTextField txthsluong;
    JTextField txtpcgiangday;
    JTextField txtpcchucvu;
    JTextField txtmsthue;
    JButton sua;
    public static int isvisible = 0;
    Thongtinchitiet thongtinchitiet;
    List<model.canbo.CanBo> list;
    private final JComboBox txtgioitinh;

    public CanBoSua(Thongtinchitiet thongtinchitiet) throws HeadlessException {
        this.thongtinchitiet = thongtinchitiet;
        setTitle("Sửa Thông Tin Cán Bộ");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                isvisible = 0;
            }
        });
        macb = new JLabel("Mã Cán Bộ");
        tencb = new JLabel("Tên Cán Bộ");
        ngaysinh = new JLabel("Ngày Sinh");
        gioitinh = new JLabel("Giới Tính");
        diachi = new JLabel("Địa Chỉ");
        sodt = new JLabel("Số Điện Thoại");
        sotk = new JLabel("Số Tài Khoản");
        email = new JLabel("Email");
        chucvu = new JLabel("Chức Vụ");
        chucdanh = new JLabel("Chức Danh");
        hsluong = new JLabel("Hệ Số Lương");
        phucapgiangday = new JLabel("Phụ Cấp Giảng Dạy");
        phucapchucvu = new JLabel("Phụ Cấp Chức Vụ");
        msthue = new JLabel("Mã Số Thuế");
        txtmacb = new JTextField();
        txtmacb.setEnabled(false);
        txttencb = new JTextField();
        txtngaysinh = new JTextField();
        String[] string = {"0", "1"};
        txtgioitinh = new JComboBox(string);
        txtdiachi = new JTextField();
        txtsodt = new JTextField();
        txtsotk = new JTextField();
        txtemail = new JTextField();
        txtchucvu = new JTextField();
        txtchucdanh = new JTextField();
        txthsluong = new JTextField();
        txtpcgiangday = new JTextField();
        txtpcchucvu = new JTextField();
        txtmsthue = new JTextField();
        sua = new JButton("Sửa");
        macb.setBounds(50, 50, 100, 30);
        tencb.setBounds(50, 90, 100, 30);
        ngaysinh.setBounds(50, 130, 100, 30);
        gioitinh.setBounds(50, 170, 100, 30);
        diachi.setBounds(50, 210, 100, 30);
        sodt.setBounds(50, 250, 100, 30);
        sotk.setBounds(50, 290, 100, 30);
        email.setBounds(50, 330, 100, 30);
        chucvu.setBounds(50, 370, 100, 30);
        chucdanh.setBounds(50, 400, 100, 30);
        hsluong.setBounds(50, 440, 100, 30);
        phucapgiangday.setBounds(50, 490, 150, 30);
        phucapchucvu.setBounds(50, 530, 100, 30);
        msthue.setBounds(50, 570, 100, 30);

        txtmacb.setBounds(250, 50, 200, 30);
        txttencb.setBounds(250, 90, 200, 30);
        txtngaysinh.setBounds(250, 130, 200, 30);
        txtgioitinh.setBounds(250, 170, 200, 30);
        txtdiachi.setBounds(250, 210, 200, 30);
        txtsodt.setBounds(250, 250, 200, 30);
        txtsotk.setBounds(250, 290, 200, 30);
        txtemail.setBounds(250, 330, 200, 30);
        txtchucvu.setBounds(250, 370, 200, 30);
        txtchucdanh.setBounds(250, 410, 200, 30);
        txthsluong.setBounds(250, 450, 200, 30);
        txtpcgiangday.setBounds(250, 490, 200, 30);
        txtpcchucvu.setBounds(250, 530, 200, 30);
        txtmsthue.setBounds(250, 570, 200, 30);
        sua.setBounds(250, 620, 100, 30);

        add(macb);
        add(tencb);
        add(ngaysinh);
        add(gioitinh);
        add(diachi);
        add(sodt);
        add(sotk);
        add(email);
        add(chucvu);
        add(chucdanh);
        add(hsluong);
        add(phucapgiangday);
        add(phucapchucvu);
        add(msthue);
        add(txtmacb);
        add(txttencb);
        add(txtngaysinh);
        add(txtgioitinh);
        add(txtdiachi);
        add(txtsodt);
        add(txtsotk);
        add(txtemail);
        add(txtchucvu);
        add(txtchucdanh);
        add(txthsluong);
        add(txtpcgiangday);
        add(txtpcchucvu);
        add(txtmsthue);
        add(sua);
        act();
        loaddata();
        setVisible(true);
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

            @Override
            public void actionPerformed(ActionEvent ae) {
//                String hesoluong = "[0-9][0-9]";
//                String pcgiangday = "(([0-9][0-9])|([0-9][0-9][0-9])";
//                String pcchucvu = "(([0-9][0-9])|([0-9][0-9][0-9])";
//                String ngaysinh = "(\\d{4})-(([0-9])|(1[0-2]))-(([0-9])|(1[0-9])|(2[0-9]|(3[01])))";
//                p1 = Pattern.compile(hesoluong);
//                p2 = Pattern.compile(pcgiangday);
//                p3 = Pattern.compile(pcchucvu);
//                p4 = Pattern.compile(ngaysinh);
//                m1 = p1.matcher(txthsluong.getText());
//                m2 = p2.matcher(txtpcgiangday.getText());
//                m3 = p3.matcher(txtpcchucvu.getText());
//                m4 = p4.matcher(txtngaysinh.getText());

                CanBoImp canBoImp = new CanBoImp();
                boolean b = true;
                if (txtmacb.getText().equals("")
                        || txttencb.getText().equals("")
                        || txtngaysinh.getText().equals("")
//                      || txtgioitinh.getSelectedIndex()
                        || txtdiachi.getText().equals("")
                        || txtsodt.getText().equals("")
                        || txtsotk.getText().equals("")
                        || txtemail.getText().equals("")
                        || txtchucvu.getText().equals("")
                        || txtchucdanh.getText().equals("")
                        || txthsluong.getText().equals("")
                        || txtpcgiangday.getText().equals("")
                        || txtpcchucvu.getText().equals("")
                        || txtmsthue.getText().equals("")) {
                    JOptionPane.showMessageDialog(macb, "Bạn Phải Nhập Đủ Các Trường");
                    b = false;
                } else
//                    if ((!m3.matches()) || (!m2.matches()) || (!m3.matches()) || (!m4.matches())) {
//                    ////                     || (!m2.matches()) || (!m3.matches())
//                    JOptionPane.showMessageDialog(macb, "Bạn Đã Nhập Sai Trường Nào Đó,Hãy Kiểm Tra Lại");
//                } else 
                {
                    canBoImp.updateByID(txtmacb.getText(),
                            txttencb.getText(),
                            txtngaysinh.getText(),
                            Integer.valueOf(txtgioitinh.getSelectedIndex()),
                            txtdiachi.getText(),
                            txtsodt.getText(),
                            txtsotk.getText(),
                            txtemail.getText(),
                            txtchucvu.getText(),
                            txtchucdanh.getText(),
                            Float.valueOf(txthsluong.getText()),
                            Float.valueOf(txtpcgiangday.getText()),
                            Float.valueOf(txtpcchucvu.getText()),
                            txtmsthue.getText());
                    JOptionPane.showMessageDialog(macb, "Ban Da Sua Thanh Cong");
                    thongtinchitiet.loaddata();
                }
            }
        });
    }

    void loaddata() {
        CanBoImp canBoImp = new CanBoImp();
        list = canBoImp.getAll();
        txtmacb.setText(list.get(Thongtinchitiet.idrow).getMaCanBo());
        txtmacb.setEnabled(false);
        txttencb.setText(list.get(Thongtinchitiet.idrow).getTenCanBo());
        txtngaysinh.setText(list.get(Thongtinchitiet.idrow).getNgaySinh().toString());
//        txtgioitinh.setText(String.valueOf(list.get(Thongtinchitiet.idrow).getGioiTinh()));
        txtgioitinh.setSelectedIndex(WIDTH);
        txtdiachi.setText(list.get(Thongtinchitiet.idrow).getDiaChi());
        txtsodt.setText(list.get(Thongtinchitiet.idrow).getSoDienThoai());
        txtsotk.setText(list.get(Thongtinchitiet.idrow).getSoTaiKhoan());
        txtemail.setText(list.get(Thongtinchitiet.idrow).getEmail());
        txtchucvu.setText(list.get(Thongtinchitiet.idrow).getChucVu());
        txtchucdanh.setText(list.get(Thongtinchitiet.idrow).getChucDanh());
        txthsluong.setText(String.valueOf(list.get(Thongtinchitiet.idrow).getHeSoLuong()));
        txtpcgiangday.setText(String.valueOf(list.get(Thongtinchitiet.idrow).getPhuCapGiangDay()));
        txtpcchucvu.setText(String.valueOf(list.get(Thongtinchitiet.idrow).getPhuCapChucVu()));
        txtmsthue.setText(list.get(Thongtinchitiet.idrow).getMaCanBo());

    }
}
