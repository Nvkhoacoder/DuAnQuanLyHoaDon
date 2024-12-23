package ui;

import controller.TimHDController;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TimHDInputUi {
    private TimHDController timHDController = null;
    private Scanner keyBoard = null;
    private PrintWriter screenPrompt = null;
    private String hoaDonIDPrompt;

    public TimHDInputUi(TimHDController timHDController, Scanner keyBoard, PrintWriter screenPrompt) {
        this.timHDController = timHDController;
        this.keyBoard = keyBoard;
        this.screenPrompt = screenPrompt;
        hoaDonIDPrompt = "MA HOA ĐON: ";
    }

    public void nhapThongTinTim(){
        screenPrompt.print(hoaDonIDPrompt);screenPrompt.flush();
        String hoaDonID = keyBoard.nextLine();
        timHDController.timHD(hoaDonID);
    }
}
