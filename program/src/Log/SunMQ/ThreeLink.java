package Log.SunMQ;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThreeLink {
    private JComboBox faceCombo;
    private JComboBox faceCombo1;
    private JComboBox faceCombo2;

    private DefaultComboBoxModel model1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel model2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel model3 = new DefaultComboBoxModel();

    public ThreeLink(JPanel panel, int[][] set) {

        List<String> province = Get_Province_name();
        for (String str : province) {
            model1.addElement(str);
        }
        faceCombo = new JComboBox(model1);

        faceCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox source = (JComboBox) e.getSource();
                String province = source.getSelectedItem().toString();

                List<String> city = Get_City_name(province);
                model2.removeAllElements();
                for (String str : city) {
                    model2.addElement(str);
                }

                model3.removeAllElements();
                List<String> Area = Get_Area_name(city.get(0));
                for (String str : Area) {
                    model3.addElement(str);
                }

            }
        });

        for (String str : Get_City_name("北京市")) {
            model2.addElement(str);
        }
        faceCombo1 = new JComboBox(model2);

        faceCombo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JComboBox source = (JComboBox) evt.getSource();
                String city = (String) source.getSelectedItem();
                List<String> Area = Get_Area_name(city);
                model3.removeAllElements();
                for (String str : Area) {
                    model3.addElement(str);
                }
            }
        });

        for (String str : Get_Area_name("北京市")) {
            model3.addElement(str);
        }

        faceCombo2 = new JComboBox(model3);

//        faceCombo.setBounds(set[0][0], set[0][1], set[0][2], set[0][3]);
//        faceCombo1.setBounds(set[1][0], set[1][1], set[1][2], set[1][3]);
//        faceCombo2.setBounds(set[2][0], set[2][1], set[2][2], set[2][3]);
        faceCombo.setBounds(set[0][0], set[0][1], set[0][2], set[0][3]);
        faceCombo.setFont(new Font("宋体", Font.PLAIN, 15));
        faceCombo1.setBounds(set[1][0], set[1][1], set[1][2], set[1][3]);
        faceCombo1.setFont(new Font("宋体", Font.PLAIN, 15));
        faceCombo2.setBounds(set[2][0], set[2][1], set[2][2], set[2][3]);
        faceCombo2.setFont(new Font("宋体", Font.PLAIN, 15));


        panel.add(faceCombo);
        panel.add(faceCombo1);
        panel.add(faceCombo2);

    }

    private List<String> Get_Province_name() {
        List<String> Province = new ArrayList<String>();
        Connection conn = Connect.get_Conn();
        String sql = "SELECT * from First";
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Fprovince");
                Province.add(name);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Province;
    }

    private List<String> Get_City_name(String Province) {
        List<String> City = new ArrayList<String>();
        Connection conn = Connect.get_Conn();
        String sql = "SELECT Scity from Second where Sprovince=" + '\"' + Province + '\"';
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Scity");
                City.add(name);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return City;

    }

    private List<String> Get_Area_name(String City) {
        List<String> Area = new ArrayList<String>();
        Connection conn = Connect.get_Conn();
        String sql = "select Tarea from Third where Tcity=" + '\"' + City + '\"';
        PreparedStatement pstmt;

        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Tarea");
                Area.add(name);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Area;
    }

    public List<String> Get_Box_Select() {

        List<String> Selection = new ArrayList<String>();

        Selection.add(faceCombo.getSelectedItem().toString());
        Selection.add(faceCombo1.getSelectedItem().toString());
        Selection.add(faceCombo2.getSelectedItem().toString());

        return Selection;
    }

}
