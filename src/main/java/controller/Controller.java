package controller;



import model.DuAn;
import model.NhanVien;
import model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    ///////NHAN VIEN////////////////////////
    Scanner scanner=new Scanner(System.in);


    public void nhapNhanVien(ArrayList<NhanVien> nhanVienList) {
        NhanVien nhanvien=new NhanVien();
        Task task= new Task();
        System.out.println("Moi ban nhap ten nhan vien:");
        nhanvien.setTen(scanner.nextLine().trim());
        while(true) {
            boolean nhanVienIDFlags=false;
            System.out.println("Moi ban nhap ID:");
            String iDNhanVien=scanner.nextLine();
            for(NhanVien nhanv : nhanVienList ) {
                if(nhanv.getID().equals(iDNhanVien))
                {
                    nhanVienIDFlags=true;
                    break;
                }
            }
            if(nhanVienIDFlags)
            {
                System.out.println("MA ID ko hop le vi da bi trung");
                continue;
            }
            else
            {
                nhanvien.setID(iDNhanVien);
                break;
            }
        }

        System.out.println("Nhap luong cua nhan vien");
        nhanvien.setLuong(scanner.nextInt());
        System.out.println("Moi ban nhap gioi tinh: (F/M)");
        scanner.nextLine();
        nhanvien.setGioiTinh(scanner.nextLine().trim());
        nhanVienList.add(nhanvien);
    }


    public void hienthiNhanVienList(ArrayList <NhanVien> nhanvienList) {

        for(NhanVien nhanv:nhanvienList) {
            System.out.println("ID:"+nhanv.getID());
            System.out.println("Ten nhan vien:"+  nhanv.getTen());
            System.out.println("Gioi tinh (F/M):"+ nhanv.getGioiTinh());
            System.out.println("Luong :"+  nhanv.getLuong());
            System.out.println("#############################################");

        }
    }


    public void themNhanVien() {


    }


    public void xoaNhanVien() {

    }

    ///////DU AN///////////////////

    Date nowtime=new Date();
    String deadlineInput;


    public void nhapDuAn(ArrayList<DuAn> duAnList) {
        DuAn duan=new DuAn();
        while (true)
        {
            boolean idFlags=false;
            System.out.println("Moi ban nhap ID du an");
            String MaID=scanner.nextLine();
            for(DuAn duAnll: duAnList)
            {
                if(duAnll.getID().equals(MaID))
                {
                    idFlags=true;
                    break;
                }
            }
            if(idFlags==true)
            {
                System.out.println("Id ban nhap khong hop le");
                continue;
            }
            else {
                duan.setID(MaID);
                break;
            }
        }
        System.out.println("Moi ban nhap ten Du An: ");
        duan.setTenDuAn(scanner.nextLine());
        System.out.println("Deadline cua du an theo yyyy/mm/dd:");
        duan.setDateLine(scanner.nextLine());
        deadlineInput=duan.getDateLine();
        // DateAndTime.stringToDate(deadlineInput);
        DateAndTime.trim(nowtime);
        duAnList.add(duan);
    }


    public void hienThiDuAn(ArrayList<DuAn> duAnList) {
        for(DuAn duAnll: duAnList) {
            System.out.println("Id cua du an la :"+duAnll.getID());
            System.out.println("Ten cua du an la:"+duAnll.getTenDuAn());
            System.out.println("Deadline cua du an la:"+duAnll.getDateLine());
            System.out.println("#################################################");
        }

    }


    public void chinhSuaDuAn(ArrayList<DuAn> duAnList) {
        while (true) {
            System.out.println("Moi ban nhap ID cua du an ma muon chinh sua ?");
            String indexID=scanner.nextLine().trim();
            scanner.nextLine();
            for (DuAn duAnll : duAnList) {
                if (indexID.equals(duAnll.getID())) {
                    while (true)
                    {
                        System.out.println("Ban muon chinh sua thong tin gi cua du an?:");
                        System.out.println("Chon (1) neu chinh sua ten");
                        System.out.println("Chon (2) neu chinh sua  ID");
                        System.out.println("Chon (3) neu chinh sua Deadline");
                        System.out.println("Chon (4) THOAT");
                        System.out.print("Ban chon la: ");
                        int o=scanner.nextInt();
                        int flagOut=0;
                        switch (o)
                        {
                            case 1:
                                System.out.println("Moi ban nhap ten Du An: ");
                                scanner.nextLine();
                                duAnll.setTenDuAn(scanner.nextLine().trim());
                                break;
                            case 2:
                                System.out.println("Moi ban nhap ID du an");
                                duAnll.setID(scanner.nextLine().trim());
                                break;
                            case 3:
                                System.out.println("Deadline cua du an theo yyyy/mm/dd:");
                                duAnll.setDateLine(scanner.nextLine().trim());
                            case 4:
                                flagOut=1;
                                break;
                            default:break;
                        }
                        if(flagOut==1) break;
                    }
                } else {
                    System.out.println("Error######, khong co du an nay");
                    break;
                }

            }
            System.out.println("Thoat chuong trinh chinh sua?(y/n):");
            char contin=scanner.next().charAt(0);
            if(contin=='n')
            {
                continue;
            }
            else break;

        }

    }
////////// TASK////////////////////

    public void nhapTask(ArrayList <NhanVien> nhanvienList) {

        Task task= new Task();
        int k=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ten task: ");
        task.setTaskTitle(scanner.nextLine().trim());
        System.out.println("Nhap ID task:");
        task.setIDtask(scanner.nextLine().trim());
        System.out.println("Nhap id Nhan vien dang thuc hien task:");
        String idTest=scanner.nextLine();
        while (true) {
            for (NhanVien nhanv : nhanvienList)
            {
                if (idTest.equals(nhanv.getID())) {
                    k=1;
                    task.setIDtask(idTest);
                    break;
                }
            }
            if(k==1)
            {
                break;
            }
            else
                System.out.println("Ma Id cua nhan vien khong ton tai");


        }
        System.out.println("Nhap tinh trang task");
        task.setTinhTrangTask(scanner.nextLine());
        System.out.println("Xin moi ban nhap deadline");
        task.setTaskDeadline(scanner.nextLine());
    }


    public void hienThiTask() {

    }


}
