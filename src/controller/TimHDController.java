package controller;

import database.TimDao;

import ui.TimHDOutputUi;

import java.io.File;

public class TimHDController {
    private TimDao timDao = null;
    private TimHDOutputUi timHDOutputUi = null;

    public TimHDController(TimDao timDao, TimHDOutputUi timHDOutputUi) {
        this.timDao = timDao;
        this.timHDOutputUi = timHDOutputUi;
    }

    public void timHD(String hoaDonID){
        boolean isFind = timDao.timHD(hoaDonID);
        if(isFind){
            timHDOutputUi.hienThongBao();

        } else {
            System.out.println("Không tìm thấy Hoá Đơn: " + hoaDonID);
        }

    }
}
