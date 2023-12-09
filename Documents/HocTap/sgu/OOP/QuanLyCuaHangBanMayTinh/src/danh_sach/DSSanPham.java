package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DSSanPham implements DanhSach<SanPham> {
    private SanPham[] dssp;
    private int n;

    private DSChiTietSanPham dsctsp;
    private String maSanPham, maNhaSanXuat;
    private int soLuong;

    public DSSanPham() {
        dssp = new SanPham[0];
        n = 0;

        dsctsp = new DSChiTietSanPham();

        // xuatFile();
    }

    public DSSanPham(int n) {
        setN(n);
        dssp = new SanPham[n];
    }

    public DSSanPham(DSSanPham other) {
        this.n = other.n;
        this.dssp = Arrays.copyOf(other.dssp, n);
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setSL(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSanPham(int i, SanPham value) {
        dssp[i] = value;
    }

    public void setSanPham(int i) {
        if (dssp[i] instanceof LapTop) {
            ((LapTop) dssp[i]).nhap();
        } else if (dssp[i] instanceof PC) {
            ((PC) dssp[i]).nhap();
        }
    }

    public SanPham getSanPham(int i) {
        return dssp[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So loai san pham: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    @Override
    public void xuat() {
        System.out.printf(" %-20s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n", "Ma san pham",
                "Ten san pham", "Don vi tinh", "So luong", "Don gia", "Dung luong pin", "Loai", "Hang man hinh");
        for (SanPham i : dssp) {
            i.xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSSanPham.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (SanPham i : dssp) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xuatFile() {
        try {
            FileReader fr = new FileReader("../src/data_base/DSSanPham.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(", ");
                if (txt.length == 7) {
                    String MaSP = txt[0].trim();
                    String Ten = txt[1].trim();
                    int SLCL = Integer.parseInt(txt[2].trim());
                    int DG = Integer.parseInt(txt[3].trim());
                    String DVT = txt[4].trim();
                    String pin = txt[5].trim();
                    String loai = txt[6].trim();

                    LapTop laptop = new LapTop(MaSP, Ten, SLCL, DG, DVT, pin, loai);
                    them(laptop);
                } else if (txt.length == 6) {
                    String MaSP = txt[0].trim();
                    String Ten = txt[1].trim();
                    int SLCL = Integer.parseInt(txt[2].trim());
                    int DG = Integer.parseInt(txt[3].trim());
                    String DVT = txt[4].trim();
                    String hangManHinh = txt[5].trim();
                    PC pc = new PC(MaSP, Ten, SLCL, DG, DVT, hangManHinh);
                    them(pc);
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void them() {
        Static.clearScreen();

        System.out.println("Thong tin san pham: ");
        System.out.print("Chon loai san pham (1. Laptop / 2. PC): ");
        int loaiSanPham = Static.scanner.nextInt();
        Static.scanner.nextLine();

        SanPham x;
        if (maSanPham == null || maSanPham.isEmpty()) {
            boolean daTonTai;

            do {
                System.out.print("Ma san pham: ");
                maSanPham = Static.scanner.nextLine();
                daTonTai = (timKiem(maSanPham) != -1);

                if (daTonTai) {
                    System.out.println("Ma san pham da ton tai! Xin nhap lai!");
                }
            } while (daTonTai);
        }

        if (loaiSanPham == 1) {
            x = new LapTop();
        } else if (loaiSanPham == 2) {
            x = new PC();
        } else {
            System.out.println("khong hop le!");
            return;
        }

        x.setMaSP(maSanPham);
        x.setSL(soLuong);
        x.nhap();
        them(x);

        dsctsp.setMSP(maSanPham);
        dsctsp.setMNSX(maNhaSanXuat);
        dsctsp.them();

        nhapFile(false);
    }

    @Override
    public void them(SanPham x) {
        dssp = Arrays.copyOf(dssp, n + 1);
        dssp[n++] = x;
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();
        int index = timKiem(maSanPham);
        timKiem(index);
    }

    public void timKiem(int index) {
        if (index == -1) {
            System.out.println("Ma san pham khong dung!");
            return;
        }

        System.out.printf(" %-20s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n", "Ma san pham",
                "Ten san pham", "Don vi tinh", "So luong", "Don gia", "Dung luong pin", "Loai", "Hang man hinh");
        dssp[index].xuat();

        dsctsp.timKiem(index);
    }

    public int timKiem(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dssp[i].getMaSP()).equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }

    public SanPham timKiemSPtheoSL(int soLuong) {
        for (int i = 0; i < n; i++) {
            if (dssp[i].getSL() == soLuong) {
                return dssp[i];
            }
        }
        return null;
    }

    public SanPham[] timKiemDStheoMaSP(String maSanPham) {
        int count = 0;
        SanPham[] ds = new SanPham[n];
        for (int i = 0; i < n; i++) {
            if (dssp[i].getMaSP().equals(maSanPham)) {
                ds[count++] = dssp[i];
            }
        }
        return Arrays.copyOf(ds, count);
    }

    public SanPham timKiemDStheoMa(String maSP) {
        for (SanPham sp : dssp) {
            if (sp.getMaSP().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    public SanPham[] timKiemDStheoKhoangDG(int dg1, int dg2) {
        int count = 0;
        SanPham[] ds = new SanPham[n];
        for (int i = 0; i < n; i++) {
            int donGia = dssp[i].getDG();
            if (donGia >= dg1 && donGia <= dg2) {
                ds[count++] = dssp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void timKiemDStheoKhoangDG() {
        Static.clearScreen();

        System.out.print("Chon gia thap nhat: ");
        int min = Static.checkInputIsInt();
        System.out.print("Chon gia cao nhat: ");
        int max = Static.checkInputIsInt();

        SanPham[] ds = timKiemDStheoKhoangDG(min, max);
        if (ds == null) {
            System.out.println("Khong co san pham nao trong khoang gia do! Xin nhap lai!");
            return;
        }

        System.out.printf(" %-20s | %-25s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n", "Ma san pham",
                "Ten san pham", "Don vi tinh", "So luong", "Don gia", "Dung luong pin", "Loai", "Hang man hinh");
        for (SanPham i : ds) {
            i.xuat();
        }
    }

    @Override
    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();
        xoa(maSanPham);
    }

    public void xoa(String maSanPham) {
        int index = timKiem(maSanPham);
        xoa(index);
    }

    @Override
    public void xoa(int index) {
        if (index == -1) {
            System.out.println("Ma san pham khong dung!");
            return;
        }

        dsctsp.xoa(index);
        for (int i = index; i < n - 1; i++) {
            dssp[i] = dssp[i + 1];
        }
        dssp = Arrays.copyOf(dssp, n - 1);
        n--;
        System.out.println("Xoa thanh cong!");

        nhapFile(false);
    }

    public void giamSoLuong(String maSanPham, int soLuongGiam) {
        int index = timKiem(maSanPham);
        if (index != -1) {
            SanPham sp = dssp[index];
            int soLuongMoi = sp.getSL() - soLuongGiam;
            if (soLuongMoi < 0) {
                soLuongMoi = 0;
            }
            sp.setSL(soLuongMoi);
            nhapFile(false);
        }
    }

    public void tangSoLuong(String maSanPham, int soLuongTang) {
        int index = timKiem(maSanPham);
        if (index != -1) {
            SanPham sp = dssp[index];
            sp.setSL(sp.getSL() + soLuongTang);
            nhapFile(false);
        }
    }

    public void sua(int index) {
        if (index == -1) {
            System.out.println("Ma san pham khong dung!");
            return;
        }

        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma San Pham");
            System.out.println("2. Ten");
            System.out.println("3. So Luong");
            System.out.println("4. Don Gia");
            System.out.println("5. Don Vi Tinh");
            if (dssp[index] instanceof LapTop) {
                System.out.println("6. Dung Luong Pin");
                System.out.println("7. Style Nguoi Dung");
            } else if (dssp[index] instanceof PC) {
                System.out.println("6. Hang Man Hinh");
            }
            System.out.println("8. Thoat");
            System.out.print("Chon chuc nang (1-8): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ma San Pham: ");
                    String maSanPham = Static.scanner.nextLine();
                    dssp[index].setMaSP(maSanPham);
                    dsctsp.getCTSP(index).setMSP(maSanPham);
                    break;
                case 2:
                    System.out.print("Ten: ");
                    String ten = Static.scanner.nextLine();
                    dssp[index].setTen(ten);
                    break;
                case 3:
                    System.out.print("So Luong: ");
                    int SL = Static.scanner.nextInt();
                    dssp[index].setSL(SL);
                    break;
                case 4:
                    System.out.print("Don Gia: ");
                    int DG = Static.scanner.nextInt();
                    dssp[index].setDG(DG);
                    break;
                case 5:
                    System.out.print("Don Vi Tinh: ");
                    String DVT = Static.scanner.nextLine();
                    dssp[index].setDVT(DVT);
                    break;
                case 6:
                    if (dssp[index] instanceof LapTop) {
                        System.out.print("Dung Luong Pin: ");
                        String pin = Static.scanner.nextLine();
                        ((LapTop) dssp[index]).setPin(pin);
                    } else if (dssp[index] instanceof PC) {
                        System.out.print("Hang Man Hinh: ");
                        String hangManHinh = Static.scanner.nextLine();
                        ((PC) dssp[index]).setHangManHinh(hangManHinh);
                    }
                    break;
                case 7:
                    if (dssp[index] instanceof LapTop) {
                        System.out.print("Style Nguoi Dung: ");
                        String loai = Static.scanner.nextLine();
                        ((LapTop) dssp[index]).setLoai(loai);
                    }
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Khong hop le!");
            }
        } while (choice != 8);
        dsctsp.nhapFile(false);
        nhapFile(false);
    }

    public void sua(String maSanPham) {
        int index = timKiem(maSanPham);
        sua(index);
    }

    @Override
    public void sua() {
        Static.clearScreen();

        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();
        sua(maSanPham);
    }
}