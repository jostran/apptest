/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.giangday.GiangDayThemV;
import view.giangday.GiangDayV;
import view.giangday.GiangDayVSua;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewGiangDay implements ActionListener {

    int a;
    GiangDayV dayV;

    public ViewGiangDay(int a, GiangDayV dayV) {
        this.a = a;
        this.dayV = dayV;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (a == 1 && GiangDayVSua.visible == 0) {
            if (GiangDayV.idrow != -1) {
                GiangDayVSua gdvs = new GiangDayVSua(dayV);
                GiangDayVSua.visible = 1;
            }else{
                JOptionPane.showMessageDialog(dayV, "Bạn Chưa Chọn Mục Để Sửa");
            }
        }
        if (a == 2 && GiangDayThemV.visible == 0) {
            GiangDayThemV gdtv = new GiangDayThemV(dayV);
            GiangDayThemV.visible = 1;
        }

    }
}
