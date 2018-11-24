package com.ChenHui.Basic;

public interface VisualInterface {

    /**
     * 本方法应当将视觉类中全部控件加载
     * 需要在<b>外层方法</b>或者<b>本对象构造方法</b>中使用一次
     */
    void assembleDisplay();

    /**
     * 本方法实现字体等内容的设置
     * 需要在<b>外层方法</b>或者<b>本对象构造方法</b>中使用一次
     */
    void configDisplay();


}
