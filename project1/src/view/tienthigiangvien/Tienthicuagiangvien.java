/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tienthigiangvien;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.canbo.CanBoImp;
import model.giangday.GiangDayImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Tienthicuagiangvien extends JPanel {

    DefaultTableModel dtm;
    JTable table;
    JPanel panel;
    JPanel panelcenter;
    JPanel panelbotom;
    JButton capnhat;
    Myframe c;
    Vector<String> title;
    Vector<Vector<String>> culoms;
    public static int isVisiable = 0;

    public Tienthicuagiangvien(Myframe c) {
        this.c = c;
        xxx();
    }

    public void xxx() {

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panelcenter = new JPanel();
        panelbotom = new JPanel();
        panelbotom.setLayout(new FlowLayout());

        title = new Vector<>();
        culoms = new Vector<Vector<String>>();
        title.add("Tên Giảng Viên");
        title.add("Số Sinh Viên");
        title.add("Hệ Số");
        title.add("Tiền Thi Của Giảng Viên");


        dtm = new DefaultTableModel();
        table = new JTable();
        panelcenter.add(new JScrollPane(table));
        capnhat = new JButton("Cập Nhật");
        panelbotom.add(capnhat);
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        load1();
    }

    void load1() {
        CanBoImp canBoImp = new CanBoImp();
        ArrayList<model.canbo.CanBo> list1 = (ArrayList<model.canbo.CanBo>) canBoImp.getAll();
        GiangDayImp dayImp = new GiangDayImp();
        ArrayList<model.giangday.GiangDay> list2 = dayImp.getAll();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                Vector<String> row = new Vector<>();
                row.add(list1.get(i).getTenCanBo());
                row.add(list2.get(j).getSoSinhVien());
                culoms.add(row);
                
            }
        }
        dtm.setDataVector(culoms, title);
        table.setModel(dtm);
    }
}
