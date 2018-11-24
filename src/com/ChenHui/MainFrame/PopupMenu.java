package com.ChenHui.MainFrame;

import com.ChenHui.Basic.VisualInterface;
import com.ChenHui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.ChenHui.Main.mainFrame;

public class PopupMenu extends JPopupMenu implements VisualInterface {
    private JMenuItem popupMenu_Undo = new JMenuItem("撤销(Ctrl+Z)");
    private JMenuItem popupMenu_Redo = new JMenuItem("重做(Ctrl+Y)");
    private JMenuItem popupMenu_Cut = new JMenuItem("剪切(Ctrl+X)");
    private JMenuItem popupMenu_Copy = new JMenuItem("复制(Ctrl+C)");
    private JMenuItem popupMenu_Paste = new JMenuItem("粘帖(Ctrl+V)");
    private JMenuItem popupMenu_Delete = new JMenuItem("删除(Delete)");
    private JMenuItem popupMenu_SelectAll = new JMenuItem("全选(Ctrl+A)");

    public PopupMenu() {
        this.popupMenu_Undo.setEnabled(false);
        this.popupMenu_Redo.setEnabled(false);
        this.assembleDisplay();
    }

    @Override
    public void assembleDisplay() {
        this.add(popupMenu_Undo);
        this.add(popupMenu_Redo);
        this.addSeparator();
        this.add(popupMenu_Cut);
        this.add(popupMenu_Copy);
        this.add(popupMenu_Paste);
        this.add(popupMenu_Delete);
        this.addSeparator();
        this.add(popupMenu_SelectAll);
    }

    @Override
    public void configDisplay() {
        this.popupMenu_Copy.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.textArea.copy();
            }
        });

        this.popupMenu_Paste.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.textArea.paste();
            }
        });

        this.popupMenu_SelectAll.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.textAreaSelectAll();
            }
        });
    }
}
