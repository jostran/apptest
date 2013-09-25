/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.nghiencuukhoahoc;

import control.frame.ViewNCKHoc;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.nghiencuukhoahoc.NghienCuuKhoaHocImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class NghienCuuKhoaHocV extends JPanel {

    JPanel panel;
    JPanel panelcenter;
    JPanel panelbottom;
    JButton them;
    JButton sua;
    JButton xoa;
    Vector<String> title;
    Vector<Vector<String>> colum;
    DefaultTableModel dtm;
    JTable table;
    Myframe m;
    ArrayList<model.nghiencuukhoahoc.NghienCuuKhoaHoc> list;
    public static int idrow = -1;

    public NghienCuuKhoaHocV(Myframe m) {
        this.m = m;
        xxx();
    }

    void xxx() {
//        setLayout(null);
        panel = new JPanel();
        panelcenter = new JPanel();
        panelcenter.setPreferredSize(new Dimension(600, 500));
        panelbottom = new JPanel();
        panel.setLayout(new BorderLayout());
        panelbottom.setLayout(new FlowLayout());
        them = new JButton("Thêm");
        them.addActionListener(new ViewNCKHoc(1, this));
        sua = new JButton("Sửa");
        sua.addActionListener(new ViewNCKHoc(2, this));
        xoa = new JButton("Xóa");
        xoa.addActionListener(new ViewNCKHoc(3, this));

        title = new Vector<String>();
        colum = new Vector<Vector<String>>();
        title.add("Mã");
        title.add("Tên");
        title.add("Cấp");
        title.add("Kinh Phí");
        title.add("Bắt Đầu");
        title.add("Kết Thúc");
        title.add("Chủ Trì");
        title.add("Tình Trạng");
        title.add("Kết Quả");
        dtm = new DefaultTableModel();
        table = new JTable();
        panelcenter.add(new JScrollPane(table));
        panelbottom.add(them);
        panelbottom.add(sua);
        panelbottom.add(xoa);

        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbottom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
        act();
//        setVisible(true);
    }

    public void loaddata() {
        NghienCuuKhoaHocImp hocImp = new NghienCuuKhoaHocImp();
        list = (ArrayList<model.nghiencuukhoahoc.NghienCuuKhoaHoc>) hocImp.getAll();
        colum = new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaDeTai());
            row.add(list.get(i).getTenDeTai());
            row.add(list.get(i).getCap());
            row.add(String.valueOf(list.get(i).getKinhPhi()));
            row.add(list.get(i).getThoiGianBatDau());
            row.add(list.get(i).getThoiGianket());
            row.add(list.get(i).getChuTri());
            row.add(list.get(i).getTinhTrang());
            row.add(list.get(i).getKetQua());
            colum.add(row);
        }
        dtm.getDataVector().removeAllElements();
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

    }
}
