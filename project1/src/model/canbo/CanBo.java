/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.canbo;

import java.sql.Date;

/**
 *
 * @author t2n
 */
public class CanBo {

    String maCanBo;
    String tenCanBo;
    Date ngaySinh;
    int gioiTinh;
    String diaChi;
    String soDienThoai;
    String soTaiKhoan;
    String email;
    String chucVu;
    String chucDanh;
    float heSoLuong;
    float phuCapGiangDay;
    float phuCapChucVu;
    String maSoThue;
    int luongToiThieu = 100;
    float congDoanPhi = (heSoLuong + phuCapChucVu) * luongToiThieu;
    float dangPhi = (heSoLuong + phuCapChucVu + phuCapGiangDay) * luongToiThieu;

    public int getLuongToiThieu() {
        return luongToiThieu;
    }

    public void setLuongToiThieu(int luongToiThieu) {
        this.luongToiThieu = luongToiThieu;
    }

    /**
     * @return the maCanBo
     */
    public String getMaCanBo() {
        return maCanBo;
    }

    /**
     * @param maCanBo the maCanBo to set
     */
    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    /**
     * @return the tenCanBo
     */
    public String getTenCanBo() {
        return tenCanBo;
    }

    /**
     * @param tenCanBo the tenCanBo to set
     */
    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the gioiTinh
     */
    public int getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    public float getCongDoanPhi() {
        return congDoanPhi;
    }

    public void setCongDoanPhi(float congDoanPhi) {
        this.congDoanPhi = congDoanPhi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the soDienThoai
     */
    public String getSoDienThoai() {
        return soDienThoai;
    }

    /**
     * @param soDienThoai the soDienThoai to set
     */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    /**
     * @return the soTaiKhoan
     */
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    /**
     * @param soTaiKhoan the soTaiKhoan to set
     */
    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the chucVu
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the chucDanh
     */
    public String getChucDanh() {
        return chucDanh;
    }

    /**
     * @param chucDanh the chucDanh to set
     */
    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    /**
     * @return the heSoLuong
     */
    public float getHeSoLuong() {
        return heSoLuong;
    }

    /**
     * @param heSoLuong the heSoLuong to set
     */
    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    /**
     * @return the phuCapGiangDay
     */
    public float getPhuCapGiangDay() {
        return phuCapGiangDay;
    }

    /**
     * @param phuCapGiangDay the phuCapGiangDay to set
     */
    public void setPhuCapGiangDay(float phuCapGiangDay) {
        this.phuCapGiangDay = phuCapGiangDay;
    }

    /**
     * @return the phuCapChucVu
     */
    public float getPhuCapChucVu() {
        return phuCapChucVu;
    }

    /**
     * @param phuCapChucVu the phuCapChucVu to set
     */
    public void setPhuCapChucVu(float phuCapChucVu) {
        this.phuCapChucVu = phuCapChucVu;
    }

    /**
     * @return the maSoThue
     */
    public String getMaSoThue() {
        return maSoThue;
    }

    /**
     * @param maSoThue the maSoThue to set
     */
    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public void setDangPhi(float dangPhi) {
        this.dangPhi = dangPhi;
    }

    public float getDangPhi() {
        return dangPhi;
    }
}//end class
