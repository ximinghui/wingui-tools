package org.ximinghui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class TaskbarUtils {

    private TaskbarUtils() {
    }

    /**
     * 统计显示器数量
     * 
     * <p>
     * 计算机连接多个显示器并处于"复制模式"时获取到的数量为1
     * 
     * @return 显示器数量
     */
    public static int countMonitors() {
        return Screen.getScreens().size();
    }

    /**
     * 获取任务栏位置
     * 
     * <p>
     * 自动隐藏任务栏时无法获取, 即使任务栏处于未隐藏状态
     * 
     * @param screen 屏幕对象
     * @return 任务栏位置
     */
    public static TaskbarPosition getTaskbarPosition(Screen screen) {
        // 完整显示器区域
        Rectangle2D fullRectangle2D = screen.getBounds();
        // 可视 (可用) 区域
        Rectangle2D visualRectangle2D = screen.getVisualBounds();
        // 完整显示器区域左上角的x坐标和y坐标
        double minXOfFull = fullRectangle2D.getMinX();
        double minYOfFull = fullRectangle2D.getMinY();
        // 完整显示器区域右下角的x坐标和y坐标
        double maxXOfFull = fullRectangle2D.getMaxX();
        double maxYOfFull = fullRectangle2D.getMaxY();
        // 可视区域左上角的x坐标和y坐标
        double minXOfVisual = visualRectangle2D.getMinX();
        double minYOfVisual = visualRectangle2D.getMinY();
        // 可视区域右下角的x坐标和y坐标
        double maxXOfVisual = visualRectangle2D.getMaxX();
        double maxYOfVisual = visualRectangle2D.getMaxY();
        // 若可视区x坐标大于完整区x坐标, 则表示任务栏位于左边
        if (minXOfVisual > minXOfFull) {
            return TaskbarPosition.LEFT;
        }
        // 若可视区y坐标大于完整区y坐标, 则表示任务栏位于上边
        if (minYOfVisual > minYOfFull) {
            return TaskbarPosition.TOP;
        }
        // 若可视区y坐标大于完整区y坐标, 则表示任务栏位于右边
        if (maxXOfVisual < maxXOfFull) {
            return TaskbarPosition.RIGHT;
        }
        // 任务栏位于下边
        assert maxYOfVisual < maxYOfFull;
        return TaskbarPosition.BOTTOM;
    }

}