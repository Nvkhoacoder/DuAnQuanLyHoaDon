package database;

import entity.HoaDon;

public class ThemHDDao extends ThemDao{

    @Override
    public void themHD(HoaDon hd) {
        HoaDonDatabase.addHoaDon(hd);
    }
}
