package Log.SunMQ;

import javax.swing.*;
import java.awt.*;

public class MessageShow {
    public MessageShow(String Message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,
                Message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
