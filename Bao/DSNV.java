import java.util.Scanner;

 public class DSNV {
    private NhanVien[] danhSach;
    private int soLuong;

    public DSNV(int soLuong) {
        this.soLuong = 0;
        danhSach = new NhanVien[soLuong];
    }


   public void them(NhanVien nv){
    if (soLuong < danhSach.length){
        danhSach[soLuong] = nv;
        soLuong++;
    }
   }

   public void xoa(int viTri){
    if (viTri >= 0 && viTri < soLuong){
        for (int i = viTri; i < soLuong; i++){
            danhSach[i] = danhSach[i+1];
        }
        soLuong--;
    }
   }

   public void sua(int viTri, NhanVien nv){
        if (viTri >=0 && viTri < soLuong){
            danhSach [viTri] = nv;
        }
   }

   public NhanVien timkiem(String maNv){
    for (int i=0; i< soLuong; i++){
        if (danhSach[i] != null && danhSach[i].getMaNV().equals(maNv)){
            return danhSach[i];
        }
    }
    return null;
   }


    public void xuatdanhsach(){
        for (int i=0; i<soLuong; i++){
            if (danhSach[i] != null){
                danhSach[i].xuat();
            }
        }
    }


    public void QuanLiNhanVien(){
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
                   System.out.println("Nhap ma nhan vien can xoa: ");
                   String maNhanVien1 = sc.next();
                   for (int i=0; i< soLuong; i++){
                    if (danhSach[i] != null && danhSach[i].getMaNV().equals(maNhanVien1)){
                        xoa(i);
                    }
                   }
                    break;
                case 3:
                   System.out.println("Nhap ma nhan vien can sua: ");
                   String maNhanVien2 = sc.next();
                   for (int i = 0; i < soLuong; i++){
                    if (danhSach[i] != null && danhSach[i].getMaNV().equals(maNhanVien2)){
                        NhanVien suaNhanVien = new NhanVien();
                        suaNhanVien.nhap();
                        sua(i, suaNhanVien);
                    }
                   }
                    break;
                case 4:
                    System.out.println("Nhap ma nhan vien can tim: ");
                    String maNhanVien3 = sc.next();
                    NhanVien timkiemNV = timkiem(maNhanVien3);
                if (timkiemNV != null) {
                    timkiemNV.xuat();
                } else {
                    System.out.println("Khong tim thay nhan vien: " + maNhanVien3);
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

