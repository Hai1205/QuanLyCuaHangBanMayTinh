package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
public class DSChiTietPhieuNhapHang implements DanhSach<ChiTietPhieuNhapHang> {
    private ChiTietPhieuNhapHang[] dsctpnh;
    private int n;

    private DSSanPham dssp;
    private String maPhieuNhap, maNhaSanXuat;

    public DSChiTietPhieuNhapHang() {
        n = 0;
        dsctpnh = new ChiTietPhieuNhapHang[n];
        
        dssp = new DSSanPham();

        xuatFile();
    }

    public DSChiTietPhieuNhapHang(int n) {
        setN(n);
        dsctpnh = new ChiTietPhieuNhapHang[n];

        xuatFile();
    }

    public DSChiTietPhieuNhapHang(DSChiTietPhieuNhapHang other) {
        this.n = other.n;
        this.dsctpnh = Arrays.copyOf(other.dsctpnh, n);

        xuatFile();
    }

    public void setMPN(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setChiTietPhieuNhapHang(int i, ChiTietPhieuNhapHang value) {
        dsctpnh[i] = value;
    }

    public void setChiTietPhieuNhapHang(int i) {
        dsctpnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public ChiTietPhieuNhapHang getChiTietPhieuNhapHang(int i) {
        return dsctpnh[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong chi tiet phieu nhap hang: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin chi tiet phieu nhap hang thu " + (i + 1) + ":");
            dsctpnh[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSChiTietPhieuNhapHang.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (ChiTietPhieuNhapHang i : dsctpnh) {
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
            FileReader fr = new FileReader("../src/data_base/DSChiTietPhieuNhapHang.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 5) {
                    String maPhieuNhapHang = txt[0].trim();
                    String maSanPham = txt[1].trim();
                    int soLuong = Integer.parseInt(txt[2].trim());
                    int donGia = Integer.parseInt(txt[3].trim());
                    int thanhTien = Integer.parseInt(txt[4].trim());
                    them(new ChiTietPhieuNhapHang(maPhieuNhapHang, maSanPham, soLuong, donGia, thanhTien));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void capNhatSLSP(ChiTietPhieuNhapHang x) {
        int index = dssp.timKiem(x.getMSP());
        if (index == -1) {
            dssp.setMSP(x.getMSP());
            dssp.setSL(x.getSL());
            dssp.setMNSX(maNhaSanXuat);
            dssp.them();
        } else {
            dssp.tangSoLuong(x.getMSP(), x.getSL());
        }
        dssp.nhapFile(false);
    }

    public void them() {
        Static.clearScreen();

        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        System.out.println("Thong tin chi tiet phieu nhap hang: ");
        dsctpnh[n] = new ChiTietPhieuNhapHang();

        dsctpnh[n].setMPNH(maPhieuNhap);
        dsctpnh[n].nhap();

        capNhatSLSP(dsctpnh[n++]);
        nhapFile(false);
    }

    public void them(ChiTietPhieuNhapHang x) {
        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        dsctpnh[n++] = x;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.println("Ma phieu nhap hang: ");
        String maPhieuNhapHang = Static.scanner.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhapHang)) {
                dsctpnh[i].xuat();
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("khong hop le!");
        }
    }

    public int timKiem(String maPhieuNhapHang) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhapHang)) {
                return i;
            }
        }
        return -1;
    }

    public ChiTietPhieuNhapHang timKiemCTPNHtheoMSP(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMSP()).equals(maSanPham)) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public ChiTietPhieuNhapHang timKiemCTPNHtheoSL(int soLuong) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getSL()) == soLuong) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public ChiTietPhieuNhapHang timKiemCTPNHtheoDG(int donGia) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getDG()) == donGia) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public ChiTietPhieuNhapHang timKiemCTPNHtheo(int thanhTien) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getTT()) == thanhTien) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public ChiTietPhieuNhapHang timKiemCTPNHtheoMPNH(String maPhieuNhapHang) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhapHang)) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public ChiTietPhieuNhapHang[] timKiemDStheoMPNH(String maPhieuNhapHang) {
        int count = 0;
        ChiTietPhieuNhapHang[] ds = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMPNH().equals(maPhieuNhapHang)) {
                ds[count++] = dsctpnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietPhieuNhapHang[] timKiemDStheoMSP(String maSanPham) {
        int count = 0;
        ChiTietPhieuNhapHang[] ds = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMSP().equals(maSanPham)) {
                ds[count++] = dsctpnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietPhieuNhapHang[] timKiemDStheoSL(int soLuong) {
        int count = 0;
        ChiTietPhieuNhapHang[] ds = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getSL() == soLuong) {
                ds[count++] = dsctpnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietPhieuNhapHang[] timKiemDStheoDG(int donGia) {
        int count = 0;
        ChiTietPhieuNhapHang[] ds = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getDG() == donGia) {
                ds[count++] = dsctpnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }
    
    public ChiTietPhieuNhapHang[] timKiemDStheoTT(int thanhTien) {
        int count = 0;
        ChiTietPhieuNhapHang[] ds = new ChiTietPhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getTT() == thanhTien) {
                ds[count++] = dsctpnh[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }
    
    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhapHang = Static.scanner.nextLine();

        int index = timKiem(maPhieuNhapHang);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }
    }
    public void xoa(int index) {
        if (index >= 0 && index < n) {
            ChiTietPhieuNhapHang ct = dsctpnh[index];
            if (ct != null) {
                dssp.giamSoLuong(ct.getMSP(), ct.getSL());
            }
            for (int i = index; i < n - 1; i++) {
                dsctpnh[i] = dsctpnh[i + 1];
            }
            dsctpnh = Arrays.copyOf(dsctpnh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");   
        } else {
            System.out.println("Khong hop le!");
        }
        nhapFile(false);
    }
    public void xoa(String maPhieuNhapHang) {
        int index = timKiem(maPhieuNhapHang);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma phieu nhap hang");
            System.out.println("2. Ma san pham");
            System.out.println("3. So luong");
            System.out.println("4. Don gia");
            System.out.println("5. Tong tien");
            System.out.println("6. Thoat");
            System.out.print("Chon chuc nang (1-6): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ma phieu nhap hang: ");
                    String maPhieuNhapHang = Static.scanner.nextLine();
                    dsctpnh[index].setMPNH(maPhieuNhapHang);
                    break;
                case 2:
                    System.out.println("Ma san pham: ");
                    String maSanPham = Static.scanner.nextLine();
                    dsctpnh[index].setMSP(maSanPham);
                    break;
                case 3:
                    System.out.println("So luong: ");
                    int soLuong = Static.scanner.nextInt();
                    dsctpnh[index].setSL(soLuong);
                    break;
                case 4:
                    System.out.println("Don gia: ");
                    int donGia = Static.scanner.nextInt();
                    dsctpnh[index].setDG(donGia);
                    break;
                case 5:
                    System.out.println("Tong tien: ");
                    int tongTien = Static.scanner.nextInt();
                    dsctpnh[index].setTT(tongTien);
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

        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhapHang = Static.scanner.nextLine();
        int index = timKiem(maPhieuNhapHang);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maPhieuNhapHang) {
        int index = timKiem(maPhieuNhapHang);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong hop le!");
        }
    }
    public void capNhatMaPhieuNhap(String maPhieuNhapCu, String maPhieuNhapMoi) {
        for (ChiTietPhieuNhapHang ctpnh : dsctpnh) {
            if (ctpnh.getMPNH().equals(maPhieuNhapCu)) {
                ctpnh.setMPNH(maPhieuNhapMoi);
            }
        }
        nhapFile(false);
    }
        
    public void thongKe() {
        Static.clearScreen();
        
        int tongSoPhieuNhap = 0;
        int tongTienNhap = 0;

        System.out.println("Thong ke so luong phieu nhap theo san pham:");
        for (int i = 0; i < n; i++) {
            String maSanPham = dsctpnh[i].getMSP();
            int soPhieuNhapTheoSanPham = 0;
            int tongTienNhapTheoSanPham = 0;
            for (int j = 0; j < n; j++) {
                if (dsctpnh[j].getMSP().equals(maSanPham)) {
                    soPhieuNhapTheoSanPham++;
                    tongTienNhapTheoSanPham += dsctpnh[j].getTT();
                }
            }
            System.out.println("Ma san pham: " + maSanPham + ", So phieu nhap: " + soPhieuNhapTheoSanPham + ", Tong tien nhap: " + tongTienNhapTheoSanPham);
            tongSoPhieuNhap += soPhieuNhapTheoSanPham;
            tongTienNhap += tongTienNhapTheoSanPham;
        }

        System.out.println("Tong so phieu nhap: " + tongSoPhieuNhap);
        System.out.println("Tong tien nhap: " + tongTienNhap);
    }
}
