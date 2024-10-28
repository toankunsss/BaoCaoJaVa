package DAO;

import Database.JDBCconnect;
import java.util.ArrayList;
import model.phieuModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Toan
 */
public class PhieuNhapDAO implements DAOinterface<phieuModel> {

    @Override
    public int them(phieuModel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO phieunhap (MaPN,thoigiannhap,TongTien,MaNV,TenNhaCungCap) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaPN());
            pst.setTimestamp(2, t.getThoiGianTao());
            pst.setDouble(3, t.getTongTien());
            pst.setString(4, t.getNguoiTao());
            pst.setString(5, t.getMaNCC());

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int capnhat(phieuModel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE phieunhap SET thoigiannhap = ?, TongTien = ?, MaNV = ?, TenNhaCungCap = ? WHERE MaPN = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, t.getThoiGianTao());
            pst.setDouble(2, t.getTongTien());
            pst.setString(3, t.getNguoiTao());
            pst.setString(4, t.getMaNCC());
            pst.setString(5, t.getMaPN());

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int xoa(String maPN) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "DELETE FROM phieunhap WHERE MaPN = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maPN);

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<phieuModel> selectAll() {
        ArrayList<phieuModel> dsPhieuNhap = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM phieunhap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                phieuModel phieu = new phieuModel();
                phieu.setMaPN(rs.getString("MaPN"));
                phieu.setThoiGianTao(rs.getTimestamp("thoigiannhap"));
                phieu.setTongTien(rs.getDouble("TongTien"));
                phieu.setNguoiTao(rs.getString("MaNV"));
                phieu.setMaNCC(rs.getString("TenNhaCungCap"));
                dsPhieuNhap.add(phieu);
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsPhieuNhap;
    }

    @Override
    public phieuModel selectById(String maPN) {
        phieuModel phieu = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM phieunhap WHERE MaPN = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maPN);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                phieu = new phieuModel();
                phieu.setMaPN(rs.getString("MaPN"));
                phieu.setThoiGianTao(rs.getTimestamp("thoigiannhap"));
                phieu.setTongTien(rs.getDouble("TongTien"));
                phieu.setNguoiTao(rs.getString("MaNV"));
                phieu.setMaNCC(rs.getString("TenNhaCungCap"));
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return phieu;
    }

    @Override
    public ArrayList<phieuModel> selectByCondition(String condition) {
        ArrayList<phieuModel> dsPhieuNhap = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM phieunhap WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                phieuModel phieu = new phieuModel();
                phieu.setMaPN(rs.getString("MaPN"));
                phieu.setThoiGianTao(rs.getTimestamp("thoigiannhap"));
                phieu.setTongTien(rs.getDouble("TongTien"));
                phieu.setNguoiTao(rs.getString("MaNV"));
                phieu.setMaNCC(rs.getString("TenNhaCungCap"));
                dsPhieuNhap.add(phieu);
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsPhieuNhap;
    }

}
