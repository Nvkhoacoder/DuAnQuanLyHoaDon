package controller;

import database.SuaDao;
import ui.SuaHDOutputUi;


import java.time.LocalDate;

public class SuaHDController {
    private SuaDao suaDao = null;
    private SuaHDOutputUi suaHDOutputUi = null;

    public SuaHDController(SuaDao suaDao, SuaHDOutputUi suaHDOutputUi) {
        this.suaDao = suaDao;
        this.suaHDOutputUi = suaHDOutputUi;
    }

    public void suaHD(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double gioThue, String loaiHD) {
        suaDao.suaHD(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, gioThue, loaiHD);
        suaHDOutputUi.hienThongBao();
    }

    public void suaHD(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, int ngayThue, String loaiHD) {
        suaDao.suaHD(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, ngayThue, loaiHD);
        suaHDOutputUi.hienThongBao();
    }

    public boolean kiemTraID(String hoaDonID){
        return suaDao.isHoaDonExists(hoaDonID);
    }

}
