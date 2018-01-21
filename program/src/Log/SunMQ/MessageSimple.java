package Log.SunMQ;

import javax.swing.*;
import java.awt.*;

public class MessageSimple {
    public MessageSimple(String Message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null,
                Message, "Finish",
                JOptionPane.PLAIN_MESSAGE);
    }
}

