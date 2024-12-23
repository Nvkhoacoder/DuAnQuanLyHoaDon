package ui;

import java.io.PrintWriter;

public class TimHDOutputUi {
    private PrintWriter screenPrompt = null;

    public TimHDOutputUi(PrintWriter screenPrompt) {
        this.screenPrompt = screenPrompt;
    }

    public void hienThongBao(){
        screenPrompt.println("Đã tìm thấy hoá đơn!!!");
    }
}
