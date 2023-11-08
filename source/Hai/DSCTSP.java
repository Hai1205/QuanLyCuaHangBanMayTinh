import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSCTSP implements DanhSach<CTSP> {
    private CTSP[] dsctsp;
    private int n;

    public DSCTSP() {
        n = 0;
        dsctsp = new CTSP[n];

    }

    public DSCTSP(int n) {
        setN(n);
        dsctsp = new CTSP[n];
    }

    public DSCTSP(DSCTSP other) {
        this.n = other.n;
        this.dsctsp = Arrays.copyOf(other.dsctsp, n);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSCTSP(int i, CTSP value) {
        dsctsp[i] = value;
    }

    public void setDSCTSP(int i) {
        dsctsp[i].nhap();
    }

    public int getN() {
        return n;
    }

    public CTSP getDSCTSP(int i) {
        return dsctsp[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("so luong chi tiet san pham: ");
        n = scanner.nextInt();

        dsctsp = new CTSP[n];
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin chi tiet san pham thu " + (i + 1) + ": ");
            dsctsp[i] = new CTSP();
            dsctsp[i].nhap();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
        System.out.println("thong tin chi tiet san pham thu " + (i + 1) + ": ");
        dsctsp[i].xuat();
        }

        // System.out.format("%-15s %-10s %-20s %-15s %-35s %-15s %-20s %-20s %-15s\n",
        //         "ma san pham",
        //         "RAM",
        //         "CPU",
        //         "hard disk",
        //         "graphic card",
        //         "OS",
        //         "ma nha san xuat",
        //         "ten nha san xuat",
        //         "thoi gian san xuat");

        // for (CTSP i : dsctsp) {
        //     System.out.format("%-15s %-10s %-20s %-15s %-35s %-15s %-20s %-20s %-15s\n",
        //             i.getMSP(),
        //             i.getRAM(),
        //             i.getCPU(),
        //             i.getHD(),
        //             i.getGC(),
        //             i.getOS(),
        //             i.getMNSX(),
        //             i.getTNSX(),
        //             i.getTGSX());
        // }
    }

    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../data_base/dsctsp.txt", xoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (CTSP i : dsctsp) {
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
            FileReader fr = new FileReader("../data_base/dsctsp.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 9) {
                    String maSanPham = txt[0].trim();
                    String RAM = txt[1].trim();
                    String CPU = txt[2].trim();
                    String hardDisk = txt[3].trim();
                    String graphicCard = txt[4].trim();
                    String OS = txt[5].trim();
                    String maNhaSanXuat = txt[6].trim();
                    String tenNhaSanXuat = txt[7].trim();
                    String namSanXuat = txt[8].trim();
                    them(new CTSP(maSanPham, RAM, CPU, hardDisk, graphicCard, OS, maNhaSanXuat, tenNhaSanXuat, namSanXuat));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void them() {
        System.out.println("thong tin chi tiet phieu nhap hang: ");
        CTSP x = new CTSP();
        x.nhap();
        them(x);

        // dsctsp = Arrays.copyOf(dsctsp, n + 1);
        // System.out.println("thong tin chi tiet san pham: ");
        // dsctsp[n] = new CTSP();
        // dsctsp[n].nhap();
        // n++;
    }

    public void them(CTSP x) {
        dsctsp = Arrays.copyOf(dsctsp, n + 1);
        dsctsp[n] = new CTSP(x);
        n++;
    }

    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma san pham: ");
        String maSanPham = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getMSP()).equals(maSanPham)) {
                System.out.println("found!");
                dsctsp[i].xuat();
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.println("not found!");
        }
    }

    public int timKiem(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getMSP()).equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }

    public CTSP timKiem1(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getMSP()).equals(maSanPham)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public DSCTSP timKiem2(String maSanPham) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getMSP().equals(maSanPham)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem3(String RAM) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getRAM().equals(RAM)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem4(String CPU) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getCPU().equals(CPU)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem5(String hardDisk) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getHD().equals(hardDisk)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem6(int graphicCard) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getGC().equals(graphicCard)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem7(int OS) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getOS().equals(OS)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem8(int maNhaSanXuat) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getMNSX().equals(maNhaSanXuat)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem9(int tenNhaSanXuat) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getTNSX().equals(tenNhaSanXuat)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public DSCTSP timKiem10(int thoiGianSanXuat) {
        int cnt = 0;
        DSCTSP ds = new DSCTSP();
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getTGSX().equals(thoiGianSanXuat)) {
                ds.them(dsctsp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }

    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ma san pham: ");
        String maSanPham = scanner.nextLine();

        int index = timKiem(maSanPham);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            xoa(index);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < n) {
            for (int i = index; i < n - 1; i++) {
                dsctsp[i] = dsctsp[i + 1];
            }
            dsctsp = Arrays.copyOf(dsctsp, n - 1);
            n--;
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public void xoa(String maSanPham) {
        int index = timKiem(maSanPham);
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
            System.out.println("1. ma san pham");
            System.out.println("2. RAM");
            System.out.println("3. CPU");
            System.out.println("4. hard disk");
            System.out.println("5. graphic card");
            System.out.println("6. OS");
            System.out.println("7. ma nha san xuat");
            System.out.println("8. ten nha san xuat");
            System.out.println("9. thoi gian san xuat");
            System.out.println("10. thoat");
            System.out.print("chon chuc nang (1-10): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("ma nha san xuat: ");
                    String maSanPham = scanner.nextLine();
                    dsctsp[index].setMSP(maSanPham);
                    break;
                case 2:
                    System.out.println("RAM: ");
                    String RAM = scanner.nextLine();
                    dsctsp[index].setRAM(RAM);
                    break;
                case 3:
                    System.out.println("CPU: ");
                    String CPU = scanner.nextLine();
                    dsctsp[index].setCPU(CPU);
                    break;
                case 4:
                    System.out.println("hard disk: ");
                    String hardDisk = scanner.nextLine();
                    dsctsp[index].setHD(hardDisk);
                    break;
                case 5:
                    System.out.println("graphic card: ");
                    String graphicCard = scanner.nextLine();
                    dsctsp[index].setGC(graphicCard);
                    break;
                case 6:
                    System.out.println("OS: ");
                    String OS = scanner.nextLine();
                    dsctsp[index].setOS(OS);
                    break;
                case 7:
                    System.out.println("ma nha san xuat: ");
                    String maNhaSanXuat = scanner.nextLine();
                    dsctsp[index].setMNSX(maNhaSanXuat);
                    break;
                case 8:
                    System.out.println("ten nha san xuat: ");
                    String tenNhaSanXuat = scanner.nextLine();
                    dsctsp[index].setTNSX(tenNhaSanXuat);
                    break;
                case 9:
                    System.out.println("thoi gian san xuat: ");
                    String thoiGianSanXuat = scanner.nextLine();
                    dsctsp[index].setTGSX(thoiGianSanXuat);
                    break;
                case 10:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 10);
    }

    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ma san pham: ");
        String maSanPham = scanner.nextLine();
        int index = timKiem(maSanPham);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        } else {
            sua(index);
        }
    }

    public void sua(String maSanPham) {
        int index = timKiem(maSanPham);
        if (index != -1) {
            sua(index);
        } else {
            System.out.println("khong hop le!");
        }
    }

    public void thongKe() {
        System.out.println("danh sach co " + n + " chi tiet san pham");

    }
}
