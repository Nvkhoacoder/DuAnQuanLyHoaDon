package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TimHDDaoFile extends TimDao{
    private File fileName = null;

    public TimHDDaoFile(File fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean timHD(String hoaDonID) {
        if (hoaDonID != null && !hoaDonID.trim().isEmpty()) {
            return kiemTraHoaDonTonTai(hoaDonID, fileName);
        }
        return false;
    }

    public boolean kiemTraHoaDonTonTai(String maHoaDon,File fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    String hoaDonID = data[0].trim();
                    if (hoaDonID.equalsIgnoreCase(maHoaDon)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
