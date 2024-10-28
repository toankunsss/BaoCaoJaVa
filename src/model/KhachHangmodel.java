package model;

/**
 *
 * @author Toan
 */
public class KhachHangmodel {
    private String maKh;
    private String tenKh;
    private String gioiTinh;
    private int soDt;
    private double tongChiTieu;
    private String diaChi;
    private int diem;

    public KhachHangmodel() {
    }

    public KhachHangmodel(String maKh, String tenKh, String gioiTinh, int soDt, double tongChiTieu, String diaChi, int diem) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.soDt = soDt;
        this.tongChiTieu = tongChiTieu;
        this.diaChi = diaChi;
        this.diem = diem;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
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

    public double getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(double tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
    
    
    
}
