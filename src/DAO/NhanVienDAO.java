package DAO;

import Database.JDBCconnect;
import java.util.ArrayList;
import model.NhanVienmodel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Toan
 */
public class NhanVienDAO implements DAOinterface<NhanVienmodel> {

    private static NhanVienDAO instance;

    public NhanVienDAO() {
        // Constructor private để ngăn việc khởi tạo từ bên ngoài
    }

    public static NhanVienDAO getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO();
        }
        return instance;
    }

    @Override
    public int them(NhanVienmodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO nhanvien (MaNV, ChucVu, Ten, GioiTinh, DiaChi, SoDT, Luong, ngaysinh,matkhau,duongdan) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNv());
            pst.setString(2, t.getChucVu());
            pst.setString(3, t.getTen());
            pst.setString(4, t.getGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setInt(6, t.getSoDt());
            pst.setDouble(7, t.getLuong());
            pst.setDate(8, (Date) t.getNgaysinh());
            pst.setString(9, t.getMatKhau());
            pst.setString(10, t.getDuongAnh());

            ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int capnhat(NhanVienmodel t) {
        int ketQua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE nhanvien SET ChucVu = ?, Ten = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?,Luong= ? , ngaysinh = ?,duongdan=? WHERE MaNV = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getChucVu());
            pst.setString(2, t.getTen());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getDiaChi());
            pst.setInt(5, t.getSoDt());
            pst.setDouble(6, t.getLuong());
            pst.setDate(7, (Date) t.getNgaysinh());
            pst.setString(8, t.getMaNv());
            pst.setString(9, t.getDuongAnh());

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
            String sql = "DELETE FROM nhanvien WHERE MaNV = ?";
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
    public ArrayList<NhanVienmodel> selectAll() {
        ArrayList<NhanVienmodel> listNhanVien = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM nhanvien";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                NhanVienmodel nv = new NhanVienmodel();
                nv.setMaNv(rs.getString("MaNV"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setTen(rs.getString("Ten"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDt(rs.getInt("SoDT"));
                nv.setLuong(rs.getDouble("Luong"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setDuongAnh(rs.getString("duongdan"));
                nv.setMatKhau(rs.getString("matkhau"));

                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listNhanVien;
    }

    @Override
    public NhanVienmodel selectById(String t) {
        NhanVienmodel nv = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM nhanvien WHERE MaNV = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nv = new NhanVienmodel();
                nv.setMaNv(rs.getString("MaNV"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setTen(rs.getString("Ten"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDt(rs.getInt("SoDT"));
                nv.setLuong(rs.getDouble("Luong"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setDuongAnh(rs.getString("duongdan"));
                return nv;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nv;
    }

    @Override
    public ArrayList<NhanVienmodel> selectByCondition(String condition) {
        ArrayList<NhanVienmodel> listNhanVien = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM nhanvien WHERE " + condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                NhanVienmodel nv = new NhanVienmodel();
                nv.setMaNv(rs.getString("MaNV"));
                nv.setChucVu(rs.getString("ChucVu"));
                nv.setTen(rs.getString("Ten"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDt(rs.getInt("SoDT"));
                nv.setLuong(rs.getDouble("Luong"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setDuongAnh(rs.getString("duongdan"));

                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listNhanVien;
    }

    public int demSoLuongNhanVien() {
        int soLuongNhanVien = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT COUNT(*) FROM nhanvien";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                soLuongNhanVien = rs.getInt(1); // Lấy giá trị đếm từ cột đầu tiên
            }
            System.out.println("Số lượng nhân viên: " + soLuongNhanVien);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return soLuongNhanVien;
    }
    public String getStoredPassword(String username) {
        String storedPassword = null;
        String sql = "SELECT matkhau FROM nhanvien WHERE Ten = ?"; // Assuming 'Ten' is the username field

        try (Connection con = JDBCconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                storedPassword = rs.getString("matkhau"); // Get the stored hashed password
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return storedPassword; // Return the retrieved hashed password or null if not found
    }

    // Method to update the password for the given username
    public boolean saveNewPassword(String username, String hashedPassword) {
        int rowsUpdated = 0;
        String sql = "UPDATE nhanvien SET matkhau = ? WHERE Ten = ?"; // Assuming 'Ten' is the username field

        try (Connection con = JDBCconnect.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, hashedPassword); // Set the new hashed password
            pst.setString(2, username); // Set the username condition

            rowsUpdated = pst.executeUpdate(); // Execute the update
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rowsUpdated > 0; // Return true if at least one row was updated
    }

}
