package database;


import entity.HoaDon;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TongDoanhThuDaoFile extends TongDTDao {
    private File fileData = null;

    public TongDoanhThuDaoFile(File fileData) {
        this.fileData = fileData;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoThang(int thang, int nam) {
        // Initialize danhSachHoaDon as ArrayList
        ArrayList<HoaDon> danhSachHoaDon = HoaDonDatabase.docTuFile(fileData);

        // Filter the list based on the month and year and return as ArrayList
        return danhSachHoaDon.stream()
                .filter(hd -> hd.getNgayHoaDon() != null &&
                        hd.getNgayHoaDon().getMonthValue() == thang &&
                        hd.getNgayHoaDon().getYear() == nam)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
