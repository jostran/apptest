/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.giangday;

import control.frame.ViewGiangDay;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.giangday.GiangDay;
import model.giangday.GiangDayImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class GiangDayV extends JPanel {

    JPanel panel;
    JPanel panelcenter;
    JPanel panelbottom;
    JButton them;
    JButton sua;
    JButton xoa;
    JButton bcapnhat;
    Vector<String> title;
    Vector<Vector<String>> colum;
    DefaultTableModel dtm;
    JTable table;
    Myframe m;
    public static int idrow = -1;

    public GiangDayV(Myframe m) {
        this.m = m;
        load();
    }

    void load() {

        setLayout(new FlowLayout());
        panel = new JPanel();
        panelcenter = new JPanel();
//        panelcenter.setPreferredSize(new Dimension(600, 500));
        panelbottom = new JPanel();
        panel.setLayout(new BorderLayout());
        panelbottom.setLayout(new FlowLayout());
        sua = new JButton("Sửa");
        sua.addActionListener(new ViewGiangDay(1, this));
        them = new JButton("Thêm");
        them.addActionListener(new ViewGiangDay(2, this));
        xoa = new JButton("Xóa");
        bcapnhat = new JButton("Cập Nhật");
        bcapnhat.addActionListener(new ViewGiangDay(3, this));

        title = new Vector<String>();
        colum = new Vector<Vector<String>>();
        title.add("Mã CB");
        title.add("Mã Môn");
        title.add("Mã Lớp");
        title.add("Thứ");
        title.add("Tiết Bắt Đầu");
        title.add("Số Tiết");
        title.add("Năm Học");
        title.add("Số SV");
        dtm = new DefaultTableModel();
        table = new JTable();
        panelcenter.add(new JScrollPane(table));
        panelbottom.add(them);
        panelbottom.add(sua);
        panelbottom.add(xoa);
        panelbottom.add(bcapnhat);

        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbottom, BorderLayout.SOUTH);
        loaddata();
        act();
        add(panel);
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
                    int id = JOptionPane.showConfirmDialog(panelbottom, "Bạn có thực sự muốn xóa hay không", null, i);
                    if (id == 0) {
                        GiangDayImp gdi = new GiangDayImp();
                        ArrayList<GiangDay> list = gdi.getAll();
                        gdi.delete(list.get(idrow).getMaLopHoc());
                        JOptionPane.showMessageDialog(m, "Bạn Đã Xóa Thành Công");
                        dtm.getDataVector().removeAllElements();
                        loaddata();
                    }

                } else {
                    JOptionPane.showMessageDialog(m, "Bạn Chưa Chọn Mục Để Xóa");
                }
            }
        });
    }

    void loaddata() {
        GiangDayImp dayImp = new GiangDayImp();
        ArrayList<GiangDay> list = dayImp.getAll();
        colum = new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaCanBo());
            row.add(list.get(i).getMaMon());
            row.add(list.get(i).getMaLopHoc());
            row.add(list.get(i).getThu());
            row.add(list.get(i).getTietBatDau());
            row.add(list.get(i).getSoTietDay());
            row.add(list.get(i).getNamHoc());
            row.add(list.get(i).getSoSinhVien());
            colum.add(row);
        }
        dtm.setDataVector(colum, title);
        table.setModel(dtm);

    }
}
