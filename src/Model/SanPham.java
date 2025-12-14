package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.ArrayList;

public class SanPham {

    private static String url = "jdbc:mysql://localhost:3306/quanlishopquanao";
    private static String user = "root";
    private static String password = "123456789";
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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void themSanPham() {
        
        try (Connection connection = getConnection()) {
            String sql = "insert into sanpham(maSanPham,loaiSanPham,tenSanPham,size,mauSanPham,giaSanPham,soLuong,ngayNhap)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, this.maSanPham);
                preparedStatement.setString(2, this.loaiSanPham);
                preparedStatement.setString(3, this.tenSanPham);
                preparedStatement.setString(4, this.size);
                preparedStatement.setString(5, this.mauSanPham);
                preparedStatement.setFloat(6, this.giaSanPham);
                preparedStatement.setInt(7, this.soLuong);
                preparedStatement.setDate(8, new java.sql.Date(this.ngayNhap.getTime()));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<SanPham> DanhSachSanPham() {
        ArrayList<SanPham> arrayTmp = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "select * from sanpham";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    SanPham data = new SanPham(resultSet.getString("maSanPham"),
                            resultSet.getString("loaiSanPham"),
                            resultSet.getString("tenSanPham"),
                            resultSet.getString("size"),
                            resultSet.getString("mauSanPham"),
                            resultSet.getFloat("giaSanPham"),
                            resultSet.getInt("soLuong"),
                            resultSet.getDate("ngayNhap"));

                    arrayTmp.add(data);
                }

                return arrayTmp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayTmp;
    }

    public void suaSanPham() {
        try (Connection connection = getConnection()) {
            String sql = "update sanpham set maSanPham=?,loaiSanPham=?,tenSanPham=?,size=?,mauSanPham=?,giaSanPham=?,soLuong=?,ngayNhap=? where maSanPham=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, this.maSanPham);
                preparedStatement.setString(2, this.loaiSanPham);
                preparedStatement.setString(3, this.tenSanPham);
                preparedStatement.setString(4, this.size);
                preparedStatement.setString(5, this.mauSanPham);
                preparedStatement.setFloat(6, this.giaSanPham);
                preparedStatement.setInt(7, this.soLuong);
                preparedStatement.setDate(8, new java.sql.Date(this.ngayNhap.getTime()));
                preparedStatement.setString(9, this.maSanPham);
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Sản phẩm đã được sửa thành công.");
                } else {
                    System.out.println("Không tìm thấy sản phẩm có mã " + this.maSanPham);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaSanPham() {
        try (Connection connection = getConnection()) {
            String sql = "delete from sanpham where maSanPham=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, this.maSanPham);
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Sản phẩm đã được xóa thành công.");
                } else {
                    System.out.println("Không tìm thấy sản phẩm có mã " + this.maSanPham);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPham> timSanPhamTheoMaSanPham(String maSP) {

        ArrayList<SanPham> arrayTmp = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "select * from sanpham where maSanPham like ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "%" + maSP + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    SanPham data = new SanPham(resultSet.getString("maSanPham"),
                            resultSet.getString("loaiSanPham"),
                            resultSet.getString("tenSanPham"),
                            resultSet.getString("size"),
                            resultSet.getString("mauSanPham"),
                            resultSet.getFloat("giaSanPham"),
                            resultSet.getInt("soLuong"),
                            resultSet.getDate("ngayNhap"));

                    arrayTmp.add(data);
                }

                return arrayTmp;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayTmp;
    }
    
    public ArrayList<SanPham> timSanPhamTheoTenSanPham(String tenSP) {

        ArrayList<SanPham> arrayTmp = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "select * from sanpham where tenSanPham like ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "%" + tenSP + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    SanPham data = new SanPham(resultSet.getString("maSanPham"),
                            resultSet.getString("loaiSanPham"),
                            resultSet.getString("tenSanPham"),
                            resultSet.getString("size"),
                            resultSet.getString("mauSanPham"),
                            resultSet.getFloat("giaSanPham"),
                            resultSet.getInt("soLuong"),
                            resultSet.getDate("ngayNhap"));

                    arrayTmp.add(data);
                }

                return arrayTmp;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayTmp;
    }
}
