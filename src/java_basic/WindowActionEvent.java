package java_basic;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/14 16:16
 * @title 标题:
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

import javax.swing.*;
import java.awt.*;

public class WindowActionEvent extends JFrame {
    JMenuItem 新建, 打开, 保存, 复制, 粘贴;    //菜单项（定义变量）
    JMenu 文件, 编辑, 格式;
    JMenuBar 菜单条;                                //菜单条=new （）；错，语句不能出现在类体里面
    JTextField text1, text2;
    JLabel labalA, labalB;
    JTextArea t;
    JButton button1, button2;
    JComboBox<String> 年, 月, 日;

    WindowActionEvent(String s) {   //窗口的初始状态
        super(s);  //子类调用父类JFrame的构造方法
        initWin();
        setBounds(100, 200, 400, 400);
        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void initWin() {
        setLayout(new FlowLayout());       //所有组件从左到右从上到下依次排列
        新建 = new JMenuItem("新建");
        打开 = new JMenuItem("打开");
        保存 = new JMenuItem("保存");
        复制 = new JMenuItem("复制");
        粘贴 = new JMenuItem("粘贴");
        文件 = new JMenu("文件");
        编辑 = new JMenu("编辑");
        格式 = new JMenu("格式");
        菜单条 = new JMenuBar();
        文件.add(新建);
        文件.add(打开);
        文件.add(保存);
        编辑.add(复制);
        编辑.add(粘贴);
        菜单条.add(文件);
        菜单条.add(编辑);
        菜单条.add(格式);
        setJMenuBar(菜单条);     //不能用add加菜单条，用setJMenuBar()这个方法将菜单条加到窗口里
        labalA = new JLabel("请输入数字A：");
        text1 = new JTextField(10);
        labalB = new JLabel("请输入数字B：");
        text2 = new JTextField(10);
        t = new JTextArea(10, 10);

        button1 = new JButton("确定");
        button2 = new JButton("退出");

        年 = new JComboBox<String>();
        月 = new JComboBox<String>();
        日 = new JComboBox<String>();
        int i = 1;
        while (i < 13) {
            月.addItem("" + i + "月");
            i++;
        }
        add(labalA);
        add(text1);
        add(labalB);
        add(text2);
        add(t);
        add(button1);
        add(button2);
        add(年);
        add(月);
        add(日);
        String s1 = text1.getText();
        System.out.println(s1);
    }

    public static class E {

        public static void main(String[] args) {
            WindowActionEvent 一个空窗口 = new WindowActionEvent("一个带有菜单的窗口");
        }
    }
}
