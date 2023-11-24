
package Controller;

import View.JFThemSanPhamView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ThemSanPhamController {

    private static String url="jdbc:mysql://localhost:3306/quanlishopquanao";
    private static String user="root";
    private static String password ="123456789";
    public static void main(String[] args) {
          JFThemSanPhamView jfs = new JFThemSanPhamView();
          jfs.show();
    }
    
    
    
}
