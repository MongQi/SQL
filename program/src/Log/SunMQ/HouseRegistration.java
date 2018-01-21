package Log.SunMQ;
//登记房屋信息窗体

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class HouseRegistration extends JFrame {

    private JPanel contentPane;
    private JTextField FloorNumber;
    private JTextField SquareNumber;
    private JTextArea LocationArea;

    public HouseRegistration(String UserId) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("登记房屋信息");
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 496, 353);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("创建房屋初始信息");
        lblNewLabel.setBounds(15, 13, 195, 30);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("省");
        lblNewLabel_1.setBounds(15, 60, 21, 18);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("市");
        lblNewLabel_2.setBounds(150, 60, 21, 18);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("区/县级市");
        lblNewLabel_3.setBounds(285, 60, 72, 18);
        panel.add(lblNewLabel_3);


        JLabel lblNewLabel_4 = new JLabel("房屋类型");
        lblNewLabel_4.setBounds(15, 105, 72, 18);
        panel.add(lblNewLabel_4);

        JComboBox HouseType = new JComboBox();
        HouseType.setBounds(100, 100, 110, 30);
        HouseType.addItem("商品房");
        HouseType.addItem("安置房");
        HouseType.addItem("回迁房");
        HouseType.addItem("经济适用房");
        HouseType.addItem("廉租房");
        panel.add(HouseType);

        JLabel lblNewLabel_5 = new JLabel("卧室数量");
        lblNewLabel_5.setBounds(246, 105, 72, 18);

        panel.add(lblNewLabel_5);

        JComboBox BedroomCount = new JComboBox();
        BedroomCount.setBounds(336, 100, 100, 30);
        for (int i = 1; i < 10; i++)
            BedroomCount.addItem(i);
        BedroomCount.addItem("10个以上");
        panel.add(BedroomCount);

        JLabel lblNewLabel_6 = new JLabel("房屋楼层");
        lblNewLabel_6.setBounds(15, 160, 72, 18);
        panel.add(lblNewLabel_6);

        FloorNumber = new JTextField();
        FloorNumber.setBounds(100, 157, 110, 30);
        panel.add(FloorNumber);
        FloorNumber.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("房屋面积");
        lblNewLabel_7.setBounds(246, 160, 72, 18);
        panel.add(lblNewLabel_7);

        SquareNumber = new JTextField();
        SquareNumber.setBounds(336, 154, 100, 30);
        panel.add(SquareNumber);
        SquareNumber.setColumns(10);

        JLabel lblHlocation = new JLabel("详细地址");
        lblHlocation.setBounds(15, 203, 72, 18);
        panel.add(lblHlocation);

        LocationArea = new JTextArea();
        LocationArea.setBounds(100, 200, 336, 60);
        panel.add(LocationArea);
        LocationArea.setLineWrap(true);
        //textArea.setColumns(10);
        int[][] loca = {{45, 55, 90, 30}, {180, 55, 90, 30}, {359, 55, 90, 30}};
        ThreeLink three1 = new ThreeLink(panel, loca);

        JButton btnConfig = new JButton("Config");
        btnConfig.setBounds(359, 297, 107, 43);
        btnConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<String> loca1 = three1.Get_Box_Select();
                    String province = loca1.get(0);
                    String type = HouseType.getSelectedItem().toString();
                    String bedroom = BedroomCount.getSelectedItem().toString();
                    int room;
                    if (bedroom == "10个以上") room = 11;
                    else {
                        room = Integer.parseInt(bedroom);
                    }
                    int square = Integer.parseInt(SquareNumber.getText().toString());
                    if (square <= 0) {
                        new MessageShow("房屋面积不正确，请尝试重新输入");
                    }
                    int floor = Integer.parseInt(FloorNumber.getText().toString());
                    if (floor <= 0 || floor > 100) {
                        new MessageShow("楼层数不对，请重新输入");
                    }
                    String location = LocationArea.getText().toString();
                    if (location.length() == 0) {
                        new MessageShow("请输入地址详细信息");
                    }
//                    System.out.println("province: " + province + " HouseType: "
//                            + type + " roomcount: " + room + " Square: " + square
//                            + "   "+location);
                    if ((floor > 0 && floor < 100) && (square > 0) && (location.length() != 0)) {
                        Insert_into_sql(loca1, type, room, floor, square, location, UserId);
                        dispose();
                    }
                    //数据库操作

                } catch (Exception inputError) {
                    new MessageShow("你的输入有错");
                }

            }
        });
        panel.add(btnConfig);
        setLocationRelativeTo(null);
    }

    private void Insert_into_sql(List<String> loca1, String type, int Bedroom,
                                 int floor, int square, String Loca, String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "insert into House(Hid,UserId,Hlocation,Hfloor,Htype," +
                "Hcount,Hsquare,Hstate,Hprovince,Hcity,Harea) VALUES"
                + "(\"" + Get_Date.get_date_string_Not_() + '0' +
                Get_Num.Get_Max_Num("HouseCountMax") +
                '\"' + ',' + '\"' + UserId + '\"' + ',' + '\"' + Loca + '\"' + ',' + floor +
                ',' + '\"' + type + '\"' + ',' + Bedroom + ',' + square + ',' + "True" +
                ',' + '\"' + loca1.get(0) + '\"' + ',' + '\"' + loca1.get(1) +
                '\"' + ',' + '\"' + loca1.get(2) + "\")";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            new MessageShow("数据库操作出错，请尝试关闭后重新登记");
            dispose();
        }
        Get_Num.update_Max_Num("HouseCountMax");
    }
}