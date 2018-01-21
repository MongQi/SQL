package Log.WangKN;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

public class CheckInformation {
    RentHouse house;

    public CheckInformation(String Hid) {
        JFrame information = new JFrame("房屋详细信息");
        JPanel contentPane = new JPanel();
        information.setVisible(true);
        Query(Hid);

        information.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        information.setBounds(600, 300, 350, 500);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);
        information.setContentPane(contentPane);

        JLabel jid = new JLabel("房屋编号:" + house.getHid());
        jid.setBounds(2, 2, 350, 30);
        jid.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jid);

        JLabel jlocation = new JLabel(house.getHprovince() + " " + house.getHcity()
                + " " + house.getHarea());
        jlocation.setBounds(2, 32, 350, 30);
        jlocation.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jlocation);

        JLabel jl = new JLabel("地理位置:" + house.getHlocation());
        jl.setBounds(2, 62, 350, 30);
        jl.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jl);

        JLabel jfloor = new JLabel("楼层:" + house.getHfloor() + "层");
        jfloor.setBounds(2, 90, 350, 30);
        jfloor.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jfloor);

        JLabel jtype = new JLabel("类型:" + house.getHtype());
        jtype.setBounds(2, 122, 350, 30);
        jtype.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jtype);

        JLabel jbedroom = new JLabel("卧室数量:" + String.valueOf(house.getHcount()));
        jbedroom.setBounds(2, 152, 350, 30);
        jbedroom.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jbedroom);

        JLabel jsquare = new JLabel("房屋面积:" + String.valueOf(house.getHsquare())
                + "平方米");
        jsquare.setBounds(2, 182, 350, 30);
        jsquare.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jsquare);

        JLabel jguarantee = new JLabel("押金:" + String.valueOf(house.getHguarantee())
                + "元");
        jguarantee.setBounds(2, 212, 350, 30);
        jguarantee.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jguarantee);

        JLabel jmoney = new JLabel("租金:" + String.valueOf(house.getHmoney())
                + "元/月");
        jmoney.setBounds(2, 242, 350, 30);
        jmoney.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jmoney);

        JLabel jdate = new JLabel("发布时间:" + String.valueOf(house.getHdate()));
        jdate.setBounds(2, 272, 350, 30);
        jdate.setFont(new Font("宋体", Font.PLAIN, 18));
        contentPane.add(jdate);

        JTextArea jdescription = new JTextArea("备注:" + house.getHdescription());
        jdescription.setBounds(2, 310, 340, 150);
        jdescription.setFont(new Font("宋体", Font.PLAIN, 18));
        jdescription.setLineWrap(true);
        jdescription.setEditable(false);
        jdescription.setBackground(Color.WHITE);
        contentPane.add(jdescription);
    }

    public void Query(String Hid) {
        Statement stament = null;
        ResultSet result = null;

        String sql = "select * from House join Information on Hid=Iid "
                + "where Hid=" + Hid;

        Connection con = ConnectionDB.ConDB("jdbc:mysql://47.94.250.207:3306/"
                + "renthouse?useUnicode=true&characterEncoding=utf8&useSSL=true");
        try {
            stament = con.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("创建连接失败");
        }
        try {
            result = stament.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("查询失败");
        }
        try {
            while (result.next()) {
                String id = result.getString("Hid");
                String location = result.getString("Hlocation");
                int floor = result.getInt("Hfloor");
                String type = result.getString("Htype");
                float money = result.getFloat("Imoney");
                float square = result.getFloat("Hsquare");
                String province = result.getString("Hprovince");
                String city = result.getString("Hcity");
                String area = result.getString("Harea");
                int count = result.getInt("Hcount");
                float guarantee = result.getFloat("Iguarantee");
                Date date = result.getDate("Itime");
                String description = result.getString("Idescription");
                house = new RentHouse(id, location, floor, type,
                        count, money, square, guarantee, province, city,
                        area, date, description);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            result.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            stament.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
