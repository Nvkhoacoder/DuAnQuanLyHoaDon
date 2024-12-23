package database;


import java.time.LocalDate;

public abstract class SuaDao {

    public abstract void suaHD(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double loai, String loaiHD);
    public abstract boolean isHoaDonExists(String hoaDonID);
}
