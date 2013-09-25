/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sach;

import control.frame.ViewSach;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.sach.SachImp;

/**
 *
 * @author Tran Xuan Truong
 */
public class SachSua extends JFrame {

    JLabel masach;
    JLabel tensach;
    JLabel namxuatban;
    JLabel nhaxuatban;
    TextField txtmasach;
    TextField txttensach;
    TextField txtnamxb;
    TextField txtnhaxb;
    JButton sua;
    Sachview sachView;
    int rowid;
    public static int isVisiable = 0;
//    ArrayList<Sachview> list=null;
    List<model.sach.Sach> list;

    public SachSua(Sachview sachview) {
        this.sachView = sachview;
        setTitle("Sửa Thông Tin Giáo Trình");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                isVisiable = 0;
            }
        });
        masach = new JLabel("Mã Sách");
        tensach = new JLabel("Tên Sách");
        namxuatban = new JLabel("Năm Xuất Bản");
        nhaxuatban = new JLabel("Nhà Xuất Bản");
        txtmasach = new TextField();
        txttensach = new TextField();
        txtnamxb = new TextField();
        txtnhaxb = new TextField();
        sua = new JButton("Chỉnh Sửa");
        masach.setBounds(20, 20, 100, 30);
        tensach.setBounds(20, 70, 100, 30);
        namxuatban.setBounds(20, 120, 100, 30);
        nhaxuatban.setBounds(20, 170, 100, 30);
        txtmasach.setBounds(150, 20, 150, 30);
        txttensach.setBounds(150, 70, 150, 30);
        txtnamxb.setBounds(150, 120, 150, 30);
        txtnhaxb.setBounds(150, 170, 150, 30);
        sua.setBounds(150, 220, 100, 30);


        add(masach);
        add(tensach);
        add(namxuatban);
        add(nhaxuatban);
        add(txtmasach);
        add(txttensach);
        add(txtnamxb);
        add(txtnhaxb);
        add(sua);

        loaddata();
        act();

        setVisible(true);
    }

    void act() {

        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean b = true;

                if (txtmasach.getText().equals("")
                        || txttensach.getText().equals("")
                        || txtnamxb.getText().equals("")
                        || txtnhaxb.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn Không Được Để Trống Trường Nào");
                    b = false;
                } else {

                    SachImp sachImp = new SachImp();
                    sachImp.updateById(txtmasach.getText(),
                            txttensach.getText(),
                            txtnamxb.getText(),
                            txtnhaxb.getText());
                    JOptionPane.showMessageDialog(sachView, "Bạn Đã Sửa Thành Công");
                    sachView.loaddata();
                }
            }
//            }
        });

    }

    public void loaddata() {
        SachImp sachImp = (SachImp) new SachImp();
        list = sachImp.getAllBook();

        txtmasach.setText(list.get(Sachview.idRow).getMaSach());
        txttensach.setText(list.get(Sachview.idRow).getTenSach());
        txtnamxb.setText(list.get(Sachview.idRow).getNamXuatBan());
        txtnhaxb.setText(list.get(Sachview.idRow).getNhaXuatBan());

    }
}
