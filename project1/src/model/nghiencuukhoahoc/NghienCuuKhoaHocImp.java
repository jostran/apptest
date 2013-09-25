package model.nghiencuukhoahoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.connection.ConnectDatabase;

public class NghienCuuKhoaHocImp implements INghienCuuKhoaHoc {

    @Override
    public void addNew(String maDeTai, String tenDeTai, String cap,
            String kinhPhi, String thoiGianBatDau, String thoiGianKetThuc,
            String tinhTrang, String ketQua, String chuTri) {
        try {

            Connection conn = ConnectDatabase.CreateConnectDB();
            String addNewBook = "INSERT INTO detaikhoahoc(maDeTai,tenDeTai,cap,kinhPhi,thoiGianBatDau,thoiGianKetThuc,tinhTrang,ketQua,chuTri) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(addNewBook);

            ps.setString(1, maDeTai);
            ps.setString(2, tenDeTai);
            ps.setString(3, cap);
            ps.setString(4, kinhPhi);
            ps.setDate(5, java.sql.Date.valueOf(thoiGianBatDau));
            ps.setDate(6, java.sql.Date.valueOf(thoiGianKetThuc));
            ps.setString(7, tinhTrang);
            ps.setString(8, ketQua);
            ps.setString(9, chuTri);

            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// end

    @Override
    public void setNguoiThamGia(String maCanBo, String maDetai, String vaiTro) {
        try {
            String insert = "INSERT INTO thamgianghienCuu(maDeTai,maCanBo,vaiTro) VALUES (?,?,?)";
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, maDetai);
            ps.setString(2, maCanBo);
            ps.setString(3, vaiTro);
            ps.execute();

            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }// end

    }// end

    @Override
    public void updateById(String maDeTai, String tenDeTai, String cap, String kinhPhi, String thoiGianBatDau, String thoiGianKetThuc, String tinhTrang, String ketQua, String chuTri) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String update = "UPDATE detaikhoahoc SET tenDeTai = ?,cap = ?, kinhPhi = ?, thoiGianBatDau = ?, thoiGianKetThuc = ?,tinhTrang = ?,ketQua = ?, chuTri = ? WHERE madeTai = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, tenDeTai);
            ps.setString(2, cap);
            ps.setString(3, kinhPhi);
            ps.setDate(4, java.sql.Date.valueOf(thoiGianBatDau));
            ps.setDate(5, java.sql.Date.valueOf(thoiGianKetThuc));
            ps.setString(6, tinhTrang);
            ps.setString(7, ketQua);
            ps.setString(8, chuTri);
            ps.setString(9, maDeTai);


            ps.execute();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }//end

    }//end

    @Override
    public void delById(String maDeTai) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String del = "DELETE FROM detaikhoahoc WHERE madeTai = ?";
            PreparedStatement ps = conn.prepareStatement(del);

            ps.setString(1, maDeTai);
            ps.execute();
            ps.close();
            conn.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }//end

    @Override
    public List<NghienCuuKhoaHoc> getAllByIdCanBo(String maCanBo) {

        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            List<NghienCuuKhoaHoc> list = new ArrayList<NghienCuuKhoaHoc>();
            String get = "SELECT * FROM detaikhoahoc JOIN thamgianghiencuu ON detaikhoahoc.madeTai = thamgianghiencuu.madeTai WHERE maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(get);
            ps.setString(1, maCanBo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NghienCuuKhoaHoc d = new NghienCuuKhoaHoc();
                d.setCap(rs.getString("cap"));
                d.setChuTri(rs.getString("chuTri"));
                d.setKetQua(rs.getString("ketQua"));
                d.setKinhPhi(rs.getFloat("kinhPhi"));
                d.setMaDeTai(rs.getString("madeTai"));
                d.setTenDeTai(rs.getString("tenDeTai"));
                d.setThoiGianBatDau(rs.getDate("thoiGianBatDau").toString());
                d.setThoiGianket(rs.getDate("thoiGianKetThuc").toString());
                d.setTinhTrang(rs.getString("tinhTrang"));

                list.add(d);

            }//end while
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }//end

        return null;
    }//end

    @Override
    public List<NghienCuuKhoaHoc> getAll() {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            List<NghienCuuKhoaHoc> list = new ArrayList<NghienCuuKhoaHoc>();
            String get = "SELECT * FROM detaikhoahoc";
            PreparedStatement ps = conn.prepareStatement(get);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NghienCuuKhoaHoc d = new NghienCuuKhoaHoc();
                d.setCap(rs.getString("cap"));
                d.setChuTri(rs.getString("chuTri"));
                d.setKetQua(rs.getString("ketQua"));
                d.setKinhPhi(rs.getFloat("kinhPhi"));
                d.setMaDeTai(rs.getString("madeTai"));
                d.setTenDeTai(rs.getString("tenDeTai"));
                d.setThoiGianBatDau(rs.getDate("thoiGianBatDau").toString());
                d.setThoiGianket(rs.getDate("thoiGianKetThuc").toString());
                d.setTinhTrang(rs.getString("tinhTrang"));

                list.add(d);
                System.out.println(list.get(0).getMaDeTai());
            }//end while
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }//end

        return null;
    }//end

    public static void main(String[] args) {
		NghienCuuKhoaHocImp dt=  new NghienCuuKhoaHocImp();
//		String a = dt.getAll().get(0).getCap();
//		System.out.println(a);
//                dt.getAll();
                dt.delById("ma1");
//                dt.updateById("ma1", "yyyy", "yyyyyyy", "13", "1991-12-10", "1999-09-08", "yyyy", "yyyyy", "yyyyy");
    }
}//ened
