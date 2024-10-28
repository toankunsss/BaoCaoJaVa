package DAO;

import Database.JDBCconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTieuPhieumodel;
import model.phieuModel;

/**
 *
 * @author Toan
 */
public class ChiTietPhieuNhapDAO implements DAOinterface<ChiTieuPhieumodel> {
    private static ChiTietPhieuNhapDAO instance;

    public ChiTietPhieuNhapDAO() {
    }

    public static ChiTietPhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietPhieuNhapDAO();
        }
        return instance;
    }


    @Override
    public int them(ChiTieuPhieumodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO chitietphieunhap (MaSua,MaPN,SoLuong,GiaNhap) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSua());
            pst.setString(2, t.getMaPN());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getDonGia());

            ketQua = pst.executeUpdate();
            String sqlSelect = "SELECT SoLuong FROM sua WHERE MaSua = ?";
            PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
            pstSelect.setString(1, t.getMaSua());
            ResultSet rs = pstSelect.executeQuery();

            int soLuongHienTai = 0;
            if (rs.next()) {
                soLuongHienTai = rs.getInt("SoLuong");
            }
            int soLuongMoi = soLuongHienTai + t.getSoLuong();
            String sqlUpdate = "UPDATE sua SET SoLuong = ? WHERE MaSua = ?";
            PreparedStatement pstUpdate = con.prepareStatement(sqlUpdate);
            pstUpdate.setInt(1, soLuongMoi);
            pstUpdate.setString(2, t.getMaSua());
            pstUpdate.executeUpdate();

            System.out.println("Đã thêm sản phẩm vào phieunhap và cập nhật số lượng mới trong sua.");
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int capnhat(ChiTieuPhieumodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE chitietphieunhap SET SoLuong = ?, GiaNhap = ? WHERE MaSua = ? AND MaPN = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoLuong());
            pst.setDouble(2, t.getDonGia());
            pst.setString(3, t.getMaSua());
            pst.setString(4, t.getMaPN());

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
    public int xoa(String maSua) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "DELETE FROM chitietphieunhap WHERE MaSua = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSua);

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
    public ArrayList<ChiTieuPhieumodel> selectAll() {
        ArrayList<ChiTieuPhieumodel> dsChiTietPhieu = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM chitietphieunhap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ChiTieuPhieumodel chiTietPhieu = new ChiTieuPhieumodel();
                chiTietPhieu.setMaSua(rs.getString("MaSua"));
                chiTietPhieu.setMaPN(rs.getString("MaPN"));
                chiTietPhieu.setSoLuong(rs.getInt("SoLuong"));
                chiTietPhieu.setDonGia(rs.getDouble("GiaNhap"));
                dsChiTietPhieu.add(chiTietPhieu);
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsChiTietPhieu;
    }

    @Override
    public ChiTieuPhieumodel selectById(String maSua) {
        ChiTieuPhieumodel chiTietPhieu = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM chitietphieunhap WHERE MaSua = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maSua);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                chiTietPhieu = new ChiTieuPhieumodel();
                chiTietPhieu.setMaSua(rs.getString("MaSua"));
                chiTietPhieu.setMaPN(rs.getString("MaPN"));
                chiTietPhieu.setSoLuong(rs.getInt("SoLuong"));
                chiTietPhieu.setDonGia(rs.getDouble("GiaNhap"));
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return chiTietPhieu;
    }

    @Override
    public ArrayList<ChiTieuPhieumodel> selectByCondition(String condition) {
        ArrayList<ChiTieuPhieumodel> dsChiTietPhieu = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM chitietphieunhap WHERE MaPN= ?" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, condition);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ChiTieuPhieumodel chiTietPhieu = new ChiTieuPhieumodel();
                chiTietPhieu.setMaSua(rs.getString("MaSua"));
                chiTietPhieu.setMaPN(rs.getString("MaPN"));
                chiTietPhieu.setSoLuong(rs.getInt("SoLuong"));
                chiTietPhieu.setDonGia(rs.getDouble("GiaNhap"));
                dsChiTietPhieu.add(chiTietPhieu);
            }
            JDBCconnect.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsChiTietPhieu;
    }

}
