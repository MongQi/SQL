package Log.WangKN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://47.94.250.207:3306/Three?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static String userName = "root";
    private static String Password = "987654";

    public static Connection ConDB() {
        Connection con = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(URL, userName, Password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }

    public static Connection ConDB(String sendURL) {
        Connection con = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(sendURL, userName, Password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;
    }
}
