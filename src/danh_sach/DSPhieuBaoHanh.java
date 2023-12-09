package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DSPhieuBaoHanh implements DanhSach<PhieuBaoHanh> {
    private PhieuBaoHanh[] dspbh;
    private int n;

    public String maPhieuBaoHanh, maSanPham, maHoaDon, maKhachHang;

    public DSPhieuBaoHanh() {
        n = 0;
        dspbh = new PhieuBaoHanh[n];

        xuatFile();
    }

    public DSPhieuBaoHanh(int n) {
        setN(n);
        dspbh = new PhieuBaoHanh[n];

        xuatFile();
    }

    public DSPhieuBaoHanh(DSPhieuBaoHanh other) {
        this.n = other.n;
        this.dspbh = Arrays.copyOf(other.dspbh, n);

        xuatFile();
    }

    public void setMPBH(String maPhieuBaoHanh) {
        this.maPhieuBaoHanh = maPhieuBaoHanh;
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setMHD(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMKH(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setPhieuBaoHanh(int i, PhieuBaoHanh value) {
        dspbh[i] = value;
    }

    public void setPhieuBaoHanh(int i) {
        dspbh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public PhieuBaoHanh getPhieuBaoHanh(int i) {
        return dspbh[i];
    }

    public void nhap() {
        Static.clearScreen();
        
        System.out.print("So luong phieu bao hanh: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin phieu bao hanh thu " + (i + 1) + ": ");
            dspbh[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSPhieuBaoHanh.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);

            for (PhieuBaoHanh i : dspbh) {
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
            FileReader fr = new FileReader("../src/data_base/DSPhieuBaoHanh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 5) {
                    String maBaoHanh = txt[0].trim();
                    String maSanPham = txt[1].trim();
                    String maHoaDon = txt[2].trim();
                    String maKhachHang = txt[3].trim();
                    String thoiGianBH = txt[4].trim();
                    them(new PhieuBaoHanh(maBaoHanh, maSanPham, maHoaDon, maKhachHang, thoiGianBH));
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

        dspbh = Arrays.copyOf(dspbh, n + 1);
        System.out.println("Thong tin phieu bao hanh: ");

        dspbh[n] = new PhieuBaoHanh();
        dspbh[n].setMaBaoHanh(maPhieuBaoHanh);
        dspbh[n].setMaSanPham(maSanPham);
        dspbh[n].setMaHoaDon(maHoaDon);
        dspbh[n].setMaKhachHang(maKhachHang);
        dspbh[n++].nhap();
        
        nhapFile(false);
    }

    public void them(PhieuBaoHanh x) {
        dspbh = Arrays.copyOf(dspbh, n + 1);
        dspbh[n] = x;
        n++;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma phieu bao hanh: ");
        String maBaoHanh = Static.scanner.nextLine();

        int index = timKiem(maBaoHanh);
        dspbh[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
        }
    }

    public int timKiem(String maBaoHanh) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(maBaoHanh)) {
                return i;
            }
        }
        return -1;
    }

    public PhieuBaoHanh timKiemPBHtheoMBH(String maBaoHanh) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(maBaoHanh)) {
                return dspbh[i];
            }
        }
        return null;
    }

    public PhieuBaoHanh timKiemPBHtheoMSP(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(maSanPham)) {
                return dspbh[i];
            }
        }
        return null;
    }

    public PhieuBaoHanh timKiemPBHtheoMHD(String maHoaDon) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(maHoaDon)) {
                return dspbh[i];
            }
        }
        return null;
    }

    public PhieuBaoHanh timKiemPBHtheoMKH(String maKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(maKhachHang)) {
                return dspbh[i];
            }
        }
        return null;
    }

    public PhieuBaoHanh timKiemPBHtheoTGBH(String thoiGianBH) {
        for (int i = 0; i < n; i++) {
            if ((dspbh[i].getMaBaoHanh()).equals(thoiGianBH)) {
                return dspbh[i];
            }
        }
        return null;
    }

    public PhieuBaoHanh[] timKiemDStheoMBH(String maBaoHanh) {
        int count = 0;
        PhieuBaoHanh[] ds = new PhieuBaoHanh[n];
        for (int i = 0; i < n; i++) {
            if (dspbh[i].getMaBaoHanh().equals(maBaoHanh)) {
                ds[count++] = dspbh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuBaoHanh[] timKiemDStheoMSP(String maSanPham) {
        int count = 0;
        PhieuBaoHanh[] ds = new PhieuBaoHanh[n];
        for (int i = 0; i < n; i++) {
            if (dspbh[i].getMaSanPham().equals(maSanPham)) {
                ds[count++] = dspbh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuBaoHanh[] timKiemDStheoMHD(String maHoaDon) {
        int count = 0;
        PhieuBaoHanh[] ds = new PhieuBaoHanh[n];
        for (int i = 0; i < n; i++) {
            if (dspbh[i].getMaHoaDon().equals(maHoaDon)) {
                ds[count++] = dspbh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuBaoHanh[] timKiemDStheoMKH(String maKhachHang) {
        int count = 0;
        PhieuBaoHanh[] ds = new PhieuBaoHanh[n];
        for (int i = 0; i < n; i++) {
            if (dspbh[i].getMaKhachHang().equals(maKhachHang)) {
                ds[count++] = dspbh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuBaoHanh[] timKiemDStheoTGBH(String thoiGianBH) {
        int count = 0;
        PhieuBaoHanh[] ds = new PhieuBaoHanh[n];
        for (int i = 0; i < n; i++) {
            if (dspbh[i].getThoiGianBH().equals(thoiGianBH)) {
                ds[count++] = dspbh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma phieu bao hanh: ");
        String maBaoHanh = Static.scanner.nextLine();

        int index = timKiem(maBaoHanh);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
        nhapFile(false);
    }
    
    public void xoa(int index) {
        if (index >= 0 && index < n) {

            for (int i = index; i < n - 1; i++) {
                dspbh[i] = dspbh[i + 1];
            }
            dspbh = Arrays.copyOf(dspbh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");

        } else {
            System.out.println("Khong hop le!");
        }
        nhapFile(false);
    }

    public void xoa(String maBaoHanh) {
        int index = timKiem(maBaoHanh);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma phieu bao hanh");
            System.out.println("2. Ma san pham");
            System.out.println("3. Ma hoa don");
            System.out.println("4. Thoi gian bao hanh");
            System.out.println("5. Ma khach hang");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma phieu bao hanh: ");
                    String maBaoHanh = Static.scanner.nextLine();
                    dspbh[index].setMaHoaDon(maBaoHanh);
                    break;
                case 2:
                    System.out.print("So luong mua: ");
                    String maSanPham = Static.scanner.nextLine();
                    dspbh[index].setMaSanPham(maSanPham);
                    break;
                case 3:
                    System.out.print("Ma san pham: ");
                    String maHoaDon = Static.scanner.nextLine();
                    dspbh[index].setMaHoaDon(maHoaDon);
                    break;
                case 4:
                    System.out.print("Thoi gian bao hanh: ");
                    String thoiGianBH = Static.scanner.nextLine();
                    dspbh[index].setThoiGianBH(thoiGianBH);
                    break;
                case 5:
                    System.out.print("Ma khach hang: ");
                    String maKhachHang = Static.scanner.nextLine();
                    dspbh[index].setMaKhachHang(maKhachHang);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 6);
        nhapFile(false);
    }

    public void sua() {
        Static.clearScreen();

        System.out.print("Ma phieu bao hanh: ");
        String maBaoHanh = Static.scanner.nextLine();

        int index = timKiem(maBaoHanh);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            sua(index);
        }
    }

    public void sua(String maBaoHanh) {
        int index = timKiem(maBaoHanh);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong tim thay!");
        }
    }

    public void thongKe() {
        Static.clearScreen();
        
        int tongSoPhieuBaoHanh = 0;
        int soPhieuBaoHanhConHan = 0;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < n; i++) {
            String thoiGianBH = dspbh[i].getThoiGianBH();
            LocalDate ngayHetHan = LocalDate.parse(thoiGianBH, dtf);
            if (ngayHetHan.isAfter(LocalDate.now())) {
                soPhieuBaoHanhConHan++;
            }
            tongSoPhieuBaoHanh++;
        }

        System.out.println("Tong so phieu bao hanh: " + tongSoPhieuBaoHanh);
        System.out.println("So phieu bao hanh con han: " + soPhieuBaoHanhConHan);
    }
}
