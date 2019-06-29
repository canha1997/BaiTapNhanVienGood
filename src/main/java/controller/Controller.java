package controller;



import model.DuAn;
import model.NhanVien;
import model.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    /////// Controller NHAN VIEN////////////////////////
    Scanner scanner=new Scanner(System.in);
    Date nowtime=new Date();
    String deadlineInput;


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
                System.out.println("MA ID ko hop le vi da bi trung");   /////Check xem rang Id bi nhap co bi trung hay ko
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


    public void xoaNhanVien(ArrayList<NhanVien> nhanVienList) {
        while (true) {
            int k=0;///// flags de thoat vong lap
            int flags=0;///// flags de nhan biet rang da xoa nhan vien
            String test;
            int inDexOf;
            System.out.println("Nhan(1) neu ban muon xoa nhan vien chi dinh trong list:");
            System.out.println("Nhan (2) neu ban muon xoa toan bo List");
            System.out.println("Nhap (3) Thoat");
            System.out.print("Ban chon la:");
            int z = scanner.nextInt();
            scanner.nextLine();
            switch (z) {
                case 1:
                    System.out.println("Nhap ID Nhan vien ban muon xoa");
                    test = scanner.nextLine();
                    for (NhanVien nhanVien : nhanVienList) {
                        if (test.equals(nhanVien.getID())) {
                           inDexOf=nhanVienList.indexOf(nhanVien);
                            nhanVienList.remove(inDexOf);
                            flags=1;
                            break;
                        }
                    }
                    if(flags==1) {
                        System.out.println("Remove nhan vien voi ID thanh cong");
                    }else
                    System.out.println("Id nhan vien khong ton tai");
                    break;
                case 2:
                      nhanVienList.removeAll(nhanVienList);
                      if(nhanVienList.size()==0) System.out.println("Remove tat ca thanh cong");
                   break;
                   default:
                       k=1;
                       break;
            }
            if(k==1) break;
        }
    }

    /////// Controller DU AN///////////////////



    public void nhapDuAn(ArrayList<DuAn> duAnList) {
        DuAn duan=new DuAn();
        while (true)
        {
            boolean idFlags=false;
            System.out.println("Moi ban nhap ID du an");
            String MaID=scanner.nextLine();
            for(DuAn duAnll: duAnList)
            {
                if(duAnll.getID().equals(MaID))     /////Check xem cop bi trung ID du an hay ko
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
        DateAndTime.stringToDate(deadlineInput);
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
            int k=0;
            System.out.println("Moi ban nhap ID cua du an ma muon chinh sua ?");
            String indexID=scanner.nextLine();
            for (DuAn duAnll : duAnList) {
                if (indexID.equals(duAnll.getID())) {
                    k=1;
                    while (true)
                    {
                        System.out.println("Ban muon chinh sua thong tin gi cua du an?:");
                        System.out.println("Chon (1) neu chinh sua ten");
                        System.out.println("Chon (2) neu chinh sua  ID");
                        System.out.println("Chon (3) neu chinh sua Deadline");
                        System.out.println("Chon (4) THOAT");
                        System.out.print("Ban chon la: ");
                        int o=scanner.nextInt();
                        scanner.nextLine();
                        int flagOut=0;///// flags de thoat vong lap
                        switch (o)
                        {
                            case 1:
                                System.out.println("Moi ban nhap ten Du An: ");
                                duAnll.setTenDuAn(scanner.nextLine());
                                scanner.nextLine();
                                break;
                            case 2:
                                System.out.println("Moi ban nhap ID du an");
                                duAnll.setID(scanner.nextLine().trim());
                                break;
                            case 3:
                                System.out.println("Deadline cua du an theo yyyy/mm/dd:");
                                duAnll.setDateLine(scanner.nextLine().trim());
                                break;
                            case 4:
                                flagOut=1;
                                break;
                            default:break;
                        }
                        if(flagOut==1) break;
                        }
                }
            }
            if(k==0) {
                System.out.println("Error######, khong co du an nay");
                continue;
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
////////// Controller TASK////////////////////

    public void nhapTask(ArrayList <NhanVien> nhanvienList, ArrayList<Task> taskList,  ArrayList<Task> kiemTraTaskCuaNhanVien) {


        Task task= new Task();
        int k=0;///// flags de thoat vong lap
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ten task: ");
        task.setTaskTitle(scanner.nextLine().trim());
        System.out.println("Nhap ID task:");
        task.setIDtask(scanner.nextLine().trim());
        while (true) {
        System.out.println("Nhap id Nhan vien dang thuc hien task:");
        String idTest=scanner.nextLine();
            for (NhanVien nhanv : nhanvienList)
            {
                if (idTest.equals(nhanv.getID())) {
                    k=1;
                    task.setTaskNhanVien(idTest);
                    break;
                }
            }
            if(k==1)
            {
                break;
            }
            else
                System.out.println("Ma Id cua nhan vien khong ton tai");
                continue;
        }

        while (true)
         {
             Pattern p = Pattern.compile("(hold|finish|processing)");
             System.out.println("Nhap tinh trang task");
             String testTinhTrang=scanner.nextLine().trim();
             Matcher matcher=p.matcher(testTinhTrang);
             if(matcher.matches())
             {
                 task.setTinhTrangTask(testTinhTrang);
                 System.out.println("Set tinh trang du an thanh cong");
                 break;
             }
             else System.out.println("Chi nhap hold/finish/processing");

        }

        System.out.println("Xin moi ban nhap deadline:");
        String deadLine=scanner.nextLine();
        task.setTaskDeadline(DateAndTime.stringToDate(deadLine));

        if(kiemTraDeadLine(task.getTaskDeadline()))
        {
            kiemTraTaskCuaNhanVien.add(task);
        }

        taskList.add(task);
    }


    public void hienThiTask(ArrayList<Task> taskList) {
        for(Task taskll: taskList) {
            System.out.println("Id cua Task la :"+taskll.getIDtask());
            System.out.println("Ten cua Task la:"+taskll.getTaskTitle());
            System.out.println("Id cua nhan vien thuc hien du an:"+taskll.getTaskNhanVien());
            System.out.println("Tinh trang cua du an:"+taskll.getTinhTrangTask());
            System.out.println("Deadline cua du an:"+taskll.getTaskDeadline());
            System.out.println("#################################################");
        }

    }
    ////Ham kiiem tra Deadline thong qua time user nhap
    ////// Neu ngay user nhap be hon ngay hien tai thi tra ve True
    public boolean kiemTraDeadLine(Date datetime)
    {
          if(datetime.before(nowtime))
          {
              return true;
          }
          else return false;
    }
    public void kiemTraDeadlineCuaNhanVien(ArrayList<Task> kiemTraTaskCuaNhanVien)
    {

        System.out.println("Danh sach nhung task da qua han");
        for(Task taskCheck: kiemTraTaskCuaNhanVien)
        {
            System.out.println(taskCheck.getTaskTitle());
            System.out.println(taskCheck.getIDtask());
            System.out.println(taskCheck.getTaskNhanVien());
            System.out.println(taskCheck.getTaskDeadline());
        }
    }
   public void kiemTraTaskCuaMotNhanVien( ArrayList <Task> taskList)
   {
       while (true) {
           int k=0;
           int flags=0;///// flags de check xem processing co >3 hay ko
           String tinhTrang="processing";
           System.out.println("Nhap id Nhan vien dang thuc hien task:");
           String idTest=scanner.nextLine();
           for (Task task11 : taskList)
           {
               if (idTest.equals(task11.getTaskNhanVien())) {
                   k=1;
                   if(tinhTrang.equals(task11.getTinhTrangTask()))
                   {
                       flags++;

                   }

               }
           }
           if(flags > 3)
           {
               System.out.println("CO QUA NHIEU TASK, BAN CAN LAM NHANH DE DAY NHANH TIEN DO");
           }
           else {
               System.out.println("TASK CUA NHAN VIEN NAY VAN ON DINH");
           }
           if(k==1)
           {
               break;
           }
           else
               System.out.println("Ma Id cua nhan vien khong ton tai");
               continue;
       }
   }


}
