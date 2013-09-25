package model.nguoithan;

import java.sql.Date;

public class NguoiThan {

    String hoVaTen;
    String quanhe;
    Date namsinh;
    String thanTich;
    String maCanBo;
    String tenCanBo;
    int tuoi;

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTenCanBo() {
        return tenCanBo;
    }

    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getQuanhe() {
        return quanhe;
    }

    public void setQuanhe(String quanhe) {
        this.quanhe = quanhe;
    }

    public Date getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Date namsinh) {
        this.namsinh = namsinh;
    }

    public String getThanTich() {
        return thanTich;
    }

    public void setThanTich(String thanTich) {
        this.thanTich = thanTich;
    }

    public String getMaCanBo() {
        return maCanBo;
    }

    public void setMaCanBo(String maCanBo) {
        this.maCanBo = maCanBo;
    }

    public NguoiThan() {
    }

    public NguoiThan(String hoVaTen, String quanhe, Date namsinh, String thanTich, String maCanBo, String tenCanBo, int tuoi) {
        this.hoVaTen = hoVaTen;
        this.quanhe = quanhe;
        this.namsinh = namsinh;
        this.thanTich = thanTich;
        this.maCanBo = maCanBo;
        this.tenCanBo = tenCanBo;
        this.tuoi = tuoi;
    }
}//end
