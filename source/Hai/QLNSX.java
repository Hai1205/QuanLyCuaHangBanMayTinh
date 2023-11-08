import java.util.Scanner;

public class QLNSX {
    private DSNSX dsnsx;

    public QLNSX(DSNSX dsnsx)
    {
        this.dsnsx = dsnsx;
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        dsnsx.xuatFile();
        do 
        {
            System.out.println("---- Menu ----");
            System.out.println("1. xem danh sach nha san xuat");
            System.out.println("2. them 1 nha san xuat");
            System.out.println("3. xoa 1 nha san xuat");
            System.out.println("4. sua thong tin 1 nha san xuat");
            System.out.println("5. tim kiem 1 nha san xuat");
            System.out.println("6. thong ke");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    dsnsx.xuat();
                    break;
                case 2:
                    dsnsx.them();
                    break;
                case 3:
                    dsnsx.xoa();
                    break;
                case 4:
                    dsnsx.sua();
                    break;
                case 5:
                    dsnsx.timKiem();
                    break;
                case 6:
                    dsnsx.thongKe();
                    break;
                case 7:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            } 
            dsnsx.nhapFile(false);
        } while (choice != 7);
    }
}
