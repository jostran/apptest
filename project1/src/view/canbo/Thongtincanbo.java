/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.canbo;

import control.frame.ViewCanbo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.canbo.CanBo;
import model.canbo.CanBoImp;
import model.canbo.ICanBo;
import view.frame.Myframe;

/**
 *
 * @author Tran Xuan Truong
 */
public class Thongtincanbo extends JPanel {

    Vector<String> title;
    Vector<Vector<String>> columns;
    Vector<Vector<String>> data;
    DefaultTableModel dtm;
    JTable table;
    Myframe c;
    JPanel paneltop;
    JPanel panelcenterl;
    JPanel panel;
    JPanel panelbotom;
    JTextField textfiel;
    JButton timkiem;
    JButton capnhat;
    public static int idrow = -1;
    JComboBox box;
    int test = 0;
    private DefaultTableModel dtm1;

    public Thongtincanbo(Myframe a) {
        this.c = a;
        xxx();
        act();
    }
    JButton chitiet;

    public void xxx() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        paneltop = new JPanel();
        paneltop.setLayout(new FlowLayout());
        panelcenterl = new JPanel();
        panelbotom = new JPanel();
        title = new Vector<String>();
        columns = new Vector<Vector<String>>();
        title.add("Mã Cán Bộ");
        title.add("Tên Cán Bộ");
        title.add("Địa Chỉ");

        dtm = new DefaultTableModel();
        table = new JTable();

        textfiel = new JTextField(15);
        String[] pString = {"Theo Mã", "Theo Tên", "Theo Địa Chỉ", "Theo mã,tên và địa chỉ"};
        box = new JComboBox(pString);
        box.setSelectedIndex(0);
        ImageIcon itimkiem = new ImageIcon("timkiem.png");
        timkiem = new JButton("Tìm Kiếm",itimkiem);
        timkiem.setPreferredSize(new Dimension(100,30));
        paneltop.add(textfiel);
        paneltop.add(box);
        paneltop.add(timkiem);
        ImageIcon icapnhat = new ImageIcon("Refresh.png");
        ImageIcon ichitiet = new ImageIcon("chitiet.png");
        capnhat = new JButton("Cập Nhật",icapnhat);
        capnhat.setPreferredSize(new Dimension(100, 30));
        chitiet = new JButton("Bang Chi Tiết",ichitiet);
        chitiet.setPreferredSize(new Dimension(100, 30));
        chitiet.addActionListener(new ViewCanbo(4, null));
        panelbotom.setLayout(new FlowLayout());
        panelbotom.add(capnhat);
        panelbotom.add(chitiet);
        panelcenterl.add(new JScrollPane(table));
        panel.add(paneltop, BorderLayout.NORTH);
        panel.add(panelcenterl, BorderLayout.CENTER);
        panel.add(panelbotom, BorderLayout.SOUTH);
        add(panel);
        loaddata();
//        timkiem();
    }

    void act() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
//                super.mouseClicked(me);
                idrow = table.getSelectedRowCount();
            }
        });
        capnhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println("heheh jjj");
                dtm.getDataVector().removeAllElements();
                loaddata();
            }
        });
        timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (box.getSelectedIndex() == 0) {
                    timkiem1();
                }
                if (box.getSelectedIndex() == 1) {
                    timkiem2();
                }
                if (box.getSelectedIndex() == 2) {
                    timkiem3();
                }
                if (box.getSelectedIndex() == 3) {
                    timkiem4();
                }

            }
        });
        textfiel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if (box.getSelectedIndex() == 0) {
                    timkiem1();
                    if (textfiel.getText().equals("")) {
                        dtm.getDataVector().removeAllElements();
                        loaddata();
                    }
                }
                if (box.getSelectedIndex() == 1) {
                    timkiem2();
                    if (textfiel.getText().equals("")) {
                        dtm.getDataVector().removeAllElements();
                        loaddata();
                    }
                }
                if (box.getSelectedIndex() == 2) {
                    timkiem3();
                    if (textfiel.getText().equals("")) {
                        dtm.getDataVector().removeAllElements();
                        loaddata();
                    }
                }
                if (box.getSelectedIndex() == 3) {
                    timkiem4();
                    if (textfiel.getText().equals("")) {
                        dtm.getDataVector().removeAllElements();
                        loaddata();
                    }
                }
            }
        });


    }//end

    void loaddata() {
        CanBoImp canBoImp = new CanBoImp();
//        ArrayList<model.canbo.CanBo> list = (ArrayList<model.canbo.CanBo>) canBoImp.getAll();
        List<CanBo> list = canBoImp.getAll();
        for (int i = 0; i < list.size(); i++) {
            Vector<String> row = new Vector<String>();
            row.add(list.get(i).getMaCanBo());
            row.add(list.get(i).getTenCanBo());
            row.add(list.get(i).getDiaChi());
            columns.add(row);
        }
        dtm.setDataVector(columns, title);
        table.setModel(dtm);

    }//end

    public void timkiem1() {
        data = new Vector<Vector<String>>();
        dtm1 = new DefaultTableModel();
        String maCanBo = textfiel.getText();
        CanBoImp canBoImp = new CanBoImp();
        ArrayList<CanBo> list = canBoImp.findbyidmaCanbo(maCanBo);
        for (CanBo cb : list) {
            Vector<String> row = new Vector<String>();
            row.add(cb.getMaCanBo());
            row.add(cb.getTenCanBo());
            row.add(cb.getDiaChi());
            data.add(row);
        }
        dtm1.setDataVector(data, title);
        table.setModel(dtm1);
    }//end

    public void timkiem2() {
        data = new Vector<Vector<String>>();
        dtm1 = new DefaultTableModel();
        String maCanBo = textfiel.getText();
        CanBoImp canBoImp = new CanBoImp();
        ArrayList<CanBo> list = canBoImp.findbytenCanbo(maCanBo);
        for (CanBo cb : list) {
            Vector<String> row = new Vector<String>();
            row.add(cb.getMaCanBo());
            row.add(cb.getTenCanBo());
            row.add(cb.getDiaChi());
            data.add(row);
        }
        dtm1.setDataVector(data, title);
        table.setModel(dtm1);
    }//end

    public void timkiem3() {
        data = new Vector<Vector<String>>();
        dtm1 = new DefaultTableModel();
        String maCanBo = textfiel.getText();
        CanBoImp canBoImp = new CanBoImp();
        ArrayList<CanBo> list = canBoImp.findbydichiCanbo(maCanBo);
        for (CanBo cb : list) {
            Vector<String> row = new Vector<String>();
            row.add(cb.getMaCanBo());
            row.add(cb.getTenCanBo());
            row.add(cb.getDiaChi());
            data.add(row);
        }
        dtm1.setDataVector(data, title);
        table.setModel(dtm1);
    }//end

    public void timkiem4() {
        data = new Vector<Vector<String>>();
        dtm1 = new DefaultTableModel();
        String maCanBo = textfiel.getText();
        CanBoImp canBoImp = new CanBoImp();
        ArrayList<CanBo> list = canBoImp.findbysumCanbo(maCanBo, maCanBo, maCanBo);
        for (CanBo cb : list) {
            Vector<String> row = new Vector<String>();
            row.add(cb.getMaCanBo());
            row.add(cb.getTenCanBo());
            row.add(cb.getDiaChi());
            data.add(row);
        }
        dtm1.setDataVector(data, title);
        table.setModel(dtm1);
    }//end
}//end
