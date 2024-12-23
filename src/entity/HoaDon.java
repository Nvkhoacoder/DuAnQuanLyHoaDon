package entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class HoaDon implements Serializable {
    protected String hoaDonID;
    protected LocalDate ngayHoaDon;
    protected String tenKhachHang;
    protected String maPhong;
    protected double donGia;
    protected String loaiHD;


    public HoaDon(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, String loaiHD) {
        this.hoaDonID = hoaDonID;
        this.ngayHoaDon = ngayHoaDon;
        this.tenKhachHang = tenKhachHang;
        this.maPhong = maPhong;
        this.donGia = donGia;
        this.loaiHD = loaiHD;
    }

    public String getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(String hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public LocalDate getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(LocalDate ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public abstract double tongTien();
}
