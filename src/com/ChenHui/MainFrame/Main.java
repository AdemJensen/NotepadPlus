package com.ChenHui.MainFrame;

import com.ChenHui.Config;
import com.ChenHui.Basic.VisualInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.UnsupportedEncodingException;

public class Main extends JFrame implements VisualInterface, Printable {
    public JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane();
    PopupMenu popupMenu = new PopupMenu();
    com.ChenHui.MainFrame.MenuBar.Main menuBar = new com.ChenHui.MainFrame.MenuBar.Main();

    public Main() {
        this.assembleDisplay();
        this.configDisplay();
    }

    @Override
    public void assembleDisplay() {
        this.add(textArea);
        this.add(scrollPane);
        //this.add(popupMenu);
    }

    @Override
    public void configDisplay() {
        this.scrollPane.setViewportView(this.textArea);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.textArea.setWrapStyleWord(true);//设置单词在一行不足容纳时换行
        this.textArea.setLineWrap(true);//设置文本编辑区自动换行默认为true,即会"自动换行"

        this.textArea.setFont((Font) Config.get("TextArea_font"));

        this.setTitle("记事本");
        this.setSize(720, 480);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                {
                    if (e.isMetaDown())//返回此鼠标事件是否为该平台的弹出菜单触发事件
                    {
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
                    }
                }
            }
        });
    }

    public void setTextAreaText(String content, String charsetName) {
        try {
            textArea.setText(new String(content.getBytes(charsetName)));
            textArea.paintImmediately(textArea.getBounds());  //刷新textArea
        } catch(UnsupportedEncodingException err) {
            System.out.println("Error: Unsupported encoding!");
        }
    }

    public String getTextAreaText() {
        return textArea.getText();
    }

    public String getTextAreaSelected() {
        return textArea.getSelectedText();
    }

    public void textAreaSelectAll() {
        textArea.selectAll();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        Graphics2D g = (Graphics2D) graphics;
        int x = (int)pageFormat.getImageableX();
        int y = (int)pageFormat.getImageableY();
        switch (pageIndex) {
            case 0:
                g.setColor(Color.BLACK);
                g.drawString(textArea.getText(), x + 100, y + 10);
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }
}
