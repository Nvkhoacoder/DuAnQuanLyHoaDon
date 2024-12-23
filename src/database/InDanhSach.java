package database;

import entity.HoaDon;

import java.util.ArrayList;

public class InDanhSach implements InDSDao {

    public ArrayList<HoaDon> layDanhSachHD() {
        return HoaDonDatabase.queryAllHoaDon();
    }
}
