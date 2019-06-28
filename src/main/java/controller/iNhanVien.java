package controller;

import model.NhanVien;

import java.util.ArrayList;

public interface iNhanVien {
    public void nhapNhanVien(ArrayList <NhanVien>nhanVienList);
    public void hienthiNhanVienList(ArrayList<NhanVien> nhanVienList);
    public  void themNhanVien();
    public void xoaNhanVien(ArrayList<NhanVien> nhanVienList);
}
