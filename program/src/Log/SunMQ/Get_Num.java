package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Get_Num {
    public static int Get_Max_Num(String TableName) {
        int Count_max = 0;
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "SELECT " + TableName + " from CountMax";
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String Num = rs.getString(TableName);
                Count_max = Integer.parseInt(Num);

            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Count_max;
    }

    public static void update_Max_Num(String TableName) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "update CountMax set " + TableName + " = " + TableName + " + 1";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
