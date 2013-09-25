/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.chamthi;

import control.frame.ViewChamThi;
import control.frame.ViewGiangDay;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.chamthi.ChamThiImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class ChamThiV extends JPanel {

    JPanel panel;
    JPanel panelcenter;
    JPanel panelbottom;
    JButton them;
    JButton sua;
    JButton xoa;
    JButton bcapnhat;
    Vector<String> title;
    public Vector<Vector<String>> colum;
    DefaultTableModel dtm;
    JTable table;
    Myframe m;
    public static int idrow = -1;

    public ChamThiV(Myframe m) {
        this.m = m;

        setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panelcenter = new JPanel();
        panelcenter.setPreferredSize(new Dimension(600, 500));
        panelbottom = new JPanel();
        panel.setLayout(new BorderLayout());
        panelbottom.setLayout(new FlowLayout());
        them = new JButton("Thêm");
        them.addActionListener(new ViewChamThi(1, this));
        sua = new JButton("Sửa");
        sua.addActionListener(new ViewChamThi(2, this));
        xoa = new JButton("Xóa");
        xoa.addActionListener(new ViewChamThi(3, this));
        bcapnhat = new JButton("Cập Nhật");

        title = new Vector<String>();
        colum = new Vector<Vector<String>>();
        title.add("Mã Lớp");
        title.add("Mã Cán Bộ");
        title.add("Mã Môn Học");
        title.add("Ngày Nộp");
        title.add("Ngày Nhận");
        title.add("Số Bài Thi");
        title.add("Lần Thi");
        dtm = new DefaultTableModel();
        table = new JTable();
        panelcenter.add(new JScrollPane(table));
        panelbottom.add(them);
        panelbottom.add(sua);
        panelbottom.add(xoa);
        panelbottom.add(bcapnhat);

        panel.add(panelcenter, BorderLayout.CENTER);
        panel.add(panelbottom, BorderLayout.SOUTH);
        add(panel);
        load();
        act();
    }

    void load() {
        ChamThiImp imp = new ChamThiImp();
        ArrayList<model.chamthi.ChamThi> list = imp.getAll();
        colum = new Vector<Vector<String>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaLop());
            row.add(list.get(i).getMaCanBo());
            row.add(list.get(i).getMaMonHoc());
            row.add(list.get(i).getNgayLopBaiCham());
            row.add(list.get(i).getNgayNhanBaiCham());
            row.add(list.get(i).getSoBaiThi());
            row.add(list.get(i).getLanThi());
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
        bcapnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtm.getDataVector().removeAllElements();
                load();
            }
        });
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = 0;
                if (idrow != -1) {
                    int id = JOptionPane.showConfirmDialog(panelbottom, "Bạn Có Thực Sự Muốn Xóa Không", null, i);
                    if (id == 0) {
                        ChamThiImp imp = new ChamThiImp();
                        ArrayList<model.chamthi.ChamThi> list = imp.getAll();
                        imp.delete(list.get(idrow).getMaMonHoc());
                        JOptionPane.showMessageDialog(m, "Bạn Đã Xóa Thành Công");
                        dtm.getDataVector().removeAllElements();
                        load();
                    }
                } else {
                    JOptionPane.showMessageDialog(m, "Bạn Chưa Chọn Mục Để Xóa");
                }
            }
        });
    }
}
