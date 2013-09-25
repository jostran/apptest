/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.canbo;

import com.sun.xml.internal.bind.v2.model.core.ID;
import control.frame.ViewCanbo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.canbo.CanBo;
import model.canbo.CanBoImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Thongtinchitiet extends JFrame {

    Myframe c;
    public DefaultTableModel dtm;
    JTable table;
    public static int isVisible = 0;
    public static int idrow = -1;
    ArrayList<Thongtinchitiet> list;
    Vector<String> title = new Vector<>();
    Vector<Vector<String>> colum = new Vector<Vector<String>>();
    JPanel panelcenter;
    JPanel panelbottom;
    JButton sua;
    JButton xoa;
    JButton chitiet;
    JButton them;

    public Thongtinchitiet() {
        setTitle("Thong Tin Chi Tiet");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                super.windowClosed(we);
                isVisible = 0;
            }
        });
        panelcenter = new JPanel();
        panelcenter.setPreferredSize(new Dimension(800, 400));
        panelcenter.setBackground(Color.WHITE);
        panelbottom = new JPanel();
        panelbottom.setPreferredSize(new Dimension(600, 100));
        panelbottom.setLayout(new FlowLayout());


        sua = new JButton("Sua");
        them = new JButton("Them");
        xoa = new JButton("Xoa");
        chitiet = new JButton("Chi Tiet");


        title.add("Mã");
        title.add("Tên Cán Bộ");
        title.add("Ngày Sinh");
        title.add("Giới Tính");
        title.add("Địa Chỉ");
        title.add("SĐT");
        title.add("Tài Khoản");
        title.add("Email");
        title.add("Chưc Vụ");
        title.add("Chức Danh");
        title.add("HS Lương");
        title.add("PC Giảng Dạy");
        title.add("PC Chức Vụ");
        title.add("MS Thuế");
        dtm = new DefaultTableModel();
        table = new JTable();
        table.setSize(800, 400);
        panelcenter.add(new JScrollPane(table));
        panelbottom.add(sua);
        sua.addActionListener(new ViewCanbo(2, this));
        panelbottom.add(xoa);
        panelbottom.add(chitiet);
        chitiet.addActionListener(new ViewCanbo(3, this));
        panelbottom.add(them);
        them.addActionListener(new ViewCanbo(1, this));
        add(panelcenter);
        add(panelbottom);
        loaddata();
        act();
        setVisible(true);

    }

    void act() {

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                idrow = table.getSelectedRow();
            }
        });
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = 0;
                if (idrow != -1) {
                    int id = JOptionPane.showConfirmDialog(c, "Bạn Có Thực Sự Muốn Xóa Không", null, i);
                    if (id == 0) {
                        CanBoImp boImp = new CanBoImp();
                        List<CanBo> list = boImp.getAll();
                        boImp.deleteByID(list.get(idrow).getMaCanBo());
                        JOptionPane.showMessageDialog(panelbottom, "Bạn Đã Xóa Thành Công");
                        loaddata();
                    }
                } else {
                    JOptionPane.showMessageDialog(c, "Bạn Chưa Chọn Trường Để Xóa");
                }
            }
        });
    }

    void loaddata() {

        CanBoImp canBoImp = (CanBoImp) new CanBoImp();
        ArrayList<model.canbo.CanBo> list = (ArrayList<model.canbo.CanBo>) canBoImp.getAll();
        colum = new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaCanBo());
            row.add(list.get(i).getTenCanBo());
            row.add(list.get(i).getNgaySinh().toString());
            row.add(String.valueOf(list.get(i).getGioiTinh()));
            row.add(list.get(i).getDiaChi());
            row.add(list.get(i).getSoDienThoai());
            row.add(list.get(i).getSoTaiKhoan());
            row.add(list.get(i).getEmail());
            row.add(list.get(i).getChucVu());
            row.add(list.get(i).getChucDanh());
            row.add(String.valueOf(list.get(i).getHeSoLuong()));
            row.add(String.valueOf(list.get(i).getPhuCapGiangDay()));
            row.add(String.valueOf(list.get(i).getPhuCapChucVu()));
            row.add(list.get(i).getMaSoThue());
            colum.add(row);
        }
        dtm.getDataVector().removeAll(list);
        dtm.setDataVector(colum, title);
        table.setModel(dtm);

    }

    public static void main(String[] args) {
        new Thongtinchitiet();
    }
}