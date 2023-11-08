import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSCTPNH implements DanhSach<CTPNH> {
    private CTPNH[] dsctpnh;
    private int n;

    public DSCTPNH() {
        n = 0;
        dsctpnh = new CTPNH[n];
    }

    public DSCTPNH(int n) {
        setN(n);
        dsctpnh = new CTPNH[n];

    }

    public DSCTPNH(DSCTPNH other) {
        this.n = other.n;
        this.dsctpnh = Arrays.copyOf(other.dsctpnh, n);

    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSCTSP(int i, CTPNH value) {
        dsctpnh[i] = value;
    }

    public void setDSCTSP(int i) {
        dsctpnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public CTPNH getDSCTSP(int i) {
        return dsctpnh[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("so luong chi tiet phieu nhap hang: ");
        n = scanner.nextInt();

        dsctpnh = new CTPNH[n];
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            dsctpnh[i] = new CTPNH();
            dsctpnh[i].nhap();
        }

    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin chi tiet phieu nhap hang thu " + (i + 1) + ":");
            dsctpnh[i].xuat();
        }

        // System.out.format("%-20s %-15s %-10s %-15s %-15s\n",
        // "ma phieu nhap hang",
        // "ma san pham",
        // "so luong",
        // "don gia",
        // "tong tien");

        // for (CTPNH i : dsctpnh) {
        // System.out.format("%-20s %-15s %-10s %-15s %-15s\n",
        // i.getMPNH(),
        // i.getMSP(),
        // i.getSL(),
        // i.getDG(),
        // i.getTT());
        // }

    }

    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../data_base/dsctpnh.txt", xoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (CTPNH i : dsctpnh) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public void nhapFile(CTPNH i, boolean xoaHetDuLieuCu) {
    //     try {
    //         FileWriter fw = new FileWriter("dsctpnh.txt", xoaHetDuLieuCu);
    //         BufferedWriter bw = new BufferedWriter(fw);
    //         bw.write(i.toString());
    //         bw.newLine();
    //         bw.close();
    //         fw.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public void xuatFile() {
        try {
            FileReader fr = new FileReader("../data_base/dsctpnh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 4) {
                    String maPhieuNhap = txt[0].trim();
                    String maSanPham = txt[1].trim();
                    int soLuong = Integer.parseInt(txt[2].trim());
                    int donGia = Integer.parseInt(txt[3].trim());
                    them(new CTPNH(maPhieuNhap, maSanPham, soLuong, donGia));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void them() {
        // System.out.println("thong tin chi tiet phieu nhap hang: ");
        // CTPNH x = new CTPNH();
        // x.nhap();
        // them(x);

        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        System.out.println("Thong tin chi tiet phieu nhap hang: ");
        dsctpnh[n] = new CTPNH();
        dsctpnh[n].nhap();
        n++;
    }

    public void them(CTPNH x) {
        dsctpnh = Arrays.copyOf(dsctpnh, n + 1);
        dsctpnh[n] = new CTPNH(x);
        n++;
    }

    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                System.out.println("found!");
                dsctpnh[i].xuat();
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("not found!");
        }
    }

    public int timKiem(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                return i;
            }
        }
        return -1;
    }

    public CTPNH timKiem1(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dsctpnh[i].getMPNH()).equals(maPhieuNhap)) {
                return dsctpnh[i];
            }
        }
        return null;
    }

    public DSCTPNH timKiem2(String maPhieuNhap) {
        int cnt = 0;
        DSCTPNH ds = new DSCTPNH();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMPNH().equals(maPhieuNhap)) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTPNH timKiem3(String maSanPham) {
        int cnt = 0;
        DSCTPNH ds = new DSCTPNH();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getMSP().equals(maSanPham)) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTPNH timKiem4(int soLuong) {
        int cnt = 0;
        DSCTPNH ds = new DSCTPNH();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getSL() == soLuong) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTPNH timKiem5(int donGia) {
        int cnt = 0;
        DSCTPNH ds = new DSCTPNH();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getDG() == donGia) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTPNH timKiem6(int tongTien) {
        int cnt = 0;
        DSCTPNH ds = new DSCTPNH();
        for (int i = 0; i < n; i++) {
            if (dsctpnh[i].getTT() == tongTien) {
                ds.them(dsctpnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }

        // nhapFile(false);
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dsctpnh[i] = dsctpnh[i + 1];
            }
            dsctpnh = Arrays.copyOf(dsctpnh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void xoa(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- chon muc can sua: ----");
            System.out.println("1. ma phieu nhap hang");
            System.out.println("2. ma san pham");
            System.out.println("3. so luong");
            System.out.println("4. don gia");
            System.out.println("5. tong tien");
            System.out.println("6. thoat");
            System.out.print("chon chuc nang (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("ma phieu nhap hang: ");
                    String maPhieuNhap = scanner.nextLine();
                    dsctpnh[index].setMPN(maPhieuNhap);
                    break;
                case 2:
                    System.out.println("ma san pham: ");
                    String maSanPham = scanner.nextLine();
                    dsctpnh[index].setMSP(maSanPham);
                    break;
                case 3:
                    System.out.println("so luong: ");
                    int soLuong = scanner.nextInt();
                    dsctpnh[index].setSL(soLuong);
                    break;
                case 4:
                    System.out.println("don gia: ");
                    int donGia = scanner.nextInt();
                    dsctpnh[index].setDG(donGia);
                    break;
                case 5:
                    System.out.println("tong tien: ");
                    int tongTien = scanner.nextInt();
                    dsctpnh[index].setTT(tongTien);
                    break;
                case 6:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 6);
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();
        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("khong hop le!");
        } else {
            sua(index);
        }
    }

    public void sua(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void thongKe() {
        System.out.println("danh sach co " + n + " chi tiet phieu nhap hang");
    }
}
