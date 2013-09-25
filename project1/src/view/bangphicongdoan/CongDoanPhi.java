/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.bangphicongdoan;

//import control.frame.ViewCongDoanPhi;
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
import model.canbo.CanBoImp;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class CongDoanPhi extends JPanel {

    DefaultTableModel dtm;
    JTable table;
    Myframe c;
    JPanel panelcentre;
    JPanel panel;
    JPanel panelbotom;
    JButton bcapnhat;
//    JButton sua;
//    JButton xoa;
    Vector<String> title;
    Vector<Vector<String>> culoms;
    ArrayList<model.canbo.CanBo> list;

    public CongDoanPhi(Myframe c) {
        this.c = c;
        xxx();
    }

    public void xxx() {
        panelcentre = new JPanel();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panelbotom = new JPanel();
        panelbotom.setLayout(new FlowLayout());
        title = new Vector<>();
        culoms = new Vector<Vector<String>>();
        title.add("Tên Nhân Viên");
        title.add("Hệ Số Lương");
        title.add("PC Chức Vụ");
        title.add("Lương Tối Thiểu");
        title.add("Công Đoàn Phí");

        dtm = new DefaultTableModel();
//        dtm.setDataVector(culoms, title);
        table = new JTable();
//        table.setModel(dtm);

        bcapnhat = new JButton("Cập Nhật");
//        sua = new JButton("Sửa");
//        sua.addActionListener(new ViewCongDoanPhi(2, this));
//        xoa = new JButton("Xóa");
        panelbotom.add(bcapnhat);
//        panelbotom.add(sua);
//        panelbotom.add(xoa);
        panelcentre.add(new JScrollPane(table));
        panel.add(panelcentre, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
        act();
    }

    void loaddata() {
        CanBoImp boImp = new CanBoImp();
        list = (ArrayList<model.canbo.CanBo>) boImp.getAll();
        for (int i = 0; i < list.size(); i++) {
            float doanphi = (list.get(i).getHeSoLuong()+list.get(i).getPhuCapChucVu())*1000/100;
            Vector<String> row = new Vector<>();
            row.add(list.get(i).getTenCanBo());
            row.add(String.valueOf(list.get(i).getHeSoLuong()));
            row.add(String.valueOf(list.get(i).getPhuCapChucVu()));
            row.add(String.valueOf(list.get(i).getLuongToiThieu()));
            row.add(String.valueOf(doanphi));
            culoms.add(row);
        }
        dtm.setDataVector(culoms, title);
        table.setModel(dtm);
    }

    void act() {
//        bcapnhat.addActionListener(new ViewCongDoanPhi(1, this));
        bcapnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtm.getDataVector().removeAllElements();
                loaddata();
            }
        });

    }
}
