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
import java.util.HashSet;
import java.util.Set;

public class DSHoaDon implements DanhSach<HoaDon> {
    private HoaDon[] dshd;
    private int n;

    private DSSanPham dssp;
    private DSChiTietHoaDon dscthd;
    private DSNhanVien dsnv;
    private DSKhachHang dskh;

    private String maKhachHang;

    public DSHoaDon() {
        n = 0;
        dshd = new HoaDon[n];

        dssp = new DSSanPham();
        dscthd = new DSChiTietHoaDon();
        dsnv = new DSNhanVien();
        dskh = new DSKhachHang();

        xuatFile();
    }

    public DSHoaDon(int n) {
        setN(n);
        dshd = new HoaDon[n];
    }

    public DSHoaDon(DSHoaDon other) {
        this.n = other.n;
        this.dshd = Arrays.copyOf(other.dshd, n);
    }

    public void setMKH(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setHoaDon(int i, HoaDon value) {
        dshd[i] = value;
    }

    public void setHoaDon(int i) {
        dshd[i].nhap();
    }

    public int getN() {
        return n;
    }

    public HoaDon getHoaDon(int i) {
        return dshd[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong hoa don: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                "Ngay mua", "Tong tien/hoa don");
        for (HoaDon i : dshd) {
            i.xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSHoaDon.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);

            for (HoaDon i : dshd) {
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
            FileReader fr = new FileReader("../src/data_base/DSHoaDon.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 5) {
                    String maHoaDon = txt[0].trim();
                    String maNhanVien = txt[1].trim();
                    String maKhachHang = txt[2].trim();
                    String ngay = txt[3].trim();
                    int tongTien = Integer.parseInt(txt[4].trim());
                    them(new HoaDon(maHoaDon, maNhanVien, maKhachHang, ngay, tongTien));
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

        dshd = Arrays.copyOf(dshd, n + 1);
        System.out.println("Thong tin hoa don: ");
        dshd[n] = new HoaDon();

        String maHoaDon, maNhanVien;
        boolean daTonTai, nhanVien, khachHang;

        do {
            System.out.print("Ma hoa don: ");
            maHoaDon = Static.scanner.nextLine();
            daTonTai = (timKiem(maHoaDon) != -1);

            if (daTonTai) {
                System.out.println("Ma hoa don da duoc su dung! Xin nhap lai!");
            }
        } while (daTonTai);

        do {
            System.out.print("Ma nhan vien: ");
            maNhanVien = Static.scanner.nextLine();
            nhanVien = (dsnv.timKiem(maNhanVien) == -1);

            if (nhanVien) {
                System.out.println("Ma nhan vien chua kha dung! Xin nhap lai!");
            }
        } while (nhanVien);

        if (maKhachHang == null || maKhachHang.isEmpty()) {
            do {
                System.out.print("Ma khach hang: ");
                maKhachHang = Static.scanner.nextLine();
                khachHang = (dskh.timKiem(maKhachHang) == -1);

                if (khachHang) {
                    System.out.println("Ma khach hang chua kha dung! Xin nhap lai!");
                }
            } while (khachHang);
        }

        dshd[n].setDSCTHD(dscthd);
        dshd[n].setMaHoaDon(maHoaDon);
        dshd[n].setMaNhanVien(maNhanVien);
        dshd[n].setMaKhachHang(maKhachHang);
        dshd[n].nhap();

        dscthd.setMHD(maHoaDon);
        dscthd.setMKH(maKhachHang);
        dscthd.nhap();

        int index = dsnv.timKiem(maNhanVien);
        int KPI = dsnv.getNhanVien(index).getKPI() + 1;
        dsnv.getNhanVien(index).setKPI(KPI);

        dshd[n++].setTongTien();

        dsnv.nhapFile(false);
        nhapFile(false);
    }

    public void them(HoaDon x) {
        dshd = Arrays.copyOf(dshd, n + 1);
        dshd[n++] = x;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma hoa don: ");
        String maHoaDon = Static.scanner.nextLine();
        int index = timKiem(maHoaDon);
        timKiem(index);
    }

    public void timKiem(int index) {
        if (index == -1) {
            System.out.println("Ma hoa don khong dung!");
            return;
        }

        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                "Ngay mua", "Tong tien/hoa don");
        dshd[index].xuat();

        System.out.println("+ Chi tiet hoa don: ");
        ChiTietHoaDon[] ds = dscthd.timKiemDStheoMHD(dshd[index].getMaHoaDon());
        System.out.format(" %-15s | %-15s | %-15s | %-15s | %-15s | %-15s%n", "Ma hoa don", "Ma san pham",
                "Ma bao hanh", "So luong mua", "Don gia", "Thanh tien");
        for (ChiTietHoaDon i : ds) {
            i.xuat();
        }
    }

    public int timKiem(String maHoaDon) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getMaHoaDon()).equals(maHoaDon)) {
                return i;
            }
        }
        return -1;
    }

    public HoaDon timKiemHDtheoMHD(String maHoaDon) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getMaHoaDon()).equals(maHoaDon)) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon timKiemHDtheoMNV(String maNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getMaNhanVien()).equals(maNhanVien)) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon timKiemHDtheoMKH(String maKhachHang) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getMaKhachHang()).equals(maKhachHang)) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon timKiemHDtheoNgay(String ngay) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getNgay()).equals(ngay)) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon timKiemHDtheoTT(int tongTien) {
        for (int i = 0; i < n; i++) {
            if ((dshd[i].getTongTien()) == tongTien) {
                return dshd[i];
            }
        }
        return null;
    }

    public HoaDon[] timKiemDStheoTT(int tongTien) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dshd[i].getTongTien() == tongTien) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public HoaDon[] timKiemDStheoMHD(String maHoaDon) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaHoaDon().equals(maHoaDon)) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public HoaDon[] timKiemDStheoMNV(String maNhanVien) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaNhanVien().equals(maNhanVien)) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xuatDStheoMKH(String maKhachHang) {
        HoaDon[] ds = timKiemDStheoMKH(maKhachHang);
        if (ds != null) {
            System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                    "Ngay mua", "Tong tien/hoa don");
            for (HoaDon i : ds) {
                i.xuat();
            }
        } else {
            System.out.println("Lich su mua hang cua khach hang hien dang trong!");
            System.out.println("Hay bat dau mua hang nao!");
        }
    }

    public HoaDon[] timKiemDStheoMKH(String maKhachHang) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMaKhachHang().equals(maKhachHang)) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public HoaDon[] timKiemDStheoNgay(String ngay) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dshd[i].getNgay().equals(ngay)) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public HoaDon[] timKiemDStheoKhoangTG(LocalDate ngay1, LocalDate ngay2) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            LocalDate ngay = LocalDate.parse(dshd[i].getNgay(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (!ngay.isBefore(ngay1) && !ngay.isAfter(ngay2)) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public HoaDon[] timKiemDStheoKhoangTT(int tt1, int tt2) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            int tongTien = dshd[i].getTongTien();
            if (tongTien >= tt1 && tongTien <= tt2) {
                ds[count++] = dshd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma hoa don: ");
        String maHoaDon = Static.scanner.nextLine();
        xoa(maHoaDon);
    }

    public void xoa(int index) {
        if (index == -1) {
            System.out.println("Ma hoa don khong dung!");
            return;
        }

        ChiTietHoaDon[] dsct = dscthd.timKiemDStheoMHD(dshd[index].getMaHoaDon());
        for (ChiTietHoaDon i : dsct) {
            if (i != null) {
                dssp.tangSoLuong(i.getMaSanPham(), i.getSoLuongMua());
                dscthd.xoaTheoHoaDon(i.getMaHoaDon());
            }
        }
        dsnv.giamKPI(dshd[index].getMaNhanVien());
        for (int i = index; i < n - 1; i++) {
            dshd[i] = dshd[i + 1];
        }
        dshd = Arrays.copyOf(dshd, n - 1);
        n--;
        System.out.println("Xoa thanh cong!");
        nhapFile(false);
    }

    public void xoa(String maHoaDon) {
        int index = timKiem(maHoaDon);
        xoa(index);
    }

    public void sua(int index) {
        if (index == -1) {
            System.out.println("Ma hoa don khong dung!");
            return;
        }

        int choice;
        do {
            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma hoa don");
            System.out.println("2. Ngay mua hang");
            System.out.println("3. Ma nhan vien");
            System.out.println("4. Ma khach hang");
            System.out.println("5. Tong tien");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma hoa don: ");
                    String maHoaDon = Static.scanner.nextLine();
                    dshd[index].setMaHoaDon(maHoaDon);
                    break;
                case 2:
                    System.out.print("Ngay mua hang: ");
                    String ngay = Static.scanner.nextLine();
                    dshd[index].setNgay(ngay);
                    break;
                case 3:
                    System.out.print("Ma nhan vien: ");
                    String maNhanVien = Static.scanner.nextLine();
                    dshd[index].setMaNhanVien(maNhanVien);
                    break;
                case 4:
                    System.out.print("Ma khach hang: ");
                    String maKhachHang = Static.scanner.nextLine();
                    dshd[index].setMaKhachHang(maKhachHang);
                    break;
                case 5:
                    System.out.print("Tong tien: ");
                    int tongTien = Static.checkInputIsInt();
                    dshd[index].setTongTien(tongTien);
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

        System.out.print("Ma phieu nhap: ");
        String maHoaDon = Static.scanner.nextLine();
        sua(maHoaDon);
    }

    public void sua(String maHoaDon) {
        int index = timKiem(maHoaDon);
        sua(index);
    }

    public void thongKe() {
        Static.clearScreen();

        System.out.println("---- Thong ke ----");

        int choice;
        do {
            System.out.println("1. Co ban");
            System.out.println("2. Theo nhan vien");
            System.out.println("3. Theo khach hang");
            System.out.println("4. Theo ngay lap hao don");
            System.out.println("5. Theo khoang thoi gian lap hao don");
            System.out.println("6. Theo khoang tong tien lap hao don");
            System.out.println("7. Thoat");
            System.out.print("Chon chuc nang (1-7): ");
            choice = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    TKcoban();
                    break;
                case 2:
                    TKtheoNV();
                    break;
                case 3:
                    TKtheoKH();
                    break;
                case 4:
                    TKtheoNgay();
                    break;
                case 5:
                    TKtheoTG();
                    break;
                case 6:
                    TKTongTien();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (choice != 7);
    }

    private void TKcoban() {
        Static.clearScreen();

        int tong = 0;
        System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                "Ngay mua", "Tong tien/hoa don");
        for (HoaDon i : dshd) {
            i.xuat();
            tong += i.getTongTien();
        }
        System.out.println("Tong tien: " + tong + ", So luong hoa don: " + (n + 1));

    }

    private void TKtheoKH() {
        Static.clearScreen();

        Set<String> KhachHang = new HashSet<>();

        int tong = 0;

        System.out.format(" %-15s | %-20s | %-20s%n", "Khach hang", "So tien da chi", "So luong don nhap hang");
        for (int i = 0; i < n; i++) {
            String maKhachHang = dshd[i].getMaKhachHang();

            // Nếu maKhachHang đã được xử lý, bỏ qua
            if (KhachHang.contains(maKhachHang)) {
                continue;
            }

            int count = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (dshd[j].getMaKhachHang().equals(maKhachHang)) {
                    count++;
                    sum += dshd[j].getTongTien();
                }
            }
            System.out.println("-----------------+----------------------+------------------------");
            System.out.format(" %-15s | %-20s | %-20s%n", maKhachHang, sum, count);

            // Đánh dấu maKhachHang đã được xử lý
            KhachHang.add(maKhachHang);
            tong += sum;
        }
        System.out.println("Tong tien: " + tong);
    }

    private void TKtheoNV() {
        Static.clearScreen();

        Set<String> NhanVien = new HashSet<>();

        int tong = 0;

        System.out.format(" %-15s | %-20s | %-20s%n", "Nhan vien", "So tien da chi", "So luong don nhap hang");
        for (int i = 0; i < n; i++) {
            String maNhanVien = dshd[i].getMaNhanVien();

            if (NhanVien.contains(maNhanVien)) {
                continue;
            }

            int count = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (dshd[j].getMaNhanVien().equals(maNhanVien)) {
                    count++;
                    sum += dshd[j].getTongTien();
                }
            }
            System.out.println("-----------------+----------------------+------------------------");
            System.out.format(" %-15s | %-20s | %-20s%n", maNhanVien, sum, count);

            NhanVien.add(maNhanVien);
            tong += sum;
        }
        System.out.println("Tong tien: " + tong);
    }

    private void TKtheoNgay() {
        Static.clearScreen();

        Set<String> Dates = new HashSet<>();

        int tong = 0;

        System.out.format(" %-15s | %-20s | %-20s%n", "Ngay", "So tien da chi", "So luong don nhap hang");
        for (int i = 0; i < n; i++) {
            String ngay = dshd[i].getNgay();

            if (Dates.contains(ngay)) {
                continue;
            }

            int count = 0;
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (dshd[j].getNgay().equals(ngay)) {
                    count++;
                    sum += dshd[j].getTongTien();
                }
            }
            System.out.println("-----------------+----------------------+------------------------");
            System.out.format(" %-15s | %-20s | %-20s%n", ngay, sum, count);

            Dates.add(ngay);
            tong += sum;
        }
        System.out.println("Tong tien: " + tong);
    }

    private void TKtheoTG() {
        Static.clearScreen();

        System.out.print("Nhap ngay bat dau: ");
        String ngayBatDau = Static.scanner.nextLine();
        System.out.print("Nhap ngay ket thuc: ");
        String ngayKetThuc = Static.scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(ngayBatDau, formatter);
        LocalDate date2 = LocalDate.parse(ngayKetThuc, formatter);

        HoaDon[] ds = timKiemDStheoKhoangTG(date1, date2);
        if (ds == null) {
            System.out.println("Khong co hoa don trong khoang thoi gian nay.");
        } else {
            int tong = 0;
            int count = 0;
            System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                    "Ngay mua", "Tong tien/hoa don");
            for (HoaDon hd : ds) {
                hd.xuat();
                tong += hd.getTongTien();
                count++;
            }
            System.out.println("Tong tien: " + tong + ", So luong hoa don: " + count);
        }
    }

    private void TKTongTien() {
        Static.clearScreen();

        System.out.print("Nhap tong tien toi thieu: ");
        int tongTienToiThieu = Static.checkInputIsInt();
        System.out.print("Nhap tong tien toi da: ");
        int tongTienToiDa = Static.checkInputIsInt();

        HoaDon[] ds = timKiemDStheoKhoangTT(tongTienToiThieu, tongTienToiDa);
        if (ds == null) {
            System.out.println("Khong co hoa don nao trong khoang tong tien nay.");
        } else {
            int count = 0;
            int tong = 0;
            System.out.format(" %-20s | %-20s | %-20s | %-20s | %-20s%n", "Ma hoa don", "Ma nhan vien", "Ma khach hang",
                    "Ngay mua", "Tong tien/hoa don");
            for (HoaDon hd : ds) {
                hd.xuat();
                tong += hd.getTongTien();
                count++;
            }
            System.out.println("Tong tien: " + tong + ", So luong hoa don: " + count);
        }
    }
}