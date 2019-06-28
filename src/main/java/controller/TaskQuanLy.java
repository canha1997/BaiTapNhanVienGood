package controller;

import model.NhanVien;
import model.Task;

import java.util.ArrayList;

public class TaskQuanLy implements iTask {
    Controller controller=new Controller();

    @Override
    public void nhapTask(ArrayList<NhanVien> nhanVienList, ArrayList<Task> taskList,  ArrayList<Task> kiemTraTaskCuaNhanVien) {
        controller.nhapTask(nhanVienList,taskList, kiemTraTaskCuaNhanVien);
    }

    @Override
    public void hienThiTask(ArrayList<Task> taskList) {
        controller.hienThiTask(taskList);

    }

    @Override
    public void kiemTraTaskCuaNhanVien( ArrayList<Task> taskDeadLineList) {
       controller.kiemTraTaskCuaNhanVien( taskDeadLineList);
    }
}