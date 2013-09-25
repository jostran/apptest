/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.canbo.CanBo;
import model.canbo.CanBoImp;
import view.canbo.CanBoChiTiet;
import view.canbo.CanBoSua;
import view.canbo.CanBoThem;
import view.canbo.Thongtincanbo;
import view.canbo.Thongtinchitiet;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewCanbo implements ActionListener {

    int a;
    Thongtinchitiet thongtinchitiet;

    public ViewCanbo(int a, Thongtinchitiet thongtinchitiet) {
        this.a = a;
        this.thongtinchitiet = thongtinchitiet;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (a == 1 && CanBoThem.isvisible == 0) {
            CanBoThem them = new CanBoThem(thongtinchitiet);
            CanBoThem.isvisible = 1;
        }
        if (a == 2 && CanBoSua.isvisible == 0) {
            if (Thongtinchitiet.idrow != -1) {
                CanBoSua sua = new CanBoSua(thongtinchitiet);
                CanBoSua.isvisible = 1;
            } else {
                JOptionPane.showMessageDialog(thongtinchitiet, "Bạn Chưa Chọn Trường Để Sửa");
            }
        }
        if (a == 3 && CanBoChiTiet.isvisible == 0) {
            if (Thongtinchitiet.idrow != -1) {
                CanBoChiTiet tiet = new CanBoChiTiet(thongtinchitiet);
                CanBoChiTiet.isvisible = 1;
            } else {
                JOptionPane.showMessageDialog(thongtinchitiet, "Bạn Chưa Chọn Trường Để Hiển Thị");
            }
        }
        if (a == 4 && Thongtinchitiet.isVisible == 0) {
            Thongtinchitiet t = new Thongtinchitiet();
            Thongtinchitiet.isVisible = 1;
        }


    }
}
