package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class HoaDonNgay extends HoaDon implements Serializable {
    private int ngayThue;

    public HoaDonNgay(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, int ngayThue, String loaiHD) {
        super(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, "Hoa Don Ngay");
        this.ngayThue = ngayThue;
    }

    public int getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(int ngayThue) {
        this.ngayThue = ngayThue;
    }

    @Override
    public double tongTien() {
        if(ngayThue <= 7){
            return ngayThue * donGia;
        } else {
            return ((donGia * 7) + (ngayThue - 7) * donGia * 0.8);
        }
    }

}
