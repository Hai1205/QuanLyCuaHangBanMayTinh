import java.util.Scanner;

public class DSPNH {
    private PhieuNhapHang[] dspnh = new PhieuNhapHang[50];
    private int n;

    public DSPNH() {
        n = 0;
    }

    public DSPNH(int n) {

    }

    public DSPNH(DSPNH other) {
        this.n = other.n;
        for (int i = 0; i < n; i++) {
            this.dspnh[i] = other.dspnh[i];
        }
    }

    public void setN() {
        this.n = n;
    }

    public void setDSPNH(int i, PhieuNhapHang value) {
        dspnh[i] = value;
    }

    public void setDSPNH(int i) {
        dspnh[i].nhap();
    }

    public int getN() {
        return n;
    }

    public PhieuNhapHang getDSPNH(int i) {
        return dspnh[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("so luong phieu nhap hang: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("--------------");
            System.out.println("nhap thong tin phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i] = new PhieuNhapHang();
            dspnh[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin cua phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i].xuat();
            System.out.println("--------------");
        }
    }

    public void them() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vi tri can them vao danh sach: ");
        int index = scanner.nextInt();
        System.out.println("nhap thong tin cua phieu nhap hang can them vao danh sach: ");
        PhieuNhapHang x = new PhieuNhapHang();
        x.nhap();

        if (index <= 0) {
            index = 0;
        }
        if (index >= n) {
            index = n;
        }
        for (int i = n; i > index; i--) {
            dspnh[i] = dspnh[i - 1];
        }
        dspnh[index] = new PhieuNhapHang();
        dspnh[index] = x;
        this.n++;

        // System.out.println("danh sach sau khi them: ");
        // xuat();
    }

    public void them(PhieuNhapHang x) {
        dspnh[n] = new PhieuNhapHang();
        dspnh[n] = x;
        this.n++;
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma phieu nhap: ");
        String maPhieuNhap = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPN()).equals(maPhieuNhap)) {
                System.out.println("found!");
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("not found!");
        }
    }

    public int search(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPN()).equals(maPhieuNhap)) {
                return i;
            }
        }
        return -1;
    }

    public PhieuNhapHang Search(String maPhieuNhap) {
        for (int i = 0; i < n; i++) {
            if ((dspnh[i].getMPN()).equals(maPhieuNhap)) {
                return dspnh[i];
            }
        }
        return null;
    }

    public DSPNH Search1(String maPhieuNhap) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(maPhieuNhap)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }

        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH Search2(String maNhanVien) {
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

    public DSPNH Search3(String maNhaSanXuat) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(maNhaSanXuat)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }

        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH Search4(String ngayNhap) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(ngayNhap)) {
                ds.them(dspnh[i]);
                cnt++;
            }
        }

        if (cnt == 0)
            return null;
        return ds;
    }

    public DSPNH Search4(int namNhap) {
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

    public DSPNH Search5(String tongTien) {
        int cnt = 0;
        DSPNH ds = new DSPNH();
        for (int i = 0; i < n; i++) {
            if (dspnh[i].getMNV().equals(tongTien)) {
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
        System.out.println("nhap vi tri: ");
        int index = scanner.nextInt();

        if (index < 0) {
            index = 0;
        }
        if (index >= n) {
            index = n - 1;
        }
        for (int i = index; i < n - 1; i++) {
            dspnh[i] = dspnh[i + 1];
        }
        n--;
        System.out.println("xoa thanh cong!");
    }

    public void xoa(String maPhieuNhap) {
        int index = search(maPhieuNhap);

        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                dspnh[i] = dspnh[i + 1];
            }
            n--;
        } else {
            System.out.println("invalid!");
        }
    }

    public void menuSua(int index) {
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
                    System.out.println("ma phieu nhap: ");
                    String maPhieuNhap = scanner.nextLine();
                    dspnh[index].setMPN(maPhieuNhap);
                    break;
                case 2:
                    System.out.println("ngay nhap hang: ");
                    String ngayNhap = scanner.nextLine();
                    dspnh[index].setNN(ngayNhap);
                    break;
                case 3:
                    System.out.println("ma nhan vien: ");
                    String maNhanVien = scanner.nextLine();
                    dspnh[index].setMNV(maNhanVien);
                    break;
                case 4:
                    System.out.println("ma nha san xuat: ");
                    String maNhaSanXuat = scanner.nextLine();
                    dspnh[index].setMNSX(maNhaSanXuat);
                    break;
                case 5:
                    System.out.println("tong tien: ");
                    int tongTien = scanner.nextInt();
                    dspnh[index].setTT(tongTien);
                    break;
                case 6:
                    System.out.println("end!");
                    break;
                default:
                    System.out.println("invalid!");
            }
        } while (choice != 6);
    }
}