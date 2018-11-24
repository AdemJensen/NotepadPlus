package com.ChenHui.Basic;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipboardOperator {
    private Clipboard clipboardObj;

    public ClipboardOperator() {
        clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();// 获取系统剪贴板
    }

    /**
     * 向剪贴板中写入文本（复制）
     */
    public void setClipboardString(String text) {
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboardObj.setContents(trans, null);
    }

    /**
     * 从剪贴板中获取文本（粘贴）
     */
    public String getClipboardString() {
        // 获取剪贴板中的内容
        Transferable trans = clipboardObj.getContents(null);

        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    // 获取剪贴板中的文本内容
                    return (String) trans.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return "";
    }
}
