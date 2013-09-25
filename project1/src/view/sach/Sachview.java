/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sach;

import control.frame.ViewSach;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.sach.SachImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Sachview extends JPanel {

    public static int idRow = -1;
    Myframe c;
    JPanel panel;
    JPanel panelcenter;
    JPanel panelbotom;
    public DefaultTableModel dtm;
    JTable table;
    JButton them;
    JButton xoa;
    JButton sua;
    public int rowid;
    ArrayList<Sachview> list = null;
    Vector<String> title = new Vector<>();
    Vector<Vector<String>> colum = new Vector<Vector<String>>();
    JButton bcapnhat;

    public Sachview(Myframe c) {
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
        colum = new Vector<Vector<String>>();
        title.add("Mã Sách");
        title.add("Tên Sách");
        title.add("Năm Xuất Bản");
        title.add("Nhà Xuất Bản");

        table = new JTable();
//        dtm.setDataVector(colum, title);
//        table.setModel(dtm);
        them = new JButton("Thêm");
        them.addActionListener(new ViewSach(2, this));
        xoa = new JButton("Xóa");
        xoa.addActionListener(new ViewSach(3, this));
        sua = new JButton("Sửa");
        bcapnhat = new JButton("Cập Nhật");
        sua.addActionListener(new ViewSach(1, this));
        panelcenter.add(new JScrollPane(table));
        panelbotom.add(them);
        panelbotom.add(xoa);
        panelbotom.add(sua);
        panelbotom.add(bcapnhat);
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
        act();
    }
//ham atc de bat su kien neu clich vao mot muc thi moi cho sau

    void act() {

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
//                idRow = table.getSelectedRow();
                idRow = table.getSelectedRow();
//                System.out.println("Idrow cua chu la :" + idRow);
            }
        });//end


        bcapnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loaddata();
            }
        });
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        });

    }

    public void loaddata() {
        DefaultTableModel dtm = new DefaultTableModel();
        SachImp sachImp = new SachImp();

        List<model.sach.Sach> list = sachImp.getAllBook();
        colum =  new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaSach());
            row.add(list.get(i).getTenSach());
            row.add(list.get(i).getNamXuatBan());
            row.add(list.get(i).getNhaXuatBan());
            colum.add(row);
        }
        dtm.getDataVector().removeAllElements();
        dtm.setDataVector(colum, title);
        table.setModel(dtm);
    }

  
}
