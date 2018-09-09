package oop;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        * Khoi tao
        * */
        DanhSachSinhVien dssv = new DanhSachSinhVien(15);
        dssv.init();
        System.out.println("Danh Sach Sinh Vien:");
        dssv.inDanhSachSinhVien();
        /*
        * danh sach khen thuong
        * */
        System.out.print("\n\nSo Sinh Vien Khen Thuong: ");
        System.out.println(dssv.getSoSinhVienKhenThuong());
        System.out.println("\nDS Khen Thuong: ");
        SinhVien[] dssvkt = dssv.getDSSVKhenThuong();
        for (SinhVien sv : dssvkt) {
            System.out.println(sv);
        }
        System.out.print("\nTong tien thuong: ");
        DecimalFormat df = new DecimalFormat("###,###");
        String tt = df.format(dssv.getTongTienKhenThuong());
        System.out.println(tt);

        /*
        * Sap Xep theo ten
        * */
        System.out.println("\nSap Xep Theo Ten:");
        dssv.sapXepDSSVByTen();
        dssv.inDanhSachSinhVien();

        /*
        * Sap xep diemtb
        * */
        System.out.println("\nSap Xep Teo Diem TB:");
        dssv.sapXepDSSVByDiemTB();
        dssv.inDanhSachSinhVien();

        /*
        * THEM
        * Tao sinh vien moi khg can masv, masv anh cho tao tu dong khg trung roi
        *
        * */
        SinhVien sv1= new SinhVien("Nam", "Hoa","Nu",7.0f,7.0f,7.0f,7.0f);
        if(dssv.themSinhVien(sv1))
            System.out.println("Da Them");
        else
            System.out.println("Mang Day");
        /*
        * Xoa
        * */
        System.out.print("\nNhap ma SV can xoa: ");
        Scanner sc = new Scanner(System.in);
        String mssv = sc.nextLine();
        if (dssv.xoaSinhVien(mssv))
            System.out.println("Da Xoa");
        else System.out.println("Ma SV khg ton tai");
        dssv.inDanhSachSinhVien();


        /*
        * Sua
        * viet cai ham nhap thong tin sinh vien nha
        * */
        SinhVien sv = new SinhVien("00001", "Tran","Tam","Nam",8.0f,7.0f,2.0f,4.0f);
        System.out.println("\nSua Thong Tin SV: ");
        if (dssv.capNhatSinhVien(sv.getMssv(),sv))
            System.out.println("Da Sua");
        else System.out.println("Ma SV khg ton tai");
        dssv.inDanhSachSinhVien();
    }
}
