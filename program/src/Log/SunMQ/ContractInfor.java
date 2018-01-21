package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractInfor extends JFrame {
    private JPanel contentPane;

    public ContractInfor(String Hid) {
        {
            setTitle("合同信息");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 432, 253);
            contentPane.add(panel);
            panel.setLayout(null);

            DefaultListModel dlm = new DefaultListModel();
            addContract(dlm, Hid);
            JList list = new JList();
            list.setModel(dlm);
            list.setBounds(14, 44, 72, 182);
            list.setSelectedIndex(0);
            String Cid = list.getSelectedValue().toString();
            panel.add(list);
            //System.out.println(Cid);

            List<String> Cont = get_contract(Cid);
            JLabel lblNewLabel = new JLabel("合同信息");
            lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
            lblNewLabel.setBounds(14, 13, 120, 18);
            panel.add(lblNewLabel);

            JPanel panel_1 = new JPanel();
            panel_1.setBounds(141, 0, 291, 253);
            panel.add(panel_1);
            panel_1.setLayout(null);
            Paint_Panel(panel_1, Cont, Hid);

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    Paint_Panel(panel_1, get_contract(list.getSelectedValue().toString())
                            , Hid);

                }
            });
            setLocationRelativeTo(null);

        }
    }

    public static boolean Contract_is_allow(String HouseId) {
        Connection conn = Connect.get_Conn_renthouse();
        String sql = "SELECT Hid from Contract where Hid =\"" + HouseId + "\"";
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

    private void Paint_Panel(JPanel panel_1, List<String> Cont, String Hid) {
        panel_1.removeAll();
        JLabel lblNewLabel_1 = new JLabel("租客信息");
        lblNewLabel_1.setBounds(44, 49, 72, 18);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel(Cont.get(0));
        lblNewLabel_2.setBounds(141, 49, 200, 18);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("合同状态");
        lblNewLabel_3.setBounds(44, 91, 72, 18);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel(Cont.get(1));
        lblNewLabel_4.setBounds(141, 91, 200, 18);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("签署日期");
        lblNewLabel_5.setBounds(44, 134, 72, 18);
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel(Cont.get(2));
        lblNewLabel_6.setBounds(141, 134, 200, 18);
        panel_1.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel(Hid);
        lblNewLabel_7.setFont(new Font("等线", Font.BOLD, 16));
        lblNewLabel_7.setBounds(44, 13, 248, 18);
        panel_1.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("合同时长");
        lblNewLabel_8.setBounds(44, 177, 72, 18);
        panel_1.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel(Cont.get(3));
        lblNewLabel_9.setBounds(141, 177, 200, 18);
        panel_1.add(lblNewLabel_9);

        panel_1.repaint();
    }

    private void addContract(DefaultListModel list, String Hid) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> HouseId = new ArrayList<String>();
        String sql1 = "select Cid from Contract";
        String sql = "SELECT Cid from Contract where Hid=" + "\"" + Hid + "\"";
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                list.addElement(rs.getString("Cid"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private List<String> get_contract(String Cid) {
        Connection conn = Connect.get_Conn_renthouse();
        List<String> Loca = new ArrayList<String>();
        String sql = "select * from Contract where Cid=\"" + Cid + "\"";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Loca.add(rs.getString("UserId"));
                if (rs.getBoolean("Cstate")) Loca.add("在履行");
                else Loca.add("不在履行");
                Loca.add(rs.getString("Ctime"));
                Loca.add(rs.getString("Crent") + " 年");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(sql+Loca);
        return Loca;

    }
}