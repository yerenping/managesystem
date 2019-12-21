package cn.yerenping.context;

import cn.yerenping.pojo.Member;
import cn.yerenping.service.MemberService;
import cn.yerenping.view.MyFrame;


/**
 * 控制器类：
 * 作用：
 * 1.连接业务层service和视图显示MyFrame
 * 2.操作数据和MyFrmae
 *
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/15
 * @Description: cn.yerenping.context
 * @version: 1.0
 */
public class ContextGUIAndService {
    private MyFrame frame;
    private MemberService memberServiceImpl;


    // 引入Service层
    public ContextGUIAndService(MemberService memberService) {
        this.memberServiceImpl = memberService;
    }


    //传入视图
    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }


    //获取表格要显示的数据
    public String[][] getTbaleData() {
        return memberServiceImpl.showAllMemberService();
    }


    //1. 显示全部
    public void showAllMember() {
        // 更新表格数据
        frame.updateShowTable(getTbaleData());
    }

    //2. 添加成员
    public int addMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled1());
        if (strings[0] == null || strings[0].equals("") || strings[1].equals("") || strings[1] == null) {
            //编号和姓名不能为空
            return 1;
        } else {
            int mid = Integer.parseInt(strings[0]);
            String name = strings[1];
            char[] sexs = strings[2].toCharArray();
            char sex = '\0';
            for (char aChar : sexs) {
                if (aChar != '\0') {
                    sex = aChar;
                }
            }
            // sex 可能为空
            String phoneCode = strings[3];
            String addr = strings[4];
            String email = strings[5];
            Member member = new Member(mid, name, sex, phoneCode, addr, email);
            boolean flag = memberServiceImpl.insertMemberService(member);
            if (flag) {
                //更新表格数据
                frame.updateShowTable(getTbaleData());
                return 0;
            } else {
                System.out.println("已存在该数据");
                return 2;
            }
        }
    }

    // 修改成员
    public int updMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled2());
        if ((strings[0] == null || strings[0].equals("")) || (strings[1].equals("") || strings[1] == null)) {
            //编号和姓名不能为空
            System.out.println("编号和姓名不能为空");
            return 1;
        } else {
            int mid = Integer.parseInt(strings[0]);
            String name = strings[1];
            char[] sexs = strings[2].toCharArray();
            char sex = '\0';
            for (char aChar : sexs) {
                if (aChar != '\0') {
                    sex = aChar;
                }
            }
            // sex 可能为空
            String phoneCode = strings[3];
            String addr = strings[4];
            String email = strings[5];
            Member member = new Member(mid, name, sex, phoneCode, addr, email);
            boolean flag = memberServiceImpl.updateByMemberService(member);
            if (flag) {
                //刷新表格
                frame.updateShowTable(getTbaleData());
                // 0 表示更新成功
                System.out.println("0-更新成功");
                return 0;
            } else {
                System.out.println("2-该成员不存在或名字重复");
                return 2;
            }

        }

    }

    //删除成员
    public int delMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled3());
        if ((strings[0] == null || strings[0].equals("")) && (strings[1].equals("") || strings[1] == null)) {
            //编号和姓名不能为都空
            System.out.println("编号和姓名不能都为空");
            return 1;
        } else {

            // 如果编号没值，姓名有值，通过姓名查删
            if ((strings[0] == null || strings[0].equals("")) && (strings[1] != null && !strings[1].equals(""))) {
                String name = strings[1];
                boolean flag2 = memberServiceImpl.deleteByNameService(name);
                if (flag2) {
                    System.out.println("成功");
                    //刷新表格
                    frame.updateShowTable(getTbaleData());
                    return 0;
                } else {
                    System.out.println("该成员不存在");
                    return 2;
                }
                // 如果仅编号有值；或者编号有值，姓名也有值，通通过编号查删
            } else {
                int mid = Integer.parseInt(strings[0]);
                boolean flag = memberServiceImpl.deleteByMidService(mid);
                if (flag) {
                    System.out.println("成功");
                    //刷新表格
                    frame.updateShowTable(getTbaleData());
                    return 0;
                } else {
                    System.out.println("该成员不存在2");
                    return 2;
                }

            }
        }

    }

    //查询成员  0正确，1错误，2错误
    public int queryMemberByName() {
        String name = frame.getFiled4().getText().trim();
        if (name == null || name.equals("")) {
            System.out.println("不能为空");
            return 1;
        }
        Member member = memberServiceImpl.showMemberByName(name);
        if (member == null) {
            System.out.println("该成员不存在");
            return 2;
        } else {
            System.out.println("查询成功");
            String[][] str = new String[1][];
            for (int i = 0; i < str.length; i++) {
                String mid = String.valueOf(member.getMid());
                String names = member.getName();
                String sex = String.valueOf(member.getSex());
                String phoneCode = member.getPhoneCode();
                String addr = member.getAddr();
                String email = member.getEmail();
                str[i] = new String[]{mid, names, sex, phoneCode, addr, email};
            }
            //更新数据
            frame.updateShowTable(str);
            return 0;
        }
    }


    public void start() {
        // 更新表格数据
        frame.updateShowTable(getTbaleData());
        // 显示窗口
        frame.showFrame();
    }

}
