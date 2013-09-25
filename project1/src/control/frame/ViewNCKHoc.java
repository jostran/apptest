/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.nghiencuukhoahoc.NghienCuuKhoaHoc;
import model.nghiencuukhoahoc.NghienCuuKhoaHocImp;
import view.nghiencuukhoahoc.NghienCuuKhoaHocSua;
import view.nghiencuukhoahoc.NghienCuuKhoaHocV;
import view.nghiencuukhoahoc.NghienCuuKhoaHocVThem;

/**
 *
 * @author Tran Xuan Truong
 */
public class ViewNCKHoc implements ActionListener {

    int a;
    NghienCuuKhoaHocV v;

    public ViewNCKHoc(int a, NghienCuuKhoaHocV v) {
        this.v = v;
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      
        if (a == 1 && NghienCuuKhoaHocVThem.visible == 0) {
            NghienCuuKhoaHocVThem hocVThem = new NghienCuuKhoaHocVThem(v);
            NghienCuuKhoaHocVThem.visible = 1;
        }
        if (a == 2 && NghienCuuKhoaHocSua.visible == 0) {
            if (NghienCuuKhoaHocV.idrow != -1) {
                NghienCuuKhoaHocSua hocSua = new NghienCuuKhoaHocSua(v);
                NghienCuuKhoaHocSua.visible = 1;
                
            } else {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Mục Để Sửa");
            }
        }
        if (a == 3) {

            int i = 0;
            if (NghienCuuKhoaHocV.idrow != -1) {
                int id = JOptionPane.showConfirmDialog(v, "Bạn Có Thực Sự Muốn Xóa Không", null, i);
                if (id == 0) {
                    NghienCuuKhoaHocImp hocImp = new NghienCuuKhoaHocImp();
                    List<NghienCuuKhoaHoc> list = hocImp.getAll();
                    hocImp.delById(list.get(NghienCuuKhoaHocV.idrow).getMaDeTai());
                    JOptionPane.showMessageDialog(v, "Bạn Đã Xóa Thành Công");
                    v.loaddata();
                    
                }
            } else {

                JOptionPane.showMessageDialog(v, "Bạn Chưa Chọn Mục Để Xóa");
            }
        }
    }
}
