/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cacchaunhanqua;

import control.frame.ViewCacchaunhanqua;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.nguoithan.NguoiThan;
import model.nguoithan.NguoiThanImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Cacchaunhanqua extends JPanel {

    Myframe c;
    DefaultTableModel dtm;
    JTable table;
    JPanel panel;
    JPanel panelcenter;
    JPanel panelbotom;
    Vector<String> title = new Vector<String>();
    Vector<Vector<String>> colum = new Vector<Vector<String>>();
    ArrayList<model.nguoithan.NguoiThan> list;
    public static int idrow = -1;
    JButton capnhat;
    JPanel paneltop;
    JTextField textfeild;
    JButton timkiem;
    Vector<Vector<String>> data;
    DefaultTableModel dtm1;

    public Cacchaunhanqua(Myframe c) {
        this.c = c;
        xxx();
    }

    public void xxx() {
        panel = new JPanel();
        paneltop = new JPanel();
        paneltop.setLayout(new FlowLayout());
        panel.setLayout(new BorderLayout());
        panelcenter = new JPanel();
        panelbotom = new JPanel();
        panelbotom.setLayout(new FlowLayout());
        title = new Vector<>();
        colum = new Vector<Vector<String>>();
        title.add("Tên");
        title.add("Tuổi");
        title.add("Thành Tích");
        title.add("Mã Phụ Huynh");
        title.add("Quan Hệ");
        dtm = new DefaultTableModel();
        table = new JTable();
        textfeild = new JTextField(30);
        timkiem = new JButton("Tìm Kiếm");
        capnhat = new JButton("Cập Nhật");
        panelbotom.add(capnhat);
        paneltop.add(textfeild);
        paneltop.add(timkiem);
        panelcenter.add(new JScrollPane(table));
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        panel.add(paneltop, BorderLayout.NORTH);
        add(panel);
        loaddata();
        act();
    }

    void loaddata() {
        NguoiThanImp imp = new NguoiThanImp();
        list = (ArrayList<model.nguoithan.NguoiThan>) imp.getByAgeLessthan15();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getHoVaTen());
            row.add(String.valueOf(list.get(i).getTuoi()));
            row.add(list.get(i).getThanTich());
            row.add(list.get(i).getMaCanBo());
            row.add(list.get(i).getQuanhe());
            colum.add(row);
        }
        dtm.setDataVector(colum, title);
        table.setModel(dtm);
    }

    void act() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                idrow = table.getSelectedRow();
            }
        });
        capnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtm.getDataVector().removeAllElements();
                loaddata();
            }
        });
        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timkiem();
            }
        });
        textfeild.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                super.keyReleased(ke);
                timkiem();
                if (textfeild.getText().equals("")) {
                    dtm.getDataVector().removeAllElements();
                    loaddata();
                }
            }
        });
    }

    void timkiem() {
        data = new Vector<Vector<String>>();
        dtm1 = new DefaultTableModel();
        String thanhtich = textfeild.getText();
        NguoiThanImp imp = new NguoiThanImp();
        list = imp.Findby(thanhtich);
        for (NguoiThan nt : list) {
            Vector<String> row = new Vector<String>();
            row.add(nt.getHoVaTen());
            row.add(String.valueOf(nt.getTuoi()));
            row.add(nt.getThanTich());
            row.add(nt.getMaCanBo());
            row.add(nt.getQuanhe());
            data.add(row);
        }
        dtm1.setDataVector(data, title);
        table.setModel(dtm1);

    }
}
