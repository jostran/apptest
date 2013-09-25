/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.nguoithan.NguoiThanImp;
import view.cacchaunhanqua.Cacchaunhanqua;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewCacchaunhanqua implements ActionListener {

    int a;
    Cacchaunhanqua c;

    public ViewCacchaunhanqua(int a, Cacchaunhanqua c) {
        this.c = c;
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (a == 1 && Cacchaunhanquathem.visible == 0) {
//            Cacchaunhanquathem c = new Cacchaunhanquathem(null);
//            Cacchaunhanquathem.visible = 1;
//        }
//        if (a == 2 && Cacchaunhanquasua.visible == 0) {
//            if (Cacchaunhanqua.idrow != -1) {
//                Cacchaunhanquasua c = new Cacchaunhanquasua(null);
//                Cacchaunhanquasua.visible = 1;
//            } else {
//                JOptionPane.showMessageDialog(c, "Ban Chua Chon Muc De Sua");
//            }
//        }
        if (a == 3) {
            if (Cacchaunhanqua.idrow != -1) {
                int i = 0;
                int id = JOptionPane.showConfirmDialog(c, "Ban Co Thuc Su Muon Xoa Khong", "", i);
                if (id == 0) {
                    NguoiThanImp imp = new NguoiThanImp();
                    List<model.nguoithan.NguoiThan> list = imp.getByAgeLessthan15();
                    imp.deleteByIdCanBo(list.get(Cacchaunhanqua.idrow).getMaCanBo(), list.get(Cacchaunhanqua.idrow).getHoVaTen());
                    JOptionPane.showMessageDialog(c, "Ban Da Xoa Thanh Cong");
                }
            } else {
                JOptionPane.showMessageDialog(c, "Ban Chua Chon Muc De Xoa");
            }

        }
    }
}
