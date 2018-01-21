package Log.SunMQ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JPanel panel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton exitButton;
    private JButton LoginButton;
    private ButtonGroup UserGroup;
    private String username;
    private String UserId;


    public LoginWindow() {
        setTitle("Login Windows");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("UserName:");
        userLabel.setBounds(110, 35, 80, 30);
        panel.add(userLabel);
        JLabel passwordLabel = new JLabel("PassWord:");
        passwordLabel.setBounds(110, 80, 80, 30);
        panel.add(passwordLabel);

        userText = new JTextField(20);
        userText.setBounds(180, 35, 165, 30);
        panel.add(userText);
        passwordText = new JPasswordField(20);
        passwordText.setBounds(180, 80, 165, 30);
        panel.add(passwordText);

        SuperLink WebRegistered = new SuperLink("用户注册",
                "http://47.94.250.207:8080/renthouse/jsps/regist.jsp");
        WebRegistered.setBounds(192, 120, 55, 30);
        panel.add(WebRegistered);

        SuperLink WebGetback =new SuperLink("密码找回",
                "http://47.94.250.207:8080/renthouse/jsps/findpwd.jsp");
        WebGetback.setBounds(292,120, 55, 30);
        panel.add(WebGetback);


        LoginButton = new JButton("登录");
        LoginButton.setBounds(180, 150, 80, 25);
        panel.add(LoginButton);

        exitButton = new JButton("退出");
        exitButton.setBounds(280, 150, 80, 25);
        panel.add(exitButton);

        JLabel usertype = new JLabel("用户类型");
        usertype.setBounds(10, 15, 60, 20);
        panel.add(usertype);

        UserGroup = new ButtonGroup();
        JRadioButton user = new JRadioButton("用户");
        JRadioButton admin = new JRadioButton("管理员");
        usertype.setBounds(10, 15, 60, 20);
        user.setBounds(10, 45, 55, 20);
        admin.setBounds(10, 80, 80, 20);
        user.setActionCommand("user");
        admin.setActionCommand("admin");
        user.setSelected(true);
        UserGroup.add(user);
        UserGroup.add(admin);
        panel.add(user);
        panel.add(admin);



        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = new String(userText.getText());
                String passwd = new String(passwordText.getPassword());
                if(!Check_User.Check_Users(username)){
                    new MessageShow("不存在该用户");
                }
                if ((Check_User.Check_Users(username))&
                        (!Check_User.Check_PassWord(username,passwd))){
                    new MessageShow("密码错误,请尝试重新输入");
                }
                if(Check_User.Check_Users(username)&&Check_User.Check_PassWord(username,passwd)) {
                    new MessageSimple("登录成功~~~~~~~");
                    UserId=username;
                    InitalWindows frame = new InitalWindows(UserId);
                    frame.setVisible(true);
                    dispose();
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mathod_Exit();
            }
        });


        setLocationRelativeTo(null);
        add(panel);

    }


    private void mathod_Exit() {
        int n = JOptionPane.showConfirmDialog(null,
                "Are you sure to exit?", "Message", JOptionPane.YES_NO_OPTION);
        if (n == 0) dispose();
    }


}