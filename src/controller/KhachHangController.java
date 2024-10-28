package controller;

import DAO.KhachHangDAO;
import java.util.ArrayList;
import model.KhachHangmodel;
/**
 *
 * @author Toan
 */
public class KhachHangController {

    private final KhachHangDAO khachHangDAO;

    public KhachHangController() {
        khachHangDAO = new KhachHangDAO();
    }

    public ArrayList<KhachHangmodel> selectAll() {
        return khachHangDAO.selectAll();
    }

    public void ThemNv(KhachHangmodel khachHangmodel) {
        khachHangDAO.them(khachHangmodel);
    }

    public void XoaNv(String khachString) {
        khachHangDAO.xoa(khachString);
    }

    public KhachHangmodel selectById(String t) {
        return khachHangDAO.selectById(t);
    }

    public void UpdateNv(KhachHangmodel khachHangmodel) {
        khachHangDAO.capnhat(khachHangmodel);
    }

}
