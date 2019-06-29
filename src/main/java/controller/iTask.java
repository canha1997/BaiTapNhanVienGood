package controller;

import model.NhanVien;
import model.Task;

import java.util.ArrayList;

public interface iTask {
    public void nhapTask(ArrayList<NhanVien> nhanVienList, ArrayList<Task> taskList,  ArrayList<Task> kiemTraTaskCuaNhanVien);
    public void hienThiTask(ArrayList<Task> taskList);
    public void kiemTraDeadlineCuaNhanVien(ArrayList<Task> taskDeadLineList);
    public void kiemTraTaskCuaNhanVien( ArrayList<Task> taskList);

}
