package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XoaHDDaoFile extends XoaDao {
    private File fileData = null;

    public XoaHDDaoFile(File fileData){
        this.fileData = fileData;
    }

    @Override
    public boolean xoaHoaDon(String maHoaDon) {
        if (maHoaDon == null || maHoaDon.trim().isEmpty()) {
            System.out.println("Mã hóa đơn không được để trống.");
            return false;
        }

        ArrayList<String> lines = new ArrayList<>();
        boolean found = false;

        // Đọc file và lọc các dòng không chứa mã hóa đơn cần xóa
        try (BufferedReader reader = new BufferedReader(new FileReader(fileData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(maHoaDon)) {
                    found = true; // Tìm thấy mã hóa đơn
                } else {
                    lines.add(line); // Giữ lại các dòng khác
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return false;
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn với mã: " + maHoaDon);
            return false;
        }

        // Ghi lại các dòng còn lại vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileData))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
            return false;
        }

        return true;
    }
}
