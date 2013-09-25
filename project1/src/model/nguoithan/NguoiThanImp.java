package model.nguoithan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.ConnectDatabase;

public class NguoiThanImp implements INguoiThan {

    ArrayList<NguoiThan> list;

    @Override
    public NguoiThan getByIdCanBo(String id) {

        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn
                    .prepareStatement("SELECT canbo.maCanBo,tenCanBo,hoVaTen,namSinh,thanhTich,quanHe FROM canbo JOIN nguoithan ON canbo.maCanBo = nguoithan.maCanBo WHERE canbo.maCanBo =  ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            NguoiThan nguoiThan = new NguoiThan();
            nguoiThan.setMaCanBo(rs.getString("maCanBo"));
            nguoiThan.setTenCanBo(rs.getString("tenCanBo"));
            nguoiThan.setHoVaTen(rs.getString("hoVaTen"));
            nguoiThan.setQuanhe(rs.getString("quanHe"));
            nguoiThan.setThanTich(rs.getString("thanhTich"));

            conn.close();
            return nguoiThan;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }// end

    @Override
    public List<NguoiThan> getAll() {
        try {
            List<NguoiThan> list = new ArrayList<NguoiThan>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn
                    .prepareStatement("SELECT canbo.maCanBo,tenCanBo,hoVaTen,namSinh,thanhTich,quanHe FROM canbo JOIN nguoithan ON canbo.maCanBo = nguoithan.maCanBo");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NguoiThan nguoiThan = new NguoiThan();
                nguoiThan.setMaCanBo(rs.getString("maCanBo"));
                nguoiThan.setTenCanBo(rs.getString("tenCanBo"));
                nguoiThan.setHoVaTen(rs.getString("hoVaTen"));
                nguoiThan.setTuoi(new Date().getYear()
                        - rs.getDate("namSinh").getYear());
                nguoiThan.setQuanhe(rs.getString("quanHe"));
                nguoiThan.setThanTich(rs.getString("thanhTich"));
                list.add(nguoiThan);

            }// end while
            System.out.println(list.get(4).getTuoi());
            conn.close();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }// end

    @Override
    public List<NguoiThan> getByAgeLessthan15() {
        try {
            List<NguoiThan> list = new ArrayList<NguoiThan>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn.prepareStatement("SELECT canbo.maCanBo,tenCanBo,hoVaTen,namSinh,thanhTich,quanHe FROM canbo JOIN nguoithan ON canbo.maCanBo = nguoithan.maCanBo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiThan nguoiThan = new NguoiThan();
                nguoiThan.setMaCanBo(rs.getString("maCanBo"));
                nguoiThan.setTenCanBo(rs.getString("tenCanBo"));
                nguoiThan.setHoVaTen(rs.getString("hoVaTen"));
                nguoiThan.setNamsinh(rs.getDate("namSinh"));
                nguoiThan.setQuanhe(rs.getString("quanHe"));
                nguoiThan.setThanTich(rs.getString("thanhTich"));
                nguoiThan.setTuoi(new Date().getYear()
                        - rs.getDate("namSinh").getYear());

                if (nguoiThan.getTuoi() < 15) {
                    list.add(nguoiThan);
                }// end if
            }// end while

            conn.close();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }// end

    @Override
    public List<NguoiThan> getByPerforman() {
        try {
            List<NguoiThan> list = new ArrayList<NguoiThan>();
            Connection conn = ConnectDatabase.CreateConnectDB();
            PreparedStatement ps = conn
                    .prepareStatement("SELECT canbo.maCanBo,tenCanBo,hoVaTen,namSinh,thanhTich,quanHe FROM canbo JOIN nguoithan ON canbo.maCanBo = nguoithan.maCanBo");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NguoiThan nguoiThan = new NguoiThan();
                nguoiThan.setMaCanBo(rs.getString("maCanBo"));
                nguoiThan.setTenCanBo(rs.getString("tenCanBo"));
                nguoiThan.setHoVaTen(rs.getString("hoVaTen"));
                nguoiThan.setNamsinh(rs.getDate("namSinh"));
                nguoiThan.setQuanhe(rs.getString("quanHe"));
                nguoiThan.setThanTich(rs.getString("thanhTich"));
                nguoiThan.setTuoi(new Date().getYear()
                        - rs.getDate("namSinh").getYear());

                if (nguoiThan.getThanTich().equals("gioi")) {
                    list.add(nguoiThan);
                }// end if

            }// end while

            conn.close();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }// end

    @Override
    public boolean addNewByIdCanBo(String maCanbo, String hoVaTen,
            String quanHe, String namSinh, String thanhTich) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String addNew = "INSERT INTO nguoithan(hoVaTen,maCanBo,quanHe,thanhTich ,namSinh) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(addNew);
            ps.setString(1, hoVaTen);
            ps.setString(2, maCanbo);
            ps.setString(3, quanHe);
            ps.setString(4, thanhTich);
            ps.setString(5, namSinh);
            ps.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }// end try
        return false;
    }// end

    @Override
    public boolean deleteByIdCanBo(String maCanBo, String hoVaTen) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String Del = "DELETE FROM nguoithan WHERE (maCanBo = ? and hoVaTen = ?)";
            PreparedStatement ps = conn.prepareStatement(Del);
            ps.setString(1, maCanBo);
            ps.setString(2, hoVaTen);
            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }// end
        return true;
    }

    @Override
    public boolean updateByIdCanBo(String maCanBo, String hoVaTen,
            String ThanhTich, String namSinh, String quanHe) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            System.out.println("xxx");
            String update = "UPDATE nguoithan SET hoVaTen = ?,quanHe = ?, namSinh = ?,thanhTich = ? WHERE maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, hoVaTen);
            ps.setString(2, quanHe);
            ps.setString(3, namSinh);
            ps.setString(4, ThanhTich);
            ps.setString(5, maCanBo);
            ps.execute();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }// end
        return true;
    }// end

    @Override
    public ArrayList<NguoiThan> Findby(String thanhTich) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<NguoiThan> list = null;
        try {
            Connection cnn = ConnectDatabase.CreateConnectDB();
            Statement s =ConnectDatabase.conn.createStatement();
            rs =s.executeQuery("SELECT * FROM nguoithan WHERE thanhTich like '%"+thanhTich+"%'");
//            String find = "SELECT * FROM nguoithan WHERE thanhTich = ?";
//            ps = cnn.prepareStatement(find);
//            ps.setString(1, thanhTich);
//            rs = ps.executeQuery();
            list = new ArrayList<NguoiThan>();
            while (rs.next()) {
                NguoiThan nt = new NguoiThan();
                nt.setHoVaTen(rs.getString("hoVaTen"));
                nt.setMaCanBo(rs.getString("maCanBo"));
                nt.setQuanhe(rs.getString("quanHe"));
//                nt.setTenCanBo(rs.getString("tenCanBo"));
                nt.setThanTich(rs.getString("thanhTich"));
                nt.setTuoi(new Date().getYear()-rs.getDate("namSinh").getYear());
//                nt.setNamsinh(null);
                list.add(nt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiThanImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        NguoiThanImp nti = new NguoiThanImp();
//        nti.deleteByIdCanBo("4", "1");
//        nti.getAll();
//        nti.getByAgeLessthan15();
//        nti.deleteByIdCanBo("4", "hongquan");
//        nti.addNewByIdCanBo("2", "ngocthuyen", "concai", "1998-1-11", "kha");
//        nti.updateByIdCanBo("5", "fuck", "gioi", "1992-11-11", "concai");
        nti.Findby("kha");
    }// end
}// end

