package model;

/**
 *
 * @author Toan
 */
public class NhaCungCap {

    private String maNhaCC;
    private String tenNCC;
    private int soDt;
    private String diaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNhaCC, String tenNCC, int soDt, String diaChi) {
        this.maNhaCC = maNhaCC;
        this.tenNCC = tenNCC;
        this.soDt = soDt;
        this.diaChi = diaChi;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
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

}
