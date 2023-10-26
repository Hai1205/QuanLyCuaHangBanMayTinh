import java.util.Scanner;

public class DSNV {
    private NhanVien[] danhSach;

    public DSNV() {
        danhSach = new NhanVien[0];
    }

    public void them(NhanVien nv) {
        int size = danhSach.length;
        NhanVien[] temp = new NhanVien[size + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = danhSach[i];
        }
        temp[size] = nv;
        danhSach = temp;
    }

    public void xoa(NhanVien nv) {
        int index = timViTri(nv);
        if (index != -1) {
            int size = danhSach.length - 1;
            NhanVien[] temp = new NhanVien[size];
            for (int i = 0; i < index; i++) {
                temp[i] = danhSach[i];
            }
            for (int i = index + 1; i < size + 1; i++) {
                temp[i - 1] = danhSach[i];
            }
            danhSach = temp;
        }
    }

    public void sua(NhanVien nv, NhanVien nvMoi) {
        int index = timViTri(nv);
        if (index != -1) {
            danhSach[index] = nvMoi;
        }
    }

    public NhanVien timkiem(String maNv) {
        for (NhanVien nv : danhSach) {
            if (nv.getMaNV().equals(maNv)) {
                return nv;
            }
        }
        return null;
    }

    public void xuatdanhsach() {
        for (NhanVien nv : danhSach) {
            nv.xuat();
        }
    }

    private int timViTri(NhanVien nv) {
        for (int i = 0; i < danhSach.length; i++) {
            if (danhSach[i].getMaNV().equals(nv.getMaNV())) {
                return i;
            }
        }
        return -1;
    }

    public void QuanLiNhanVien() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Quan Li Nhan Vien ====");
            System.out.println("1. Them Nhan Vien");
            System.out.println("2. Sua Nhan Vien");
            System.out.println("3. Xoa Nhan Vien");
            System.out.println("4. Tim Kiem Nhan Vien");
            System.out.println("5. Hien Thi Danh Sach Nhan Vien");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
    
            int luaChon = sc.nextInt();
    
            switch (luaChon) {
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    them(nv);
                    break;
                case 2:
                    System.out.println("Nhap ma nhan vien can sua: ");
                    String maNhanVien = sc.next();
                    NhanVien nvSua = timkiem(maNhanVien);
                    if (nvSua != null) {
                        NhanVien nvMoi = new NhanVien();
                        nvMoi.nhap();
                        sua(nvSua, nvMoi);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVien);
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma nhan vien can xoa: ");
                    String maNhanVienXoa = sc.next();
                    NhanVien nvXoa = timkiem(maNhanVienXoa);
                    if (nvXoa != null) {
                        xoa(nvXoa);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVienXoa);
                    }
                    break;
                case 4:
                    System.out.println("Nhap ma nhan vien can tim: ");
                    String maNhanVienCanTim = sc.next();
                    NhanVien timnv = timkiem(maNhanVienCanTim);
                    if (timnv != null) {
                        timkiem(maNhanVienCanTim);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVienCanTim);
                    }
                    break;
                case 5: 
                    xuatdanhsach();
                    break;
                case 6:
                    System.out.println("Ket thuc chuong trinh.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
    }
}
    
