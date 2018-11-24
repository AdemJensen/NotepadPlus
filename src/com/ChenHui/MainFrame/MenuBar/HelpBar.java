package com.ChenHui.MainFrame.MenuBar;

import com.ChenHui.Basic.Dialog;
import com.ChenHui.Basic.FileOperator;
import com.ChenHui.Config;
import com.ChenHui.Basic.VisualInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.ChenHui.Main.mainFrame;

public class HelpBar extends JMenu implements VisualInterface {
    private JMenuItem HelpBar_help = new JMenuItem("查看帮助");
    private JMenuItem HelpBar_about = new JMenuItem("关于");

    public HelpBar() {
        super("帮助", true);
        this.assembleDisplay();
        this.configDisplay();
    }

    @Override
    public void assembleDisplay() {
        this.add(HelpBar_help);
        this.add(HelpBar_about);
    }

    @Override
    public void configDisplay() {
        this.HelpBar_help.setFont((Font)Config.get("MenuBar_font_small"));
        this.HelpBar_about.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog.infoDialog(mainFrame, "版权声明",
                        "本工程为 微软俱乐部 作业内容。\n" +
                                "原作者 刘元。\n" +
                                "由 任腾龙 进行重构与升级。\n" +
                                "具体实现细则：\n" +
                                "   刘元：打开文件、保存文件、菜单栏、文本编辑区、弹出栏和主要框架编写。\n" +
                                "   任腾龙：打开文件改进、保存文件改进、另存文件、新建文件、打印文件、整体代码结构化和重构。\n" +
                                "Build 20181122AC\n" +
                                "另：原本有尝试实现剪贴板和编辑区域代码高亮显示，不过失败了。");
            }
        });
        this.HelpBar_help.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog.infoDialog(mainFrame, "使用说明",
                        "这么小的工程还想要使用说明？\n" +
                                "好吧好吧，是这样的，现在已经支持的操作有：\n" +
                                "打开文件、保存文件、另存文件、新建文件、打印文件。\n" +
                                "然后嘞，有右键弹出菜单，但是在Mac环境下，里面的按钮没有一个能用的。\n" +
                                "不过令人出乎意料的是，快捷键的复制、剪切和粘贴是可以使用的。");
            }
        });
    }
}
