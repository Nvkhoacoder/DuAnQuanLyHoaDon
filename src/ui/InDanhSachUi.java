package ui;

import controller.InDanhSachController;
import entity.HoaDon;
import entity.HoaDonGio;
import entity.HoaDonNgay;

import java.io.PrintWriter;
import java.util.List;

public class InDanhSachUi {
    private PrintWriter screenOut = null;
    private InDanhSachController inDSHDControl = null;

    public InDanhSachUi(PrintWriter screenOut, InDanhSachController inDSHDControl) {
        this.screenOut = screenOut;
        this.inDSHDControl = inDSHDControl;
    }

    public void hienThiDanhSachHoaDon() {
        List<HoaDon> danhSachHoaDon = inDSHDControl.layDanhSachHoaDon();

        if (danhSachHoaDon.isEmpty()) {
            screenOut.println("Danh Sach Hoa Don Trong!!!");
        } else {
            screenOut.println("Danh Sach Hoa Don: ");
            for (HoaDon hoaDon : danhSachHoaDon) {
                screenOut.println("Ma Hoa Don: " + hoaDon.getHoaDonID());
                screenOut.println("Ngay Hoa Don: " + hoaDon.getNgayHoaDon());
                screenOut.println("Ten Khach Hang: " + hoaDon.getTenKhachHang());
                if (hoaDon instanceof HoaDonGio) {
                    HoaDonGio hdGio = (HoaDonGio) hoaDon;
                    screenOut.println("Ma Phong: " + hoaDon.getMaPhong());
                    screenOut.println("So Gio Thue: " + hdGio.getGioThue());
                    screenOut.println("Đon Gia: " + hdGio.getDonGia());
                    screenOut.println("Loai Hoa Don: " + hdGio.getLoaiHD());
                } else if (hoaDon instanceof HoaDonNgay) {
                    HoaDonNgay hdNgay = (HoaDonNgay) hoaDon;
                    screenOut.println("Ma Phong: " + hoaDon.getMaPhong());
                    screenOut.println("So Ngay Thue: " + hdNgay.getNgayThue());
                    screenOut.println("Đon Gia: " + hdNgay.getDonGia());
                    screenOut.println("Loai Hoa Don: " + hdNgay.getLoaiHD());
                }
                screenOut.println("---------------------------------");
            }
            screenOut.flush();
        }
    }
}
