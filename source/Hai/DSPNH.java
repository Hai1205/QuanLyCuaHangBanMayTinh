import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSPNH implements DanhSach<PhieuNhapHang> {
    private PhieuNhapHang[] dspnh;
    private int n;

    public DSPNH() {
        n = 0;
        dspnh = new PhieuNhapHang[n];

    }

    public DSPNH(int n) {
        setN(n);
        dspnh = new PhieuNhapHang[n];
    }

    public DSPNH(DSPNH other) {
        this.n = other.n;
        this.dspnh = Arrays.copyOf(other.dspnh, n);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSpnh(int i, PhieuNhapHang value) {
        dspnh[i] = value;
    }

    public void setDSpnh(int i) {
        dspnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public PhieuNhapHang getDSpnh(int i) {
        return dspnh[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("so luong phieu nhap hang : ");
        n = scanner.nextInt();

        dspnh = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i] = new PhieuNhapHang();
            dspnh[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i].xuat();
        }
    }

    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../data_base/dspnh.txt", xoaHetDuLieuCu);
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
            FileReader fr = new FileReader("../data_base/dspnh.txt");
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
        System.out.println("thong tin phieu nhap hang: ");
        PhieuNhapHang x = new PhieuNhapHang();
        x.nhap();
        them(x);

        // dspnh = Arrays.copyOf(dspnh, n + 1);
        // System.out.println("thong tin phieu nhap hang: ");
        // dspnh[n] = new PhieuNhapHang();
        // dspnh[n].nhap();
        // n++;
    }

    public void them(PhieuNhapHang x) {
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = new PhieuNhapHang(x);
        n++;
    }

    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPNH()).equals(maPhieuNhap)) {
                System.out.println("found!");
                dspnh[i].xuat();
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
            if ((dspnh[i].getMPNH()).equals(maPhieuNhap)) {
                return i;
            }
        }
        return -1;
    }

    public PhieuNhapHang timKiem1(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPNH()).equals(maPhieuNhap)) {
                return dspnh[i];
            }
        }
        return null;
    }

    public DSPNH timKiem2(String maPhieuNhap) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMPNH().equals(maPhieuNhap)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH timKiem3(String maNhanVien) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(maNhanVien)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH timKiem4(String maNhaSanXuat) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNSX().equals(maNhaSanXuat)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH timKiem5(String ngayNhap) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getNN().equals(ngayNhap)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH timKiem6(int namNhap) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (getNamNhap(i) == namNhap) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH timKiem7(int tongTien) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getTT() == tongTien) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public int getNamNhap(int i) {
        String subStr = dspnh[i].getNN().substring(6, 6 + 4);
        int nam = Integer.parseInt(subStr);
        return nam;
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma phieu nhap hang: ");
        String maPhieuNhap = scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dspnh[i] = dspnh[i + 1];
            }
            dspnh = Arrays.copyOf(dspnh, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public void xoa(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void sua(int index) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- chon muc can sua: ----");
            System.out.println("1. ma phieu nhap");
            System.out.println("2. ngay nhap hang");
            System.out.println("3. ma nhan vien");
            System.out.println("4. ma nha san xuat");
            System.out.println("5. tong tien");
            System.out.println("6. thoat");
            System.out.print("chon chuc nang (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ma phieu nhap hang: ");
                    String maPhieuNhap = scanner.nextLine();
                    dspnh[index].setMPN(maPhieuNhap);
                    break;
                case 2:
                    System.out.print("ngay nhap hang: ");
                    String ngayNhap = scanner.nextLine();
                    dspnh[index].setNN(ngayNhap);
                    break;
                case 3:
                    System.out.print("ma nhan vien: ");
                    String maNhanVien = scanner.nextLine();
                    dspnh[index].setMNV(maNhanVien);
                    break;
                case 4:
                    System.out.print("ma nha san xuat: ");
                    String maNhaSanXuat = scanner.nextLine();
                    dspnh[index].setMNSX(maNhaSanXuat);
                    break;
                case 5:
                    System.out.print("tong tien: ");
                    int tongTien = scanner.nextInt();
                    dspnh[index].setTT(tongTien);
                    break;
                case 6:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong !");
            }
        } while (choice != 6);
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma phieu nhap: ");
        String maPhieuNhap = scanner.nextLine();

        int index = timKiem(maPhieuNhap);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            sua(index);
        }
    }

    public void sua(String maPhieuNhap) {
        int index = timKiem(maPhieuNhap);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong tim thay!");
        }
    }

    public void thongKe() {
        System.out.println("danh sach co " + n + " phieu nhap hang");

    }
}