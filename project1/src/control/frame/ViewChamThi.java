/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.chamthi.ChamThiV;
import view.chamthi.ChamThiVSua;
import view.chamthi.ChamThiVThem;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewChamThi implements ActionListener {

    int a;
    ChamThiV thi;

    public ViewChamThi(int a, ChamThiV thi) {
        this.thi = thi;
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (a == 1 && ChamThiVThem.visible == 0) {
            ChamThiVThem them = new ChamThiVThem(null);
            ChamThiVThem.visible = 1;

        }
        if (a == 2 && ChamThiVSua.visible == 0) {
            if (ChamThiV.idrow != -1) {
                ChamThiVSua sua = new ChamThiVSua(null);
                ChamThiVSua.visible = 1;
            }else{
                JOptionPane.showMessageDialog(thi, "Bạn Chưa Chọn Mục Để Sửa");
            }
        }
        if(a==3){
           
        }
    }
}
