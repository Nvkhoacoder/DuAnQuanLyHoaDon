package database;



import entity.HoaDon;
import entity.HoaDonGio;
import entity.HoaDonNgay;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class SuaHDDaoFile extends SuaDao {
    private File fileData = null;

    public SuaHDDaoFile(String fileData) {
        this.fileData = new File(fileData);
    }

    @Override
    public void suaHD(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double loai, String loaiHD) {
        ArrayList<HoaDon> listHD = HoaDonDatabase.docTuFile(fileData);
        boolean found = false;

        if (hoaDonID != null) {
            for (HoaDon hoaDon : listHD) {
                if (hoaDon.getHoaDonID().equalsIgnoreCase(hoaDonID)) {
                    hoaDon.setNgayHoaDon(ngayHoaDon);
                    hoaDon.setTenKhachHang(tenKhachHang);
                    hoaDon.setMaPhong(maPhong);
                    hoaDon.setDonGia(donGia);
                    if (hoaDon instanceof HoaDonGio) {
                        ((HoaDonGio) hoaDon).setGioThue(loai);
                        hoaDon.setLoaiHD(loaiHD);
                    } else if (hoaDon instanceof HoaDonNgay) {
                        ((HoaDonNgay) hoaDon).setNgayThue((int) loai);
                        hoaDon.setLoaiHD(loaiHD);
                    }
                    found = true;
                    break;
                }
            }

            if (found) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileData,false))){
                    for (HoaDon hoaDon : listHD) {
                        if (hoaDon instanceof HoaDonNgay) {
                            HoaDonNgay hoaDonNgay = (HoaDonNgay) hoaDon;
                            bw.write(hoaDonNgay.getHoaDonID() + "," + hoaDonNgay.getNgayHoaDon() + ","
                                    + hoaDonNgay.getTenKhachHang() + "," + hoaDonNgay.getMaPhong() + ","
                                    + hoaDonNgay.getDonGia() + "," + hoaDonNgay.getNgayThue() + "," + hoaDonNgay.getLoaiHD() );
                        } else if (hoaDon instanceof HoaDonGio) {
                            HoaDonGio hoaDonGio = (HoaDonGio) hoaDon;
                            bw.write(hoaDonGio.getHoaDonID() + "," + hoaDonGio.getNgayHoaDon() + ","
                                    + hoaDonGio.getTenKhachHang() + "," + hoaDonGio.getMaPhong() + ","
                                    + hoaDonGio.getDonGia() + "," + hoaDonGio.getGioThue() + "," + hoaDonGio.getLoaiHD() );
                        }
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Không tìm thấy hóa đơn với mã: " + hoaDonID);
            }
        } else {
            System.out.println("Mã hóa đơn không được để trống.");
        }
    }

    @Override
    public boolean isHoaDonExists(String maHoaDon) {

        try (Scanner fileScanner = new Scanner(fileData)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Assuming each line contains a single invoice ID, modify as per the actual file format
                if (line.contains(maHoaDon)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
