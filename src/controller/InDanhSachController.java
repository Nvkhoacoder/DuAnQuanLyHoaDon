package controller;

import database.InDSDao;
import entity.HoaDon;
import java.util.ArrayList;

public class InDanhSachController {
    private InDSDao inDSDao = null;

    public InDanhSachController(InDSDao inDSDao) {
        this.inDSDao = inDSDao;
    }

    public ArrayList<HoaDon> layDanhSachHoaDon(){
        return inDSDao.layDanhSachHD();
    }
}
