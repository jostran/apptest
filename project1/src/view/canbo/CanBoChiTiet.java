/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.canbo;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.canbo.CanBoImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class CanBoChiTiet extends JFrame {

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
    JTextField txtgioitinh;
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
    public static int isvisible = 0;
    Thongtinchitiet thongtinchitiet;
    List<model.canbo.CanBo> list;

    public CanBoChiTiet(Thongtinchitiet thongtinchitiet) throws HeadlessException {
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
        txtmacb = new JTextField("");
        txttencb = new JTextField();
        txtngaysinh = new JTextField();
        txtgioitinh = new JTextField();
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
        loaddata();
        setVisible(true);
    }

    void loaddata() {
        CanBoImp canBoImp = new CanBoImp();
        list = canBoImp.getAll();
        txtmacb.setText(list.get(Thongtinchitiet.idrow).getMaCanBo());
        txttencb.setText(list.get(Thongtinchitiet.idrow).getTenCanBo());
        txtngaysinh.setText(list.get(Thongtinchitiet.idrow).getNgaySinh().toString());
        txtgioitinh.setText(String.valueOf(list.get(Thongtinchitiet.idrow).getGioiTinh()));
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
