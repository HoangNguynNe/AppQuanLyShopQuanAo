package Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SanPham {

    private String maSanPham, loaiSanPham, tenSanPham, size, mauSanPham;
    private float giaSanPham;
    private int soLuong;
    private Date ngayNhap;

    public SanPham() {

    }

    public SanPham(String maSanPham, String loaiSanPham, String tenSanPham, String size, String mauSanPham, float giaSanPham, int soLuong, Date ngayNhap) {
        this.maSanPham = maSanPham;
        this.loaiSanPham = loaiSanPham;
        this.tenSanPham = tenSanPham;
        this.size = size;
        this.mauSanPham = mauSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMauSanPham() {
        return mauSanPham;
    }

    public void setMauSanPham(String mauSanPham) {
        this.mauSanPham = mauSanPham;
    }

    public float getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(float giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void xuatSanPham() {
        System.out.println("Ma san pham : " + this.maSanPham);
        System.out.println("Loai san pham : " + this.loaiSanPham);
        System.out.println("Ten san pham : " + this.tenSanPham);
        System.out.println("Size : " + this.size);
        System.out.println("Mau san pham : " + this.mauSanPham);
        System.out.println("Gia san pham : " + this.giaSanPham);
        System.out.println("So luong : " + this.soLuong);
         SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ngay nhap : " + dateFormat.format(this.ngayNhap));

    }

}
