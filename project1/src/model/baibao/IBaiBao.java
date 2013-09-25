package model.baibao;

import java.util.List;


public interface IBaiBao {
	public void addNew(String maBaiBao, String tenBaiBao, String namXuatBan,
			String soXuatBan, String tapChiDang, float chiSoIssn);

	public void updateById(String maBaiBao, String tenBaiBao,
			String namXuatBan, String soXuatBan, String tapChiDang,
			float chiSoIssn);

	public void delById(String maBaiBao);

	public void setNguoiThamGia(String maBaiBao, String maCanBo, String vaiTro);

	public List<BaiBao> getAllByIdCanBo(String maCanBo);

	public List<BaiBao> getAll();

}
