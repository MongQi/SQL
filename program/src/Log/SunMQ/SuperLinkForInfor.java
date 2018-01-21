package Log.SunMQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SuperLinkForInfor extends JLabel {
    private String text;
    private boolean isSupported = true;

    public SuperLinkForInfor(String text, String Hid) {
        this.text = text;
        setText(false);
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setText(isSupported);
                if (isSupported)
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setText(false);
            }

            public void mouseClicked(MouseEvent e) {
                if (ContractInfor.Contract_is_allow(Hid)) {
                    ContractInfor con = new ContractInfor(Hid);
                    con.setVisible(true);
                } else new MessageShow("此房屋无合同信息");
            }
        });
    }

    private void setText(boolean b) {
        if (!b)
            setText("<html><font color=blue><u>" + text);
        else
            setText("<html><font color=red><u>" + text);
    }
}