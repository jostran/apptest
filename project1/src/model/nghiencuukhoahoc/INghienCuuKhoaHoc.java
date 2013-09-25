package model.nghiencuukhoahoc;

import java.util.List;


public interface INghienCuuKhoaHoc {
	public void addNew
	(String maDeTai,String tenDeTai,String cap, String kinhPhi, String thoiGianBatDau,String thoiGianKetThuc, String tinhTrang,String ketQua, String chuTri);
	public void updateById
	(String maDeTai,String tenDeTai,String cap, String kinhPhi, String thoiGianBatDau,String thoiGianKetThuc, String tinhTrang,String ketQua, String chuTri);
	public void delById(String maDeTai);
	public void setNguoiThamGia(String maCanBo, String maDeTai, String vaiTro);//. nhung can bo nao viet de tai nay
	
	public List<NghienCuuKhoaHoc> getAllByIdCanBo(String maCanBo);// can bo nay viet nhung de tai khoa hoc nao
	public List<NghienCuuKhoaHoc> getAll();

}
