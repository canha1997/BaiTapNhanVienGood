package controller;

import model.NhanVien;

import java.util.ArrayList;

public class NhanVienQuanLy implements iNhanVien{
    Controller controller=new Controller();


    @Override
    public void nhapNhanVien(ArrayList<NhanVien> nhanVienList) {

        controller.nhapNhanVien(nhanVienList);
    }

    @Override
    public void hienthiNhanVienList(ArrayList <NhanVien> nhanVienList) {
        controller.hienthiNhanVienList(nhanVienList);
    }

    @Override
    public void themNhanVien() {
        controller.themNhanVien();
    }

    @Override
    public void xoaNhanVien(ArrayList<NhanVien> nhanVienList) {
        controller.xoaNhanVien(nhanVienList);
    }
}
