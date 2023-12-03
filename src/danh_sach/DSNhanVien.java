package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSNhanVien implements DanhSach<NhanVien> {
    private NhanVien[] dsnv;
    private int n;

    private String maNhanVien;

    public DSNhanVien() {
        n = 0;
        dsnv = new NhanVien[n];

        xuatFile();
    }

    public DSNhanVien(int n) {
        setN(n);
        dsnv = new NhanVien[n];

        xuatFile();
    }

    public DSNhanVien(DSNhanVien other) {
        this.n = other.n;
        this.dsnv = Arrays.copyOf(other.dsnv, n);

        xuatFile();
    }

    public void setMNV(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setdsnv(int i, NhanVien value) {
        dsnv[i] = value;
    }

    public void setdsnv(int i) {
        dsnv[i].nhap();
    }

    public int getN() {
        return n;
    }

    public NhanVien getNhanVien(int i) {
        return dsnv[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong nhan vien: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin nhan vien thu " + (i + 1) + ": ");
            dsnv[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSNhanVien.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (NhanVien i : dsnv) {
                if (i != null) {
                    bw.write(i.toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void xuatFile() {
        try {
            FileReader fr = new FileReader("../src/data_base/DSNhanVien.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 6) {
                    String maNhanVien = txt[0].trim();
                    String hoNhanVien = txt[1].trim();
                    String tenNhanVien = txt[2].trim();
                    String ngaySinh = txt[3].trim();
                    int KPI = Integer.parseInt(txt[4].trim());
                    int luong = Integer.parseInt(txt[5].trim());
                    them(new NhanVien(maNhanVien, hoNhanVien, tenNhanVien, ngaySinh, KPI, luong));
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

        dsnv = Arrays.copyOf(dsnv, n + 1);
        System.out.println("Thong tin nhan vien: ");
        dsnv[n] = new NhanVien();

        if (maNhanVien.isEmpty()) {
            boolean daTonTai;
            do {
                System.out.print("Ma nhan vien: ");
                maNhanVien = Static.scanner.nextLine();
                daTonTai = (timKiem(maNhanVien) != -1);
                if (daTonTai) {
                    System.out.println("Ma nhan vien da ton tai! Xin nhap lai!");
                }
            } while (daTonTai);
        }

        dsnv[n].setMaNhanVien(maNhanVien);
        dsnv[n++].nhap();
        nhapFile(false);
    }

    public void them(NhanVien x) {
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = x;
        n++;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma nhan vien: ");
        String maNhanVien = Static.scanner.nextLine();

        int index = timKiem(maNhanVien);
        dsnv[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
        }
    }

    public int timKiem(String maNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getMaNhanVien()).equals(maNhanVien)) {
                return i;
            }
        }
        return -1;
    }

    public NhanVien timKiemNVtheoMNV(String maNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getMaNhanVien()).equals(maNhanVien)) {
                return dsnv[i];
            }
        }
        return null;
    }

    public NhanVien timKiemNVtheoHNV(String hoNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getHoNhanVien()).equals(hoNhanVien)) {
                return dsnv[i];
            }
        }
        return null;
    }

    public NhanVien timKiemNVtheoTNV(String tenNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getTenNhanVien()).equals(tenNhanVien)) {
                return dsnv[i];
            }
        }
        return null;
    }

    public NhanVien timKiemNVtheoNS(String ngaySinh) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getNgaySinh()).equals(ngaySinh)) {
                return dsnv[i];
            }
        }
        return null;
    }

    public NhanVien timKiemNVtheoL(int luong) {
        for (int i = 0; i < n; i++) {
            if ((dsnv[i].getLuong()) == luong) {
                return dsnv[i];
            }
        }
        return null;
    }

    public NhanVien[] timKiemDStheoMNV(String maNhanVien) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNhanVien().equals(maNhanVien)) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoHNV(String hoNhanVien) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getHoNhanVien().equals(hoNhanVien)) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoTNV(String tenNhanVien) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getTenNhanVien().equals(tenNhanVien)) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoNS(String ngaySinh) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getNgaySinh().equals(ngaySinh)) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoL(int luong) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getLuong() == luong) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoKhoangTG(String ngay1, String ngay2) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            String ngaySinh = dsnv[i].getNgaySinh();
            if (ngaySinh.compareTo(ngay1) >= 0 && ngaySinh.compareTo(ngay2) <= 0) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhanVien[] timKiemDStheoKhoangTT(int luong1, int luong2) {
        int count = 0;
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            long luong = dsnv[i].getLuong();
            if (luong >= luong1 && luong <= luong2) {
                ds[count++] = dsnv[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    } 

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma nhan vien: ");
        String maNhanVien = Static.scanner.nextLine();

        int index = timKiem(maNhanVien);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dsnv[i] = dsnv[i + 1];
            }
            dsnv = Arrays.copyOf(dsnv, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong hop le!");
        }
        nhapFile(false);
    }

    public void xoa(String maNhanVien) {
        int index = timKiem(maNhanVien);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }
    public void giamKPI(String maNhanVien) {
        int indexNV = timKiem(maNhanVien);
        if (indexNV != -1) {
            NhanVien nv = getNhanVien(indexNV);
            nv.setKPI(Math.max(nv.getKPI() - 1, 0)); 
            nhapFile(false);
        }
    }
    public void sua(int index) {
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma nhan vien");
            System.out.println("2. Ho nhan vien");
            System.out.println("3. Ten nhan vien");
            System.out.println("4. Ngay sinh");
            System.out.println("5. Luong");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma nhan vien: ");
                    String maNhanVien = Static.scanner.nextLine();
                    dsnv[index].setMaNhanVien(maNhanVien);
                    break;
                case 2:
                    System.out.print("Ho nhan vien: ");
                    String hoNhanVien = Static.scanner.nextLine();
                    dsnv[index].setHoNhanVien(hoNhanVien);
                    break;
                case 3:
                    System.out.print("Ten nhan vien: ");
                    String tenNhanVien = Static.scanner.nextLine();
                    dsnv[index].setTenNhanVien(tenNhanVien);
                    break;
                case 4:
                    System.out.print("Ngay sinh: ");
                    String ngaySinh = Static.scanner.nextLine();
                    dsnv[index].setNgaySinh(ngaySinh);
                    break;
                case 5:
                    System.out.print("Luong: ");
                    int luong = Static.scanner.nextInt();
                    dsnv[index].setLuong(luong);
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

        System.out.print("Ma phieu nhap: ");
        String maNhanVien = Static.scanner.nextLine();

        int index = timKiem(maNhanVien);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maNhanVien) {
        int index = timKiem(maNhanVien);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("Khong hop le!");
        }
    }

    public void capNhatMaNhanVien(String maNhanVienCu, String maNhanVienMoi) {
        for (NhanVien nv : dsnv) {
            if (nv.getMaNhanVien().equals(maNhanVienCu)) {
                nv.setMaNhanVien(maNhanVienMoi);
            }
        }
        nhapFile(false);
    }
    
    public void thongKe() {
        Static.clearScreen();
        
       System.out.println("Nhan vien co: " + n + "phieu nhap" );{
        long tongLuong = 0;
        for (int i = 0; i < n; i++) {
            tongLuong += dsnv[i].getLuong();
        }
        double luongTrungBinh = (double) tongLuong / n;
        System.out.println("Luong trung binh cua nhan vien la: " + luongTrungBinh);
    
        int indexMaxLuong = 0;
        for (int i = 1; i < n; i++) {
            if (dsnv[i].getLuong() > dsnv[indexMaxLuong].getLuong()) {
                indexMaxLuong = i;
            }
        }
        System.out.println("Nhan vien co luong cao nhat la:");
        dsnv[indexMaxLuong].xuat();

        int indexMinLuong = 0;
        for (int i = 1; i < n; i++) {
            if (dsnv[i].getLuong() < dsnv[indexMinLuong].getLuong()) {
                indexMinLuong = i;
            }
        }
        System.out.println("Nhan vien co luong thap nhat la:");
        dsnv[indexMinLuong].xuat();
    }
}
}