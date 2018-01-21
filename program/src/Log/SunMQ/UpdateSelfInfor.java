package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UpdateSelfInfor extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public UpdateSelfInfor(String UserId) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("更新个人信息");
        setBounds(100, 100, 451, 303);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 433, 256);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("修改信息");
        lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
        lblNewLabel.setBounds(14, 13, 99, 18);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("姓名");
        lblNewLabel_1.setBounds(14, 66, 72, 18);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("电话");
        lblNewLabel_2.setBounds(14, 112, 72, 18);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("性别");
        lblNewLabel_3.setBounds(14, 160, 72, 18);
        panel.add(lblNewLabel_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("需修改请勾选", false);
        chckbxNewCheckBox.setForeground(Color.RED);
        chckbxNewCheckBox.setBounds(290, 62, 133, 27);
        panel.add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("需修改请勾选", false);
        chckbxNewCheckBox_1.setForeground(Color.RED);
        chckbxNewCheckBox_1.setBounds(290, 108, 133, 27);
        panel.add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("需修改请勾选", false);
        chckbxNewCheckBox_2.setForeground(Color.RED);
        chckbxNewCheckBox_2.setBounds(290, 156, 133, 27);
        panel.add(chckbxNewCheckBox_2);
        List<String> UserInfo = InitalWindows.Get_User_information(UserId);
        textField = new JTextField(UserInfo.get(1));
        textField.setBounds(144, 63, 86, 24);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField(UserInfo.get(3));
        textField_1.setBounds(144, 109, 86, 24);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("男");
        comboBox.addItem("女");
        comboBox.setBounds(144, 157, 86, 24);
        panel.add(comboBox);

        SuperLink sp = new SuperLink("修改密码", "http://47.94.250.207:8080/renthouse/jsps/modifypwd.jsp");
        sp.setBounds(192, 215, 72, 18);
        panel.add(sp);
        JButton btnNewButton = new JButton("确认修改");
        btnNewButton.setBounds(290, 206, 133, 37);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                if (chckbxNewCheckBox.isSelected()) {
                    Change("Username", textField.getText().toString(), UserId);
                    i++;
                }
                if (chckbxNewCheckBox_1.isSelected()) {
                    Change("Usertel", textField_1.getText().toString(), UserId);
                    i++;
                }
                if (chckbxNewCheckBox_2.isSelected()) {
                    Change("Usersex", comboBox.getSelectedItem().toString(), UserId);
                    i++;
                }
                if (i == 0) {
                    new MessageShow("您未做出更新");
                    dispose();
                } else {
                    new MessageSimple("更新完成，请尝试重新登录客户端");
                    dispose();
                }

            }
        });
        panel.add(btnNewButton);
        setLocationRelativeTo(null);
    }

    void Change(String Type, String date, String UserId) {
        String sql_set = "update User set " + Type + "=\"" + date + "\" where UserId=\"" + UserId
                + "\"";
        Connection conn = Connect.get_Conn_renthouse();

        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql_set);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            System.out.println(sql_set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
