package DAO;

import Database.JDBCconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHangmodel;

/**
 *
 * @author Toan
 */
public class KhachHangDAO implements DAOinterface<KhachHangmodel> {

    private static KhachHangDAO instance;

    public KhachHangDAO() {
        // Constructor private to prevent instantiation from outside
    }

    public static KhachHangDAO getInstance() {
        if (instance == null) {
            instance = new KhachHangDAO();
        }
        return instance;
    }

    @Override
    public int them(KhachHangmodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO khachhang (MaKH, Ten, GioiTinh, DiaChi, SoDT, TongChiTieu, Diem) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaKh());
            pst.setString(2, t.getTenKh());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getDiaChi());
            pst.setInt(5, t.getSoDt());
            pst.setDouble(6, t.getTongChiTieu());
            pst.setDouble(7, 1);

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int capnhat(KhachHangmodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE khachhang SET Ten = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, TongChiTieu = ?, Diem = ? WHERE MaKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenKh());
            pst.setString(2, t.getGioiTinh());
            pst.setString(3, t.getDiaChi());
            pst.setInt(4, t.getSoDt());
            pst.setDouble(5, t.getTongChiTieu());
            pst.setDouble(6, 1);
            pst.setString(7, t.getMaKh());  // Fixed index from 7 to 8

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int xoa(String t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "DELETE FROM khachhang WHERE MaKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị xóa.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<KhachHangmodel> selectAll() {
        ArrayList<KhachHangmodel> listKhachHang = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM khachhang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                KhachHangmodel kh = new KhachHangmodel();
                kh.setMaKh(rs.getString("MaKH"));
                kh.setTenKh(rs.getString("Ten"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDt(rs.getInt("SoDT"));
                kh.setTongChiTieu(rs.getDouble("TongChiTieu")); // Ensure this method exists in KhachHangmodel
                kh.setDiem(rs.getDouble("Diem")); // Ensure this method exists in KhachHangmodel
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }

    @Override
    public KhachHangmodel selectById(String t) {
        KhachHangmodel kh = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM khachhang WHERE MaKH = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                kh = new KhachHangmodel();
                kh.setMaKh(rs.getString("MaKH"));
                kh.setTenKh(rs.getString("Ten"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDt(rs.getInt("SoDT"));
                kh.setTongChiTieu(rs.getDouble("TongChiTieu")); // Ensure this method exists in KhachHangmodel
                kh.setDiem(rs.getDouble("Diem")); // Ensure this method exists in KhachHangmodel
                return kh;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kh;
    }

    @Override
    public ArrayList<KhachHangmodel> selectByCondition(String condition) {
        ArrayList<KhachHangmodel> listKhachHang = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM khachhang WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                KhachHangmodel kh = new KhachHangmodel();
                kh.setMaKh(rs.getString("MaKH"));
                kh.setTenKh(rs.getString("Ten"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDt(rs.getInt("SoDT"));
                kh.setTongChiTieu(rs.getDouble("TongChiTieu"));
                kh.setDiem(rs.getDouble("Diem"));
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }

    public int demSoLuongKhachHang() {
        int soLuongKhachHang = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT COUNT(*) FROM khachhang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                soLuongKhachHang = rs.getInt(1); // Lấy giá trị đếm từ cột đầu tiên
            }
            System.out.println("Số lượng khách hàng: " + soLuongKhachHang);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return soLuongKhachHang;
    }

}
