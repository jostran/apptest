/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.giangday;

import java.util.ArrayList;

/**
 *
 * @author Tran Xuan Truong
 */
public interface IGiangDay {
    public ArrayList<GiangDay> getAll();
    public void delete(String maLopHoc);
    public void addnew(String maCanBo, String maMonHoc,String maLopHoc,String thu,String tietBatDau,String soTietDay,String namHoc,String soSinhVien);
    public void update(String maCanBo, String maMonHoc,String maLopHoc,String thu,String tietBatDau,String soTietDay,String namHoc,String soSinhVien);
}
