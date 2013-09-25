package model.baibao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.connection.ConnectDatabase;

public class BaiBaoImp implements IBaiBao {

    @Override
    public void addNew(String maBaiBao, String tenBaiBao, String namXuatBan,
            String soXuatBan, String tapChiDang, float chiSoIssn) {
        PreparedStatement ps;
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String addNewBook = "INSERT INTO baibao(maBaiBao,tenBaiBao,namXuatBan,soXuatBan,tenTapChiDang,chiSoIssn) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(addNewBook);

            ps.setString(1, maBaiBao);
            ps.setString(2, tenBaiBao);
            ps.setDate(3, java.sql.Date.valueOf(namXuatBan));
            ps.setString(4, soXuatBan);
            ps.setString(5, tapChiDang);
            ps.setFloat(6, chiSoIssn);

            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end

    @Override
    public void updateById(String maBaiBao, String tenBaiBao,
            String namXuatBan, String soXuatBan, String tapChiDang,
            float chiSoIssn) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String update = "UPDATE baibao SET tenBaiBao = ?,namXuatBan= ?,soXuatBan= ?,tenTapChiDang= ?,chiSoIssn= ? WHERE maBaiBao = ?";
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1, tenBaiBao);
            ps.setDate(2, java.sql.Date.valueOf(namXuatBan));
            ps.setString(3, soXuatBan);
            ps.setString(4, tapChiDang);
            ps.setFloat(5, chiSoIssn);
            ps.setString(6, maBaiBao);

            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// end

    @Override
    public void delById(String maBaiBao) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String del = "DELETE from baibao WHERE maBaiBao = ?";
            PreparedStatement ps = conn.prepareStatement(del);
            ps.setString(1, maBaiBao);
            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end

    @Override
    public void setNguoiThamGia(String maBaiBao, String maCanBo, String vaiTro) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            String insert = "INSERT INTO thamgiabaibao(maBaiBao,maCanBo,vaiTro) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, maBaiBao);
            ps.setString(2, maCanBo);
            ps.setString(3, vaiTro);
            ps.execute();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end

    @Override
    public List<BaiBao> getAllByIdCanBo(String maCanBo) {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            List<BaiBao> list = new ArrayList<BaiBao>();
            String insert = "select * from baibao join thamgiabaibao on baibao.maBaiBao = thamgiabaibao.mabaiBao where maCanBo = ?";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setString(1, maCanBo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BaiBao bb = new BaiBao();
                bb.setTenBaiBao(rs.getString("tenBaiBao"));
                bb.setTapChiDang(rs.getString("tenTapChiDang"));
                bb.setSoXuatBan(rs.getString("soXuatBan"));
                bb.setNamXuatBan(rs.getString("namXuatBan"));
                bb.setMaBaiBao(rs.getString("maBaiBao"));
                bb.setChiSoIssn(rs.getFloat("chiSoIssn"));

                list.add(bb);
            }// nend

            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }// /ned
        return null;
    }// end

    @Override
    public List<BaiBao> getAll() {
        try {
            Connection conn = ConnectDatabase.CreateConnectDB();
            List<BaiBao> list = new ArrayList<BaiBao>();
            String insert = "select * from baibao";
            PreparedStatement ps = conn.prepareStatement(insert);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BaiBao bb = new BaiBao();
                bb.setTenBaiBao(rs.getString("tenBaiBao"));
                bb.setTapChiDang(rs.getString("tenTapChiDang"));
                bb.setSoXuatBan(rs.getString("soXuatBan"));
                bb.setNamXuatBan(rs.getString("namXuatBan"));
                bb.setMaBaiBao(rs.getString("maBaiBao"));
                bb.setChiSoIssn(rs.getFloat("chiSoIssn"));

                list.add(bb);
            }// nend

            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }// /ned
        return null;
    }//end

    public static void main(String[] args) {
        BaiBaoImp b = new BaiBaoImp();
//        String s = b.getAll().get(0).getMaBaiBao();
//        b.addNew("ma9", "Oshit", "1111-11-11", "13", "Bao Dan Tri", 4);
//        b.delById("ma9");
        System.out.println("hehehe");
        b.updateById("ma5", "yyy", "1991-11-11", "yyy", "xxyyyxx", 7);
    }
}// end class
