package controller;



import model.DuAn;
import model.NhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        ArrayList<NhanVien> nhanvienList = new ArrayList<>();
        ArrayList<DuAn> duAnList = new ArrayList<>();
        int testNhapNhanVien=0;
        while (true) {
            int x=0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Chon 1 : de quan ly nhan vien");
            System.out.println("Chon 2 : de quan ly Du An");
            if(testNhapNhanVien==1)
            {
                System.out.println("Chon 3 :de quan ly Task");
            }
            System.out.println("Ban chon la: ");
            x=sc.nextInt();
            switch (x)
            {
                case 1: nhanVien(nhanvienList);
                    testNhapNhanVien=1;
                    break;
                case 2: duAn(duAnList);
                    break;
                case 3: Task(nhanvienList);
                default:break;
            }

        }
    }
    public static void nhanVien(ArrayList<NhanVien> nhanVienList)
    {
        NhanVienQuanLy quanlyNhanVien=new NhanVienQuanLy();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int flag=0;
            System.out.println("##########Dang QUAN LY NHAN VIEN##########  ");
            System.out.println("Chon (1) de co the nhap vo thong tin cua mot nhan vien:");
            System.out.println("Chon (2) de co the xuat ra toan bo nhan vien trong list");
            System.out.println("Chon (3) de thoat");
            int s=sc.nextInt();
            switch (s) {
                case 1:
                    quanlyNhanVien.nhapNhanVien(nhanVienList);
                    break;
                case 2:
                    quanlyNhanVien.hienthiNhanVienList(nhanVienList);
                    break;
                case 3:flag=1;
                    break;
                default:break;
            }
            if(flag==1) break;
        }
    }
    public static void duAn(ArrayList<DuAn> duAnList)
    {
        DuAnQuanLy quanlyDuAn=new DuAnQuanLy();
        Scanner sc = new Scanner(System.in);
        int k;
        while (true) {
            System.out.println("##########Dang QUAN LY DU AN##########  ");
            System.out.println("Chon (1) de co the nhap vo mot du an:");
            System.out.println("Chon (2) de co the xuat ra toan bo du an trong list");
            System.out.println("Chon (3) de co the chinh sua du an");
            System.out.println("Chon (4) de Thoat");
            k = sc.nextInt();
            int flag=0;
            switch (k) {
                case 1:
                    quanlyDuAn.nhapDuAn(duAnList);
                    break;
                case 2:
                    quanlyDuAn.hienThiDuAn(duAnList);
                    break;
                case 3:
                    quanlyDuAn.chinhSuaDuAn(duAnList);
                    break;
                case 4:
                    flag=1;
                    break;
                default:break;
            }
            if(flag==1) break;
        }
    }
    public static void Task(ArrayList<NhanVien> nhanVienList)
    {
        TaskQuanLy task=new TaskQuanLy();
        System.out.println("#### QUAN LY STARK########");
        task.nhapTask(nhanVienList);
    }
}
