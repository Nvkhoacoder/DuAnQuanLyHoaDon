package database;

public class TimHDDao extends TimDao {

    @Override
    public boolean timHD(String maHoaDon){
        return HoaDonDatabase.timHoaDon(maHoaDon);
    }
}
