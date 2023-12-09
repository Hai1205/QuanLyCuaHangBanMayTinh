package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSNhaSanXuat implements DanhSach<NhaSanXuat> {
    private NhaSanXuat[] dsnsx;
    private int n;

    private String maNhaSanXuat;

    public DSNhaSanXuat() {
        n = 0;
        dsnsx = new NhaSanXuat[n];

        xuatFile();
    }

    public DSNhaSanXuat(int n) {
        setN(n);
        dsnsx = new NhaSanXuat[n];

        xuatFile();
    }

    public DSNhaSanXuat(DSNhaSanXuat other) {
        this.n = other.n;
        this.dsnsx = Arrays.copyOf(other.dsnsx, n);

        xuatFile();
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setNhaSanXuat(int i, NhaSanXuat value) {
        dsnsx[i] = value;
    }

    public void setNhaSanXuat(int i) {
        dsnsx[i].nhap();
    }

    public int getN() {
        return n;
    }

    public NhaSanXuat getNhaSanXuat(int i) {
        return dsnsx[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong nha san xuat: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin nha san xuat thu " + (i + 1) + ": ");
            dsnsx[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSNhaSanXuat.txt", khongXoaHetDuLieuCu);
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
            FileReader fr = new FileReader("../src/data_base/DSNhaSanXuat.txt");
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
        Static.clearScreen();

        dsnsx = Arrays.copyOf(dsnsx, n + 1);
        System.out.println("Thong tin nha san xuat: ");
        dsnsx[n] = new NhaSanXuat();

        boolean daTonTai;
        
        if (maNhaSanXuat == null || maNhaSanXuat.isEmpty()) {
            do {
                System.out.print("Ma nha san xuat: ");
                maNhaSanXuat = Static.scanner.nextLine();

                daTonTai = (timKiem(maNhaSanXuat) != -1);

                if (daTonTai) {
                    System.out.println("Ma nha san xuat da ton tai! Xin nhap lai!");
                }
            } while (daTonTai);
        }
        
        dsnsx[n].setMNSX(maNhaSanXuat);
        dsnsx[n++].nhap();

        nhapFile(false);
    }

    public void them(NhaSanXuat x) {
        dsnsx = Arrays.copyOf(dsnsx, n + 1);
        dsnsx[n] = x;
        n++;
        nhapFile(false);
    }

    public void timKiem() {
        Static.clearScreen();

        System.out.print("Ma nha san xuat: ");
        String maNhaSanXuat = Static.scanner.nextLine();

        int index = timKiem(maNhaSanXuat);
        dsnsx[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
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

    public NhaSanXuat timKiemNSXtheoMNSX(String maNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsnsx[i].getMNSX()).equals(maNhaSanXuat)) {
                return dsnsx[i];
            }
        }
        return null;
    }

    public NhaSanXuat timKiemNSXtheoTNSX(String tenNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsnsx[i].getTNSX()).equals(tenNhaSanXuat)) {
                return dsnsx[i];
            }
        }
        return null;
    }

    public NhaSanXuat[] timKiemDStheoMNSX(String maNhaSanXuat) {
        int count = 0;
        NhaSanXuat[] ds = new NhaSanXuat[n];
        for (int i = 0; i < n; i++) {
            if (dsnsx[i].getMNSX().equals(maNhaSanXuat)) {
                ds[count++] = dsnsx[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public NhaSanXuat[] timKiemDStheoTNSX(String tenNhaSanXuat) {
        int count = 0;
        NhaSanXuat[] ds = new NhaSanXuat[n];
        for (int i = 0; i < n; i++) {
            if (dsnsx[i].getTNSX().equals(tenNhaSanXuat)) {
                ds[count++] = dsnsx[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma nha san xuat: ");
        String maNhaSanXuat = Static.scanner.nextLine();

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
        nhapFile(false);
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
        int choice;
        do {
            Static.clearScreen();

            System.out.println("---- Chon muc can sua: ----");
            System.out.println("1. Ma nha san xuat");
            System.out.println("2. Ten nha san xuat");
            System.out.println("3. Thoat");
            System.out.print("Chon chuc nang (1-3): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ma nha san xuat: ");
                    String maNhaSanXuat = Static.scanner.nextLine();
                    dsnsx[index].setMNSX(maNhaSanXuat);
                    break;
                case 2:
                    System.out.println("Ten nha san xuat: ");
                    String tenNhaSanXuat = Static.scanner.nextLine();
                    dsnsx[index].setTNSX(tenNhaSanXuat);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 3);
        nhapFile(false);
    }

    public void sua() {
        Static.clearScreen();

        System.out.print("Ma nha san xuat: ");
        String maNhaSanXuat = Static.scanner.nextLine();
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
            System.out.println("Khong hop le!");
        }
    }
    public void capNhatMaNhaSanXuat(String maNhaSanXuatCu, String maNhaSanXuatMoi) {
        for (NhaSanXuat nsx : dsnsx) {
            if (nsx.getMNSX().equals(maNhaSanXuatCu)) {
                nsx.setMNSX(maNhaSanXuatMoi);
            }
        }
        nhapFile(false);
    }
    
    public void thongKe() {
        Static.clearScreen();
        
        System.out.println("Thong ke so luong san pham theo nha san xuat:");
    
        int[] soLuongTheoNSX = new int[n];
    
        String[] maNSXArray = new String[n];
        
        Arrays.fill(soLuongTheoNSX, 0);
    
        for (int i = 0; i < n; i++) {
            String maNSX = dsnsx[i].getMNSX();
    
            int j;
            for (j = 0; j < n; j++) {
                if (maNSX.equals(maNSXArray[j])) {
                    break;
                }
            }
    
            if (j == n) {
                maNSXArray[i] = maNSX;
                for (int k = 0; k < n; k++) {
                    if (maNSX.equals(dsnsx[k].getMNSX())) {
                        soLuongTheoNSX[i]++;
                    }
                }
                System.out.println("Ma NSX: " + maNSX + ", So luong: " + soLuongTheoNSX[i]);
            }
        }
    }
}
