import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  
import java.util.Arrays;

public class DanhSachSanPham implements DanhSach<SanPham> {    
    private SanPham[] dssp;
    private int n;

    public DanhSachSanPham() {
        dssp= new SanPham[0];
        n = 0;
    }
    public DanhSachSanPham(int n) {
        setN(n);
        dssp = new SanPham[n];
    }
    public DanhSachSanPham(DanhSachSanPham other) {
        this.n = other.n;   
        this.dssp = Arrays.copyOf(other.dssp, n);
    }
      public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void setDanhSachSanPham(int i, SanPham value) {
        dssp[i] = value;
    }

    public void setDanhSachSanPham(int i) {
        if (dssp[i] instanceof LapTop) {
            ((LapTop) dssp[i]).nhap();
        } else if (dssp[i] instanceof PC) {
            ((PC) dssp[i]).nhap();
        }
    }
  
    public SanPham getDanhSachSanPham(int i) {
        return dssp[i];
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("so luong chi tiet san pham: ");
        n = scanner.nextInt();
    
        dssp = new SanPham[n];
        for (int i = 0; i < n; i++) {
            System.out.println("thong tin chi tiet san pham thu " + (i + 1) + ": ");
            System.out.print("Chon loai san pham (1. Laptop / 2. PC): ");
            int loaiSanPham = scanner.nextInt();
            scanner.nextLine();
    
            if (loaiSanPham == 1) {
                dssp[i] = new LapTop("", "", 0, 0, "", 0, "");
            } else if (loaiSanPham == 2) {
                dssp[i] = new PC("", "", 0, 0, "", "");
            } else {
                System.out.println("Lua chon khong hop le.");
                i--; // Nếu lựa chọn không hợp lệ, giảm giá trị của i để lặp lại vòng lặp.
            }
    
            dssp[i].nhap();
        }
    }
    @Override
    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin san pham thu " + (i + 1));
            dssp[i].xuat();
            System.out.println("--------------------------");
        }
    }
    public void nhapFile(boolean xoaHetDuLieuCu) {
        try {
            FileWriter fw = new FileWriter("output.txt", xoaHetDuLieuCu);
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
            System.out.println("Xuat file...");
    
            FileReader fr = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(fr);
    
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] txt = line.split(", ");  
                if (txt.length == 7) { 
                    String MaSP = txt[0].trim();
                    String Ten = txt[1].trim();
                    int SLCL = Integer.parseInt(txt[2].trim());
                    double DG = Double.parseDouble(txt[3].trim());
                    String DVT = txt[4].trim();
                    int pin = Integer.parseInt(txt[5].trim());
                    String styleNguoiDung = txt[6].trim();
    
                    LapTop laptop = new LapTop(MaSP, Ten, SLCL, DG, DVT, pin, styleNguoiDung);
                    them(laptop);
                } else if (txt.length == 6) { 
                    String MaSP = txt[0].trim();
                    String Ten = txt[1].trim();
                    int SLCL = Integer.parseInt(txt[2].trim());
                    double DG = Double.parseDouble(txt[3].trim());
                    String DVT = txt[4].trim();
                    String hangManHinh = txt[5].trim();
                    PC pc = new PC(MaSP, Ten, SLCL, DG, DVT, hangManHinh);
                    them(pc);
                }
            }
    
            br.close();
            fr.close();
    
            System.out.println("Hoan thanh xuat file!");
        } catch (IOException e) {  
            e.printStackTrace();
        }
    }
    
    
    public void them() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("thong tin san pham: ");
        
        System.out.print("Chon loại san pham (1. Laptop / 2. PC): ");
        int loaiSanPham = scanner.nextInt();
        scanner.nextLine();
    
        SanPham x;
    
        if (loaiSanPham == 1) {
            x = new LapTop("", "", 0, 0, "", 0, "");
        } else if (loaiSanPham == 2) {
            x = new PC("", "", 0, 0, "", "");
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
    
        x.nhap();
        them(x);
    }
    
    @Override
    public void them(SanPham x) {
        dssp = Arrays.copyOf(dssp, n + 1);
        dssp[n] = x;
        n++;
    }
    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ma san pham: ");
        String maSanPham = scanner.nextLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((dssp[i].getMaSP()).equals(maSanPham)) {
                System.out.println("found!");
                dssp[i].xuat();
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
            if ((dssp[i].getMaSP()).equals(maSanPham)) {
                return i;
            }
        }
        return -1;
    }
    public SanPham timKiem1(String maSanPham) {
        for (int i = 0; i < n; i++) {
            if ((dssp[i].getMaSP()).equals(maSanPham)) {
                return dssp[i];
            }
        }
        return null;
    }
    public DanhSachSanPham timKiem2(String maSanPham) {
        int cnt = 0;
        DanhSachSanPham ds = new DanhSachSanPham();
        for (int i = 0; i < n; i++) {
            if (dssp[i].getMaSP().equals(maSanPham)) {
                ds.them(dssp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }
    public DanhSachSanPham timKiem3(String Ten) {
        int cnt = 0;
        DanhSachSanPham ds = new DanhSachSanPham();
        for (int i = 0; i < n; i++) {
            if (dssp[i].getTen().equals(Ten)) {
                ds.them(dssp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }
    public DanhSachSanPham timKiem4(int SLCL) {
        int cnt = 0;
        DanhSachSanPham ds = new DanhSachSanPham();
        for (int i = 0; i < n; i++) {
            if (dssp[i].getSL() == SLCL) {
                ds.them(dssp[i]);
                cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }
    public DanhSachSanPham timKiem5(double DG) {
        int cnt = 0;
        DanhSachSanPham ds = new DanhSachSanPham();
        for (int i = 0; i < n; i++) {
            if (dssp[i].getDG() == DG){
            ds.them(dssp[i]); 
            cnt++;
            }
        }
        if (cnt == 0)
            return null;
        return ds;
    }
    public DanhSachSanPham timKiem6(int DVT) {
        int cnt = 0;
        DanhSachSanPham ds = new DanhSachSanPham();
        for (int i = 0; i < n; i++) {
            if (dssp[i].getDVT().equals(DVT)) {
                ds.them(dssp[i]);
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
                dssp[i] = dssp[i + 1];
            }
            dssp = Arrays.copyOf(dssp, n - 1);
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
    
            System.out.println("8. thoat");
            System.out.print("chon chuc nang (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    System.out.println("Ma San Pham: ");
                    String maSanPham = scanner.nextLine();
                    dssp[index].setMaSP(maSanPham);
                    break;
                case 2:
                    System.out.println("Ten: ");
                    String ten = scanner.nextLine();
                    dssp[index].setTen(ten);
                    break;
                case 3:
                    System.out.println("So Luong: ");
                    int SL = scanner.nextInt();
                    dssp[index].setSL(SL);
                    break;
                case 4:
                    System.out.println("Don Gia: ");
                    double DG = scanner.nextDouble();
                    dssp[index].setDG(DG);
                    break;
                case 5:
                    System.out.println("Don Vi Tinh: ");
                    String DVT = scanner.nextLine();
                    dssp[index].setDVT(DVT);
                    break;
                case 6:
                    if (dssp[index] instanceof LapTop) {
                        System.out.println("Dung Luong Pin: ");
                        int pin = scanner.nextInt();
                        ((LapTop) dssp[index]).setPin(pin);
                    } else if (dssp[index] instanceof PC) {
                        System.out.println("Hang Man Hinh: ");
                        scanner.nextLine(); 
                        String hangManHinh = scanner.nextLine();
                        ((PC) dssp[index]).setHangManHinh(hangManHinh);
                    }
                    break;
                case 7:
                    if (dssp[index] instanceof LapTop) {
                        System.out.println("Style Nguoi Dung: ");
                        String styleNguoiDung = scanner.nextLine();
                        ((LapTop) dssp[index]).setStyleNguoiDung(styleNguoiDung);
                    }
                    break;
                case 8:
                    System.out.println("Ket thuc!");
                    break;
                default:
                    System.out.println("Khong hop le!");
            }
        } while (choice != 8);
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
        System.out.println("Thong ke theo ma san pham:");

        String[] uniqueMaSPs = new String[n];
        int[] countPerMaSP = new int[n];
        int uniqueCount = 0;

        for (SanPham sanPham : dssp) {
            String maSP = sanPham.getMaSP();
            boolean found = false;

            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueMaSPs[i].equals(maSP)) {
                    countPerMaSP[i]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueMaSPs[uniqueCount] = maSP;
                countPerMaSP[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println("ma san pham: " + uniqueMaSPs[i] + ", So luong: " + countPerMaSP[i]);
        }
    }

    public SanPham[] getDanhSach() {
        return dssp;
    }
}
