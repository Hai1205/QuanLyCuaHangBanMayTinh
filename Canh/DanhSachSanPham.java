import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements DanhSach<SanPham> {
    private SanPham[] danhSach;
    private int soLuong;

    public DanhSachSanPham() {
        danhSach = new SanPham[0];
        soLuong = 0;
    }

    
    public int getN() {
        return soLuong;
    }

    
    public void setN(int n) {
        soLuong = n;
    }

    
    public void Them(SanPham sanPham) {
        danhSach = Arrays.copyOf(danhSach, soLuong + 1);
        danhSach[soLuong] = sanPham;
        soLuong++;
    }

    
    public void Xoa(String MaSP) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSP().equals(MaSP)) {
                for (int j = i; j < soLuong - 1; j++) {
                    danhSach[j] = danhSach[j + 1];
                }
                soLuong--;
                danhSach = Arrays.copyOf(danhSach, soLuong);
                System.out.println("Da xoa san pham co ma : " + MaSP);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + MaSP);
    }

    
    public void Sua(String MaSP, SanPham sanPhamMoi) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaSP().equals(MaSP)) {
                danhSach[i] = sanPhamMoi;
                System.out.println("Da cap nhat thong tin san pham co ma: " + MaSP);
                return;
            }
        }
        System.out.println("Khong tim thay san pham co ma: " + MaSP);
    }

    
    public void TimKiem(String tenSanPham) {
        boolean found = false;
        for (SanPham sanPham : danhSach) {
            if (sanPham.getTen().equalsIgnoreCase(tenSanPham)) {
                sanPham.Xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ten: " + tenSanPham);
        }
    }

    
    public void ThongKe() {
        System.out.println("Thong ke theo ten san pham:");

        String[] uniqueMaSPs = new String[soLuong];
        int[] countPerMaSP = new int[soLuong];
        int uniqueCount = 0;

        for (SanPham sanPham : danhSach) {
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
            System.out.println("San Pham: " + uniqueMaSPs[i] + ", So luong: " + countPerMaSP[i]);
        }
    }

    
    public void GhiDuLieuVaoFile(String tenFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile))) {
            for (SanPham sanPham : danhSach) {
                if (sanPham instanceof LapTop) {
                    LapTop laptop = (LapTop) sanPham;
                    writer.println("1, " + laptop.getTen() + ", " + laptop.getSL() + ", " + laptop.getDG() + ", "
                            + laptop.getDVT() + ", " + laptop.getPin() + ", " + laptop.getStyleNguoiDung());
                } else if (sanPham instanceof PC) {
                    PC pc = (PC) sanPham;
                    writer.println("2, " + pc.getTen() + ", " + pc.getSL() + ", " + pc.getDG() + ", " + pc.getDVT()
                            + ", " + pc.getHangManHinh());
                }
            }
            System.out.println("Ghi du lieu vao file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi ghi du lieu vao file: " + e.getMessage());
        }
    }

    
    public void DocDuLieuTuFile(String tenFile) {
        try (Scanner scanner = new Scanner(new File(tenFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                int loaiSanPham = Integer.parseInt(parts[0]);

                if (loaiSanPham == 1) {
                    LapTop laptop = new LapTop(parts[1], parts[1], Integer.parseInt(parts[2]),
                            Double.parseDouble(parts[3]), parts[4], Integer.parseInt(parts[5]), parts[6]);
                    Them(laptop);
                } else if (loaiSanPham == 2) {
                    PC pc = new PC(parts[1], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]),
                            parts[4], parts[5]);
                    Them(pc);
                }
            }
            System.out.println("Doc du lieu tu file thanh cong.");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi doc du lieu tu file: " + e.getMessage());
        }
    }

    
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong san pham: ");
        int soLuongSanPham = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuongSanPham; i++) {
            System.out.println("Nhap thong tin san pham thu  " + (i + 1));
            System.out.print("Chon loai san pham (1. Laptop / 2. PC): ");
            int loaiSanPham = scanner.nextInt();
            scanner.nextLine();

            if (loaiSanPham == 1) {
                LapTop laptop = new LapTop("", "", 0, 0, "", 0, "");
                laptop.Nhap();
                Them(laptop);
            } else if (loaiSanPham == 2) {
                PC pc = new PC("", "", 0, 0, "", "");
                pc.Nhap();
                Them(pc);
            } else {
                System.out.println("Lua chon khong hop le.");
                i--;
            }
        }
    }

    
    public void Xuat() {
        for (int i = 0; i < soLuong; i++) {
            System.out.println("--------------------------");
            System.out.println("Thong tin san pham thu " + (i + 1));
            danhSach[i].Xuat();
            System.out.println("--------------------------");
        }
    }

    
    public SanPham[] getDanhSach() {
        return danhSach;
    }
}
