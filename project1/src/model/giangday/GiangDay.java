/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.giangday;

/**
 *
 * @author Tran Xuan Truong
 */
public class GiangDay {
    public String maCanBo;
    public String maMonHoc;
    public String maLopHoc;
    public String thu;
    public String tietBatDau;
    public String soTietDay;
    public String namHoc;
    public String soSinhVien;

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public String getMaMon() {
        return maMonHoc;
    }

    public void setMaMon(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getTietBatDau() {
        return tietBatDau;
    }

    public void setTietBatDau(String tietBatDau) {
        this.tietBatDau = tietBatDau;
    }

    public String getSoTietDay() {
        return soTietDay;
    }

    public void setSoTietDay(String soTietDay) {
        this.soTietDay = soTietDay;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getSoSinhVien() {
        return soSinhVien;
    }

    public void setSoSinhVien(String soSinhVien) {
        this.soSinhVien = soSinhVien;
    }

    public GiangDay() {
    }

    public GiangDay(String maCanBo, String maMonHoc, String maLopHoc, String thu, String tietBatDau, String soTietDay, String namHoc, String soSinhVien) {
        this.maCanBo = maCanBo;
        this.maMonHoc = maMonHoc;
        this.maLopHoc = maLopHoc;
        this.thu = thu;
        this.tietBatDau = tietBatDau;
        this.soTietDay = soTietDay;
        this.namHoc = namHoc;
        this.soSinhVien = soSinhVien;
    }
    
}
