package danh_sach;

import thanh_phan.*;
import thuc_thi.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DSChiTietSanPham implements DanhSach<ChiTietSanPham> {
    private ChiTietSanPham[] dsctsp;
    private int n;

    private String maSanPham, maNhaSanXuat;

    public DSChiTietSanPham() {
        n = 0;
        dsctsp = new ChiTietSanPham[n];

        xuatFile();
    }

    public DSChiTietSanPham(int n) {
        setN(n);
        dsctsp = new ChiTietSanPham[n];

        xuatFile();
    }

    public DSChiTietSanPham(DSChiTietSanPham other) {
        this.n = other.n;
        this.dsctsp = Arrays.copyOf(other.dsctsp, n);

        xuatFile();
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setMSP(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setMNSX(String maNhaSanXuat) {
        this.maNhaSanXuat = maNhaSanXuat;
    }

    public void setCTSP(int i, ChiTietSanPham value) {
        dsctsp[i] = value;
    }

    public void setCTSP(int i) {
        dsctsp[i].nhap();
    }

    public int getN() {
        return n;
    }

    public ChiTietSanPham getCTSP(int i) {
        return dsctsp[i];
    }

    public void nhap() {
        Static.clearScreen();

        System.out.print("So luong chi tiet san pham: ");
        int m = Static.checkInputIsInt();
        Static.scanner.nextLine();

        for (int i = 0; i < m; i++) {
            them();
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin chi tiet san pham thu " + (i + 1) + ": ");
            dsctsp[i].xuat();
        }
    }

    public void nhapFile(boolean khongXoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("../src/data_base/DSChiTietSanPham.txt", khongXoaHetDuLieuCu);
            BufferedWriter bw = new BufferedWriter(fw);
            for (ChiTietSanPham i : dsctsp) {
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
            FileReader fr = new FileReader("../src/data_base/DSChiTietSanPham.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                if (txt.length == 8) {
                    String maSanPham = txt[0].trim();
                    String maNhaSanXuat = txt[1].trim();
                    String RAM = txt[2].trim();
                    String ROM = txt[3].trim();
                    String CPU = txt[4].trim();
                    String graphicCard = txt[5].trim();
                    String OS = txt[6].trim();
                    String namSanXuat = txt[7].trim();
                    them(new ChiTietSanPham(maSanPham, maNhaSanXuat, RAM, ROM, CPU, graphicCard, OS, namSanXuat));
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

        dsctsp = Arrays.copyOf(dsctsp, n + 1);
        System.out.println("thong tin chi tiet san pham: ");
        dsctsp[n] = new ChiTietSanPham();
        dsctsp[n].setMSP(maSanPham);
        dsctsp[n].setMNSX(maNhaSanXuat);
        dsctsp[n++].nhap();
        
        nhapFile(false);
    }

    public void them(ChiTietSanPham x) {
        dsctsp = Arrays.copyOf(dsctsp, n + 1);
        dsctsp[n++] = x;
        nhapFile(false);
    }

    public void timKiem() {
        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();

        int index = timKiem(maSanPham);
        dsctsp[index].xuat();
        if (index == -1) {
            System.out.println("Khong hop le!");
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

    public ChiTietSanPham timKiemCTSPtheoMSP(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getMSP()).equals(maSanPham)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoMNSX(String maNhaSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getMNSX()).equals(maNhaSanXuat)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoRAM(String RAM) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getRAM()).equals(RAM)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoCPU(String CPU) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getCPU()).equals(CPU)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoROM(String ROM) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getROM()).equals(ROM)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoGC(String graphicCard) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getGC()).equals(graphicCard)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoOS(String OS) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getOS()).equals(OS)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham timKiemCTSPtheoTGSX(String namSanXuat) {
        for (int i = 0; i < n; i++) {
            if ((dsctsp[i].getNamSanXuat()).equals(namSanXuat)) {
                return dsctsp[i];
            }
        }
        return null;
    }

    public ChiTietSanPham[] timKiemDStheoMSP(String maSanPham) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getMSP().equals(maSanPham)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoMNSX(String maNhaSanXuat) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getMNSX().equals(maNhaSanXuat)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoRAM(String RAM) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getRAM().equals(RAM)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoCPU(String CPU) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getCPU().equals(CPU)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoROM(String ROM) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getROM().equals(ROM)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoGC(String graphicCard) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getGC().equals(graphicCard)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoOS(String OS) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getOS().equals(OS)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public ChiTietSanPham[] timKiemDStheoTGSX(String namSanXuat) {
        int count = 0;
        ChiTietSanPham[] ds = new ChiTietSanPham[n];
        for (int i = 0; i < n; i++) {
            if (dsctsp[i].getNamSanXuat().equals(namSanXuat)) {
                ds[count++] = dsctsp[i];
            }
        }
        if (count == 0)
            return null;
        return Arrays.copyOf(ds, count);
    }

    public void xoa() {
        Static.clearScreen();

        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();

        int index = timKiem(maSanPham);
        if (index == -1) {
            System.out.println("Khong hop le!");
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
            System.out.println("Khong hop le!");
        }
        nhapFile(false);
    }
    

    public void xoa(String maSanPham) {
        int index = timKiem(maSanPham);
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
            System.out.println("1. Ma san pham");
            System.out.println("2. RAM");
            System.out.println("3. CPU");
            System.out.println("4. Hard disk");
            System.out.println("5. Graphic card");
            System.out.println("6. OS");
            System.out.println("7. Ma nha san xuat");
            System.out.println("8. Thoi gian san xuat");
            System.out.println("9. Thoat");
            System.out.print("Chon chuc nang (1-9): ");
            choice = Static.scanner.nextInt();
            Static.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ma nha san xuat: ");
                    String maSanPham = Static.scanner.nextLine();
                    dsctsp[index].setMSP(maSanPham);
                    break;
                case 2:
                    System.out.println("RAM: ");
                    String RAM = Static.scanner.nextLine();
                    dsctsp[index].setRAM(RAM);
                    break;
                case 3:
                    System.out.println("CPU: ");
                    String CPU = Static.scanner.nextLine();
                    dsctsp[index].setCPU(CPU);
                    break;
                case 4:
                    System.out.println("Dung luong o cung: ");
                    String ROM = Static.scanner.nextLine();
                    dsctsp[index].setROM(ROM);
                    break;
                case 5:
                    System.out.println("Card do hoa: ");
                    String graphicCard = Static.scanner.nextLine();
                    dsctsp[index].setGC(graphicCard);
                    break;
                case 6:
                    System.out.println("He dieu hanh: ");
                    String OS = Static.scanner.nextLine();
                    dsctsp[index].setOS(OS);
                    break;
                case 7:
                    System.out.println("Ma nha san xuat: ");
                    String maNhaSanXuat = Static.scanner.nextLine();
                    dsctsp[index].setMNSX(maNhaSanXuat);
                    break;
                case 8:
                    System.out.println("Nam san xuat: ");
                    String namSanXuat = Static.scanner.nextLine();
                    dsctsp[index].setNamSanXuat(namSanXuat);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("khong hop le!");
            }
        } while (choice != 9);
        nhapFile(false);
    }

    public void sua() {
        Static.clearScreen();

        System.out.print("Ma san pham: ");
        String maSanPham = Static.scanner.nextLine();
        int index = timKiem(maSanPham);
        if (index == -1) {
            System.out.println("Khong hop le!");
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
        Static.clearScreen();
        
        System.out.println("Tong so san pham: " + n);
        
        System.out.println("Thong ke theo nha san xuat:");
        thongKeTheoThuocTinh("MNSX");
    
        System.out.println("Thong ke theo loai CPU:");
        thongKeTheoThuocTinh("CPU");
    
        System.out.println("Thong ke theo he dieu hanh:");
        thongKeTheoThuocTinh("He dieu hanh");
    }
    
    private void thongKeTheoThuocTinh(String thuocTinh) {
        String[] thuocTinhArray = new String[n];
        for (int i = 0; i < n; i++) {
            switch (thuocTinh) {
                case "MNSX":
                    thuocTinhArray[i] = dsctsp[i].getMNSX();
                    break;
                case "CPU":
                    thuocTinhArray[i] = dsctsp[i].getCPU();
                    break;
                case "OS":
                    thuocTinhArray[i] = dsctsp[i].getOS();
                    break;
            }
        }
    
        Arrays.sort(thuocTinhArray);
    
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (thuocTinhArray[i].equals(thuocTinhArray[i - 1])) {
                count++;
            } else {
                System.out.println(thuocTinh + ": " + thuocTinhArray[i - 1] + ", So luong: " + count);
                count = 1;
            }
        }
        System.out.println(thuocTinh + ": " + thuocTinhArray[n - 1] + ", So luong: " + count);
    }
}
