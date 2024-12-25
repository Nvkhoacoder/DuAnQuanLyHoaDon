package ui;

import controller.DemSoLuongHDController;
import controller.TongDoanhThuController;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class HoaDonMenuConsoleUi {
    private Scanner keyBoardInput = null;
    private String prompt = null;
    private PrintWriter screenPrompt = null;
    private ThemHDInputUi themHDInputUi = null;
    private SuaHDInputUi suaHDInputUi = null;
    private XoaHDInputUi xoaHDInputUi = null;
    private TimHDInputUi timHDInputUi = null;
    private DoanhThuInputUi doanhThuInputUi = null;
    private DemSoLuongHDController demSoLuongHDController = null;
    private InDanhSachUi inDanhSachUi = null;

    public HoaDonMenuConsoleUi(Scanner keyBoardInput, PrintWriter screenPrompt, ThemHDInputUi themHDInputUi, SuaHDInputUi suaHDInputUi, XoaHDInputUi xoaHDInputUi, TimHDInputUi timHDInputUi, DoanhThuInputUi doanhThuInputUi, DemSoLuongHDController demSoLuongHDController, InDanhSachUi inDanhSachUi) {
        this.keyBoardInput = keyBoardInput;
        this.screenPrompt = screenPrompt;
        this.themHDInputUi = themHDInputUi;
        this.suaHDInputUi = suaHDInputUi;
        this.xoaHDInputUi = xoaHDInputUi;
        this.timHDInputUi = timHDInputUi;
        this.doanhThuInputUi = doanhThuInputUi;
        this.demSoLuongHDController = demSoLuongHDController;
        this.inDanhSachUi = inDanhSachUi;
        this.prompt = "Vui Long Nhap ->";
    }

    public void hoaDonProgram() {
        String command = " ";
        screenPrompt.println("Go lenh \"help\" de bat dau chuong trinh");

        while (true) {
            screenPrompt.print(prompt);
            screenPrompt.flush();
            command = keyBoardInput.nextLine();
            command = command.trim();

            if (command.equalsIgnoreCase("help")) {
                help();
                continue;
            }

            if (command.equalsIgnoreCase("about")) {
                about();
                continue;
            }

            if (command.equalsIgnoreCase("add")) {

                themHD();
                continue;
            }

            if (command.equalsIgnoreCase("remove")) {

                xoaHD();
                continue;
            }

            if (command.equalsIgnoreCase("update")) {

                suaHD();
                continue;
            }

            if (command.equalsIgnoreCase("find")) {

                timHD();
                continue;
            }

            if (command.equalsIgnoreCase("print")) {

                inDSHD();
                continue;
            }

            if (command.equalsIgnoreCase("sl")) {

                tongSoLuongHD();
                continue;
            }

            if (command.equalsIgnoreCase("dt")) {

                tinhDTTheoThang();
                continue;
            }

            if (command.equalsIgnoreCase("quit")) {
                break;
            }

        }
    }

    private void help() {
        screenPrompt.println("~~~~~~~~Hoa Don Management Menu~~~~~~~~");
        screenPrompt.println("[START] Bat dau chuong trinh.");
        screenPrompt.println("[ABOUT] Thong tin ve phan mem.");
        screenPrompt.println("[ADD] Them Hoa Don.");
        screenPrompt.println("[REMOVE] Xoa Hoa Don.");
        screenPrompt.println("[UPDATE] Chinh Sua Hoa Don.");
        screenPrompt.println("[FIND] Tim Hoa Don.");
        screenPrompt.println("[PRINT] In Danh Sach Hoa Don.");
        screenPrompt.println("[SL] Tong So Luong Hoa Don Theo Loai.");
        screenPrompt.println("[DT] Tinh tong Doanh Thu Theo Thang.");
        screenPrompt.println("[QUIT] Dong phan mem.");
        screenPrompt.println("~~~~~~~~Hoa Don Management Menu~~~~~~~~");
    }

    private void themHD() {
        themHDInputUi.nhapThongTinHoaDon();
    }

    private void inDSHD() {
        inDanhSachUi.hienThiDanhSachHoaDon();
    }

    private void xoaHD() {
        xoaHDInputUi.nhapMaHoaDonCanXoa();
    }

    private void suaHD() {
        suaHDInputUi.nhapThongTinSuaHD();
    }

    private void timHD() {
        timHDInputUi.nhapThongTinTim();
    }

    private void tongSoLuongHD() {
        demSoLuongHDController.demSoLuongHD();
    }

    private void tinhDTTheoThang() {
        doanhThuInputUi.tongDoanhThuTheoThang();
    }

    private void about(){
        screenPrompt.println("Day la chuong trinh ve quan ly hoa don trong khach san.");
        screenPrompt.println("Bao gom cac chuc nang them,xoa,sua,tim hoa don.");
        screenPrompt.println("Trong day con co them tong so luong hoa don va tong doanh thu thang.");
        screenPrompt.println("Cam on da xem va su dung chuong trinh nay");
    }
}
