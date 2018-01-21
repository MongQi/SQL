package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LookHouseAndContract extends JFrame {
    private JPanel contentPane;

    public LookHouseAndContract(String UserId) {
        setTitle("房屋信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 322);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 432, 80);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("请选择你要查看的房屋信息");
        lblNewLabel.setBounds(14, 13, 240, 18);
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
        panel.add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(128, 43, 148, 24);
        addHouse(comboBox, UserId);
        panel.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("房屋编号");
        lblNewLabel_1.setBounds(14, 46, 72, 18);
        panel.add(lblNewLabel_1);


        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 79, 432, 196);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        PaintPanel(comboBox, panel_1);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                PaintPanel(comboBox, panel_1);
            }
        });
        setLocationRelativeTo(null);

        //panel.removeAll();

    }

    private void PaintPanel(JComboBox comboBox, JPanel panel_1) {
        panel_1.removeAll();
        JLabel lblNewLabel_2 = new JLabel("详细信息");
        lblNewLabel_2.setBounds(14, 13, 72, 18);

        panel_1.add(lblNewLabel_2);
        List<String> Loca = get_House_info(comboBox.getSelectedItem().toString());
        JLabel lblNewLabel_3 = new JLabel("地址信息");
        lblNewLabel_3.setBounds(14, 44, 72, 18);
        panel_1.add(lblNewLabel_3);
        //地址
        JLabel lblNewLabel_4 = new JLabel(Loca.get(0));
        lblNewLabel_4.setBounds(114, 44, 270, 18);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("详细地址");
        lblNewLabel_5.setBounds(14, 75, 72, 18);
        panel_1.add(lblNewLabel_5);
        //详细地址
        JLabel lblNewLabel_6 = new JLabel(Loca.get(1));
        lblNewLabel_6.setBounds(114, 75, 270, 18);
        panel_1.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("出租状态");
        lblNewLabel_7.setBounds(14, 106, 72, 18);
        panel_1.add(lblNewLabel_7);
        //出租状态
        JLabel lblNewLabel_8 = new JLabel(Loca.get(2));
        lblNewLabel_8.setBounds(114, 106, 72, 18);
        panel_1.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("房屋面积");
        lblNewLabel_9.setBounds(214, 106, 72, 18);
        panel_1.add(lblNewLabel_9);
        //房屋面积
        JLabel lblNewLabel_10 = new JLabel(Loca.get(3));
        lblNewLabel_10.setBounds(312, 106, 72, 18);
        panel_1.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("房屋层数");
        lblNewLabel_11.setBounds(14, 138, 72, 18);
        panel_1.add(lblNewLabel_11);
        //房屋层数
        JLabel lblNewLabel_12 = new JLabel(Loca.get(4));
        lblNewLabel_12.setBounds(114, 138, 72, 18);
        panel_1.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("房屋类型");
        lblNewLabel_13.setBounds(214, 137, 72, 18);
        panel_1.add(lblNewLabel_13);
        //房屋类型
        JLabel lblNewLabel_14 = new JLabel(Loca.get(5));
        lblNewLabel_14.setBounds(312, 138, 72, 18);
        panel_1.add(lblNewLabel_14);

        JLabel lblNewLabel_15 = new JLabel("卧室数量");
        lblNewLabel_15.setBounds(14, 165, 72, 18);
        panel_1.add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel(Loca.get(6));
        lblNewLabel_16.setBounds(114, 165, 72, 18);
        panel_1.add(lblNewLabel_16);

        SuperLinkForInfor lblNewLabel_17 = new SuperLinkForInfor("查看该房屋所有的合同信息",
                comboBox.getSelectedItem().toString());
        lblNewLabel_17.setBounds(214, 165, 170, 18);
        panel_1.add(lblNewLabel_17);

        panel_1.repaint();
    }


    private void addHouse(JComboBox comboBox, String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> HouseId = new ArrayList<String>();
        String sql = "SELECT Hid from House where UserId=" + "\"" + UserId + "\"";
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
            comboBox.addItem(s);
        }

    }

    private List get_House_info(String HouseId) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> Loca = new ArrayList<String>();
        String sql = "select * from House where Hid=\"" + HouseId + "\"";
        PreparedStatement pstmt;
        String Index;
        String AllIndex;
        String state;
        String square;
        String floor;
        String type;
        String bedroom;


        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AllIndex = rs.getString("Hlocation");
                Index = rs.getString("Hprovince") + " " + rs.getString("Hcity") +
                        " " + rs.getString("Harea");
                if (rs.getBoolean("Hstate")) state = "未出租";
                else state = "已出租";
                square = rs.getString("Hsquare");
                floor = rs.getString("Hfloor");
                bedroom = rs.getString("Hcount");
                type = rs.getString("Htype");
                Loca.add(Index);
                Loca.add(AllIndex);
                Loca.add(state);
                Loca.add(square);
                Loca.add(floor);
                Loca.add(type);
                Loca.add(bedroom);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Loca;
    }


}
