package Log.SunMQ;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection get_Conn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://47.94.250.207:3306/" +
                "Three?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String password = "987654";
        com.mysql.jdbc.Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection get_Conn_renthouse() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://47.94.250.207:3306/" +
                "renthouse?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String password = "987654";
        com.mysql.jdbc.Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
