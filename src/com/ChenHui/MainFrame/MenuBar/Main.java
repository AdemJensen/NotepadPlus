package com.ChenHui.MainFrame.MenuBar;

import com.ChenHui.Config;
import com.ChenHui.Basic.VisualInterface;

import javax.swing.*;
import java.awt.*;

public class Main extends JMenuBar implements VisualInterface {
    private JMenu menuBar_File = new FileBar();
    private JMenu menuBar_Help = new HelpBar();

    public Main() {
        this.assembleDisplay();
        this.configDisplay();
    }

    @Override
    public void assembleDisplay() {
        this.add(menuBar_File);
        this.add(menuBar_Help);
    }

    @Override
    public void configDisplay() {
        menuBar_File.setFont((Font) Config.get("MenuBar_font_large"));
        menuBar_Help.setFont((Font) Config.get("MenuBar_font_large"));
    }
}
