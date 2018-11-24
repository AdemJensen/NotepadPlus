package com.ChenHui.Basic;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

import static com.ChenHui.Main.mainFrame;

public class FileOperator {
    private static String openedFilePath = "";
    private static String CurrentContent = "";
    private static String CurrentEncoding = "UTF-8";

    public static void clear() {
        openedFilePath = "";
        CurrentContent = "";
        CurrentEncoding = "UTF-8";
    }

    public static boolean isOpened() {
        return !openedFilePath.equals("");
    }

    public static String getFilePath() {
        return openedFilePath;
    }

    public static String getContent() {
        return CurrentContent;
    }

    public static String getEncoding() {
        return CurrentEncoding;
    }

    public static void getFile() {
        FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt","txt");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);// 设置仅能选择文件夹
        fileChooser.setMultiSelectionEnabled(false);// 禁止选择多个文件夹
        if (fileChooser.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {// 打开文件选择器
            try {
                File selectedFile = fileChooser.getSelectedFile();  //取得选中的文件
                String tempOpenedFilePath = selectedFile.getPath();   //取得路径
                FileReader fReader = new FileReader(tempOpenedFilePath);
                StringBuilder passage = new StringBuilder();
                BufferedReader bReader = new BufferedReader(fReader);
                String line;
                while ((line = bReader.readLine()) != null) {
                    passage.append(line);
                    passage.append("\n");
                }
                openedFilePath = tempOpenedFilePath;
                CurrentContent = passage.toString();
                CurrentEncoding = fReader.getEncoding();
            } catch (FileNotFoundException eee) {
                Dialog.errDialog(mainFrame, "错误", "系统无法找到指定文件，请检查您的权限(0x23333333)！");
                System.out.println("Error: Specific file not found!");
            } catch (IOException fff) {
                Dialog.errDialog(mainFrame, "错误", "无法读取指定文件，请检查您的权限(0x23333333)！");
                System.out.println("Error: Failed to read file!");
            } catch (NullPointerException err) {
                System.out.println("Notice: No file selected.");
            } catch (Exception ggg) {
                Dialog.errDialog(mainFrame, "错误", "未知错误！");
                System.out.println("Error: " + ggg);
            }
        }
    }

    public static void save() {
        if (isOpened()) {
            try {
                OutputStream oStream = new FileOutputStream(openedFilePath);
                oStream.write(mainFrame.getTextAreaText().getBytes(CurrentEncoding));
                CurrentContent = mainFrame.getTextAreaText();
            } catch (FileNotFoundException eee) {
                Dialog.errDialog(mainFrame, "错误", "无法向指定文件写入，请检查您的权限(0x23333333)！");
                System.out.println("Error: Specific file not found!");
            } catch (IOException fff) {
                Dialog.errDialog(mainFrame, "错误", "无法向指定文件写入，请检查您的权限(0x66666666)！");
                System.out.println("Error: Failed to write file!");
            } catch (Exception ggg) {
                Dialog.errDialog(mainFrame, "错误", "未知错误！");
                System.out.println("Error: " + ggg);
            }
        } else {
            saveAs();
        }
    }

    public static void saveAs() {
        JFileChooser fc=new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file=fc.getSelectedFile();
            openedFilePath = file.getPath();
            save();
        }
    }
}
