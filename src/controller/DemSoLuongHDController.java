package controller;

import database.DemDao;


public class DemSoLuongHDController {
    private DemDao demDao = null;


    public DemSoLuongHDController(DemDao demDao){
        this.demDao = demDao;
    }

    public void demSoLuongHD() {
        demDao.demSoLuongHD();
    }
}
