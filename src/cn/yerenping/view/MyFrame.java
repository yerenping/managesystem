package cn.yerenping.view;

import cn.yerenping.context.ContextGUIAndService;
import cn.yerenping.data.MemberData;
import cn.yerenping.pojo.Member;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;


/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/15
 * @Description: cn.yerenping.view
 * @version: 1.0
 */

public class MyFrame {
    // 所有组件
    private static JFrame win; // 最大面板
    private JPanel contentPane; //主面板

    // 上
    private JPanel topPanel;    //上层标题面板
    private JLabel titleLabel;    //标题

    // 中
    private JTable showTable;    //显示内容表格

    // 下
    private String[] menuStr;   // 表格中的标题
    private String[] str;       // 第一行
    private JTextField[] filed1;// 第二行
    private JTextField[] filed2;// 第三行
    private JTextField[] filed3;// 第四行
    private JTextField filed4;// 第五行
    private JLabel label;//姓名

    //四个按钮
    private JButton queryAllBtn;
    private JButton queryBtn;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;

    // 引入上下连接对象
    private ContextGUIAndService context;


    public MyFrame(ContextGUIAndService context) {
        //设置上、中、下三层布局
        this.context = context;
        this.str = "编号，姓名，性别，电话，地址，Email".split("，");
        this.menuStr = "编号，姓名，性别，电话，地址，Email".split("，");
        init();
        addComp();
        addListener();
    }

    public void init() {
        win = new JFrame("叶仁平 - 666通讯录");
        //给窗体添加容器
        contentPane = new JPanel();
        win.setContentPane(contentPane);
        //给窗体添加布局
        contentPane.setPreferredSize(new Dimension(880, 500));
        win.pack();
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        win.setLayout(new BorderLayout(0, 10));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
    }

    //给标签添加Get方法
    public JTextField[] getFiled1() {
        System.out.println(filed1[0]);
        return filed1;
    }

    public JTextField[] getFiled2() {
        return filed2;
    }

    public JTextField[] getFiled3() {
        return filed3;
    }

    public JTextField getFiled4() {
        return filed4;
    }

    public void addComp() {
        contentPane.add(top(), BorderLayout.NORTH);
        contentPane.add(mid(), BorderLayout.CENTER);
        contentPane.add(down(), BorderLayout.SOUTH);

    }

    public JPanel top() {
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600, 40));
        titleLabel = new JLabel("666通讯录系统", JLabel.CENTER);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 25));
        topPanel.add(titleLabel);
        titleLabel.setForeground(Color.red);
        return topPanel;
    }

    public JScrollPane mid() {
        JScrollPane centerPane = new JScrollPane();
        showTable = new JTable();
        centerPane.setViewportView(showTable);
        centerPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return centerPane;
    }

    public JPanel down() {
        JPanel downPane = new JPanel();
        GridLayout lay = new GridLayout(5, 7, 5, 5);
        downPane.setLayout(lay);
        //第一行
        for (int i = 0; i < str.length; i++) {
            JLabel label = new JLabel(str[i], JLabel.CENTER);
            downPane.add(label);
        }
        queryAllBtn = new JButton("显示全部");
        downPane.add(queryAllBtn);

        //第二行
        filed1 = new JTextField[6];
        for (int i = 0; i < filed1.length; i++) {
            filed1[i] = new JTextField();
            downPane.add(filed1[i]);
        }
        addBtn = new JButton("添加成员");
        downPane.add(addBtn);

        //第三行
        filed2 = new JTextField[6];
        for (int i = 0; i < filed2.length; i++) {
            filed2[i] = new JTextField();
            downPane.add(filed2[i]);
        }
        updateBtn = new JButton("修改成员");
        downPane.add(updateBtn);

        //第四行
        //两个文本框
        filed3 = new JTextField[2];
        for (int i = 0; i < filed3.length; i++) {
            filed3[i] = new JTextField();
            downPane.add(filed3[i]);
        }
        // 四个空格
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel("");
            downPane.add(label);
        }
        deleteBtn = new JButton("删除");
        downPane.add(deleteBtn);

        //第四行
        // 姓名标签
        label = new JLabel("姓名：");
        downPane.add(label);
        //1文本框
        filed4 = new JTextField();
        downPane.add(filed4);
        // 四个空格
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel("");
            downPane.add(label);
        }
        queryBtn = new JButton("姓名查询");
        downPane.add(queryBtn);
        return downPane;
    }

    // 更新表格数据
    public void updateShowTable(String[][] data) {


        TableModel tm = new DefaultTableModel(data, menuStr);

        showTable.setModel(tm);
    }


    // 获取新增成员框中的数据
    public String[] getInsertTxtInfo(JTextField[] textFields) {
        String[] strings = new String[6];
        for (int i = 0; i < textFields.length; i++) {
            strings[i] = textFields[i].getText().trim();
        }
        return strings;
    }


    /**
     * 显示界面
     */
    public void showFrame() {
        win.setVisible(true);
    }


    /**
     *
     */
    protected void autoFillInput() {
        //获取选中的数据
        int row = showTable.getSelectedRow();
        for (int i = 0; i < filed2.length; i++) {
            filed2[i].setText((String)showTable.getValueAt(row, i));
        }
        for (int i = 0; i < filed3.length; i++) {
            filed3[i].setText((String)showTable.getValueAt(row, i));
        }
    }



    /**
     * 添加时间监听
     */
    public void addListener() {
        //1.queryAllBtn监听
        queryAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.showAllMember();
            }
        });
        //2.addBtn按钮监听
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.addMember();
                System.out.println(index);
                if (index == 0){
                    System.out.println("添加成功");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "编号名或者姓名为空！", "提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "抱歉，已存在该用户（编号和用户名不能重复）！", "错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //3. updBtn按钮监听
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.updMember();
                System.out.println(index+"--------------");
                if (index == 0){
                    System.out.println("修改成功");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "编号名或者姓名为空！", "提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "抱歉，该成员不存" +
                            "在或名字重复！", "错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //3. deleteBtn按钮监听
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.delMember();
                if (index == 0){
                    System.out.println("修改成功");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "编号名或者姓名为空！", "提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "抱歉，该成员不存！", "错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //4. queryBtn按钮监听
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.queryMemberByName();
                if (index == 0){
                    System.out.println("查询成功");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "名称不能为空！", "提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "抱歉，找不到该成员！", "错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //5. showTable添加表格点击监听
        showTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 填充修改框和删除框
                autoFillInput();
            }
        });

        //6.窗口关闭监听
        win.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(win, "你确定要退出通讯录吗？", "系统关闭", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (flag == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


    }

}
