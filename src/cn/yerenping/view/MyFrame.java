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
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/15
 * @Description: cn.yerenping.view
 * @version: 1.0
 */

public class MyFrame {
    // �������
    private static JFrame win; // ������
    private JPanel contentPane; //�����

    // ��
    private JPanel topPanel;    //�ϲ�������
    private JLabel titleLabel;    //����

    // ��
    private JTable showTable;    //��ʾ���ݱ��

    // ��
    private String[] menuStr;   // ����еı���
    private String[] str;       // ��һ��
    private JTextField[] filed1;// �ڶ���
    private JTextField[] filed2;// ������
    private JTextField[] filed3;// ������
    private JTextField filed4;// ������
    private JLabel label;//����

    //�ĸ���ť
    private JButton queryAllBtn;
    private JButton queryBtn;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;

    // �����������Ӷ���
    private ContextGUIAndService context;


    public MyFrame(ContextGUIAndService context) {
        //�����ϡ��С������㲼��
        this.context = context;
        this.str = "��ţ��������Ա𣬵绰����ַ��Email".split("��");
        this.menuStr = "��ţ��������Ա𣬵绰����ַ��Email".split("��");
        init();
        addComp();
        addListener();
    }

    public void init() {
        win = new JFrame("Ҷ��ƽ - 666ͨѶ¼");
        //�������������
        contentPane = new JPanel();
        win.setContentPane(contentPane);
        //��������Ӳ���
        contentPane.setPreferredSize(new Dimension(880, 500));
        win.pack();
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        win.setLayout(new BorderLayout(0, 10));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
    }

    //����ǩ���Get����
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
        titleLabel = new JLabel("666ͨѶ¼ϵͳ", JLabel.CENTER);
        titleLabel.setFont(new Font("����", Font.BOLD, 25));
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
        //��һ��
        for (int i = 0; i < str.length; i++) {
            JLabel label = new JLabel(str[i], JLabel.CENTER);
            downPane.add(label);
        }
        queryAllBtn = new JButton("��ʾȫ��");
        downPane.add(queryAllBtn);

        //�ڶ���
        filed1 = new JTextField[6];
        for (int i = 0; i < filed1.length; i++) {
            filed1[i] = new JTextField();
            downPane.add(filed1[i]);
        }
        addBtn = new JButton("��ӳ�Ա");
        downPane.add(addBtn);

        //������
        filed2 = new JTextField[6];
        for (int i = 0; i < filed2.length; i++) {
            filed2[i] = new JTextField();
            downPane.add(filed2[i]);
        }
        updateBtn = new JButton("�޸ĳ�Ա");
        downPane.add(updateBtn);

        //������
        //�����ı���
        filed3 = new JTextField[2];
        for (int i = 0; i < filed3.length; i++) {
            filed3[i] = new JTextField();
            downPane.add(filed3[i]);
        }
        // �ĸ��ո�
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel("");
            downPane.add(label);
        }
        deleteBtn = new JButton("ɾ��");
        downPane.add(deleteBtn);

        //������
        // ������ǩ
        label = new JLabel("������");
        downPane.add(label);
        //1�ı���
        filed4 = new JTextField();
        downPane.add(filed4);
        // �ĸ��ո�
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel("");
            downPane.add(label);
        }
        queryBtn = new JButton("������ѯ");
        downPane.add(queryBtn);
        return downPane;
    }

    // ���±������
    public void updateShowTable(String[][] data) {


        TableModel tm = new DefaultTableModel(data, menuStr);

        showTable.setModel(tm);
    }


    // ��ȡ������Ա���е�����
    public String[] getInsertTxtInfo(JTextField[] textFields) {
        String[] strings = new String[6];
        for (int i = 0; i < textFields.length; i++) {
            strings[i] = textFields[i].getText().trim();
        }
        return strings;
    }


    /**
     * ��ʾ����
     */
    public void showFrame() {
        win.setVisible(true);
    }


    /**
     *
     */
    protected void autoFillInput() {
        //��ȡѡ�е�����
        int row = showTable.getSelectedRow();
        for (int i = 0; i < filed2.length; i++) {
            filed2[i].setText((String)showTable.getValueAt(row, i));
        }
        for (int i = 0; i < filed3.length; i++) {
            filed3[i].setText((String)showTable.getValueAt(row, i));
        }
    }



    /**
     * ���ʱ�����
     */
    public void addListener() {
        //1.queryAllBtn����
        queryAllBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.showAllMember();
            }
        });
        //2.addBtn��ť����
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.addMember();
                System.out.println(index);
                if (index == 0){
                    System.out.println("��ӳɹ�");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "�������������Ϊ�գ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "��Ǹ���Ѵ��ڸ��û�����ź��û��������ظ�����", "����",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //3. updBtn��ť����
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.updMember();
                System.out.println(index+"--------------");
                if (index == 0){
                    System.out.println("�޸ĳɹ�");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "�������������Ϊ�գ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "��Ǹ���ó�Ա����" +
                            "�ڻ������ظ���", "����",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //3. deleteBtn��ť����
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.delMember();
                if (index == 0){
                    System.out.println("�޸ĳɹ�");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "�������������Ϊ�գ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "��Ǹ���ó�Ա���棡", "����",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //4. queryBtn��ť����
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = context.queryMemberByName();
                if (index == 0){
                    System.out.println("��ѯ�ɹ�");
                }else if (index == 1){
                    JOptionPane.showMessageDialog(contentPane, "���Ʋ���Ϊ�գ�", "��ʾ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(contentPane, "��Ǹ���Ҳ����ó�Ա��", "����",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //5. showTable��ӱ��������
        showTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // ����޸Ŀ��ɾ����
                autoFillInput();
            }
        });

        //6.���ڹرռ���
        win.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(win, "��ȷ��Ҫ�˳�ͨѶ¼��", "ϵͳ�ر�", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (flag == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


    }

}
