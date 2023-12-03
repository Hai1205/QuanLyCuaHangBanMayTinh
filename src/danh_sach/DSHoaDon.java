package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

        xuatFile();
    }

    public DSHoaDon(DSHoaDon other) {
        this.n = other.n;
        this.dshd = Arrays.copyOf(other.dshd, n);

        xuatFile();
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
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin phoa don thu " + (i + 1) + ": ");
            dshd[i].xuat();
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
        dshd[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
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
            for (int i = 0; i < ds.length; i++) {
                System.out.println("--------------------------");
                System.out.println("Thong tin phoa don thu " + (i + 1) + ": ");
                ds[i].xuat();
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

    public HoaDon[] timKiemDStheoKhoangTG(String ngay1, String ngay2) {
        int count = 0;
        HoaDon[] ds = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            String ngay = dshd[i].getNgay();
            if (ngay.compareTo(ngay1) >= 0 && ngay.compareTo(ngay2) <= 0) {
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

        int index = timKiem(maHoaDon);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }
    public void xoa(int index) {
        if (index >= 0 && index < n) {
            HoaDon hd = dshd[index];
            if (hd != null) {
                ChiTietHoaDon[] chiTiet = dscthd.timKiemDStheoMHD(hd.getMaHoaDon());
                if (chiTiet != null) {
                    for (ChiTietHoaDon ct : chiTiet) {
                        if (ct != null) {
                            dssp.tangSoLuong(ct.getMaSanPham(), ct.getSoLuongMua());
                            dscthd.xoaTheoHoaDon(ct.getMaHoaDon());
                        }
                    }
                }
                dsnv.giamKPI(hd.getMaNhanVien());
            }
            for (int i = index; i < n - 1; i++) {
                dshd[i] = dshd[i + 1];
            }
            dshd = Arrays.copyOf(dshd, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong hop le!");
        }
        nhapFile(false);
    }    
    public void xoa(String maHoaDon) {
        int index = timKiem(maHoaDon);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
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

        int index = timKiem(maHoaDon);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maHoaDon) {
        int index = timKiem(maHoaDon);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void thongKe() {
        Static.clearScreen();
        
        int tongSoHoaDon = 0;
        int tongTienTrenTongHoaDon = 0;
    
        System.out.println("So hoa don theo ngay:");
        for (int i = 0; i < n; i++) {
            String ngay = dshd[i].getNgay();
            int soHoaDonTheoNgay = 0;
            for (int j = 0; j < n; j++) {
                if (dshd[j].getNgay().equals(ngay)) {
                    soHoaDonTheoNgay++;
                }
            }
            System.out.println("Ngay: " + ngay + ", So luong hoa don: " + soHoaDonTheoNgay);
        }
    
        System.out.println("So hoa don theo nhan vien:");
        for (int i = 0; i < n; i++) {
            String maNhanVien = dshd[i].getMaNhanVien();
            int soHoaDonTheoNhanVien = 0;
            for (int j = 0; j < n; j++) {
                if (dshd[j].getMaNhanVien().equals(maNhanVien)) {
                    soHoaDonTheoNhanVien++;
                }
            }
            System.out.println("Nhan vien: " + maNhanVien + ", So luong hoa don: " + soHoaDonTheoNhanVien);
        }
    
        System.out.println("So hoa don theo khach hang:");
        for (int i = 0; i < n; i++) {
            String maKhachHang = dshd[i].getMaKhachHang();
            int soHoaDonTheoKhachHang = 0;
            for (int j = 0; j < n; j++) {
                if (dshd[j].getMaKhachHang().equals(maKhachHang)) {
                    soHoaDonTheoKhachHang++;
                }
            }
            System.out.println("Khach hang: " + maKhachHang + ", So luong hoa don: " + soHoaDonTheoKhachHang);
        }
    
        for (int i = 0; i < n; i++) {
            tongTienTrenTongHoaDon += dshd[i].getTongTien();
            tongSoHoaDon++;
        }
        System.out.println("Tong tien : " + tongTienTrenTongHoaDon);
        System.out.println("Tong hoa don: " + tongSoHoaDon);
    }
    
    public void thongKeKhoangTG() throws ParseException {
        System.out.print("Nhap ngay bat dau: ");
        String ngayBatDau = Static.scanner.nextLine();
        System.out.print("Nhap ngay ket thuc: ");
        String ngayKetThuc = Static.scanner.nextLine();
        // Chuyển đổi định dạng ngày từ dd/mm/yyyy sang yyyy-mm-dd
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateBatDau = sdf.parse(ngayBatDau);
        Date dateKetThuc = sdf.parse(ngayKetThuc);
        sdf.applyPattern("yyyy-MM-dd");
        ngayBatDau = sdf.format(dateBatDau);
        ngayKetThuc = sdf.format(dateKetThuc);

        HoaDon[] ds = timKiemDStheoKhoangTG(ngayBatDau, ngayKetThuc);
        if (ds == null) {
            System.out.println("Khong co hoa don trong khoang thoi gian nay.");
        } else {
            for (HoaDon hd : ds) {
                hd.xuat();
            }
        }
    }

    public void thongKeKhoangTT() {
        System.out.print("Nhap tong tien toi thieu: ");
        int tongTienToiThieu = Static.checkInputIsInt();
        System.out.print("Nhap tong tien toi da: ");
        int tongTienToiDa = Static.checkInputIsInt();

        HoaDon[] ds = timKiemDStheoKhoangTT(tongTienToiThieu, tongTienToiDa);
        if (ds == null) {
            System.out.println("Khong co hoa don nao trong khoang tong tien nay.");
        } else {
            for (HoaDon hd : ds) {
                hd.xuat();
            }
        }
    }
}