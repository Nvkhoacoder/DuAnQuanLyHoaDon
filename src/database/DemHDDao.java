package database;

import entity.HoaDon;
import entity.HoaDonGio;
import entity.HoaDonNgay;

import java.util.ArrayList;

public class DemHDDao extends DemDao{

    @Override
    public void demSoLuongHD(){
        ArrayList<HoaDon> demSoLuong = HoaDonDatabase.queryAllHoaDon();
        int theoNgay = 0;
        int theoGio = 0;
        for(HoaDon hoaDon : demSoLuong){
            if(hoaDon instanceof HoaDonNgay){
                theoNgay++;
            } else if(hoaDon instanceof HoaDonGio){
                theoGio++;
            }
        }

        System.out.println("Hoa Don theo ngay: " + theoNgay);
        System.out.println("Hoa Don theo gio: " + theoGio);
    }
}
