package com.ChenHui;

import java.awt.*;
import java.util.*;

public class Config {
    private static Map<String, Object> content = new HashMap<>();
    public static void initConfig() {
        set("MenuBar_font_large", new Font("宋体", Font.PLAIN, 17));
        set("MenuBar_font_small", new Font("宋体", Font.PLAIN, 15));
        set("TextArea_font", new Font("宋体", Font.PLAIN, 20));
    }
    public static void set(String name, Object item) {
        content.put(name, item);
    }
    public static Object get(String name) {
        return content.get(name);
    }
}
