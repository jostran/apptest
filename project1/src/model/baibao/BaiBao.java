package model.baibao;

public class BaiBao {

    private String maBaiBao;
    private String tenBaiBao;
    private String namXuatBan;
    private String soXuatBan;
    private String tapChiDang;
    private float chiSoIssn;

    public String getMaBaiBao() {
        return maBaiBao;
    }

    public void setMaBaiBao(String maBaiBao) {
        this.maBaiBao = maBaiBao;
    }

    public String getTenBaiBao() {
        return tenBaiBao;
    }

    public void setTenBaiBao(String tenBaiBao) {
        this.tenBaiBao = tenBaiBao;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getSoXuatBan() {
        return soXuatBan;
    }

    public void setSoXuatBan(String soXuatBan) {
        this.soXuatBan = soXuatBan;
    }

    public String getTapChiDang() {
        return tapChiDang;
    }

    public void setTapChiDang(String tapChiDang) {
        this.tapChiDang = tapChiDang;
    }

    public float getChiSoIssn() {
        return chiSoIssn;
    }

    public void setChiSoIssn(float chiSoIssn) {
        this.chiSoIssn = chiSoIssn;
    }

    public BaiBao() {
    }

    public BaiBao(String maBaiBao, String tenBaiBao, String namXuatBan, String soXuatBan, String tapChiDang, float chiSoIssn) {
        this.maBaiBao = maBaiBao;
        this.tenBaiBao = tenBaiBao;
        this.namXuatBan = namXuatBan;
        this.soXuatBan = soXuatBan;
        this.tapChiDang = tapChiDang;
        this.chiSoIssn = chiSoIssn;
    }
}
