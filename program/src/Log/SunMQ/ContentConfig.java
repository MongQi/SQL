package Log.SunMQ;

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

public class ContentConfig extends JFrame {
    private JPanel contentPane;
    private JTextField RenterID;
    private JTextField RentYear;
    private JTextField ContentDay;

    public ContentConfig(String UserId) {
        setTitle("登记合同信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 483, 346);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 465, 299);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("登记房屋合同信息");
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
        lblNewLabel.setBounds(14, 13, 180, 18);
        panel.add(lblNewLabel);

        JComboBox HouseChoose = new JComboBox();
        HouseChoose.setBounds(95, 64, 96, 30);
        add_housename(HouseChoose, UserId);
        panel.add(HouseChoose);

        JLabel HouseChooseLabel = new JLabel("选择房屋");
        HouseChooseLabel.setBounds(14, 67, 72, 20);
        //查找房屋信息

        panel.add(HouseChooseLabel);

        JLabel RenterIDLabel = new JLabel("租客ID");
        RenterIDLabel.setBounds(205, 67, 72, 20);
        panel.add(RenterIDLabel);

        RenterID = new JTextField();
        RenterID.setBounds(291, 64, 100, 30);
        panel.add(RenterID);
        RenterID.setColumns(10);

        JLabel RentYearLabel = new JLabel("出租年");
        RentYearLabel.setBounds(14, 114, 72, 20);
        panel.add(RentYearLabel);

        RentYear = new JTextField();
        RentYear.setBounds(95, 112, 100, 30);
        panel.add(RentYear);
        RentYear.setColumns(10);

        JLabel RentMonthLabel = new JLabel(" + 出租月");
        RentMonthLabel.setBounds(205, 115, 120, 20);
        panel.add(RentMonthLabel);

        JComboBox RentMonth = new JComboBox();
        RentMonth.setBounds(291, 112, 100, 30);
        for (int i = 0; i < 12; i++)
            RentMonth.addItem(i);
        panel.add(RentMonth);

        DefaultComboBoxModel model_year = new DefaultComboBoxModel();
        DefaultComboBoxModel model_month = new DefaultComboBoxModel();

        for (int i = 2010; i < 2050; i++)
            model_year.addElement(i);
        for (int i = 1; i < 13; i++)
            model_month.addElement(i);

        JComboBox ContentYear = new JComboBox(model_year);
        ContentYear.setBounds(172, 155, 70, 30);
        panel.add(ContentYear);

        JComboBox ContentMonth = new JComboBox(model_month);
        ContentMonth.setBounds(321, 155, 70, 30);
        panel.add(ContentMonth);

        JLabel ContentYearLabel = new JLabel("年");
        ContentYearLabel.setBounds(95, 155, 72, 20);
        panel.add(ContentYearLabel);

        JLabel ContentMonthLabel = new JLabel("月");
        ContentMonthLabel.setBounds(248, 158, 72, 20);
        panel.add(ContentMonthLabel);

        JLabel lblNewLabel_7 = new JLabel("出租日期");
        lblNewLabel_7.setBounds(14, 158, 72, 20);
        panel.add(lblNewLabel_7);

        JLabel ContentDayLabel = new JLabel("日");
        ContentDayLabel.setBounds(95, 201, 72, 20);
        panel.add(ContentDayLabel);

        ContentDay = new JTextField();
        ContentDay.setBounds(170, 198, 100, 30);
        panel.add(ContentDay);
        ContentDay.setColumns(10);

        JButton Config = new JButton("确认登记");
        Config.setBounds(271, 246, 120, 40);
        String YMD = new Get_Date().get_date_string();
        //System.out.println(YMD);
        Config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String RentId = RenterID.getText().toString();
                String HouseId = HouseChoose.getSelectedItem().toString();
                int rentyear;
                int rentMonth;
                int rentBeginYear;
                int rentBeginMonth;
                int rentBeginDay;
                try {
                    if (RentId.length() == 0) new MessageShow("请输入用户Id");
                    if (!Check_User.Check_Users(RentId)) new MessageShow("用户信息不存在，请重新输入");
                    rentyear = Integer.parseInt(RentYear.getText().toString());
                    if (rentyear < 0 || rentyear > 100) new MessageShow("年份输入有误");
                    //rentMonth = Integer.parseInt(RentMonth.getSelectedItem().toString());
                    rentBeginYear = Integer.parseInt(ContentYear.getSelectedItem().toString());
                    rentBeginMonth = Integer.parseInt(ContentMonth.getSelectedItem().toString());
                    rentBeginDay = Integer.parseInt(ContentDay.getText().toString());
                    if (rentBeginDay <= 0 || rentBeginDay > 31) new MessageShow("日期输入有误");
                    String data = rentBeginYear + "-" + rentBeginMonth + "-" + rentBeginDay;
                    if (Check_User.Check_Users(RentId) && (rentyear < 100 && rentyear > 0)
                            && (rentBeginDay > 0 && rentBeginDay < 32)) {
                        Insert_into_conTract(HouseId, RentId, Get_Date.get_date_string_Not_(),
                                data, rentyear);
                        update_houseInfor_and_Hstate(HouseId, UserId);
                        dispose();
                    }

                } catch (Exception e1) {
                    new MessageShow("你的输入有问题");
                }


            }
        });
        panel.add(Config);
        setLocationRelativeTo(null);
    }

    public static boolean Have_house_in_info(String UserId) {
        String sql = "SELECT Iid from Information where Iid in " +
                "(SELECT Hid from House where UserId=\"" + UserId + "\") ";
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

    private void add_housename(JComboBox comboBox__1, String UserId) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> HouseId = new ArrayList<String>();
        String sql = "SELECT Iid from Information WHERE Iid in " +
                "(SELECT Hid from House WHERE UserId=\"" + UserId + "\") ";

        //System.out.println(sql);
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HouseId.add(rs.getString("Iid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : HouseId) {
            comboBox__1.addItem(s);
        }

    }

    private void Insert_into_conTract(String Hid, String RenterId, String Time_num,
                                      String Time_Contract, int rent_year) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "insert into Contract(Cid,Hid,UserId,Cstate,Ctime,Crent) " +
                "VALUES(\"" + Time_num + '0' + Get_Num.Get_Max_Num("ContractCountMax") +
                "\",\"" + Hid + "\",\"" + RenterId + "\",True,\"" + Time_Contract + "\"," + rent_year + ")";
        System.out.println(sql);
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

    private void update_houseInfor_and_Hstate(String Hid, String UserId) {
        String sql_set = "update House set Hstate=FALSE where Hid=\"" + Hid + "\"";
        String sql_del_info = "DELETE from Information where Iid=\"" + Hid + "\"";

        Connection conn = Connect.get_Conn_renthouse();

        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql_set);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            //System.out.println(sql_set);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection conn1 = Connect.get_Conn_renthouse();
        PreparedStatement pstmt1;
        try {
            pstmt1 = (PreparedStatement) conn1.prepareStatement(sql_del_info);
            pstmt1.executeUpdate();
            pstmt1.close();
            conn1.close();
            System.out.println(sql_del_info);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
