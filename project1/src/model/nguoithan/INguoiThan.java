package model.nguoithan;

import java.util.ArrayList;
import java.util.List;


public interface INguoiThan {
	
	public NguoiThan getByIdCanBo(String id);
	public List<NguoiThan> getAll();
	public List<NguoiThan> getByAgeLessthan15();
	public List<NguoiThan> getByPerforman();
	public boolean addNewByIdCanBo(String idCanbo,String hoVaTen,String quanHe,String namSinh , String thanhTich);
	public boolean deleteByIdCanBo(String id, String hoVaTen);
	public boolean updateByIdCanBo(String maCanBo,String hoVaTen,String ThanhTich,String namSinh,String quanHe);
        public ArrayList<NguoiThan> Findby(String thanhTich);
}//end
