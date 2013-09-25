/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.chamthi;

/**
 *
 * @author Tran Xuan Truong
 */
public class ChamThi {

    public String maLop;
    public String maCanBo;
    public String maMonHoc;
    public String ngayLopBaiCham;
    public String ngayNhanBaiCham;
    public String soBaiThi;
    public String lanThi;

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getNgayLopBaiCham() {
        return ngayLopBaiCham;
    }

    public void setNgayLopBaiCham(String ngayLopBaiCham) {
        this.ngayLopBaiCham = ngayLopBaiCham;
    }

    public String getNgayNhanBaiCham() {
        return ngayNhanBaiCham;
    }

    public void setNgayNhanBaiCham(String ngayNhanBaiCham) {
        this.ngayNhanBaiCham = ngayNhanBaiCham;
    }

    public String getSoBaiThi() {
        return soBaiThi;
    }

    public void setSoBaiThi(String soBaiThi) {
        this.soBaiThi = soBaiThi;
    }

    public String getLanThi() {
        return lanThi;
    }

    public void setLanThi(String lanThi) {
        this.lanThi = lanThi;
    }

    public ChamThi() {
    }

    public ChamThi(String maLop, String maCanBo, String maMonHoc, String ngayLopBaiCham, String ngayNhanBaiCham, String soBaiThi, String lanThi) {
        this.maLop = maLop;
        this.maCanBo = maCanBo;
        this.maMonHoc = maMonHoc;
        this.ngayLopBaiCham = ngayLopBaiCham;
        this.ngayNhanBaiCham = ngayNhanBaiCham;
        this.soBaiThi = soBaiThi;
        this.lanThi = lanThi;
    }
}
