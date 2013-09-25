/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import com.sun.rowset.internal.Row;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import model.nguoithan.NguoiThanImp;
import model.sach.Sach;
import model.sach.SachImp;
import view.sach.SachSua;
import view.sach.SachThem;
import view.sach.Sachview;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewSach implements ActionListener {

    int a;
    Sachview sachview;
//    SachThem sachThem;
    List<model.sach.Sach> list;

    public ViewSach(int a, Sachview sachview) {
        this.a = a;
        this.sachview = sachview;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (a == 1 && SachSua.isVisiable == 0) {
            if (Sachview.idRow != -1) {
                SachSua g = new SachSua(sachview);
                SachSua.isVisiable = 1;
            }else{
                JOptionPane.showMessageDialog(sachview, "Bạn Chưa Chọn Mục Để Sửa");
            }

        }
        if (a == 2 && SachThem.isVisiable == 0) {
            SachThem g = new SachThem(sachview);
            SachThem.isVisiable = 1;
        }
        if (a == 3) {
            int i = 0;

            if (Sachview.idRow != -1) {
                //                System.out.println(list.get(Sachview.idRow).getMaSach());
                int CONFIRM = JOptionPane.showConfirmDialog(sachview, "Bạn Có Thực Sự Muốn Xóa Không", "", i);
                if (CONFIRM == 0) {
                    SachImp sachImp = new SachImp();
                    List<Sach> list = sachImp.getAllBook();
                    sachImp.delById(list.get(Sachview.idRow).getMaSach());
                    JOptionPane.showMessageDialog(sachview, "Xóa Thành Công");
                    
//                    sachview.dtm.getDataVector().removeAllElements();
                    sachview.loaddata();
                    
                }
            }else{
                JOptionPane.showMessageDialog(sachview, "Bạn Chưa Chọn Mục Để Xóa");

            }
        }
        }
    }
