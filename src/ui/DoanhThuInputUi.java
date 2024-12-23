package ui;

import controller.TongDoanhThuController;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DoanhThuInputUi {
    private Scanner keyBoard = null;
    private PrintWriter screenPrompt = null;
    private String thangPrompt,namPrompt;
    private TongDoanhThuController tongDoanhThuController = null;

    public DoanhThuInputUi(TongDoanhThuController tongDoanhThuController,Scanner keyBoard, PrintWriter screenPrompt){
        this.tongDoanhThuController = tongDoanhThuController;
        this.keyBoard = keyBoard;
        this.screenPrompt = screenPrompt;
        thangPrompt = "NHAP THANG: ";
        namPrompt = "NHAP NAM: ";
    }

    public void tongDoanhThuTheoThang() {
        screenPrompt.print(thangPrompt);
        screenPrompt.flush();
        int thang = keyBoard.nextInt();

        while (thang < 1 || thang > 12) {
            screenPrompt.println("Vui Long Nhap Lai Thang");
            screenPrompt.print(thangPrompt);
            screenPrompt.flush();
            thang = keyBoard.nextInt();
        }

        screenPrompt.print(namPrompt);
        screenPrompt.flush();
        int nam = keyBoard.nextInt();

        tongDoanhThuController.tinhThanhTienMonthHD(thang,nam);
        keyBoard.nextLine();
    }

}
