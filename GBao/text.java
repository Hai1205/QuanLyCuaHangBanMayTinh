import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        HoaDon mot = new HoaDon("1", "30/1/2023", "3122410024", "999", 999.999);
        HoaDon hai = new HoaDon("2", "31/11/2023", "3122410025", "9991", 999.000);
        DSHoaDon dsHoaDon = new DSHoaDon();
        dsHoaDon.them(mot);
        dsHoaDon.them(hai);
        dsHoaDon.quanLyDanhSach();
    }
}