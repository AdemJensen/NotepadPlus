package com.ChenHui.MainFrame.MenuBar;

import com.ChenHui.*;
import com.ChenHui.Basic.Dialog;
import com.ChenHui.Basic.FileOperator;
import com.ChenHui.Basic.VisualInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import static com.ChenHui.Main.mainFrame;

public class FileBar extends JMenu implements VisualInterface {
    private JMenuItem FileBar_create = new JMenuItem("新建");
    private JMenuItem FileBar_open = new JMenuItem("打开");
    private JMenuItem FileBar_save = new JMenuItem("保存");
    private JMenuItem FileBar_saveAs = new JMenuItem("另存为");
    private JMenuItem FileBar_print = new JMenuItem("打印");
    private JMenuItem FileBar_backGround = new JMenuItem("背景");

    public FileBar() {
        super("文件", true);
        this.assembleDisplay();
        this.configDisplay();
    }

    @Override
    public void assembleDisplay() {
        this.add(FileBar_create);
        this.addSeparator();
        this.add(FileBar_open);
        this.add(FileBar_save);
        this.add(FileBar_saveAs);
        this.addSeparator();
        this.add(FileBar_print);
        this.add(FileBar_backGround);
    }

    @Override
    public void configDisplay() {
        this.FileBar_create.setFont((Font)Config.get("MenuBar_font_small"));
        this.FileBar_open.setFont((Font)Config.get("MenuBar_font_small"));
        this.FileBar_save.setFont((Font)Config.get("MenuBar_font_small"));
        this.FileBar_saveAs.setFont((Font)Config.get("MenuBar_font_small"));
        this.FileBar_print.setFont((Font)Config.get("MenuBar_font_small"));
        this.FileBar_backGround.setFont((Font)Config.get("MenuBar_font_small"));

        this.FileBar_create.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setTextAreaText("", "UTF-8");
                FileOperator.clear();
            }
        });

        this.FileBar_open.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.getFile();
                mainFrame.setTextAreaText(FileOperator.getContent(), FileOperator.getEncoding());
            }
        });

        this.FileBar_save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.save();
            }
        });

        this.FileBar_saveAs.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOperator.saveAs();
            }
        });

        this.FileBar_print.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(mainFrame);
                try {
                    job.print();
                } catch (PrinterException eeeeee) {
                    Dialog.errDialog(mainFrame, "错误", "无法执行打印请求，出现未知错误");
                }
            }
        });
    }
}
