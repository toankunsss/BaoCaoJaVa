package model;

import java.util.Date;

/**
 *
 * @author Toan
 */
public class sanpham {
    private String maSua;
    private String tenSua;
    private int soLuong;
    private double donGia;
    private String Size;
    private String maNCC;
    private Date ngayXK;
    private Date ngayHetHan;
    private String anh;
    private String khoiLuong;

    public sanpham() {
    }

    public sanpham(String maSua, String tenSua, int soLuong, double donGia, String Size, String maNCC, Date ngayXK, Date ngayHetHan, String anh, String khoiLuong) {
        this.maSua = maSua;
        this.tenSua = tenSua;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.Size = Size;
        this.maNCC = maNCC;
        this.ngayXK = ngayXK;
        this.ngayHetHan = ngayHetHan;
        this.anh = anh;
        this.khoiLuong = khoiLuong;
    }

    public String getMaSua() {
        return maSua;
    }

    public void setMaSua(String maSua) {
        this.maSua = maSua;
    }

    public String getTenSua() {
        return tenSua;
    }

    public void setTenSua(String tenSua) {
        this.tenSua = tenSua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public Date getNgayXK() {
        return ngayXK;
    }

    public void setNgayXK(Date ngayXK) {
        this.ngayXK = ngayXK;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
    
}
