package ui;

import java.io.PrintWriter;

public class ThemHDOutputUi {
    private PrintWriter screenPronmpt = null;

    public ThemHDOutputUi(PrintWriter screenPronmpt) {
        this.screenPronmpt = screenPronmpt;
    }

    public void hienThongBao(){
        screenPronmpt.println("Bạn đã thêm thành công Hoá Đơn");
    }
}
