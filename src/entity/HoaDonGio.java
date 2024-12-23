package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class HoaDonGio extends HoaDon implements Serializable {
    private double gioThue;

    public HoaDonGio(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double gioThue, String loaiHD) {
        super(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, "Hoa Don Gio");
        this.gioThue = gioThue;
        if(gioThue > 30){
            throw new IllegalArgumentException("Không thể sử dụng hoá đơn theo giờ.Vui lòng làm lại theo hoá đơn ngày");
        }
    }

    public double getGioThue() {
        return gioThue;
    }

    public void setGioThue(double gioThue) {
        this.gioThue = gioThue;
    }

    @Override
    public double tongTien() {
        if(gioThue <= 24){
            return gioThue * donGia;
        } else if(gioThue > 24 && gioThue < 30){
            return 24 * donGia;
        } else {
            return 0;
        }
    }
}
