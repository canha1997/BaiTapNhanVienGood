package controller;

import model.DuAn;

import java.util.ArrayList;

public class DuAnQuanLy implements iDuAn{
    Controller controller=new Controller();

    @Override
    public void nhapDuAn(ArrayList<DuAn> duAnList) {
        controller.nhapDuAn(duAnList);
    }

    @Override
    public void hienThiDuAn(ArrayList<DuAn> duAnList) {
        controller.hienThiDuAn(duAnList);
    }

    @Override
    public void chinhSuaDuAn(ArrayList<DuAn> duAnList) {
        controller.chinhSuaDuAn(duAnList);
    }
}