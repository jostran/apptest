package model.sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.connection.ConnectDatabase;

public class SachImp implements ISach {

    @Override
    public void addNew(String maSach, String tenSach, String namXuatBan,
            String nhaXuatBan) {
        try {

            Connection conn = ConnectDatabase.CreateConnectDB();
            String addNewBook = "INSERT INTO sach(maSach,tenSach,namXuatBan,nhaXuatBan) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(addNewBook);

            ps.setString(1, maSach);
            ps.setString(2, tenSach);
//            ps.setDate(3, java.sql.Date.valueOf(namXuatBan));
            ps.setString(3, namXuatBan);
            ps.setString(4, nhaXuatBan);

            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end

    @Override
    public void setNguoiThamGia(String maCanBo, String maSach, String vaiTro) {
        try {
            String insert = "INSERT INTO thamgiavietsach(maSach,maCanBo,vaiTro) VALUES (?,?,?)";
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, maSach);
            ps.setString(2, maCanBo);
            ps.setString(3, vaiTro);
            ps.execute();

            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }// end

    }// end

    @Override
    public List<NguoiThamGia> getNguoiThamGia(String maSach) {
        try {
            List<NguoiThamGia> list = new ArrayList<NguoiThamGia>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            String get = "SELECT * FROM sach JOIN thamgiavietsach ON sach.maSach = thamgiavietsach.maSach WHERE sach.maSach = ?";
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, maSach);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NguoiThamGia nguoiThamGia = new NguoiThamGia();
                nguoiThamGia.setVaiTro(rs.getString("vaiTro"));
                nguoiThamGia.setMaNguoiThamGia(rs.getString("maCanBo"));
                list.add(nguoiThamGia);
            }// end

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }//end
        return null;

    }// end

    @Override
    public List<Sach> getAllBook() {
        List<Sach> list;
        PreparedStatement ps;
        ResultSet rs;
        try {
            list = new ArrayList<Sach>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            String getAllBook = "SELECT * FROM sach ";
            ps = conn.prepareStatement(getAllBook);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("maSach"));
                sach.setTenSach(rs.getString("tenSach"));
                sach.setNamXuatBan(rs.getDate("namXuatBan").toString());
                sach.setNhaXuatBan(rs.getString("nhaXuatBan"));
                list.add(sach);
            }// end
//                System.out.println(list.get(0).getMaSach());
//                System.out.println(list.get(0).getTenSach());
//                System.out.println(list.get(0).getNamXuatBan());
//                System.out.println(list.get(0).getNhaXuatBan());

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }// end
        return null;
    }// end

    @Override
    public List<Sach> getBookByIdCanBo(String maCanBo) {
        try {
            List<Sach> list = new ArrayList<Sach>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            String getAllBook = "SELECT * FROM sach JOIN thamgiavietsach ON sach.maSach = thamgiavietsach.maSach WHERE maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(getAllBook);
            ps.setString(1, maCanBo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("maSach"));
                sach.setNamXuatBan(rs.getDate("namXuatBan").toString());
                sach.setNhaXuatBan(rs.getString("nhaXuatBan"));
                sach.setTenSach(rs.getString("tenSach"));

                list.add(sach);
            }// end

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }// end
        return null;
    }// end

    @Override
    public void updateById(String maSach, String tenSach, String namXuatBan,
            String nhaXuatBan) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String update = "UPDATE sach SET tenSach = ?, namXuatBan = ?, nhaXuatBan = ? WHERE maSach = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, tenSach);
            ps.setDate(2, java.sql.Date.valueOf(namXuatBan));
            ps.setString(3, nhaXuatBan);
            ps.setString(4, maSach);

            ps.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }// end

    }// end

    @Override
    public void delById(String maSach) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String del = "DELETE FROM sach WHERE maSach = ?";
            PreparedStatement ps = conn.prepareStatement(del);
            ps.setString(1, maSach);
            ps.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }// end

    }// end

    public static void main(String[] args) {
        SachImp s = new SachImp();
//         s.addNewBook("4", "2", "1888-1-1", "hn");
//         s.addNew("yyy", "yyyy", "2010-12-12 ", "yyy");
         s.updateById("ma5","fuck", "1987-1-12", "fuck");
//		s.setNguoiThamGia("7", "4", "tac gi ngu");
//		s.getNguoiThamGia("1");
//        s.getAllBook();
//        s.addNew("123", "Khoa Hoc Vien Tuong", "1992-02-02", "Bo Lao dong");
//        s.delById("ma2");
    }
}// end class
