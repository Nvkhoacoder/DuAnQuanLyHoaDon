package database;

import entity.HoaDon;
import entity.HoaDonGio;
import entity.HoaDonNgay;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;

public class HoaDonDatabase {
    private static ArrayList<HoaDon> listHD = new ArrayList<>();;
    private static int count = 0;

    public static void initDatabase() {
        addHoaDon(new HoaDonGio("nvk544", LocalDate.of(2024,04,05),"Nguyễn Vũ Khoa","LM10",100000,15.0f,"Hoa Đon Gio"));
        addHoaDon(new HoaDonNgay("tnat2806",LocalDate.of(2024,06,28),"Trần Như Ái Trinh","AR10",120000,10,"Hoa Don Ngay"));
    }


    public static void addHoaDon(HoaDon hoaDon) {
        listHD.add(hoaDon);
        count++;
    }

    public static ArrayList<HoaDon> queryAllHoaDon() {
        return listHD;
    }

    public static int getCountHD() {
        return count;
    }

    public static void suaHoaDon(String hoaDonID, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, double loai, String loaiHD) {
        boolean flag = false;
        for(HoaDon hoaDon : listHD) {
            if(hoaDon.getHoaDonID().equalsIgnoreCase(hoaDonID)) {
                hoaDon.setNgayHoaDon(ngayHoaDon);
                hoaDon.setTenKhachHang(tenKhachHang);
                hoaDon.setMaPhong(maPhong);
                hoaDon.setDonGia(donGia);
                if(hoaDon instanceof HoaDonGio) {
                    ((HoaDonGio) hoaDon).setGioThue(loai);
                    hoaDon.setLoaiHD(loaiHD);
                } else if(hoaDon instanceof HoaDonNgay) {
                    ((HoaDonNgay) hoaDon).setNgayThue((int)loai);
                    hoaDon.setLoaiHD(loaiHD);
                }
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println("Không tìm thấy Hoá Đơn " + hoaDonID + " trong danh sách Hoá Đơn");
        }
    }

    public static boolean xoaHoaDon(String maHoaDon) {
        for(HoaDon hoaDon : listHD) {
            if(hoaDon.getHoaDonID().equalsIgnoreCase(maHoaDon)) {
                listHD.remove(hoaDon);
                count--;
                return true;
            }
        }
        return false;
    }

    public static boolean timHoaDon(String hoaDonID) {
        for(HoaDon hoaDon : listHD) {
            if(hoaDon.getHoaDonID().equalsIgnoreCase(hoaDonID)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<HoaDon> docTuFile(File fileData) {
        listHD.clear();
        count = 0;

        try {
            FileReader fr = new FileReader(fileData, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String hoaDonID = data[0];
                    LocalDate ngayHoaDon = LocalDate.parse(data[1]);
                    String tenKhachHang = data[2];
                    String maPhong = data[3];
                    double donGia = Double.parseDouble(data[4]);
                    String loaiString = data[6];
                    HoaDon hoaDon;
                    if(loaiString.equalsIgnoreCase("Hoa Don Ngay")) {
                        int ngayThue = Integer.parseInt(data[5]);
                        hoaDon = new HoaDonNgay(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, ngayThue, loaiString);
                    } else if (loaiString.equalsIgnoreCase("Hoa Don Gio")){
                        double gioThue = Double.parseDouble(data[5]);
                        hoaDon = new HoaDonGio(hoaDonID, ngayHoaDon, tenKhachHang, maPhong, donGia, gioThue, loaiString);
                    } else {
                        throw new IllegalArgumentException("Loai hoa don không hop le: " + loaiString);
                    }
                    listHD.add(hoaDon);
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public static boolean kiemTraHoaDonTonTai(String maHoaDon) {
        boolean found = false;
        for (HoaDon hoaDon : listHD) {
            if(hoaDon.getHoaDonID().equalsIgnoreCase(maHoaDon)){
                found = true;
            }
        }
        return found;
    }


}
