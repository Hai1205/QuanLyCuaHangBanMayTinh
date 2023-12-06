package thuc_thi;

import java.io.*;
import danh_sach.*;
import quan_ly.*;
import java.util.Scanner;

public class TaiKhoan {
    private DSSanPham dssp;
    private DSKhachHang dskh;

    private QLHoaDon qlhd;
    private QLPhieuNhapHang qlpnh;
    private QLPhieuBaoHanh qlpbh;
    private QLNhanVien qlnv;
    private QLNhaSanXuat qlnsx;
    private QLSanPham qlsp;
    private QLKhachHang qlkh;

    private String username, password, maKhachHang;

    public TaiKhoan() {
        dssp = new DSSanPham();
        dskh = new DSKhachHang();

        qlhd = new QLHoaDon();
        qlpnh = new QLPhieuNhapHang();
        qlpbh = new QLPhieuBaoHanh();
        qlnv = new QLNhanVien();
        qlnsx = new QLNhaSanXuat();
        qlsp = new QLSanPham(dssp);
        qlkh = new QLKhachHang(dskh);
    }

    public void menu() {
        int luaChon;
        do {
            Static.clearScreen();

            System.out.println("---- Menu ----");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky");
            System.out.println("3. Thoat");
            System.out.print("Chon chuc nang (1-3): ");
            luaChon = Static.checkInputIsInt();
            Static.scanner.nextLine();

            switch (luaChon) {
                case 1:
                    dangNhap();
                    break;
                case 2:
                    dangKy();
                    break;
                case 3:
                    System.out.println("Chuong trinh ket thuc!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
            }
        } while (luaChon != 3);
    }

    private void dangNhap() {
        Static.clearScreen();

        String Username, Password;

        System.out.println("---- Dang nhap ----");
        do {
            System.out.print("Ten dang nhap: ");
            Username = Static.scanner.nextLine();

            if (Username.isEmpty()) {
                System.out.println("Ten dang nhap khong duoc de trong! Xin nhap lai!");
            } else if (checkSpace(Username)) {
                System.out.println("Ten dang nhap khong duoc co khoang trang! Xin nhap lai!");
            } else if (!checkUsername(Username)) {
                System.out.println("Ten dang nhap khong dung! Xin nhap lai!");
            }
        } while (Username.isEmpty() || checkSpace(Username) || !checkUsername(Username));

        do {
            System.out.print("Mat khau: ");
            Password = Static.scanner.nextLine();

            if (Password.isEmpty()) {
                System.out.println("Mat khau khong duoc de trong! Xin nhap lai!");
            } else if (checkSpace(Password)) {
                System.out.println("Mat khau khong duoc co khoang trang! Xin nhap lai!");
            } else if (!(Password.equals(password))) {
                System.out.println("Mat khau khong dung! Xin nhap lai!");
            }
        } while (Password.isEmpty() || checkSpace(Password) || !(Password.equals(password)));


        if (maKhachHang.equals("null")) {
            admin();
        } else {
            user();
        }
    }

    private void dangKy() {
        Static.clearScreen();

        System.out.println("---- Dang ky ----");
        do {
            System.out.print("Ten dang nhap: ");
            username = Static.scanner.nextLine();
    
            if (username.isEmpty()) {
                System.out.println("Ten dang nhap khong duoc de trong! Xin nhap lai!");
            } else if (checkSpace(username)) {
                System.out.println("Ten dang nhap khong duoc co khoang trang! Xin nhap lai!");
            } else if (checkUsername(username)) {
                System.out.println("Ten dang nhap da duoc su dung! Xin nhap lai!");
            }
        } while (username.isEmpty() || checkSpace(username) || checkUsername(username));
    
        setPassword();
    
        boolean daTonTai;
        do {
            System.out.print("Ma khach hang: ");
            maKhachHang = Static.scanner.nextLine();
            daTonTai = (dskh.timKiem(maKhachHang) != -1);
    
            if (daTonTai) {
                System.out.println("Ma khach hang da duoc su dung! Xin nhap lai!");
            }
        } while (daTonTai);
        dskh.setMKH(maKhachHang);
        dskh.them();
    
        System.out.println("Dang ky thanh cong!");
    
        nhapFile(username, password, maKhachHang, true);
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setPassword() {
        String rePassword;

        do {
            System.out.print("Mat khau: ");
            setPassword(Static.scanner.nextLine());
    
            if (password.isEmpty()) {
                System.out.println("Mat khau khong duoc de trong! Xin nhap lai!");
            } else if (checkSpace(password)) {
                System.out.println("Mat khau khong duoc co khoang trang! Xin nhap lai!");
            }
        } while (password.isEmpty() || checkSpace(password));
    
        do {
            System.out.print("Nhap lai mat khau: ");
            rePassword = Static.scanner.nextLine();
    
            if (rePassword.isEmpty()) {
                System.out.println("Vui long nhap lai mat khau!");
            } else if (checkSpace(rePassword)) {
                System.out.println("Mat khau khong duoc co khoang trang! Xin nhap lai!");
            } else if (!password.equals(rePassword)) {
                System.out.println("Mat khau nhap lai khong khop! Xin nhap lai!");
            }
        } while (rePassword.isEmpty() || checkSpace(rePassword) || !password.equals(rePassword));

    }

    private void admin() {
            int choice;
            do 
            {
                Static.clearScreen();

                System.out.println("---- " + username + " ----");
                System.out.println("1. San pham");
                System.out.println("2. Bao hanh");
                System.out.println("3. Nhan vien");
                System.out.println("4. Khach hang");
                System.out.println("5. Nha san xuat");
                System.out.println("6. Nhap hang");
                System.out.println("7. Hoa don");
                System.out.println("8. Dang xuat");
                System.out.print("chon chuc nang (1-8): ");
                choice = Static.checkInputIsInt();
                Static.scanner.nextLine();
    
                switch (choice) 
                {
                    case 1:
                        qlsp.menu();
                        break;
                    case 2:
                        qlpbh.menu();
                        break;
                    case 3:
                        qlnv.menu();
                        break;
                    case 4:
                        qlkh.menu();
                        break;
                    case 5:
                        qlnsx.menu();
                        break;
                    case 6:
                        qlpnh.menu();
                        break;
                    case 7:
                        qlhd.menu();
                    case 8:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon lai!");
                } 
            } while (choice != 8);
    }

    private void user() {
        int index = dskh.timKiem(maKhachHang);

        int luaChon;
            do {
                Static.clearScreen();
                
                System.out.println("---- " + username + " ----");
                System.out.println("1. Xem cac san pham hien co trong cua hang");
                System.out.println("2. Mua hang");
                System.out.println("3. Cai dat");
                System.out.println("4. Dang xuat");
                System.out.print("Chon chuc nang (1-4): ");
                luaChon = Static.checkInputIsInt();
                Static.scanner.nextLine();

                switch (luaChon) {
                    case 1:
                        dssp.xuat();
                    case 2:
                        qlhd.setMKH(maKhachHang);
                        qlhd.menu();
                        break;
                    case 3:
                        Static.clearScreen();
                        do {
                            System.out.println("---- Cai dat ----");
                            System.out.println("1. Thong tin");
                            System.out.println("2. Sua thong tin");
                            System.out.println("3. Thoat");
                            System.out.print("Chon chuc nang (1-3): ");
                            luaChon = Static.checkInputIsInt();
                            Static.scanner.nextLine();

                            switch (luaChon) {
                                case 1:
                                    dskh.getKH(index).xuat();
                                    break;
                                case 2:
                                    dskh.sua(maKhachHang);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Lua chon khong hop le! Vui long chon lai!");
                            }
                        } while (luaChon != 3);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon lai!");
                }
            } while (luaChon != 4);
    }
    
    public boolean checkSpace(String str) {
        return str != null && str.contains(" ");
    }
    
    private boolean checkUsername(String username) {
        try (Scanner scanner = new Scanner(new File("../src/data_base/DSTaiKhoan.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length > 0 && parts[0].equals(username)) {
                    setUsername(parts[0]);
                    setPassword(parts[1]);
                    setMaKhachHang(parts[2]);
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void nhapFile(String username, String password, String maKhachHang, boolean khongXoaHet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("../src/data_base/DSTaiKhoan.txt", khongXoaHet))) {
            writer.write(username + ", " + password + ", " + maKhachHang);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
