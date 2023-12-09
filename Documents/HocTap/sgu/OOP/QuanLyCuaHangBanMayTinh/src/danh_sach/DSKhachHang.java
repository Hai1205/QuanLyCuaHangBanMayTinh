package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSKhachHang implements DanhSach<KhachHang> {
    private KhachHang[] dskh;
    private int n;

    private String maKhachHang;

    public DSKhachHang() {
        n = 0;
        dskh = new KhachHang[n];

        xuatFile();
    }

    public DSKhachHang(int n) {
        setN(n);
        dskh = new KhachHang[n];

        xuatFile();
    }

    public DSKhachHang(DSKhachHang other) {
        this.n = other.n;
        this.dskh = Arrays.copyOf(other.dskh, n);

        xuatFile();
    }

    public void setMKH(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setKH(int i, KhachHang value) {
        dskh[i] = value;
    }

    public void setKH(int i) {
        dskh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public KhachHang getKH(int i) {
        return dskh[i];
    }

    public void nhap() {
        Static.clearScreen();
        
        System.out.print("So luong khach hang: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma khach hang", "Ho khach hang", "Ten khach hang", "Dia chi", "So dien thoai");
        for (KhachHang i : dskh) {
            i.xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSKhachHang.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (KhachHang i : dskh) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatFile() {
        try {
            FileReader fr = new FileReader("../src/data_base/DSKhachHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 5) {
                    String maKhachHang = txt[0].trim();
                    String hoKhachHang = txt[1].trim();
                    String tenKhachHang = txt[2].trim();
                    String diaChi = txt[3].trim();
                    String soDienThoai = txt[4].trim();

                    them(new KhachHang(maKhachHang, hoKhachHang, tenKhachHang, diaChi, soDienThoai));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void them() {
        Static.clearScreen();
        
        dskh = Arrays.copyOf(dskh, n + 1);
        System.out.println("Thong tin khach hang: ");
        dskh[n] = new KhachHang();
        
        boolean daTonTai;
        
        if (maKhachHang.isEmpty()) {
            do {
            System.out.print("Ma khach hang: ");
            maKhachHang = Static.scanner.nextLine();
            daTonTai = (timKiem(maKhachHang) != -1);
            
            if (daTonTai) {
                System.out.println("Ma khach hang da ton tai! Xin nhap lai!");
            }
        } while (daTonTai);
        }
        
        dskh[n].setMaKhachHang(maKhachHang);
        dskh[n++].nhap();
        nhapFile(false);
    }

    public void them(KhachHang x) {
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = x;
        n++;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma khach hang: ");
        String maKhachHang = Static.scanner.nextLine();

        int index = timKiem(maKhachHang);

        if (index == -1) {
            System.out.println("Ma khach hang khong dung!");
            return;
        }
        
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma khach hang", "Ho khach hang", "Ten khach hang", "Dia chi", "So dien thoai");
        dskh[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
        }
    }

    public int timKiem(String maKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getMaKhachHang()).equals(maKhachHang)) {
                return i;
            }
        }
        return -1;
    }

    public KhachHang timKiemKHtheoMKH(String maKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getMaKhachHang()).equals(maKhachHang)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang timKiemKHtheoHKH(String hoKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getHoKhachHang()).equals(hoKhachHang)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang timKiemKHtheoTKH(String tenKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getTenKhachHang()).equals(tenKhachHang)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang timKiemKHtheoDC(String diaChi) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getDiaChi()).equals(diaChi)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang timKiemKHtheoSDT(String soDienThoai) {
        for (int i = 0; i < n; i++) {
            if ((dskh[i].getSoDienThoai()).equals(soDienThoai)) {
                return dskh[i];
            }
        }
        return null;
    }

    public KhachHang[] timKiemDStheoMKH(String maKhachHang) {
        int count = 0;
        KhachHang[] ds = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKhachHang().equals(maKhachHang)) {
                ds[count++] = dskh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public KhachHang[] timKiemDStheoHKH(String hoKhachHang) {
        int count = 0;
        KhachHang[] ds = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            if (dskh[i].getHoKhachHang().equals(hoKhachHang)) {
                ds[count++] = dskh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public KhachHang[] timKiemDStheoTKH(String tenKhachHang) {
        int count = 0;
        KhachHang[] ds = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            if (dskh[i].getTenKhachHang().equals(tenKhachHang)) {
                ds[count++] = dskh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public KhachHang[] timKiemDStheoDC(String diaChi) {
        int count = 0;
        KhachHang[] ds = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            if (dskh[i].getDiaChi().equals(diaChi)) {
                ds[count++] = dskh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public KhachHang[] timKiemDStheoSDT(String soDienThoai) {
        int count = 0;
        KhachHang[] ds = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            if (dskh[i].getSoDienThoai().equals(soDienThoai)) {
                ds[count++] = dskh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xoa() {
        Static.clearScreen();
        
        System.out.print("Ma khach hang: ");
        String maKhachHang = Static.scanner.nextLine();

        int index = timKiem(maKhachHang);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dskh[i] = dskh[i + 1];
            }
            dskh = Arrays.copyOf(dskh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay!");
        }
        nhapFile(false);
    }

    public void xoa(String maKhachHang) {
        int index = timKiem(maKhachHang);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma khach hang");
            System.out.println("2. Ho khach hang");
            System.out.println("3. Ten khach hang");
            System.out.println("4. Dia chi");
            System.out.println("5. So dien thoai");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma khach hang: ");
                    String maKhachHang = Static.scanner.nextLine();
                    dskh[index].setMaKhachHang(maKhachHang);
                    break;
                case 2:
                    System.out.print("Ho khach han: ");
                    String hoKhachHang = Static.scanner.nextLine();
                    dskh[index].setHoKhachHang(hoKhachHang);
                    break;
                case 3:
                    System.out.print("Ten khach han: ");
                    String tenKhachHang = Static.scanner.nextLine();
                    dskh[index].setTenKhachHang(tenKhachHang);
                    break;
                case 4:
                    System.out.print("Dia chi: ");
                    String diaChi = Static.scanner.nextLine();
                    dskh[index].setDiaChi(diaChi);
                    break;
                case 5:
                    System.out.print("So dien thoai: ");
                    String soDienThoai = Static.scanner.nextLine();
                    dskh[index].setSoDienThoai(soDienThoai);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Khong hop le!");
            }
        } while (choice != 6);
        nhapFile(false);
    }

    public void sua() {
        Static.clearScreen();

        System.out.print("Ma khach hang: ");
        String maKhachHang = Static.scanner.nextLine();

        int index = timKiem(maKhachHang);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            sua(index);
        }
    }

    public void sua(String maKhachHang) {
        int index = timKiem(maKhachHang);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong tim thay!");
        }
    }
}
