package DAO;

import Database.JDBCconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.NhaCungCap;

/**
 *
 * @author Toan
 */
public class NhaCCDAO implements DAOinterface<NhaCungCap> {
    private static NhaCCDAO instance;

    public NhaCCDAO() {
        // Constructor private to prevent instantiation from outside
    }

    public static NhaCCDAO getInstance() {
        if (instance == null) {
            instance = new NhaCCDAO();
        }
        return instance;
    }
    @Override
    public int them(NhaCungCap ncc) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "INSERT INTO nhacungcap (MaNCC,TenNCCl,SoDT,DiaCHi)" + "VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ncc.getMaNhaCC());
            pst.setString(2, ncc.getTenNCC());
            pst.setInt(3, ncc.getSoDt());
            pst.setString(4, ncc.getDiaChi());
            ketqua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int capnhat(NhaCungCap ncc) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "UPDATE nhacungcap SET TenNCCl=?,SoDT=?,DiaCHi=? where MaNCC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(14, ncc.getMaNhaCC());
            pst.setString(1, ncc.getTenNCC());
            pst.setInt(2, ncc.getSoDt());
            pst.setString(3, ncc.getDiaChi());
            ketqua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int xoa(String t) {
        int ketqua = 0;
        try (Connection con = JDBCconnect.getConnection();) {
            String sql = "DELETE FROM nhacungcap WHERE MaNCC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ketqua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketqua + " dòng bị thay đổi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketqua;

    }

    @Override
    public ArrayList<NhaCungCap> selectAll() {
        ArrayList<NhaCungCap> nhaCungCaps = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM nhacungcap ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCCl"));
                ncc.setSoDt(rs.getInt("SoDT"));
                ncc.setDiaChi(rs.getString("DiaCHi"));
                nhaCungCaps.add(ncc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhaCungCaps;
    }

    @Override
    public NhaCungCap selectById(String t) {
        NhaCungCap ncc = null;
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "Select * FROM nhacungcap WHERE MaNCC=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCCl"));
                ncc.setSoDt(rs.getInt("SoDT"));
                ncc.setDiaChi(rs.getString("DiaCHi"));
                return ncc;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ncc;
    }

    @Override
    public ArrayList<NhaCungCap> selectByCondition(String condition) {
        ArrayList<NhaCungCap> nhaCungCaps = new ArrayList<>();
        try (Connection con = JDBCconnect.getConnection()) {
            String sql = "SELECT * FROM nhacungcap where="+condition;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNhaCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCCl"));
                ncc.setSoDt(rs.getInt("SoDT"));
                ncc.setDiaChi(rs.getString("DiaCHi"));
                nhaCungCaps.add(ncc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhaCungCaps;
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
}
