package controller;

import DAO.PhieuNhapDAO;
import java.util.ArrayList;
import model.phieuModel;

/**
 *
 * @author Toan
 */
public class PhieuNhapController {
    
    private PhieuNhapDAO phieuNhapDAO;

    public PhieuNhapController() {
        phieuNhapDAO = new PhieuNhapDAO();
    }

    // Phương thức lấy tất cả các phiếu nhập từ DAO
    public ArrayList<phieuModel> selectAll() {
        return phieuNhapDAO.selectAll();
    }

    // Thêm phiếu nhập mới
    public void themPhieu(phieuModel phieu) {
        phieuNhapDAO.them(phieu);
    }

    // Xóa phiếu nhập theo mã phiếu
    public void xoaPhieu(String maPhieu) {
        phieuNhapDAO.xoa(maPhieu);
    }

    // Tìm phiếu nhập theo mã
    public phieuModel selectById(String maPhieu) {
        return phieuNhapDAO.selectById(maPhieu);
    }

    // Cập nhật phiếu nhập
    public void capNhatPhieu(phieuModel phieu) {
        phieuNhapDAO.capnhat(phieu);
    }

    // Kiểm tra xem mã phiếu có tồn tại không
    public boolean isMaPhieuExists(String maPhieu) {
        ArrayList<phieuModel> danhSachPhieu = selectAll();
        return danhSachPhieu.stream().anyMatch(ph -> ph.getMaPN().equals(maPhieu));
    }

    // Lấy danh sách phiếu nhập theo điều kiện tìm kiếm
    public ArrayList<phieuModel> selectByCondition(String condition) {
        return phieuNhapDAO.selectByCondition(condition);
    }
}
