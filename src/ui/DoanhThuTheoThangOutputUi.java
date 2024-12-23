package ui;

import java.io.PrintWriter;

public class DoanhThuTheoThangOutputUi {
    private PrintWriter screenPrompt = null;

    public DoanhThuTheoThangOutputUi(PrintWriter screenPrompt) {
        this.screenPrompt = screenPrompt;
    }

    public void hienThongBao(String message) {
        screenPrompt.println(message);
    }
}
