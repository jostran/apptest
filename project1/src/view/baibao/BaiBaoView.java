/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.baibao;

import control.frame.ViewBaiBao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.baibao.BaiBaoImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class BaiBaoView extends JPanel {

    Myframe c;
    JPanel panel;
    JPanel panelcenter;
    JPanel panelbotom;
    DefaultTableModel dtm;
    JTable table;
    JButton them;
    JButton xoa;
    JButton sua;
    List<model.baibao.BaiBao> list;
    Vector<String> row;
    Vector<Vector<String>> colum;
    Vector<String> title;
    Vector<String> title1;
    public static int idrow = -1;
    JButton bcapnhat;

    public BaiBaoView(Myframe c) {
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
        title.add("Mã Bài Báo");
        title.add("Tên Bài Báo");
        title.add("Năm Xuất Bản");
        title.add("Số Xuất Bản");
        title.add("Tên Tạp Chí");
        title.add("Chỉ Số ISSN");
        dtm = new DefaultTableModel();
        table = new JTable();
        them = new JButton("Thêm");
        them.addActionListener(new ViewBaiBao(1, this));
        xoa = new JButton("Xóa");
        xoa.addActionListener(new ViewBaiBao(3, this));
        sua = new JButton("Sửa");
        bcapnhat = new JButton("Cập Nhật");
        sua.addActionListener(new ViewBaiBao(2, this));
        panelcenter.add(new JScrollPane(table));
        panelbotom.add(them);
        panelbotom.add(xoa);
        panelbotom.add(sua);
        panelbotom.add(bcapnhat);
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
        act();
    }

    void act() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                idrow = table.getSelectedRow();
            }
        });
        bcapnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtm.getDataVector().removeAllElements();
                loaddata();
            }
        });
    }

    public void loaddata() {
        dtm = new DefaultTableModel();
        BaiBaoImp baiBaoImp = new BaiBaoImp();
        list = baiBaoImp.getAll();
        colum = new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            row = new Vector<String>();
            row.add(list.get(i).getMaBaiBao());
            row.add(list.get(i).getTenBaiBao());
            row.add(list.get(i).getNamXuatBan());
            row.add(list.get(i).getSoXuatBan());
            row.add(list.get(i).getTapChiDang());
            row.add(String.valueOf(list.get(i).getChiSoIssn()));
            colum.add(row);

        }
        dtm.getDataVector().removeAllElements();
        dtm.setDataVector(colum, title);
        table.setModel(dtm);
    }
}
