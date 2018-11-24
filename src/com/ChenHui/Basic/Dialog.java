package com.ChenHui.Basic;

import javax.swing.*;
import java.awt.*;

public class Dialog extends JOptionPane {
    public static void warnDialog(Component parent, String title, String content) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.WARNING_MESSAGE);
    }
    public static void errDialog(Component parent, String title, String content) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }
    public static void infoDialog(Component parent, String title, String content) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
