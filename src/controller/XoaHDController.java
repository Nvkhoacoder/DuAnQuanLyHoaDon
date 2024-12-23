package controller;

import database.XoaDao;
import database.XoaHDDao;
import ui.XoaHDOutputUi;

import java.io.File;

public class XoaHDController {
    private XoaDao xoaDao = null;
    private XoaHDOutputUi xoaHDOutputUi = null;

    public XoaHDController(XoaDao xoaDao, XoaHDOutputUi xoaHDOutputUi) {
        this.xoaDao = xoaDao;
        this.xoaHDOutputUi = xoaHDOutputUi;
    }

    public void xoaHD(String hoaDonID) {
        boolean isDeleted = xoaDao.xoaHoaDon(hoaDonID);
        if (isDeleted) {
            xoaHDOutputUi.hienThongBao();
        } else {
            System.out.println("Không tìm thấy Hoá Đơn: " + hoaDonID);
        }
    }
}
