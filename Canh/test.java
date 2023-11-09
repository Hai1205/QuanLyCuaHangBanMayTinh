public class test {
    public static void main(String[] args) {
        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
        Menu menu = new Menu();

        SanPham sp1 = new LapTop("1", "Laptop Acer", 5, 800, "Chiec", 6500, "GM");
        SanPham sp16 = new LapTop("16", "Laptop Acer", 5, 4600, "Chiec", 6500, "GM");

        SanPham sp2 = new PC("2", "PC Gaming", 3, 1500, "Bo", "LG");
        SanPham sp3 = new LapTop("3", "Dell XPS", 2, 1200, "Chiec", 6500, "GM");
        SanPham sp4 = new PC("4", "PC Workstation", 1, 2500, "Bo", "MS");
        SanPham sp5 = new LapTop("5", "HP Envy", 4, 1000, "Chiec", 6500, "GM");
        SanPham sp6 = new PC("6", "PC Office", 6, 800, "Bo", "NH");
        SanPham sp7 = new LapTop("7", "Asus ROG", 3, 2000, "Chiec", 7503, "GM");
        SanPham sp8 = new PC("8", "PC Mini", 2, 600, "Bo", "HJIWAD");
        SanPham sp9 = new LapTop("9", "MacBook Air", 8, 1200, "Chiec", 71000, "GM");
        SanPham sp10 = new PC("10", "PC Home", 5, 700, "Bo", "GƯUID");
        SanPham sp11 = new LapTop("11", "Lenovo ThinkPad", 2, 1300, "Chiec", 8700, "GM");
        SanPham sp12 = new PC("12", "PC All-in-One", 3, 1000, "Bo", "AEFG");
        SanPham sp13 = new LapTop("13", "Surface Laptop", 4, 1500, "Chiec", 1250, "GM");
        SanPham sp14 = new PC("14", "PC Server", 1, 3000, "Bo", "ETG");
        SanPham sp15 = new LapTop("15", "MSI Gaming Laptop", 6, 1800, "Chiec", 1200, "GM");

        danhSachSanPham.Them(sp1);
        danhSachSanPham.Them(sp2);
        danhSachSanPham.Them(sp3);
        danhSachSanPham.Them(sp4);
        danhSachSanPham.Them(sp5);
        danhSachSanPham.Them(sp6);
        danhSachSanPham.Them(sp7);
        danhSachSanPham.Them(sp8);
        danhSachSanPham.Them(sp9);
        danhSachSanPham.Them(sp10);
        danhSachSanPham.Them(sp11);
        danhSachSanPham.Them(sp12);
        danhSachSanPham.Them(sp13);
        danhSachSanPham.Them(sp14);
        danhSachSanPham.Them(sp15);
        danhSachSanPham.Them(sp16);


        //danhSachSanPham.Xuat();

        danhSachSanPham.GhiDuLieuVaoFile("output.txt");
        
        menu.docDuLieuTuFile("output.txt");
        
        menu.hienThiMenu();
    }
}
