package database;

import entity.HoaDon;
import entity.HoaDonGio;
import entity.HoaDonNgay;


import java.io.*;
import java.util.ArrayList;

public class ThemHDDataFile extends ThemDao{
    private File fileData = null;

    public ThemHDDataFile(String fileName) {
        this.fileData = new File(fileName);
    }

    @Override
    public void themHD(HoaDon hd) {
        FileWriter fileStream = null;
        BufferedWriter bw = null;

        try {
            fileStream = new FileWriter(fileData, true);
            bw = new BufferedWriter(fileStream);


            if (hd instanceof HoaDonGio) {
                HoaDonGio hoaDonGio = (HoaDonGio) hd;
                bw.write(hd.getHoaDonID() + "," + hd.getNgayHoaDon() + "," + hd.getTenKhachHang() + ","
                        + hd.getMaPhong() + "," + hd.getDonGia() + "," + hoaDonGio.getGioThue() + "," + hd.getLoaiHD());
            } else if (hd instanceof HoaDonNgay) {

                HoaDonNgay hoaDonNgay = (HoaDonNgay) hd;
                bw.write(hd.getHoaDonID() + "," + hd.getNgayHoaDon() + "," + hd.getTenKhachHang() + ","
                        + hd.getMaPhong() + "," + hd.getDonGia() + "," + hoaDonNgay.getNgayThue() + "," + hd.getLoaiHD());
            }
            bw.newLine();
            bw.flush();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
