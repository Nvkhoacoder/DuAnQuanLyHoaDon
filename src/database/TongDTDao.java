package database;

import entity.HoaDon;

import java.util.ArrayList;

public abstract class TongDTDao {
    public abstract ArrayList<HoaDon> getHoaDonTheoThang(int thang, int nam);
}
