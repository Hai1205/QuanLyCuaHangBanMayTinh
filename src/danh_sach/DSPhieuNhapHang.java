package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSPhieuNhapHang implements DanhSach<PhieuNhapHang> {
    private PhieuNhapHang[] dspnh;
    private int n;

    private DSSanPham dssp;
    private DSChiTietPhieuNhapHang dsctpnh;
    private DSNhaSanXuat dsnsx;
    private DSNhanVien dsnv;

    public DSPhieuNhapHang() {
        n = 0;
        dspnh = new PhieuNhapHang[n];

        dssp = new DSSanPham();
        dssp = new DSSanPham();
        dsctpnh = new DSChiTietPhieuNhapHang();
        dsnsx = new DSNhaSanXuat();
        dsnv = new DSNhanVien();
        
        xuatFile();
    }

    public DSPhieuNhapHang(int n) {
        setN(n);
        dspnh = new PhieuNhapHang[n];

        xuatFile();
    }

    public DSPhieuNhapHang(DSPhieuNhapHang other) {
        this.n = other.n;
        this.dspnh = Arrays.copyOf(other.dspnh, n);

        xuatFile();
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setPhieuNhapHang(int i, PhieuNhapHang value) {
        dspnh[i] = value;
    }

    public void setPhieuNhapHang(int i) {
        dspnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public PhieuNhapHang getPhieuNhapHang(int i) {
        return dspnh[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong phieu nhap hang: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSPhieuNhapHang.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);

            for (PhieuNhapHang i : dspnh) {
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
            FileReader fr = new FileReader("../src/data_base/DSPhieuNhapHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 5) {
                    String maPhieuNhap = txt[0].trim();
                    String ngayNhap = txt[1].trim();
                    String maNhanVien = txt[2].trim();
                    String maNhaSanXuat = txt[3].trim();
                    int tongTien = Integer.parseInt(txt[4].trim());
                    them(new PhieuNhapHang(maPhieuNhap, ngayNhap, maNhanVien, maNhaSanXuat, tongTien));
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

        dspnh = Arrays.copyOf(dspnh, n + 1);
        System.out.println("Thong tin phieu nhap hang: ");
        dspnh[n] = new PhieuNhapHang();

        String maPhieuNhap, maNhanVien, maNhaSanXuat;
        boolean phieuNhapHang, nhanVien, nhaSanXuat;

        do {
            System.out.print("Ma phieu nhap hang: ");
            maPhieuNhap = Static.scanner.nextLine();
            phieuNhapHang = (timKiem(maPhieuNhap) != -1);

            if (phieuNhapHang) {
                System.out.println("Ma phieu nhap hang da ton tai! Xin nhap lai!");
            }
        } while (phieuNhapHang);

        do {
            System.out.print("Ma nhan vien: ");
            maNhanVien = Static.scanner.nextLine();
            nhanVien = (dsnv.timKiem(maNhanVien) == -1);

            if (nhanVien) {
                System.out.println("Ma nhan vien khong dung! Xin nhap lai!");
            }
        } while (nhanVien);

        do {
            System.out.print("Ma nha san xuat: ");
            maNhaSanXuat = Static.scanner.nextLine();
            nhaSanXuat = (dsnsx.timKiem(maNhaSanXuat) == -1);

            if (nhaSanXuat) {
                System.out.println("Ma nha san xuat khong dung! Xin nhap lai!");
            }
        } while (nhaSanXuat);

        dspnh[n].setDSCTPNH(dsctpnh);
        dspnh[n].setMPN(maPhieuNhap);
        dspnh[n].setMNV(maNhanVien);
        dspnh[n].setMNSX(maNhaSanXuat);
        dspnh[n].nhap();

        dsctpnh.setMPN(maPhieuNhap);
        dsctpnh.setMNSX(maNhaSanXuat);
        dsctpnh.nhap();
        
        dspnh[n++].setTT();

        nhapFile(false);
    }

    public void them(PhieuNhapHang x) {
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = x;
        n++;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhap = Static.scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        dspnh[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
        }
    }

    public int timKiem(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPNH()).equals(maPhieuNhap)) {
                return i;
            }
        }
        return -1;
    }

    public PhieuNhapHang timKiemPNHtheoNN(String ngayNhap) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getNN()).equals(ngayNhap)) {
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang timKiemPNHtheoMNV(String maNhanVien) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMNV()).equals(maNhanVien)) {
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang timKiemPNHtheoMNSX(String maNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMNSX()).equals(maNhaSanXuat)) {
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang timKiemPNHtheoTT(int tongTien) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getTT()) == tongTien) {
                return dspnh[i];
            }
        }
        return null;
    }

    public PhieuNhapHang[] timKiemDSTheoMPNH(String maPhieuNhapHang) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMPNH().equals(maPhieuNhapHang)) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDSTheoMNV(String maNhanVien) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(maNhanVien)) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDSTheoMNSX(String maNhaSanXuat) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNSX().equals(maNhaSanXuat)) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDSTheoNN(int ngayNhap) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMPNH().equals(ngayNhap)) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDSTheoTT(int tongTien) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getTT() == tongTien) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDSTheoMPNH(int nam) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (getNamNhap(i) == nam) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public int getNamNhap(int i) {
        String subStr = dspnh[i].getNN().substring(6, 6 + 4);
        int nam = Integer.parseInt(subStr);
        return nam;
    }

    public PhieuNhapHang[] timKiemDStheoKhoangTG(String ngay1, String ngay2) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            String ngay = dspnh[i].getNN();
            if (ngay.compareTo(ngay1) >= 0 && ngay.compareTo(ngay2) <= 0) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public PhieuNhapHang[] timKiemDStheoKhoangTT(int tt1, int tt2) {
        int count = 0;
        PhieuNhapHang[] ds = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            int tongTien = dspnh[i].getTT();
            if (tongTien >= tt1 && tongTien <= tt2) {
                ds[count++] = dspnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    } 

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhap = Static.scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            xoa(index);
        }
    }
    public void xoa(int index) {
        if (index >= 0 && index < n) {
            PhieuNhapHang pnh = dspnh[index];
            if (pnh != null) {
                ChiTietPhieuNhapHang[] chiTiet = dsctpnh.timKiemDStheoMPNH(pnh.getMPNH());
                if (chiTiet != null) {
                    for (ChiTietPhieuNhapHang ct : chiTiet) {
                        if (ct != null) {
                            dssp.giamSoLuong(ct.getMSP(), ct.getSL());
                            dsctpnh.xoa(ct.getMPNH());
                        }
                    }
                }
            }
            for (int i = index; i < n - 1; i++) {
                dspnh[i] = dspnh[i + 1];
            }
            dspnh = Arrays.copyOf(dspnh, n--);
            System.out.println("Xoa thanh cong!");
            nhapFile(false);
        } else {
            System.out.println("Khong hop le!");
        }
    }
    
    public void xoa(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
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
            System.out.println("1. Ma phieu nhap");
            System.out.println("2. Ngay nhap hang");
            System.out.println("3. Ma nhan vien");
            System.out.println("4. Ma nha san xuat");
            System.out.println("5. Tong tien");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma phieu nhap hang: ");
                    String maPhieuNhapMoi = Static.scanner.nextLine();
                    String maPhieuNhapCu = dspnh[index].getMPNH();
                    dspnh[index].setMPN(maPhieuNhapMoi);
                    dsctpnh.capNhatMaPhieuNhap(maPhieuNhapCu, maPhieuNhapMoi);
                    break;
                case 2:
                    System.out.print("Ngay nhap hang: ");
                    String ngayNhap = Static.scanner.nextLine();
                    dspnh[index].setNN(ngayNhap);
                    break;
                case 3:
                    System.out.print("Ma nhan vien: ");
                    String maNhanVienMoi = Static.scanner.nextLine();
                    String maNhanVienCu = dspnh[index].getMNV();
                    dspnh[index].setMNV(maNhanVienMoi);
                    dsnv.capNhatMaNhanVien(maNhanVienCu, maNhanVienMoi);
                    break;
                case 4:
                    System.out.print("Ma nha san xuat: ");
                    String maNhaSanXuatMoi = Static.scanner.nextLine();
                    String maNhaSanXuatCu = dspnh[index].getMNSX();
                    dspnh[index].setMNSX(maNhaSanXuatMoi);
                    dsnsx.capNhatMaNhaSanXuat(maNhaSanXuatCu, maNhaSanXuatMoi);
                    break;
                case 5:
                    System.out.print("Tong tien: ");
                    int tongTien = Static.scanner.nextInt();
                    dspnh[index].setTT(tongTien);
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
        String maPhieuNhap = Static.scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("Khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("Khong hop le!");
        }
    }

    public void thongKe() {
        Static.clearScreen();

        int tongSoPhieuNhap = 0;
        int soPhieuNhapTheoNhanVien = 0;
        int soPhieuNhapTheoNhaSanXuat = 0;

        System.out.println("TThong ke so luong phieu nhap theo ngay:");
        for (int i = 0; i < n; i++) {
            String ngayNhap = dspnh[i].getNN();
            int soPhieuNhapTheoNgay = 0;
            for (int j = 0; j < n; j++) {
                if (dspnh[j].getNN().equals(ngayNhap)) {
                    soPhieuNhapTheoNgay++;
                }
            }
            System.out.println("Ngay: " + ngayNhap + ", So phieu nhap: " + soPhieuNhapTheoNgay);
        }

        for (int i = 0; i < n; i++) {
            String maNhanVien = dspnh[i].getMNV();
            String maNhaSanXuat = dspnh[i].getMNSX();

            for (int j = 0; j < n; j++) {
                if (dspnh[j].getMNV().equals(maNhanVien)) {
                    soPhieuNhapTheoNhanVien++;
                }
                if (dspnh[j].getMNSX().equals(maNhaSanXuat)) {
                    soPhieuNhapTheoNhaSanXuat++;
                }
            }

            tongSoPhieuNhap++;
        }

        System.out.println("So phieu nhap theo nhan vien: " + soPhieuNhapTheoNhanVien);
        System.out.println("So phieu nhap theo nha san xuat: " + soPhieuNhapTheoNhaSanXuat);
        System.out.println("Tong so phieu nhap: " + tongSoPhieuNhap);
    }
}