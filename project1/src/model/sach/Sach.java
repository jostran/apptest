package model.sach;

public class Sach {

    private String maSach;
    private String tenSach;
    private String namXuatBan;
    private String nhaXuatBan;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String namXuatBan, String nhaXuatBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
    }
    
    
    public static void main(String[] args) {
        
    }
}
