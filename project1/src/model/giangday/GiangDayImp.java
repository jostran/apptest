/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.giangday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.ConnectDatabase;

/**
 *
 * @author Tran Xuan Truong
 */
public class GiangDayImp implements IGiangDay{

    @Override
    public ArrayList<GiangDay> getAll() {
        ArrayList<GiangDay> list;
        try {
            Connection cnn= ConnectDatabase.CreateConnectDB();
            String getall="SELECT * FROM giangday";
            PreparedStatement ps = cnn.prepareStatement(getall);
           ResultSet rs=  ps.executeQuery();
            list= new ArrayList<GiangDay>();
            while (rs.next()) {
                GiangDay gd = new GiangDay();
                gd.setMaCanBo(rs.getString("maCanBo"));
                gd.setMaLopHoc(rs.getString("maLopHoc"));
                gd.setMaMon(rs.getString("maMonHoc"));
                gd.setNamHoc(rs.getString("namHoc"));
                gd.setSoSinhVien(rs.getString("soSinhVien"));
                gd.setThu(rs.getString("thu"));
                gd.setTietBatDau(rs.getString("tietBatDau"));
                gd.setSoTietDay(rs.getString("soTietDay"));
                list.add(gd);
            }
               return  list;   
        } catch (SQLException ex) {
            Logger.getLogger(GiangDayImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void delete(String maLopHoc) {
        try {
            Connection cnn= ConnectDatabase.CreateConnectDB();
            String delete ="DELETE FROM giangday WHERE maLopHoc=?";
            PreparedStatement ps = cnn.prepareStatement(delete);
            ps.setString(1, maLopHoc);
            ps.execute();
            ps.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GiangDayImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addnew(String maCanBo, String maMonHoc, String maLopHoc, String thu, String tietBatDau, String soTietDay, String namHoc, String soSinhVien) {
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            String addnew = "INSERT INTO giangday(maCanBo,maMonHoc,maLopHoc,thu,tietBatDau,soTietDay,namHoc,soSinhVien) VALUE(?,?,?,?,?,?,?,?)";
            PreparedStatement ps= cnn.prepareStatement(addnew);
            ps.setString(1, maCanBo);
            ps.setString(2, maMonHoc);
            ps.setString(3, maLopHoc);
            ps.setString(4, thu);
            ps.setString(5, tietBatDau);
            ps.setString(6, soTietDay);
            ps.setString(7, namHoc);
            ps.setString(8, soSinhVien);
            ps.execute();
            ps.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GiangDayImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String maCanBo, String maMonHoc, String maLopHoc, String thu, String tietBatDau, String soTietDay, String namHoc, String soSinhVien) {
        try {
            Connection cnn= ConnectDatabase.CreateConnectDB();
            String update = "UPDATE giangday SET thu=?,tietBatDau=?,soTietDay=?,namHoc=?,soSinhVien=? WHERE maMonHoc=?";
            PreparedStatement ps = cnn.prepareStatement(update);
            ps.setString(1, thu);
            ps.setString(2, tietBatDau);
            ps.setString(3, soTietDay);
            ps.setString(4, namHoc);
            ps.setString(5, soSinhVien);
            ps.setString(6, maMonHoc);
            ps.execute();
            ps.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GiangDayImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args) {
        GiangDayImp imp = new GiangDayImp();
//        imp.getAll();
        imp.delete("lop1");
//        imp.addnew("4", "2", "lop1", "3", "2", "5", "2012-11-11", "40");
        imp.update("4", "2", "lop1", "3", "3", "3", "1919-11-11", "50");
    }
    
}
