package cn.yerenping.context;

import cn.yerenping.pojo.Member;
import cn.yerenping.service.MemberService;
import cn.yerenping.view.MyFrame;


/**
 * �������ࣺ
 * ���ã�
 * 1.����ҵ���service����ͼ��ʾMyFrame
 * 2.�������ݺ�MyFrmae
 *
 * @Auther: Ҷ��ƽ wwww.yerenping.cn
 * @Date: 2019/12/15
 * @Description: cn.yerenping.context
 * @version: 1.0
 */
public class ContextGUIAndService {
    private MyFrame frame;
    private MemberService memberServiceImpl;


    // ����Service��
    public ContextGUIAndService(MemberService memberService) {
        this.memberServiceImpl = memberService;
    }


    //������ͼ
    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }


    //��ȡ���Ҫ��ʾ������
    public String[][] getTbaleData() {
        return memberServiceImpl.showAllMemberService();
    }


    //1. ��ʾȫ��
    public void showAllMember() {
        // ���±������
        frame.updateShowTable(getTbaleData());
    }

    //2. ��ӳ�Ա
    public int addMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled1());
        if (strings[0] == null || strings[0].equals("") || strings[1].equals("") || strings[1] == null) {
            //��ź���������Ϊ��
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
            // sex ����Ϊ��
            String phoneCode = strings[3];
            String addr = strings[4];
            String email = strings[5];
            Member member = new Member(mid, name, sex, phoneCode, addr, email);
            boolean flag = memberServiceImpl.insertMemberService(member);
            if (flag) {
                //���±������
                frame.updateShowTable(getTbaleData());
                return 0;
            } else {
                System.out.println("�Ѵ��ڸ�����");
                return 2;
            }
        }
    }

    // �޸ĳ�Ա
    public int updMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled2());
        if ((strings[0] == null || strings[0].equals("")) || (strings[1].equals("") || strings[1] == null)) {
            //��ź���������Ϊ��
            System.out.println("��ź���������Ϊ��");
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
            // sex ����Ϊ��
            String phoneCode = strings[3];
            String addr = strings[4];
            String email = strings[5];
            Member member = new Member(mid, name, sex, phoneCode, addr, email);
            boolean flag = memberServiceImpl.updateByMemberService(member);
            if (flag) {
                //ˢ�±��
                frame.updateShowTable(getTbaleData());
                // 0 ��ʾ���³ɹ�
                System.out.println("0-���³ɹ�");
                return 0;
            } else {
                System.out.println("2-�ó�Ա�����ڻ������ظ�");
                return 2;
            }

        }

    }

    //ɾ����Ա
    public int delMember() {
        String[] strings = frame.getInsertTxtInfo(frame.getFiled3());
        if ((strings[0] == null || strings[0].equals("")) && (strings[1].equals("") || strings[1] == null)) {
            //��ź���������Ϊ����
            System.out.println("��ź��������ܶ�Ϊ��");
            return 1;
        } else {

            // ������ûֵ��������ֵ��ͨ��������ɾ
            if ((strings[0] == null || strings[0].equals("")) && (strings[1] != null && !strings[1].equals(""))) {
                String name = strings[1];
                boolean flag2 = memberServiceImpl.deleteByNameService(name);
                if (flag2) {
                    System.out.println("�ɹ�");
                    //ˢ�±��
                    frame.updateShowTable(getTbaleData());
                    return 0;
                } else {
                    System.out.println("�ó�Ա������");
                    return 2;
                }
                // ����������ֵ�����߱����ֵ������Ҳ��ֵ��ͨͨ����Ų�ɾ
            } else {
                int mid = Integer.parseInt(strings[0]);
                boolean flag = memberServiceImpl.deleteByMidService(mid);
                if (flag) {
                    System.out.println("�ɹ�");
                    //ˢ�±��
                    frame.updateShowTable(getTbaleData());
                    return 0;
                } else {
                    System.out.println("�ó�Ա������2");
                    return 2;
                }

            }
        }

    }

    //��ѯ��Ա  0��ȷ��1����2����
    public int queryMemberByName() {
        String name = frame.getFiled4().getText().trim();
        if (name == null || name.equals("")) {
            System.out.println("����Ϊ��");
            return 1;
        }
        Member member = memberServiceImpl.showMemberByName(name);
        if (member == null) {
            System.out.println("�ó�Ա������");
            return 2;
        } else {
            System.out.println("��ѯ�ɹ�");
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
            //��������
            frame.updateShowTable(str);
            return 0;
        }
    }


    public void start() {
        // ���±������
        frame.updateShowTable(getTbaleData());
        // ��ʾ����
        frame.showFrame();
    }

}
