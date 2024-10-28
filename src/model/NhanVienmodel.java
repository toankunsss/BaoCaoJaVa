package model;

import java.util.Date;

/**
 *
 * @author Toan
 */
public class NhanVienmodel {
    private String maNv;
    private  String chucVu;
    private String ten;
    private String gioiTinh;
    private int soDt;
    private String diaChi;
    private Date ngaysinh;
    private double luong;
    private String matkhau;
    private String duongAnh;

    public NhanVienmodel() {
    }

    public NhanVienmodel(String maNv, String chucVu, String ten, String gioiTinh, int soDt, String diaChi, Date ngaysinh, double luong,String matkhau) {
        this.maNv = maNv;
        this.chucVu = chucVu;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.soDt = soDt;
        this.diaChi = diaChi;
        this.ngaysinh = ngaysinh;
        this.luong = luong;
        this.matkhau=matkhau;
        this.duongAnh=duongAnh;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDt() {
        return soDt;
    }

    public void setSoDt(int soDt) {
        this.soDt = soDt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    public String getMatKhau(){
        return matkhau;
    }
    public void setMatKhau(String matkhau){
        this.matkhau=matkhau;
    }
    public void setDuongAnh(String duongAnh){
        this.duongAnh=duongAnh;
    }
    public String getDuongAnh(){
        return duongAnh;
    }
    
}
