/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dangphi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class Dangphi extends JPanel {

    DefaultTableModel dtm;
    JTable table;
    Myframe c;
    JPanel panel;
    JPanel panelcenter;
    JPanel panelbotom;
//    JButton sua;
//    JButton xoa;
    JButton bcapnhat;
    ArrayList<model.canbo.CanBo> list;
    Vector<Vector<String>> culoms;
    Vector<String> title;

    public Dangphi(Myframe c) {
        this.c = c;
        xxx();
    }

    public void xxx() {
        panel = new JPanel();
        panelcenter = new JPanel();
        panelbotom = new JPanel();
        panel.setLayout(new BorderLayout());
        panelbotom.setLayout(new FlowLayout());
        title = new Vector<>();
        culoms = new Vector<Vector<String>>();
        title.add("Tên Nhân Viên");
        title.add("Hệ Số Lương");
        title.add("PC Chức Vụ");
        title.add("Phụ Cấp Giảng Dạy");
        title.add("Đảng Phí");

        dtm = new DefaultTableModel();
        table = new JTable();
        panelcenter.add(new JScrollPane(table));
        bcapnhat = new JButton("Cập Nhật");
        panelbotom.add(bcapnhat);
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
        act();
    }

    void loaddata() {
        CanBoImp boImp = new CanBoImp();
        list = (ArrayList<CanBo>) boImp.getAll();
        for (int i = 0; i < list.size(); i++) {
           float dangphi = ((list.get(i).getHeSoLuong()+list.get(i).getPhuCapChucVu()+list.get(i).getPhuCapGiangDay())*1200/100);
//           float dangphi =10;
            Vector<String> row = new Vector<>();
            row.add(list.get(i).getTenCanBo());
            row.add(String.valueOf(list.get(i).getHeSoLuong()));
            row.add(String.valueOf(list.get(i).getPhuCapChucVu()));
            row.add(String.valueOf(list.get(i).getPhuCapGiangDay()));
            row.add(String.valueOf(dangphi));
            culoms.add(row);
           
        }
        dtm.setDataVector(culoms, title);
        table.setModel(dtm);
        
    }
    void act(){
        bcapnhat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                dtm.getDataVector().removeAllElements();
                loaddata();
            }
        });
    }
}
