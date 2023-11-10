import java.util.Scanner;

public class DSHoaDon {
    private HoaDon[] danhSach;

    public DSHoaDon() {
        danhSach = new HoaDon[0];
    }

    public void them(HoaDon hd) {
        HoaDon[] newDanhSach = new HoaDon[danhSach.length + 1];
        for (int i = 0; i < danhSach.length; i++) {
            newDanhSach[i] = danhSach[i];
        }
        newDanhSach[danhSach.length] = hd;
        danhSach = newDanhSach;
    }

    public void xoa(int viTri) {
        if (viTri >= 0 && viTri < danhSach.length) {
            HoaDon[] newDanhSach = new HoaDon[danhSach.length - 1];
            for (int i = 0; i < viTri; i++) {
                newDanhSach[i] = danhSach[i];
            }
            for (int i = viTri; i < danhSach.length - 1; i++) {
                newDanhSach[i] = danhSach[i + 1];
            }
            danhSach = newDanhSach;
        }
    }

    public void sua(int viTri, HoaDon hd) {
        if (viTri >= 0 && viTri < danhSach.length) {
            danhSach[viTri] = hd;
        }
    }

    public HoaDon timKiemMaNV(String maNhanVien) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i] != null && danhSach[i].getMaNhanVien().equals(maNhanVien)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public HoaDon timKiem(String maHoaDon) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(maHoaDon)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void xuatDanhSach() {
        for (int i = 0; i < danhSach.length; i++) {
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
        System.out.println("4. Tim kiem hoa don bang ma nhan vien");
        System.out.println("5. Tim kiem ma hoa don");
        System.out.println("6. Xuat danh sach hoa don");
        System.out.println("7. Thoat");
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
                for (int i = 0; i < danhSach.length; i++) {
                    if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(maHD)) {
                        xoa(i);
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Nhap ma hoa don can sua: ");
                String ma = scanner.next();
                for (int i = 0; i < danhSach.length; i++) {
                    if (danhSach[i] != null && danhSach[i].getMaHoaDon().equals(ma)) {
                        HoaDon suaHoaDon = new HoaDon();
                        suaHoaDon.nhap();
                        sua(i, suaHoaDon);
                        break;
                    }
                }
                break;
            case 4:
                System.out.println("Nhap ma nhan vien can tim: ");
                String m = scanner.next();
                HoaDon timkiemNV = timKiemMaNV(m);
                if (timkiemNV != null) {
                    timkiemNV.xuat();
                } else {
                    System.out.println("Khong tim thay hoa don co ma nhan vien: " + m);
                }
                break;
            case 5:
                System.out.println("Nhap ma hoa don can tim: ");
                String n = scanner.next();
                HoaDon timkiemHD = timKiem(n);
                if (timkiemHD != null) {
                    timkiemHD.xuat();
                } else {
                    System.out.println("Khong tim thay hoa don co ma: " + n);
                }
                break;
            case 6:
                xuatDanhSach();
                break;
            case 7:
                return;
            default:
                System.out.println("Lua chon khong hop le. Vui long nhap lai.");
                break;
            }
        }
    }
}