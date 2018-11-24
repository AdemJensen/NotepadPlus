package com.ChenHui;

import com.ChenHui.Basic.ClipboardOperator;

public class Main {
    public static com.ChenHui.MainFrame.Main mainFrame;
    public static ClipboardOperator clipboard;

    public static void main(String[] args) {
        clipboard = new ClipboardOperator();
        mainFrame = new com.ChenHui.MainFrame.Main();
        mainFrame.setVisible(true);
    }
}
