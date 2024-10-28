package controller;

import DAO.NhanVienDAO;
import java.util.ArrayList;
import model.NhanVienmodel;

/**
 *
 * @author Toan
 */
public class NhanVienController {

    private NhanVienDAO nhanVienDAO;

    public NhanVienController() {
        nhanVienDAO = new NhanVienDAO();
    }

    public ArrayList<NhanVienmodel> selectAll() {
        return nhanVienDAO.selectAll();
    }

    public void ThemNv(NhanVienmodel nhanVienmodel) {
        nhanVienDAO.them(nhanVienmodel);
    }

    public void XoaNv(String nhanVienmodel) {
        nhanVienDAO.xoa(nhanVienmodel);
    }

    public NhanVienmodel selectById(String t) {
        return nhanVienDAO.selectById(t);
    }

    public void UpdateNv(NhanVienmodel nhanVienmodel) {
        nhanVienDAO.capnhat(nhanVienmodel);
    }

    public boolean isMaNvExists(String maNv) {
        ArrayList<NhanVienmodel> danhSachNhanVien = selectAll();
        return danhSachNhanVien.stream().anyMatch(nv -> nv.getMaNv().equals(maNv));
    }

    public ArrayList<NhanVienmodel> selectByCondition(String condition){
            return nhanVienDAO.selectByCondition(condition);
    }



}
