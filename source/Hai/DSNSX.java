import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSNSX implements DanhSach<NhaSanXuat> {
    private NhaSanXuat[] dsnsx;
    private int n;

    public DSNSX() {
        n = 0;
        dsnsx = new NhaSanXuat[n];

    }

    public DSNSX(int n) {
        setN(n);
        dsnsx = new NhaSanXuat[n];
    }

    public DSNSX(DSNSX other) {
        this.n = other.n;
        this.dsnsx = Arrays.copyOf(other.dsnsx, n);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSCTSP(int i, NhaSanXuat value) {
        dsnsx[i] = value;
    }

    public void setDSCTSP(int i) {
        dsnsx[i].nhap();
    }

    public int getN() {
        return n;
    }

    public NhaSanXuat getDSCTSP(int i) {
        return dsnsx[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("so luong nha san xuat: ");
        n = scanner.nextInt();

        dsnsx = new NhaSanXuat[n];
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin nha san xuat thu " + (i + 1) + ": ");
            dsnsx[i] = new NhaSanXuat();
            dsnsx[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin nha san xuat thu " + (i + 1) + ": ");
            dsnsx[i].xuat();
        }
    }

    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../data_base/dsnsx.txt", xoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (NhaSanXuat i : dsnsx) {
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
            FileReader fr = new FileReader("../data_base/dsnsx.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 2) {
                    String maNhaSanXuat = txt[0].trim();
                    String tenNhaSanXuat = txt[1].trim();
                    them(new NhaSanXuat(maNhaSanXuat, tenNhaSanXuat));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void them() {
        System.out.println("thong tin nha san xuat: ");
        NhaSanXuat x = new NhaSanXuat();
        x.nhap();
        them(x);

        // dsnsx = Arrays.copyOf(dsnsx, n + 1);
        // System.out.println("Thong tin chi tiet phieu nhap hang: ");
        // dsnsx[n] = new NhaSanXuat();
        // dsnsx[n].nhap();
        // n++;
    }

    public void them(NhaSanXuat x) {
        dsnsx = Arrays.copyOf(dsnsx, n + 1);
        dsnsx[n] = new NhaSanXuat(x);
        n++;
    }

    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma nha san xuat: ");
        String maNhaSanXuat = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dsnsx[i].getMNSX()).equals(maNhaSanXuat)) {
                System.out.println("found!");
                dsnsx[i].xuat();
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("not found!");
        }
    }

    public int timKiem(String maNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsnsx[i].getMNSX()).equals(maNhaSanXuat)) {
                return i;
            }
        }
        return -1;
    }

    public NhaSanXuat timKiem1(String maNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsnsx[i].getMNSX()).equals(maNhaSanXuat)) {
                return dsnsx[i];
            }
        }
        return null;
    }

    public DSNSX timKiem2(String maNhaSanXuat) {
        int cnt = 0;
        DSNSX ds = new DSNSX();
        for (int i = 0; i < n; i++) {
            if (dsnsx[i].getMNSX().equals(maNhaSanXuat)) {
                ds.them(dsnsx[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSNSX timKiem3(String tenNhaSanXuat) {
        int cnt = 0;
        DSNSX ds = new DSNSX();
        for (int i = 0; i < n; i++) {
            if (dsnsx[i].getTNSX().equals(tenNhaSanXuat)) {
                ds.them(dsnsx[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma nha san xuat: ");
        String maNhaSanXuat = scanner.nextLine();

        int index = timKiem(maNhaSanXuat);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dsnsx[i] = dsnsx[i + 1];
            }
            dsnsx = Arrays.copyOf(dsnsx, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public void xoa(String maNhaSanXuat) {
        int index = timKiem(maNhaSanXuat);
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
            System.out.println("1. ma nha san xuat");
            System.out.println("2. ten nha san xuat");
            System.out.println("3. thoat");
            System.out.print("chon chuc nang (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("ma nha san xuat: ");
                    String maNhaSanXuat = scanner.nextLine();
                    dsnsx[index].setMNSX(maNhaSanXuat);
                    break;
                case 2:
                    System.out.println("ten nha san xuat: ");
                    String tenNhaSanXuat = scanner.nextLine();
                    dsnsx[index].setTNSX(tenNhaSanXuat);
                    break;
                case 3:
                    System.out.println("end!");
                    break;
                default:
                    System.out.println("invalid!");
            }
        } while (choice != 3);
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma nha san xuat: ");
        String maNhaSanXuat = scanner.nextLine();
        int index = timKiem(maNhaSanXuat);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        }
        else {
            sua(index);
        }
    }

    public void sua(String maNhaSanXuat) {
        int index = timKiem(maNhaSanXuat);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("invalid!");
        }
    }

    public void thongKe() {
        System.out.println("danh sach co " + n + " nha san xuat");

    }
}
