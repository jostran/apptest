/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.baibao.BaiBaoImp;
import view.baibao.BaiBaoView;
import view.baibao.Baibaosua;
import view.baibao.Baibaothem;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewBaiBao implements ActionListener {

    int a;
    BaiBaoView baiBaoView;

    public ViewBaiBao(int a, BaiBaoView baiBaoView) {
        this.baiBaoView = baiBaoView;
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (a == 1 && Baibaothem.isvisible == 0) {
            Baibaothem b = new Baibaothem(null);
            Baibaothem.isvisible = 1;
        }
        if (a == 2 && Baibaosua.isvisible == 0) {
            if (BaiBaoView.idrow != -1) {
                Baibaosua b = new Baibaosua(null);
                Baibaosua.isvisible = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Mục Để Sửa");
            }
        }
        if (a == 3) {
            int i = 0;
            if (BaiBaoView.idrow != -1) {
                int id = JOptionPane.showConfirmDialog(baiBaoView, "Bạn Có Thực Sự Muốn Xóa Không", "Message", i);
                if (id == 0) {
                    BaiBaoImp baiBaoImp = new BaiBaoImp();
                    ArrayList<model.baibao.BaiBao> list = (ArrayList<model.baibao.BaiBao>) baiBaoImp.getAll();
                    baiBaoImp.delById(list.get(BaiBaoView.idrow).getMaBaiBao());
                    JOptionPane.showMessageDialog(baiBaoView, "Bạn Đã Xóa Thành Công");
                    baiBaoView.loaddata();
                }
            } else {
                JOptionPane.showMessageDialog(baiBaoView, "Bạn Chưa Chọn Trường Để Xóa");
            }
        }
    }
}
