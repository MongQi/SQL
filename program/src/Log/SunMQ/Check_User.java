package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class Check_User {
    public static boolean Check_Users(String UserId) {
        String sql = "select UserId from User where UserId=\"" + UserId + "\"";
        Connection conn = Connect.get_Conn_renthouse();
        PreparedStatement pstmt;
        boolean b1 = false;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) b1 = true;
            else b1 = false;
            conn.close();
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1;
    }

    public static boolean Check_PassWord(String UserId,String Passwd) {
        String sql = "select UserId from User where UserId=\"" + UserId + "\" and Password=" +
                "\"" + Passwd + "\"";
        Connection conn = Connect.get_Conn_renthouse();
        PreparedStatement pstmt;
        boolean b1 = false;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) b1 = true;
            else b1 = false;
            conn.close();
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b1;

    }
}
