import java.util.Scanner;

class MenuNV extends DSNV{
    public void MENU(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Quan Li Nhan Vien ====");
            System.out.println("1. Them Nhan Vien");
            System.out.println("2. Sua Nhan Vien");
            System.out.println("3. Xoa Nhan Vien");
            System.out.println("4. Tim Kiem Nhan Vien");
            System.out.println("5. Thong Ke Nhan Vien"); 
            // Thêm nhân viên ưu tứu thưởng thêm 10% lương(bán được 20 hóa đơn 1 ngày )
            // Thêm nhân viên xuất sắc thưởng thêm 20% lương (bán được 50 hóa đơn 1 ngày) 
            // Nhân viên có nhiều hóa đơn nhất thưởng thêm 10% lương
            // Nhân viên có ít hóa đơn nhất 
            // Nhân viên nghỉ có phép (Không nhận lương ngày nghỉ)
            // Nhân viên nghỉ không phép (trừ x2 lương ngày nghỉ)

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

