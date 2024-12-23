package database;


import java.time.LocalDate;

public class SuaHDData extends SuaDao{

    @Override
    public void suaHD(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double loai, String loaiHD){
        HoaDonDatabase.suaHoaDon(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, loai, loaiHD);
    }

    @Override
    public boolean isHoaDonExists(String hoaDonID){
        return HoaDonDatabase.kiemTraHoaDonTonTai(hoaDonID);
    }
}
