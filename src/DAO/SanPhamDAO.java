package DAO;

import Database.JDBCconnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.sanpham;
import java.sql.ResultSet;

/**
 *
 * @author Toan
 */
public class SanPhamDAO implements DAOinterface<sanpham> {

    private static SanPhamDAO instance;

    public SanPhamDAO() {

    }

    public static SanPhamDAO getInstance() {
        if (instance == null) {
            instance = new SanPhamDAO();
        }
        return instance;
    }

    @Override
    public int them(sanpham t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO sua (MaSua,TenSua,Soluong,DonGia,Size,anh,KhoiLuong,HanSuDung) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSua());
            pst.setString(2, t.getTenSua());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getDonGia());
            pst.setString(5, t.getSize());
            pst.setString(6, t.getAnh());
            pst.setString(7, t.getKhoiLuong());
            pst.setDate(8, (Date) t.getNgayHetHan());

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int capnhat(sanpham t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE sua SET MaSua=?,TenSua=?,Soluong=?,DonGia=?,Size=?,anh=?,KhoiLuong=?,HanSuDung=?) ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSua());
            pst.setString(2, t.getTenSua());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getDonGia());
            pst.setString(5, t.getSize());
            pst.setString(6, t.getAnh());
            pst.setString(7, t.getKhoiLuong());
            pst.setDate(8, (Date) t.getNgayHetHan());

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
            String sql = "DELETE FROM sua WHERE MaSua= ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<sanpham> selectAll() {
        ArrayList<sanpham> listSP = new ArrayList<>();
        Connection con = JDBCconnect.getConnection();
        String sql = "SELECT * FROM sua";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sanpham sp = new sanpham();
                sp.setMaSua(rs.getString("MaSua"));
                sp.setTenSua(rs.getString("TenSua"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setAnh(rs.getString("anh"));
                sp.setKhoiLuong(rs.getString("KhoiLuong"));
                sp.setSize(rs.getString("Size"));
                sp.setNgayHetHan(rs.getDate("HanSuDung"));
                sp.setDonGia(rs.getDouble("DonGia"));
                listSP.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSP;
    }

    @Override
    public sanpham selectById(String t) {
        sanpham sp = null;
        Connection con = JDBCconnect.getConnection();
        String sql = "SELECT * FROM sua WHERE MaSua=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sp = new sanpham();
                sp.setMaSua(rs.getString("MaSua"));
                sp.setTenSua(rs.getString("TenSua"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setAnh(rs.getString("anh"));
                sp.setKhoiLuong(rs.getString("KhoiLuong"));
                sp.setSize(rs.getString("Size"));
                sp.setNgayHetHan(rs.getDate("HanSuDung"));
                sp.setDonGia(rs.getDouble("DonGia"));
                return sp;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sp;
    }

    @Override
    public ArrayList<sanpham> selectByCondition(String condition) {
        ArrayList<sanpham> listSP = new ArrayList<>();
        Connection con = JDBCconnect.getConnection();
        String sql = "SELECT * FROM sua WHERE " + condition;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sanpham sp = new sanpham();
                sp.setMaSua(rs.getString("MaSua"));
                sp.setTenSua(rs.getString("TenSua"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setAnh(rs.getString("anh"));
                sp.setKhoiLuong(rs.getString("KhoiLuong"));
                sp.setSize(rs.getString("Size"));
                sp.setNgayHetHan(rs.getDate("HanSuDung"));
                sp.setDonGia(rs.getDouble("DonGia"));
                listSP.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSP;
    }

    public ArrayList<String> layDanhSachTenNCC() {
        ArrayList<String> tenNCCList = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT TenNCCl FROM nhacungcap";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tenNCCList.add(rs.getString("TenNCCl"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNCCList;
    }

    public String getTenSuaByMa(String maSua) {
        String tenSua = "";
        // Kết nối với cơ sở dữ liệu và thực hiện truy vấn
        String query = "SELECT TenSua FROM sua WHERE MaSua = ?";
        try (Connection conn = JDBCconnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maSua);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tenSua = rs.getString("TenSua");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenSua;
    }

}
