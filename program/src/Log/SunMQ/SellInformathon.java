package Log.SunMQ;
//发布房屋消息窗体

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellInformathon extends JFrame {

    private JPanel contentPane;
    private JTextField money;
    private JTextField guarantee;

    public SellInformathon(String UserId) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 398);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("发布消息");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 482, 351);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("发布租房信息：");
        lblNewLabel.setBounds(14, 13, 150, 18);
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 17));
        panel.add(lblNewLabel);

        JLabel lblHouse = new JLabel("选择已有房屋：");
        lblHouse.setBounds(14, 57, 100, 18);
        panel.add(lblHouse);

        JComboBox HouseName = new JComboBox();
        HouseName.setBounds(120, 54, 105, 24);
        add_housename(HouseName, UserId);
        panel.add(HouseName);

        JLabel Together = new JLabel("能否合租：");
        Together.setBounds(260, 60, 72, 18);

        panel.add(Together);

        JComboBox Joint = new JComboBox();
        Joint.setBounds(360, 57, 105, 24);
        Joint.addItem("不能");
        Joint.addItem("能");
        panel.add(Joint);

        JLabel MoneyLabel = new JLabel("月租金：");
        MoneyLabel.setBounds(14, 105, 72, 18);
        panel.add(MoneyLabel);

        money = new JTextField();
        money.setBounds(120, 102, 105, 25);
        panel.add(money);
        money.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("押金：");
        lblNewLabel_1.setBounds(260, 105, 72, 18);
        panel.add(lblNewLabel_1);

        guarantee = new JTextField();
        guarantee.setBounds(360, 102, 105, 25);
        panel.add(guarantee);
        guarantee.setColumns(10);

        JLabel lblDescription = new JLabel("房屋详细描述：");
        lblDescription.setBounds(14, 157, 454, 18);
        panel.add(lblDescription);

        JTextArea description = new JTextArea();
        description.setBounds(14, 188, 454, 110);
        description.setLineWrap(true);
        panel.add(description);

        JButton publish = new JButton("确认发布");
        publish.setBounds(355, 303, 113, 35);
        publish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String HouseId = HouseName.getSelectedItem().toString();
                int moneycount;
                int guaranteeMoney;
                String deci;
                String together = Together.getText().toString();
                String Toge;
                if (together == "能") Toge = "TRUE";
                else Toge = "FALSE";

                try {
                    moneycount = Integer.parseInt(money.getText().toString());
                    if (moneycount < 0) new MessageShow("租金输入有误");
                    guaranteeMoney = Integer.parseInt(guarantee.getText().toString());
                    if (guaranteeMoney < 0) new MessageShow("押金输入有误");
                    deci = description.getText().toString();
                    if (deci.length() == 0) new MessageShow("请描述房屋详细信息");
                    if (deci.length() > 100) new MessageShow("房屋的描述信息不能超过100个字");
                    String Date_Now = Get_Date.get_date_string();
                    //String Date_num = Get_Date.get_date_string_Not_();
//                    Insert_Into_Sql("11","True",1111,
//                            11111,"1111-11-11","111111");
                    //if(Infor_is_allow(HouseId)) new MessageShow("此房屋已发布出租信息，" +
                    //"请勿重复发布，请耐心等待");
                    if (moneycount > 0 && guaranteeMoney > 0 &&
                            (deci.length() > 0 && deci.length() < 100)) {
                        Insert_Into_Sql(HouseId, Toge, moneycount, guaranteeMoney,
                                Date_Now, deci);
                        dispose();
                    }
                } catch (Exception sellExc1) {
                    new MessageShow("输入有误");
                }

                //

            }
        });
        panel.add(publish);
        setLocationRelativeTo(null);
    }

    public static boolean Infor_is_allow(String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "SELECT Hid from House where UserId =\"" + UserId + "\"";
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

    public static boolean Infor_can_rent(String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        int i = 0;
        String sql = "SELECT Hid from House where Hid not in " +
                "(SELECT Iid from Information) and Hstate=true and UserId="
                + "\"" + UserId + "\"";
        boolean b1 = false;
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) b1 = true;
            else b1 = false;
            conn.close();
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            new MessageShow("与服务器连接出错，请稍后再试");
        }

        return b1;
    }

    private void add_housename(JComboBox comboBox__1, String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> HouseId = new ArrayList<String>();
        String sql = "SELECT Hid from House where Hid not in " +
                "(SELECT Iid from Information) and Hstate=true and UserId="
                + "\"" + UserId + "\"";
        //System.out.println(sql);
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HouseId.add(rs.getString("Hid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : HouseId) {
            comboBox__1.addItem(s);
        }

    }

    private void Insert_Into_Sql(String HouseId, String Joint, int Money_count,
                                 int guaranteeMoney, String Date_, String Deci) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "insert into Information" +
                "(Iid,Ijoint,Iguarantee,Imoney,Itime,Idescription) " +
                "VALUES('" + HouseId + "'," + Joint + "," + Money_count + ","
                + guaranteeMoney + ",'" + Date_ + "','" + Deci + "')";
        //System.out.println(sql);
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String Sql="insert into Information" +
//                "(Iid,Ijoint,Iguarantee,Imoney,Itime,Idescription) " +
//                "VALUES('11',TRUE,1111,11111,'1111-11-11','111111')";
    }


}