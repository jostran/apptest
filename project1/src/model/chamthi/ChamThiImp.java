/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chamthi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.ConnectDatabase;

/**
 *
 * @author Tran Xuan Truong
 */
public class ChamThiImp implements IChamThi {

    @Override
    public ArrayList<ChamThi> getAll() {
        ArrayList<ChamThi> list;
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            String getall = "SELECT * FROM chamthi";
            ps = cnn.prepareStatement(getall);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                ChamThi thi = new ChamThi();
                thi.setMaCanBo(rs.getString("maCanBo"));
                thi.setMaLop(rs.getString("maLopHoc"));
                thi.setMaMonHoc(rs.getString("maMonHoc"));
                thi.setNgayNhanBaiCham(rs.getString("ngayNhanBaiCham"));
                thi.setNgayLopBaiCham(rs.getString("ngayLopBaiCham"));
                thi.setSoBaiThi(rs.getString("soBaiThi"));
                thi.setLanThi(rs.getString("lanThi"));
                list.add(thi);
//            System.out.println(list.get(0).getMaMonHoc());
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChamThiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void delete( String maMonHoc) {
        try {
            Connection  cnn = ConnectDatabase.CreateConnectDB();
            String del = "DELETE FROM chamthi WHERE maMonHoc=?";
            PreparedStatement ps = cnn.prepareStatement(del);
            ps.setString(1, maMonHoc);
            ps.execute();
            ps.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChamThiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String maCanBo, String maMonHoc, String maLopHoc, String soBaiThi, String ngayLopBaiCham, String ngayNhanBaiCham, String lanThi) {
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            String update = "UPDATE chamthi SET soBaiThi=?,ngayLopBaiCham=?,ngayNhanBaiCham=?,lanThi=? WHERE maCanBo=?";
            PreparedStatement ps = cnn.prepareStatement(update);
            ps.setString(1, soBaiThi);
            ps.setString(2, ngayLopBaiCham);
            ps.setString(3, ngayNhanBaiCham);
            ps.setString(4, lanThi);
            ps.setString(5, maCanBo);

            ps.execute();
            ps.close();
            cnn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addnew(String maCanBo, String maMonHoc, String maLopHoc, String soBaiThi, String ngayNopBaiCham, String ngayNhanBaiCham, String lanThi) {
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            String addnew="INSERT INTO chamthi(maCanBo,maMonHoc,maLopHoc,soBaiThi,ngayLopBaiCham,ngayNhanBaiCham,lanThi) VALUE(?,?,?,?,?,?,?)";
            PreparedStatement ps= cnn.prepareStatement(addnew);
            ps.setString(1, maCanBo);
            ps.setString(2, maMonHoc);
            ps.setString(3, maLopHoc);
            ps.setString(4,soBaiThi);
            ps.setDate(5, java.sql.Date.valueOf(ngayNopBaiCham));
            ps.setDate(6, java.sql.Date.valueOf(ngayNhanBaiCham));
            ps.setString(7, lanThi);
            ps.execute();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChamThiImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        ChamThiImp cti = new ChamThiImp();
//        cti.getAll();
//        cti.delete("3");
        cti.update("lop1", "canbo1", "monhoc1", "6", "1999-10-10", "2000-11-11", "7");
//        cti.addnew("4", "4", "lop2", "4", "1991-11-11", "1992-10-10", "5");
    }
}
