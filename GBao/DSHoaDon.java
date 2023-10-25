import java.util.Scanner;

public class DSHoaDon {
    private HoaDon[] danhSach;
    private int soLuong;

    public DSHoaDon(int soLuong) {
        this.soLuong = 0;
        danhSach = new HoaDon[soLuong];
    }

    public void them(HoaDon hd) {
        if (soLuong < danhSach.length) {
            danhSach[soLuong] = hd;
            soLuong++;
        }
    }

    public void xoa(int viTri) {
        if (viTri >= 0 && viTri < soLuong) {
            for (int i = viTri; i < soLuong - 1; i++) {
                danhSach[i] = danhSach[i + 1];
            }
            soLuong--;
        }
    }

    public void sua(int viTri, HoaDon hd) {
        if (viTri >= 0 && viTri < soLuong) {
            danhSach[viTri] = hd;
        }
    }

    public HoaDon timKiem(String maHoaDon) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(maHoaDon)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void xuatDanhSach() {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i] != null) {
                danhSach[i].xuat();
            }
        }
    }
    
    public void quanLyDanhSach() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Them hoa don");
            System.out.println("2. Xoa hoa don");
            System.out.println("3. Sua thong tin hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Xuat danh sach hoa don");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    HoaDon hd = new HoaDon();
                    hd.nhap();
                    them(hd);
                    break;
                case 2:
                    System.out.println("Nhap ma hoa don can xoa: ");
                    String maHD = scanner.next();
                    for (int i = 0; i < soLuong; i++) {
                        if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(maHD)) {
                            xoa(i);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma hoa don can sua: ");
                    String ma = scanner.next();
                        for (int i = 0; i < soLuong; i++) {
                            if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(ma)) {
                                        HoaDon suaHoaDon = new HoaDon();
                                        suaHoaDon.nhap();
                                        sua(i, suaHoaDon);
                            }
                        }
                    break;
                case 4:
                    System.out.println("Nhap ma hoa don can tim: ");
                    String n = scanner.next();
                    HoaDon timkiemHD = timKiem(n);
                    if (timkiemHD != null) {
                        timkiemHD.xuat();
                    } else {
                        System.out.println("Khong tim thay hoa don co ma: " + n);
                    }
                    break;
                case 5:
                    xuatDanhSach();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                    break;
                    }
                }
            }
        }