package model.canbo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface ICanBo {

    public List<CanBo> getAll();//end

    public CanBo getById(String macanbo);//end

    public int getAmount();//end
    //ham nay lay ra so luong

    public void addNew(String id, String name, String dob,
            int sex, String address, String phone, String account,
            String email, String chucvu, String chucDanh, float hesoLuong,
            float phuCapDay, float phuCapChucvu, String masoThue);//end

    public boolean deleteByID(String id);//end

    public void updateByID(String id, String name, String dob,
            int sex, String address, String phone, String account,
            String email, String chucvu, String chucDanh, float hesoLuong,
            float phuCapDay, float phuCapChucvu, String masoThue);//end
    public ArrayList<CanBo> findbytenCanbo(String tenCanBo);
    public ArrayList<CanBo> findbyidmaCanbo(String maCanBo);
    public ArrayList<CanBo> findbydichiCanbo(String diaChi);
    public ArrayList<CanBo> findbysumCanbo(String tenCanBo,String maCanBo,String diaChi);
}//end
