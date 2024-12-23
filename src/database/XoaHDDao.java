package database;

public class XoaHDDao extends XoaDao {

    @Override
    public boolean xoaHoaDon(String maHoaDon){
        return HoaDonDatabase.xoaHoaDon(maHoaDon);
    }
}
