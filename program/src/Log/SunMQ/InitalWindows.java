package Log.SunMQ;

//import Log.WangKN.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InitalWindows extends JFrame {
    public InitalWindows(String UserId) {

        setTitle("Super--租房系统");
        getContentPane().setBackground(Color.WHITE);
        setForeground(Color.WHITE);
        getContentPane().setForeground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 912, 471);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setForeground(Color.WHITE);
        panel.setBounds(0, 0, 542, 424);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton button = new JButton("");
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon("bin\\search.png"));
        //button.setFocusPainted();
        button.setBounds(31, 48, 479, 177);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
//                User frame = new User("租房管理系统");
//                frame.setVisible(true);
                //搜索信息
            }
        });
        panel.add(button);

        JButton button_1 = new JButton("");

        button_1.setIcon(new ImageIcon("bin\\publish.png"));
        button_1.setBounds(31, 269, 449, 131);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SellInformathon.Infor_can_rent(UserId)) {
                    SellInformathon frame = new SellInformathon(UserId);
                    frame.setVisible(true);
                } else new MessageShow("您暂未录入房屋信息，或所有房屋都已发布信息");
            }
        });
        panel.add(button_1);

        JLabel lblNewLabel = new JLabel("欢迎使用租房系统!!!");
        lblNewLabel.setForeground(new Color(112, 128, 144));
        lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 18));
        lblNewLabel.setBounds(31, 0, 221, 35);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(240, 255, 255));
        panel_1.setBounds(544, 13, 336, 281);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        List<String> UserInfo = Get_User_information(UserId);
        JLabel label = new JLabel("ID  :    " + UserInfo.get(0));
        label.setFont(new Font("华文中宋", Font.BOLD, 15));
        label.setBounds(24, 95, 260, 23);
        panel_1.add(label);

        JLabel label_1 = new JLabel("姓名:    " + UserInfo.get(1));
        label_1.setBounds(24, 60, 260, 23);
        label_1.setFont(new Font("华文中宋", Font.BOLD, 15));
        panel_1.add(label_1);


        JLabel label_3 = new JLabel("性别:    " + UserInfo.get(2));
        label_3.setBounds(24, 130, 260, 23);
        label_3.setFont(new Font("华文中宋", Font.BOLD, 15));
        panel_1.add(label_3);

        JLabel label_4 = new JLabel("电话:    " + UserInfo.get(3));
        label_4.setBounds(24, 165, 260, 23);
        label_4.setFont(new Font("华文中宋", Font.BOLD, 15));
        panel_1.add(label_4);


        JLabel label_2 = new JLabel("用户信息");
        label_2.setFont(new Font("黑体", Font.BOLD, 19));
        label_2.setBounds(14, 13, 104, 48);
        panel_1.add(label_2);

        JButton btnNewButton = new JButton("修改个人信息");
        btnNewButton.setBounds(164, 241, 158, 27);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSelfInfor update = new UpdateSelfInfor(UserId);
                update.setVisible(true);
            }
        });
        panel_1.add(btnNewButton);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(544, 296, 350, 124);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JButton button_2 = new JButton();
        button_2.setBounds(0, 13, 113, 105);
        button_2.setIcon(new ImageIcon("bin\\house.png"));

        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HouseRegistration frameRegistration = new HouseRegistration(UserId);
                frameRegistration.setVisible(true);
            }
        });
        panel_2.add(button_2);

        JButton button_3 = new JButton();
        button_3.setBounds(111, 13, 113, 105);
        button_3.setIcon(new ImageIcon("bin\\content.png"));
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ContentConfig.Have_house_in_info(UserId)) {
                    ContentConfig c1 = new ContentConfig(UserId);
                    c1.setVisible(true);
                } else new MessageShow("暂无可登记合同的房屋(只有在房屋已经发布信息后，才可登记合同)");
            }
        });
        panel_2.add(button_3);

        JButton button_4 = new JButton();
        button_4.setIcon(new ImageIcon("bin\\sss.png"));
        button_4.setBounds(222, 13, 113, 105);
        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SellInformathon.Infor_is_allow(UserId)) {
                    LookHouseAndContract look = new LookHouseAndContract(UserId);
                    look.setVisible(true);
                } else new MessageShow("不存在房屋信息");
            }
        });
        panel_2.add(button_4);
        setLocationRelativeTo(null);
    }

    public static List<String> Get_User_information(String Userid) {
        List<String> UserInfor = new ArrayList<String>();
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "SELECT * from User WHERE UserId=\"" + Userid + "\"";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserInfor.add(rs.getString("UserId"));
                UserInfor.add(rs.getString("Username"));
                UserInfor.add(rs.getString("Usersex"));
                UserInfor.add(rs.getString("Usertel"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(UserInfor);
        return UserInfor;
    }
}