package ui;


import controller.SuaHDController;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SuaHDInputUi {
    private SuaHDController suaHDController = null;
    private Scanner keyBoard = null;
    private PrintWriter screenPrompt = null;
    private String hoaDonIDPrompt, ngayHoaDonPrompt, tenKhachHangPrompt, maPhongPrompt,
            donGiaPrompt, gioThuePrompt, ngayThuePrompt, loaiHD;

    public SuaHDInputUi(SuaHDController suaHDController, Scanner keyBoard, PrintWriter screenPrompt) {
        this.suaHDController = suaHDController;
        this.keyBoard = keyBoard;
        this.screenPrompt = screenPrompt;
        hoaDonIDPrompt = "MA HOA DON: ";
        ngayHoaDonPrompt = "NGAY LAM HOA DON (dd/MM/yyyy): ";
        tenKhachHangPrompt = "TEN KHACH HANG: ";
        maPhongPrompt = "MA PHONG: ";
        donGiaPrompt = "DON GIA: ";
        gioThuePrompt = "SO GIO THUE: ";
        ngayThuePrompt = "SO NGAY THUE: ";
        loaiHD = "LOAI HOA DON [\"Gio\" / \"Ngay\"]: ";
    }

    public void nhapThongTinSuaHD() {
        String maHoaDon;
        while (true) {
            screenPrompt.print(hoaDonIDPrompt);screenPrompt.flush();
            maHoaDon = keyBoard.nextLine();
            if(suaHDController.kiemTraID(maHoaDon)) {
                break;
            } else {
                screenPrompt.println("Ma Hoa Don ma ban nhap khong co. Vui Long nhap lai!!!");
            }
        }

        screenPrompt.print(ngayHoaDonPrompt); screenPrompt.flush();
        String ngayHoaDonStr = keyBoard.nextLine();
        LocalDate ngayHoaDon = LocalDate.parse(ngayHoaDonStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        screenPrompt.print(tenKhachHangPrompt);screenPrompt.flush();
        String tenKhachHang = keyBoard.nextLine();
        screenPrompt.print(maPhongPrompt);screenPrompt.flush();
        String maPhong = keyBoard.nextLine();
        screenPrompt.print(donGiaPrompt);screenPrompt.flush();
        double donGia = keyBoard.nextDouble();keyBoard.nextLine();
        screenPrompt.print(loaiHD);screenPrompt.flush();
        String loaiHD = keyBoard.nextLine();
        if ("Gio".equalsIgnoreCase(loaiHD)) {
            screenPrompt.print(gioThuePrompt);screenPrompt.flush();
            double gioThue = keyBoard.nextDouble();keyBoard.nextLine();

            suaHDController.suaHD(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia, gioThue, "Hoa Don Gio");
        } else if ("Ngay".equalsIgnoreCase(loaiHD)) {
            screenPrompt.print(ngayThuePrompt);screenPrompt.flush();
            int ngayThue = keyBoard.nextInt();keyBoard.nextLine();

            suaHDController.suaHD(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia, ngayThue, "Hoa Don Ngay");
        } else {
            screenPrompt.println("Loai hoa don khong hop le. Vui long nhap 'Gio' hoac 'Ngay'.");
        }
    }
}
