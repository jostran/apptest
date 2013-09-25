package model.canbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.connection.ConnectDatabase;
import sun.security.pkcs11.Secmod;

public class CanBoImp implements ICanBo {

    ArrayList<CanBo> list;
    PreparedStatement ps;
    ResultSet rs;
    Connection cnn;

    @Override
    public List<CanBo> getAll() {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            list = new ArrayList<CanBo>();
            String getAll = "SELECT * FROM canbo";
            ps = conn.prepareStatement(getAll);
            rs = ps.executeQuery();

            while (rs.next()) {
                CanBo canBo = new CanBo();
                canBo.setChucDanh(rs.getString("chucVu"));
                canBo.setChucVu(rs.getString("chucDanh"));
                canBo.setDiaChi(rs.getString("diaChi"));
                canBo.setEmail(rs.getString("email"));
                canBo.setGioiTinh(rs.getInt("gioiTinh"));
                canBo.setHeSoLuong(rs.getFloat("heSoLuong"));
                canBo.setMaCanBo(rs.getString("maCanBo"));
                canBo.setMaSoThue(rs.getString("maSoThue"));
                canBo.setNgaySinh(rs.getDate("ngaySinh"));
                canBo.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
                canBo.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
                canBo.setSoDienThoai(rs.getString("soDienThoai"));
                canBo.setSoTaiKhoan(rs.getString("soTaikhoan"));
                canBo.setTenCanBo(rs.getString("tenCanBo"));
//                System.out.println(rs.getString("maCanBo"));
                list.add(canBo);
            }//end
            System.out.println(list.get(0).getMaCanBo());
            conn.close();
            return list;
        } //end
        catch (Exception ex) {
            ex.printStackTrace();
        }//end
        return null;
    }//end

    @Override
    public CanBo getById(String maCanBo) {
        try {
            CanBo canBo = new CanBo();
            Connection conn = ConnectDatabase.CreateConnectDB();
            String getById = "SELECT * FROM canbo WHERE maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(getById);
            ps.setString(1, maCanBo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            canBo.setChucDanh(rs.getString("chucVu"));
            canBo.setChucVu(rs.getString("chucDanh"));
            canBo.setDiaChi(rs.getString("diaChi"));
            canBo.setEmail(rs.getString("email"));
            canBo.setGioiTinh(rs.getInt("gioiTinh"));
            canBo.setHeSoLuong(rs.getFloat("heSoLuong"));
            canBo.setMaCanBo(rs.getString("maCanBo"));
            canBo.setMaSoThue(rs.getString("maSoThue"));
            canBo.setNgaySinh(rs.getDate("ngaySinh"));
            canBo.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
            canBo.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
            canBo.setSoDienThoai(rs.getString("soDienThoai"));
            canBo.setSoTaiKhoan(rs.getString("soTaikhoan"));
            canBo.setTenCanBo(rs.getString("tenCanBo"));

            conn.close();
            return canBo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }//end
        return null;
    }//end

    @Override
    public void addNew(String id, String name, String dob, int sex, String address, String phone, String account, String email, String chucvu, String chucDanh, float hesoLuong, float phuCapDay, float phuCapChucvu, String masoThue) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String addnew = "INSERT INTO canbo(maCanBo,tenCanBo,ngaySinh,gioiTinh,diaChi,soDienThoai,soTaiKhoan,email,chucVu,ChucDanh,heSoLuong,phuCapGiangDay,phuCapChucVu,maSoThue) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(addnew);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setDate(3, java.sql.Date.valueOf(dob));
            ps.setInt(4, sex);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, account);
            ps.setString(8, email);
            ps.setString(9, chucvu);
            ps.setString(10, chucDanh);
            ps.setFloat(11, hesoLuong);
            ps.setFloat(12, phuCapDay);
            ps.setFloat(13, phuCapChucvu);
            ps.setString(14, masoThue);

            ps.execute();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }//end
//        return false;
    }//end

    @Override
    public int getAmount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteByID(String id) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String deleteByid = "DELETE FROM canbo WHERE maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(deleteByid);
            ps.setString(1, id);
            ps.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }//end
        return false;
    }//end

    @Override
    public void updateByID(String id, String name, String dob, int sex, String address, String phone, String account, String email, String chucvu, String chucDanh, float hesoLuong, float phuCapDay, float phuCapChucvu, String masoThue) {
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            String update = "UPDATE canbo SET tenCanBo=?,ngaySinh=?,gioiTinh=?,diaChi=?,soDienThoai=?,soTaiKhoan=?,email=?,chucVu=?,chucDanh=?,heSoLuong=?,phuCapGiangDay=?,phuCapChucVu=?,maSoThue=? WHERE maCanBo=?";
            PreparedStatement ps = cnn.prepareStatement(update);
            ps.setString(1, name);
            ps.setString(2, String.valueOf(dob));
            ps.setString(3, String.valueOf(sex));
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, account);
            ps.setString(7, email);
            ps.setString(8, chucvu);
            ps.setString(9, chucDanh);
            ps.setString(10, String.valueOf(hesoLuong));
            ps.setString(11, String.valueOf(phuCapDay));
            ps.setString(12, String.valueOf(phuCapChucvu));
            ps.setString(13, masoThue);
            ps.setString(14, id);
//            System.out.println("yyy");
            ps.execute();
            cnn.close();
//            System.out.println("xxx");
        } catch (SQLException ex) {
            Logger.getLogger(CanBoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<CanBo> findbytenCanbo(String tenCanBo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CanBo> list = null;
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
//            String find = "SELECT * FROM canbo WHERE tenCanBo Like '%"+tenCanBo+"%'";
//            ps = cnn.prepareStatement(find);
//            ps.setString(1, tenCanBo);
            Statement s =ConnectDatabase.conn.createStatement();
            rs= s.executeQuery("SELECT * FROM canbo WHERE tenCanBo Like '%"+tenCanBo+"%'");
//            rs = ps.executeQuery();


            list = new ArrayList<CanBo>();


            while (rs.next()) {
                CanBo cb = new CanBo();
                cb.setMaCanBo(rs.getString("maCanBo"));
                cb.setTenCanBo(rs.getString("tenCanBo"));
                cb.setGioiTinh(rs.getInt("gioiTinh"));
                cb.setNgaySinh(new java.sql.Date(rs.getDate("ngaySinh").getTime()));
                cb.setDiaChi(rs.getString("diaChi"));
                cb.setEmail(rs.getString("email"));
                cb.setChucVu(rs.getString("chucVu"));
                cb.setChucDanh(rs.getString("chucDanh"));
                cb.setHeSoLuong(rs.getFloat("heSoLuong"));
                cb.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
                cb.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
                cb.setSoDienThoai(rs.getString("soDienThoai"));
                cb.setSoTaiKhoan(rs.getString("soTaiKhoan"));
                cb.setMaSoThue(rs.getString("maSoThue"));
                list.add(cb);

//                System.out.println(cb.getDiaChi());
//                System.out.println(cb.getMaCanBo());
//                System.out.println(list.get(0).getNgaySinh());
            }

            return list;



        } catch (SQLException ex) {
            Logger.getLogger(CanBoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<CanBo> findbyidmaCanbo(String maCanBo) {
        PreparedStatement ps;
        ResultSet rs;
        try {
           Connection  cnn = ConnectDatabase.CreateConnectDB();
            Statement s = ConnectDatabase.conn.createStatement();
            rs =s.executeQuery("SELECT *FROM canbo WHERE maCanBo Like '%"+maCanBo+"%'");
//            String canbo = "SELECT *FROM canbo WHERE maCanBo Like '%"+maCanBo+"%'";
//            ps = cnn.prepareStatement(canbo);
//            ps.setString(1, maCanBo);
//            rs = ps.executeQuery();
            list = new ArrayList<CanBo>();
            while (rs.next()) {
                CanBo cb = new CanBo();
                cb.setMaCanBo(rs.getString("maCanBo"));
                cb.setTenCanBo(rs.getString("tenCanBo"));
                cb.setGioiTinh(rs.getInt("gioiTinh"));
                cb.setNgaySinh(new java.sql.Date(rs.getDate("ngaySinh").getTime()));
                cb.setDiaChi(rs.getString("diaChi"));
                cb.setEmail(rs.getString("email"));
                cb.setChucVu(rs.getString("chucVu"));
                cb.setChucDanh(rs.getString("chucDanh"));
                cb.setHeSoLuong(rs.getFloat("heSoLuong"));
                cb.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
                cb.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
                cb.setSoDienThoai(rs.getString("soDienThoai"));
                cb.setSoTaiKhoan(rs.getString("soTaiKhoan"));
                cb.setMaSoThue(rs.getString("maSoThue"));
                list.add(cb);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CanBoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public ArrayList<CanBo> findbydichiCanbo(String diaChi) {
        PreparedStatement ps;
        ResultSet rs;

        try {
            cnn = ConnectDatabase.CreateConnectDB();
//            String find = "SELECT * FROM canbo WHERE diaChi =? ";
//            ps = cnn.prepareStatement(find);
            Statement s = ConnectDatabase.conn.createStatement();
            rs = s.executeQuery("SELECT * FROM canbo WHERE diaChi Like '%"+diaChi+"%'");
//            ps.setString(1, diaChi);
//            rs = ps.executeQuery();
            list = new ArrayList<CanBo>();
            while (rs.next()) {
                CanBo cb = new CanBo();
                cb.setMaCanBo(rs.getString("maCanBo"));
                cb.setTenCanBo(rs.getString("tenCanBo"));
                cb.setGioiTinh(rs.getInt("gioiTinh"));
                cb.setNgaySinh(new java.sql.Date(rs.getDate("ngaySinh").getTime()));
                cb.setDiaChi(rs.getString("diaChi"));
                cb.setEmail(rs.getString("email"));
                cb.setChucVu(rs.getString("chucVu"));
                cb.setChucDanh(rs.getString("chucDanh"));
                cb.setHeSoLuong(rs.getFloat("heSoLuong"));
                cb.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
                cb.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
                cb.setSoDienThoai(rs.getString("soDienThoai"));
                cb.setSoTaiKhoan(rs.getString("soTaiKhoan"));
                cb.setMaSoThue(rs.getString("maSoThue"));
                list.add(cb);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CanBoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<CanBo> findbysumCanbo(String tenCanBo, String maCanBo, String diaChi) {
        list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            Statement s = ConnectDatabase.conn.createStatement();
            rs= s.executeQuery("SELECT * FROM canbo WHERE (tenCanBo Like '%"+tenCanBo+"%')OR(maCanBo Like '%"+maCanBo+"%')OR(diaChi Like '%"+diaChi+"%')");
//            String find = "SELECT * FROM canbo WHERE tenCanBo    OR(maCanBo=?)OR(diaChi=?)";
//            ps = cnn.prepareStatement(find);
//            ps.setString(1, tenCanBo);
//            ps.setString(2, maCanBo);
//            ps.setString(3, diaChi);
//            rs = ps.executeQuery();
//            System.out.println("xxx");
            while (rs.next()) {
//                System.out.println("yyyyy");
                CanBo cb = new CanBo();
                cb.setMaCanBo(rs.getString("maCanBo"));
                cb.setTenCanBo(rs.getString("tenCanBo"));
                cb.setGioiTinh(rs.getInt("gioiTinh"));
                cb.setNgaySinh(new java.sql.Date(rs.getDate("ngaySinh").getTime()));
                cb.setDiaChi(rs.getString("diaChi"));
                cb.setEmail(rs.getString("email"));
                cb.setChucVu(rs.getString("chucVu"));
                cb.setChucDanh(rs.getString("chucDanh"));
                cb.setHeSoLuong(rs.getFloat("heSoLuong"));
                cb.setPhuCapChucVu(rs.getFloat("phuCapChucVu"));
                cb.setPhuCapGiangDay(rs.getFloat("phuCapGiangDay"));
                cb.setSoDienThoai(rs.getString("soDienThoai"));
                cb.setSoTaiKhoan(rs.getString("soTaiKhoan"));
                cb.setMaSoThue(rs.getString("maSoThue"));
//                System.out.println("ttttt");
                list.add(cb);
//                System.out.println("fuck");


            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CanBoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        CanBoImp ci = new CanBoImp();
//        System.out.println(ci.addNew("fuck", "NgocThuyen","2012-11-11", 3, "3", "3", "3", "3", "3", "3", 3, 3, 3, "3"));
//        System.out.println("xxx");
//        ci.addNew("44", "concai", "2008-02-12", Integer.valueOf(1),
//                "3", "3", "3", "3", "3", "3", Float.valueOf(1), Float.valueOf(1),Float.valueOf(1), "4");
//        ci.updateByID("44", "what the fuck", "2010-02-12", Integer.valueOf(1),
//                "4", "4", "4", "4", "4", "4", Float.valueOf(1), Float.valueOf(1),Float.valueOf(1), "4");
//        System.out.println("sucsess");
//        ci.getAll();
//        ArrayList<CanBo> list = new CanBoImp().findbyCanbo("tantruong");
//        ci.deleteByID("ma1");
        ci.findbysumCanbo(null, null, null);
    }//end
}//end