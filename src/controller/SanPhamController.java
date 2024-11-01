package controller;

import DAO.SanPhamDAO;
import java.util.ArrayList;
import model.sanpham;

/**
 *
 * @author Toan
 */
public class SanPhamController {

    private final SanPhamDAO sanPhamDAO;

    public SanPhamController() {
        sanPhamDAO = new SanPhamDAO();
    }

    // Lấy tất cả sản phẩm
    public ArrayList<sanpham> selectAll() {
        return sanPhamDAO.selectAll();
    }

    // Thêm sản phẩm
    public void ThemSanPham(sanpham sp) {
        sanPhamDAO.them(sp);
    }

    // Xóa sản phẩm
    public void XoaSanPham(String maSanPham) {
        sanPhamDAO.xoa(maSanPham);
    }

    // Lấy sản phẩm theo ID
    public sanpham selectById(String maSanPham) {
        return sanPhamDAO.selectById(maSanPham);
    }

    public ArrayList<sanpham> seLectByCondition(String condition) {
        return sanPhamDAO.selectByCondition(condition);
    }

    // Cập nhật sản phẩm
    public void UpdateSanPham(sanpham sanPham) {
        sanPhamDAO.capnhat(sanPham);
    }

    public ArrayList<String> LayTenNcc() {
        return sanPhamDAO.layDanhSachTenNCC();
    }

    public boolean isMaSpExists(String maNv) {
        ArrayList<sanpham> danhSachNhanVien = selectAll();
        return danhSachNhanVien.stream().anyMatch(nv -> nv.getMaSua().equals(maNv));
    }

    public String GetTenSuaById(String maSua) {
        return sanPhamDAO.getTenSuaByMa(maSua);
    }
    public int getSoLuongSP(){
        return  sanPhamDAO.laySoLuongSanPham();
    }
    public SanPhamController(SanPhamDAO sanPhamDAO) {
        this.sanPhamDAO = sanPhamDAO;
    }

    public String GetDuongDanAnh(String maSua) {
        sanpham sp = sanPhamDAO.selectById(maSua);
        if (sp != null) {
            return sp.getAnh();
        } else {
            System.out.println("San pham not found with id: " + maSua);
            return null;
        }
    }
    public int SoLuongDaBan(String masp){
        return sanPhamDAO.getSoldQuantity(masp);
    }
}
