/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chamthi;

import java.util.ArrayList;

/**
 *
 * @author Tran Xuan Truong
 */
public interface IChamThi {
    public ArrayList<ChamThi> getAll();
    public void  delete(String maMonHoc);
    public void update(String maCanBo,String maMonHoc,String maLopHoc,String soBaiThi,String ngayNopBaiCham,String ngayNhanBaiCham,String lanThi);
    public void addnew(String maCanBo,String maMonHoc,String maLopHoc,String soBaiThi,String ngayNopBaiCham,String ngayNhanBaiCham,String lanThi);
}  
