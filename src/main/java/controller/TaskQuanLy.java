package controller;

import java.util.ArrayList;

public class TaskQuanLy implements iTask {
    Controller controller=new Controller();
    @Override
    public void nhapTask(ArrayList nhanVienList) {
        controller.nhapTask(nhanVienList);
    }

    @Override
    public void hienThiTask() {

    }
}