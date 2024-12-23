package ui;

import java.io.PrintWriter;

public class XoaHDOutputUi {
    private PrintWriter screenPrompt = null;

    public XoaHDOutputUi(PrintWriter screenPrompt) {
        this.screenPrompt = screenPrompt;
    }

    public void hienThongBao() {
        screenPrompt.println("Bạn đã xóa thành công Hoá Đơn");
    }
}
