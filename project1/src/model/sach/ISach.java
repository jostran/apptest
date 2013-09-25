package model.sach;

import java.util.List;

public interface ISach {
	public void addNew(String maSach,String tenSach,String namXuatBan, String nhaXuatBan);
	public void updateById(String maSach,String tenSach, String namXuatBan , String nhaXuatBan);
	public void delById(String maSach);
	public void setNguoiThamGia(String maCanBo, String maSach, String vaiTro);
	public List<NguoiThamGia> getNguoiThamGia(String maSach);// nhung ai tyam gia viet quyen sach nay
	public List<Sach> getBookByIdCanBo(String maCanBo);// can bo nay viet nhung quyen sach nao
	public List<Sach> getAllBook();
	
}//end
