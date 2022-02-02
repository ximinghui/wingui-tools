package org.ximinghui;

import static java.lang.System.out;
import javafx.stage.Screen;

public class Test {

    public static void main(String[] args) {
        JavaFXInitializer.init();
        // 获取显示器数量
        int number = TaskbarUtils.countMonitors();
        out.println(String.format("当前共有%d个显示器", number));
        // 获取任务栏位置
        Screen screen = Screen.getPrimary();
        TaskbarPosition position = TaskbarUtils.getTaskbarPosition(screen);
        out.println(String.format("主屏幕中的任务栏位于%s", position.name()));
        // 获取DPI
        out.println(String.format("主屏幕的DPI为%s", screen.getDpi()));
    }

}
