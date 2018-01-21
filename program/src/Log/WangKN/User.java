package Log.WangKN;

import Log.SunMQ.ThreeLink;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class User extends JFrame {

    List<RentHouse> Prorent = new ArrayList<RentHouse>();
    private JPanel contentPane;//最主要的pandle，放置控件
    private JPanel OutputHouse;//搜索按钮点击之后的pandle，存放房屋信息

    public User(String string) {
        setTitle(string);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 300, 800, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        OutputHouse = new JPanel();
        OutputHouse.setLayout(null);
        OutputHouse.setBounds(0, 90, 800, 360);
        getContentPane().add(OutputHouse);

        JPanel jp0 = new JPanel();
        jp0.setBounds(0, 0, 800, 40);
        getContentPane().add(jp0);
        jp0.setLayout(null);

        JLabel image = new JLabel();
        image.setBounds(0, 0, 800, 40);
        image.setIcon(new ImageIcon("bin\\02.png"));
        jp0.add(image);

        //条件板块
        JPanel jp1 = new JPanel();
        jp1.setBounds(0, 40, 800, 50);
        getContentPane().add(jp1);
        jp1.setLayout(null);

        JLabel label_1 = new JLabel("区域");
        label_1.setFont(new Font("宋体", Font.PLAIN, 15));
        label_1.setBounds(10, 10, 30, 30);
        jp1.add(label_1);

        int[][] set = {{50, 10, 80, 30}, {140, 10, 80, 30}, {230, 10, 80, 30}};
        ThreeLink pca = new ThreeLink(jp1, set);

        JLabel label = new JLabel("房屋面积");
        label.setFont(new Font("宋体", Font.PLAIN, 15));
        label.setBounds(320, 10, 70, 30);
        jp1.add(label);

        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setFont(new Font("宋体", Font.PLAIN, 15));
        comboBox_3.setModel(new DefaultComboBoxModel(new String[]{"50平方米以下",
                "50-70平方米", "70-90平方米", "90-110平方米", "110-130平方米",
                "130-150平方米", "150-200平方米", "200平方米以上"}));
        comboBox_3.setBounds(380, 10, 120, 30);
        jp1.add(comboBox_3);

        JLabel label_2 = new JLabel("户型");
        label_2.setFont(new Font("宋体", Font.PLAIN, 15));
        label_2.setBounds(510, 10, 30, 30);
        jp1.add(label_2);

        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setFont(new Font("宋体", Font.PLAIN, 15));
        comboBox_4.setModel(new DefaultComboBoxModel(new String[]{"一室",
                "两室", "三室", "四室", "五室", "五室以上"}));
        comboBox_4.setBounds(540, 10, 60, 30);
        jp1.add(comboBox_4);

        JLabel label_3 = new JLabel("类型");
        label_3.setFont(new Font("宋体", Font.PLAIN, 15));
        label_3.setBounds(610, 10, 30, 30);
        jp1.add(label_3);

        JComboBox comboBox_5 = new JComboBox();
        comboBox_5.setFont(new Font("宋体", Font.PLAIN, 15));
        comboBox_5.setModel(new DefaultComboBoxModel(new String[]{"整租", "合租"}));
        comboBox_5.setBounds(640, 10, 60, 30);
        jp1.add(comboBox_5);

        JButton button = new JButton("搜索");
        button.setFont(new Font("宋体", Font.PLAIN, 15));
        button.setBounds(710, 10, 65, 30);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
//				根据相应的信息进行检索
                Remove();//清除掉OutputHouse上的所有控件
                List<String> area = pca.Get_Box_Select();
                String square = (String) comboBox_3.getSelectedItem();
                String bedroom = (String) comboBox_4.getSelectedItem();
                String state = (String) comboBox_5.getSelectedItem();
                LoadHouse load = new LoadHouse();
                load.DeterSQL(area.get(0), area.get(1), area.get(2),
                        square, bedroom, state);
                load.DBquery();
                Prorent = load.getRent();
                PrintHouse(state, 1);
            }
        });
        jp1.add(button);
    }

    //	打印房屋信息
    public void PrintHouse(String state, int page) {
        if (Prorent.isEmpty()) {
            JPanel jp0 = new JPanel();
            jp0.setBounds(0, 0, 800, 360);
            jp0.setBackground(Color.WHITE);
            jp0.setLayout(null);
            OutputHouse.add(jp0);

            JLabel jl0 = new JLabel("无此类房屋出租");
            jl0.setBounds(0, 0, 800, 300);
            jl0.setForeground(Color.RED);
            jl0.setHorizontalAlignment(SwingConstants.CENTER);
            jl0.setVerticalAlignment(SwingConstants.CENTER);
            jl0.setFont(new Font("宋体", Font.PLAIN, 40));
            jp0.add(jl0);
            contentPane.updateUI();
        } else {
            int number = Prorent.size();
            int PageSum = number / 4 + 1;
            if (page < PageSum) {
                number = 4;
            } else if (page == PageSum) {
                number = number % 4;
            } else {
                number = 0;
                JOptionPane.showMessageDialog(OutputHouse,
                        "<html><body>输入页码有误,<br>"
                                + "请重新输入</body></html>",
                        "标题", JOptionPane.WARNING_MESSAGE);
            }
            for (int i = 0; i < number; i++) {
                JPanel jp0 = new JPanel();
                jp0.setLayout(null);
                jp0.setBorder(new LineBorder(Color.GRAY, 1, false));
                jp0.setBounds(200 * i, 0, 200, 280);
                jp0.setBackground(Color.WHITE);
                OutputHouse.add(jp0);

                String Hid = Prorent.get(page * i).getHid();
                JLabel jl0 = new JLabel("房屋编号:" + Hid);
                jl0.setBounds(2, 0, 180, 30);
                jl0.setFont(new Font("宋体", Font.PLAIN, 18));
                jp0.add(jl0);

                String Hprovince = Prorent.get(page * i).getHprovince();
                String Hcity = Prorent.get(page * i).getHcity();
                String Harea = Prorent.get(page * i).getHarea();
                JLabel jl1 = new JLabel(Hprovince + " " + Hcity + " " + Harea);
                jl1.setBounds(2, 35, 180, 30);
                jl1.setFont(new Font("宋体", Font.PLAIN, 18));
                jp0.add(jl1);

                float Hmoney = Prorent.get(page * i).getHmoney();
                JLabel jl2 = new JLabel("租金:");
                JLabel jl3 = new JLabel(String.valueOf(Hmoney));
                JLabel jl4 = new JLabel("元/月");
                jl2.setBounds(2, 80, 180, 30);
                jl3.setBounds(48, 65, 100, 50);
                jl4.setBounds(148, 80, 60, 30);
                jl2.setFont(new Font("宋体", Font.PLAIN, 18));
                jl3.setFont(new Font("Times New Roman", Font.PLAIN, 35));
                jl4.setFont(new Font("宋体", Font.PLAIN, 15));
                jl3.setForeground(Color.RED);
                jl4.setForeground(Color.RED);
                jp0.add(jl2);
                jp0.add(jl3);
                jp0.add(jl4);

                int Hfloor = Prorent.get(page * i).getHfloor();
                JLabel jl5 = new JLabel("楼层:" + String.valueOf(Hfloor) + "层");
                jl5.setBounds(2, 120, 800, 30);
                jl5.setFont(new Font("宋体", Font.PLAIN, 18));
                jp0.add(jl5);

                float Hsquare = Prorent.get(page * i).getHsquare();
                JLabel jl8 = new JLabel("面积:" + String.valueOf(Hsquare) +
                        "平方米");
                jl8.setBounds(2, 160, 800, 30);
                jl8.setFont(new Font("宋体", Font.PLAIN, 18));
                jp0.add(jl8);

                JLabel jl10 = new JLabel("出租方式:" + state);
                jl10.setBounds(2, 200, 180, 30);
                jl10.setFont(new Font("宋体", Font.PLAIN, 18));
                jp0.add(jl10);

                JLabel message = new JLabel("<html><U>详细信息>>></u></html>");
                message.setBounds(2, 240, 180, 30);
                message.setHorizontalAlignment(SwingConstants.RIGHT);
                message.setFont(new Font("宋体", Font.PLAIN, 18));
                message.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                        ;
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub
                        ;
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub
                        message.setForeground(Color.BLACK);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub
                        message.setForeground(Color.BLUE);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub
                        CheckInformation in = new CheckInformation(Hid);
                    }
                });
                jp0.add(message);
            }
            JPanel jflip = new JPanel();
            jflip.setBounds(0, 280, 800, 80);
            jflip.setLayout(null);
            OutputHouse.add(jflip);

            JLabel sumpage = new JLabel("/" + String.valueOf(PageSum) + "页");
            sumpage.setBounds(395, 0, 40, 40);
            sumpage.setFont(new Font("宋体", Font.PLAIN, 18));
            jflip.add(sumpage);

            JTextField jcurrpage = new JTextField();
            jcurrpage.setText(String.valueOf(page));
            jcurrpage.setBounds(365, 10, 30, 20);
            jcurrpage.setHorizontalAlignment(SwingConstants.RIGHT);
            jcurrpage.setFont(new Font("宋体", Font.PLAIN, 18));
            jflip.add(jcurrpage);

            JButton flip = new JButton("跳转");
            flip.setBounds(440, 5, 70, 28);
            flip.setFont(new Font("宋体", Font.PLAIN, 18));
            flip.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    String derpage = jcurrpage.getText();
                    PrintHouse(state, Integer.valueOf(derpage));
                }
            });
            jflip.add(flip);

            JButton pageup = new JButton("上一页");
            pageup.setBounds(250, 5, 100, 28);
            pageup.setFont(new Font("宋体", Font.PLAIN, 18));
            pageup.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if (page - 1 == 0) {
                        JOptionPane.showMessageDialog(OutputHouse,
                                "当前已是第一页");
                    } else {
                        PrintHouse(state, page - 1);
                    }
                }
            });
            jflip.add(pageup);

            JButton pagedown = new JButton("下一页");
            pagedown.setBounds(515, 5, 100, 28);
            pagedown.setFont(new Font("宋体", Font.PLAIN, 18));
            pagedown.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if (page + 1 > PageSum) {
                        JOptionPane.showMessageDialog(OutputHouse,
                                "当前已是最后一页");
                    } else {
                        PrintHouse(state, page + 1);
                    }
                }
            });
            jflip.add(pagedown);

            JButton toppage = new JButton("首页");
            toppage.setBounds(150, 5, 80, 28);
            toppage.setFont(new Font("宋体", Font.PLAIN, 18));
            toppage.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    PrintHouse(state, 1);
                }
            });
            jflip.add(toppage);

            JButton lastpage = new JButton("末页");
            lastpage.setBounds(635, 5, 80, 28);
            lastpage.setFont(new Font("宋体", Font.PLAIN, 18));
            lastpage.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    PrintHouse(state, PageSum);
                }
            });
            jflip.add(lastpage);

            contentPane.updateUI();
        }
    }

    //	清除掉输出pandle的信息
    public void Remove() {
        OutputHouse.removeAll();
    }
}