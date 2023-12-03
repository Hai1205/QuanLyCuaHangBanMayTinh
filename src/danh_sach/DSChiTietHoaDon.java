package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSChiTietHoaDon implements DanhSach<ChiTietHoaDon> {
    private ChiTietHoaDon[] dscthd;
    private int n;

    private String maHoaDon, maKhachHang;
    private DSSanPham dssp;
    private DSPhieuBaoHanh dspbh;

    public DSChiTietHoaDon() {
        n = 0;
        dscthd = new ChiTietHoaDon[n];
        
        dssp = new DSSanPham();
        dspbh =  new DSPhieuBaoHanh();

        xuatFile();
    }

    public DSChiTietHoaDon(int n) {
        setN(n);
        dscthd = new ChiTietHoaDon[n];

        xuatFile();
    }

    public DSChiTietHoaDon(DSChiTietHoaDon other) {
        this.n = other.n;
        this.dscthd = Arrays.copyOf(other.dscthd, n);

        xuatFile();
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

    public void setDSChiTietHoaDon(int i, ChiTietHoaDon value) {
        dscthd[i] = value;
    }

    public void setDSChiTietHoaDon(int i) {
        dscthd[i].nhap();
    }

    public int getN() {
        return n;
    }

    public ChiTietHoaDon getChiTietHoaDon(int i) {
        return dscthd[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong chi tiet hoa don: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {       
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin chi tiet hoa don thu " + (i + 1) + ": ");
            dscthd[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSChiTietHoaDon.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);

            for (ChiTietHoaDon i : dscthd) {
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
            FileReader fr = new FileReader("../src/data_base/DSChiTietHoaDon.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 6) {
                    String maHoaDon = txt[0].trim();
                    String maSanPham = txt[1].trim();
                    String maBaoHanh = txt[2].trim();
                    int soLuongMua = Integer.parseInt(txt[3].trim());
                    int donGia = Integer.parseInt(txt[4].trim());
                    int thanhTien = Integer.parseInt(txt[5].trim());
                    them(new ChiTietHoaDon(maHoaDon, maSanPham, maBaoHanh, soLuongMua, donGia, thanhTien));
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
        
        dscthd = Arrays.copyOf(dscthd, n + 1);
        System.out.println("Thong tin chi tiet hoa don: ");
        dscthd[n] = new ChiTietHoaDon();

        String maSanPham, maBaoHanh;
        boolean chuaTonTai, daTonTai;
        do {
            System.out.print("Ma san pham: ");
            maSanPham = Static.scanner.nextLine();
            chuaTonTai = (dssp.timKiem(maSanPham) == -1);

            if (chuaTonTai) {
                System.out.println("Ma san pham chua kha dung! Xin nhap lai!");
            }
        } while (chuaTonTai);

        do {
            System.out.print("Ma bao hanh: ");
            maBaoHanh = Static.scanner.nextLine();
            daTonTai = (dspbh.timKiem(maBaoHanh) != -1);

            if (daTonTai) {
                System.out.println("Ma phieu bao hanh da ton tai! Xin nhap lai!");
            }
        } while (daTonTai);

        dscthd[n].setDSSP(dssp);
        dscthd[n].setMaHoaDon(maHoaDon);
        dscthd[n].setMaSanPham(maSanPham);
        dscthd[n].setMaBaoHanh(maBaoHanh);
        dscthd[n].nhap();

        dspbh.setMPBH(maBaoHanh);
        dspbh.setMSP(maSanPham);
        dspbh.setMHD(maHoaDon);
        dspbh.setMKH(maKhachHang);
        dspbh.them();

        int index = dssp.timKiem(maSanPham);
        int SL = dssp.getSanPham(index).getSL() - dscthd[n++].getSoLuongMua();
        dssp.getSanPham(index).setSL(SL);

        dssp.nhapFile(false);
        nhapFile(false);
    }

    public void them(ChiTietHoaDon x) {
        dscthd = Arrays.copyOf(dscthd, n + 1);
        dscthd[n++] = x;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma hoa don: ");
        String maHoaDon = Static.scanner.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getMaHoaDon()).equals(maHoaDon)) {
                dscthd[i].xuat();
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("Khong hop le!");
        }
    }

    public int timKiem(String maHoaDon) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getMaHoaDon()).equals(maHoaDon)) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietHoaDon timKiemCTHDtheoMHD(String maHoaDon) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getMaHoaDon()).equals(maHoaDon)) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon timKiemCTHDtheoMSP(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getMaSanPham()).equals(maSanPham)) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon timKiemCTHDtheoMBH(String maBaoHanh) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getMaBaoHanh()).equals(maBaoHanh)) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon timKiemCTHDtheoSLM(int soLuongMua) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getSoLuongMua()) == soLuongMua) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon timKiemCTHDtheoDG(int donGia) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getDonGia()) == donGia) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon timKiemCTHDtheoTT(int thanhTien) {
        for (int i = 0; i < n; i++) {
            if ((dscthd[i].getThanhTien()) == thanhTien) {
                return dscthd[i];
            }
        }
        return null;
    }

    public ChiTietHoaDon[] timKiemDStheoMHD(String maHoaDon) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getMaHoaDon().equals(maHoaDon)) {
                ds[count++] = dscthd[i];
            }
        }

        return Arrays.copyOf(ds, count);
    }

    public ChiTietHoaDon[] timKiemDStheoMSP(String maSanPham) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getMaSanPham().equals(maSanPham)) {
                ds[count++] = dscthd[i];
            }
        }

        return Arrays.copyOf(ds, count);
    }

    public ChiTietHoaDon[] timKiemDStheoMBH(String maBaoHanh) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getMaBaoHanh().equals(maBaoHanh)) {
                ds[count++] = dscthd[i];
            }
        }

        return Arrays.copyOf(ds, count);
    }

    public ChiTietHoaDon[] timKiemDStheoSLM(int soLuongMua) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getSoLuongMua() == soLuongMua) {
                ds[count++] = dscthd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietHoaDon[] timKiemDStheoDG(int donGia) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getThanhTien() == donGia) {
                ds[count++] = dscthd[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietHoaDon[] timKiemDStheoTT(int thanhTien) {
        int count = 0;
        ChiTietHoaDon[] ds = new ChiTietHoaDon[n];
        for (int i = 0; i < n; i++) {
            if (dscthd[i].getThanhTien() == thanhTien) {
                ds[count++] = dscthd[i];
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
            for (int i = index; i < n - 1; i++) {
                dscthd[i] = dscthd[i + 1];
            }
            dscthd = Arrays.copyOf(dscthd, n - 1);
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

    public void xoaTheoHoaDon(String maHoaDon) {
        for (int i = 0; i < n;) {
            if (dscthd[i].getMaHoaDon().equals(maHoaDon)) {
                for (int j = i; j < n - 1; j++) {
                    dscthd[j] = dscthd[j + 1];
                }
                dscthd = Arrays.copyOf(dscthd, n - 1);
                n--;
            } else {
                i++;
            }
        }
        nhapFile(false);
    }

    public void sua(int index) {
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma hoa don");
            System.out.println("2. So luong mua");
            System.out.println("3. Ma san pham");
            System.out.println("4. Don gia");
            System.out.println("5. Ma bao hanh");
            System.out.println("6. Thanh tien");
            System.out.println("7. Thoat");
            System.out.print("Chon chuc nang (1-7): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma hoa don: ");
                    String maHoaDon = Static.scanner.nextLine();
                    dscthd[index].setMaHoaDon(maHoaDon);
                    break;
                case 2:
                    System.out.print("So luong mua: ");
                    int soLuongMua = Static.scanner.nextInt();
                    dscthd[index].setSoLuongMua(soLuongMua);
                    break;
                case 3:
                    System.out.print("Ma san pham: ");
                    String maSanPham = Static.scanner.nextLine();
                    dscthd[index].setMaSanPham(maSanPham);
                    break;
                case 4:
                    System.out.print("Don gia: ");
                    int donGia = Static.scanner.nextInt();
                    dscthd[index].setDonGia(donGia);
                    break;
                case 5:
                    System.out.print("Ma bao hanh: ");
                    String maBaoHanh = Static.scanner.nextLine();
                    dscthd[index].setMaBaoHanh(maBaoHanh);
                    break;
                case 6:
                    System.out.print("Thanh tien: ");
                    int thanhTien = Static.scanner.nextInt();
                    dscthd[index].setThanhTien(thanhTien);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 7);
        nhapFile(false);
    }

    public void sua() {
        Static.clearScreen();

        System.out.print("Ma hoa don: ");
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
            System.out.println("Khong hop le!");
        }
    }

    public void thongKe() {
        Static.clearScreen();
        
        for (int i = 0; i < n; i++) {
            String maSanPham = dscthd[i].getMaSanPham();
            int soLuongMua = 0;
            int thanhTien = 0;
    
            for (int j = 0; j < n; j++) {
                if (dscthd[j].getMaSanPham().equals(maSanPham)) {
                    soLuongMua += dscthd[j].getSoLuongMua();
                    thanhTien += dscthd[j].getThanhTien();
                }
            }
    
            System.out.println("Ma san pham: " + maSanPham + ", So luong mua: " + soLuongMua + ", Tong thanh tien: " + thanhTien);
        }
    }
}
