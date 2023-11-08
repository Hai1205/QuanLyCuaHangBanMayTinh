import java.util.Scanner;

public class QLCTSP {
    private DSCTSP dsctsp;

    public QLCTSP(DSCTSP dsctsp)
    {
        this.dsctsp = dsctsp;
    }

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        dsctsp.xuatFile();
        do 
        {
            System.out.println("---- Menu ----");
            System.out.println("1. xem danh sach chi tiet san pham");
            System.out.println("2. them 1 chi tiet san pham");
            System.out.println("3. xoa 1 chi tiet san pham");
            System.out.println("4. sua thong tin 1 chi tiet san pham");
            System.out.println("5. tim kiem 1 chi tiet san pham");
            System.out.println("6. thong ke");
            System.out.println("7. thoat");
            System.out.print("chon chuc nang (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    dsctsp.xuat();
                    break;
                case 2:
                    dsctsp.them();
                    break;
                case 3:
                    dsctsp.xoa();
                    break;
                case 4:
                    dsctsp.sua();
                    break;
                case 5:
                    dsctsp.timKiem();
                    break;
                case 6:
                    dsctsp.thongKe();
                    break;
                case 7:
                    System.out.println("ket thuc!");
                    break;
                default:
                    System.out.println("khong hop le!");
            } 
            dsctsp.nhapFile(false);
        } while (choice != 7);
    }
}
