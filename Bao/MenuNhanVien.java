import java.util.Scanner;

public class MenuNhanVien {
    
    private DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();

    public void MENU() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Quan Li Nhan Vien ====");
            System.out.println("1. Them Nhan Vien");
            System.out.println("2. Sua Nhan Vien");
            System.out.println("3. Xoa Nhan Vien");
            System.out.println("4. Tim Kiem Nhan Vien");
            System.out.println("5. Thong Ke Nhan Vien");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    danhSachNhanVien.them(nv);
                    break;
                case 2:
                    System.out.println("Nhap ma nhan vien can sua: ");
                    String maNhanVien = sc.next();
                    NhanVien nvSua = danhSachNhanVien.timkiem(maNhanVien);
                    if (nvSua != null) {
                        NhanVien nvMoi = new NhanVien();
                        nvMoi.nhap();
                        danhSachNhanVien.sua(nvSua, nvMoi);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVien);
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma nhan vien can xoa: ");
                    String maNhanVienXoa = sc.next();
                    NhanVien nvXoa = danhSachNhanVien.timkiem(maNhanVienXoa);
                    if (nvXoa != null) {
                        danhSachNhanVien.xoa(nvXoa);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVienXoa);
                    }
                    break;
                case 4:
                    System.out.println("Nhap ma nhan vien can tim: ");
                    String maNhanVienCanTim = sc.next();
                    NhanVien timnv = danhSachNhanVien.timkiem(maNhanVienCanTim);
                    if (timnv != null) {
                        danhSachNhanVien.timkiem(maNhanVienCanTim);
                    } else {
                        System.out.println("Khong tim thay nhan vien: " + maNhanVienCanTim);
                    }
                    break;
                    case 5:
    System.out.println("1. Nhan vien uu tu");
    System.out.println("2. Nhan vien xuat sac");
    System.out.print("Nhap lua chon cua ban: ");

    int luaChon2 = sc.nextInt();
    switch (luaChon2) {
        case 1:
            System.out.println("Danh sach Nhan vien uu tu:");
            for (NhanVien nvUt : danhSachNhanVien.danhSach) {
                danhSachNhanVien.thuongLuong(nvUt); 
                System.out.println("Ma nhan vien: " + nvUt.getMaNhanVien());
                System.out.println("Ho: " + nvUt.getHoNhanVien());
                System.out.println("Ten: " + nvUt.getTenNhanVien());
                System.out.println("Ngay sinh: " + nvUt.getNgaySinh());
                System.out.println("Luong: " + nvUt.getLuong());
            }
            break;
        case 2:
            System.out.println("Danh sach Nhan vien xuat sac:");
            for (NhanVien nvXs : danhSachNhanVien.danhSach) {
                danhSachNhanVien.thuongLuong(nvXs); 
                System.out.println("Ma nhan vien: " + nvXs.getMaNhanVien());
                System.out.println("Ho: " + nvXs.getHoNhanVien());
                System.out.println("Ten: " + nvXs.getTenNhanVien());
                System.out.println("Ngay sinh: " + nvXs.getNgaySinh());
                System.out.println("Luong: " + nvXs.getLuong());
            }
            break;
        default:
            System.out.println("Lua chon khong hop le. Vui long chon lai.");
            break;
    }
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
